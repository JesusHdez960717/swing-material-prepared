/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.prepared.textfield;

import com.root101.swing.material.components.textfield.MaterialFormatedTextField;
import com.root101.swing.material.components.textfield._MaterialFormatedTextFieldRuntime;
import com.root101.swing.util.Utils;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import com.root101.utils.formateer.*;
import java.util.StringTokenizer;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialTextFieldMoney extends _MaterialFormatedTextFieldRuntime<BigDecimal> {

    public static MaterialFormatedTextField from() {
        return new _MaterialTextFieldMoney();
    }

    public static MaterialFormatedTextField from(boolean negative) {
        return new _MaterialTextFieldMoney(negative);
    }

    private static final String INCORRECTO = "Tipo de dato incorrecto";

    private boolean negative = false;

    public _MaterialTextFieldMoney() {
        this(false);
    }

    public _MaterialTextFieldMoney(boolean negative) {
        super(new MoneyFormateer(), BigDecimal.class);
        this.setMaxLength(20);
        this.negative = negative;
        addListeners();
    }

    private void addListeners() {
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (validateText(evt.getKeyChar()) == null) {
                    Utils.beep();
                    evt.consume();
                }
            }
        });
    }

    private Object validateText(char c) {
        String text;

        if (c == (char) KeyEvent.VK_BACK_SPACE || c == (char) KeyEvent.VK_DELETE) {
            c = ' ';
        } else if (!Character.isDigit(c) && c != (char) KeyEvent.VK_MINUS && c != KeyEvent.VK_COMMA && c != KeyEvent.VK_PERIOD) {//si no es un digito o el + o el espacio de arribo, ERROR 
            return null;
        }
        String ch = (c + "").trim();
        try {
            this.commitEdit();
        } catch (Exception e) {
        }
        String originalText = getValue().toString();
        int caretPos = getCaretPosition() - new StringTokenizer(getText().trim(), MoneyFormateer.MIDDLE).countTokens() + 1;
        caretPos = Math.max(0, Math.min(caretPos, originalText.length()));

        text = (originalText.substring(0, caretPos) + ch + originalText.substring(caretPos, originalText.length()));
        if (negative && text.length() == 1 && text.contains("-")) {
            return BigDecimal.ZERO;
        }

        try {
            return new BigDecimal(text.replace(",", "."));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public BigDecimal getObject() {
        try {
            return new BigDecimal(getValue().toString().replace(",", "."));
        } catch (Exception e) {
            wrong(INCORRECTO);
            return null;
            //throw new RuntimeException(INCORRECTO);
        }
    }

}
