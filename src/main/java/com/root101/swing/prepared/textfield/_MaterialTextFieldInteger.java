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

import com.root101.swing.material.components.textfield.MaterialTextField;
import com.root101.swing.material.components.textfield._MaterialTextField;
import com.root101.swing.util.Utils;
import java.awt.event.KeyEvent;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialTextFieldInteger extends _MaterialTextField<Integer> {

    public static MaterialTextField from() {
        return new _MaterialTextFieldInteger();
    }

    public static MaterialTextField from(boolean negative) {
        return new _MaterialTextFieldInteger(negative);
    }

    private boolean negative = false;

    public _MaterialTextFieldInteger() {
        this(false);
    }

    public _MaterialTextFieldInteger(boolean negative) {
        super(Integer.class);
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
        } else if (!Character.isDigit(c) && c != (char) KeyEvent.VK_MINUS) {//si no es un digito o el + o el espacio de arribo, ERROR 
            return null;
        }
        String ch = (c + "").trim();
        text = (getText().substring(0, getCaretPosition()) + ch + getText().substring(getCaretPosition(), getText().length()));
        if (negative && text.length() == 1 && text.contains("-")) {
            return -0;
        }

        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            return null;
        }
    }
}
