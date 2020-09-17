package com.jhw.swing.prepared.textfield;

import com.jhw.swing.material.components.textfield.MaterialTextField;
import com.jhw.swing.material.components.textfield._MaterialTextField;
import com.jhw.swing.util.Utils;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
