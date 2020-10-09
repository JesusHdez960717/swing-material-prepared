/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.prepared.textfield;

import com.jhw.swing.material.components.textfield.MaterialFormatedTextField;
import com.jhw.swing.material.components.textfield.MaterialFormatedTextFieldIcon;
import com.jhw.swing.material.components.textfield.MaterialTextField;
import com.jhw.swing.material.components.textfield.MaterialTextFieldIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialPreparedTextFactory {

    public static MaterialFormatedTextField buildFormatedMoney() {
        return _MaterialTextFieldMoney.from(false);
    }

    public static MaterialFormatedTextField buildFormatedMoney(boolean negative) {
        return _MaterialTextFieldMoney.from(negative);
    }
    public static MaterialFormatedTextFieldIcon buildFormatedMoneyIcon() {
        return _MaterialTextFieldMoneyIcon.from(false);
    }

    public static MaterialFormatedTextFieldIcon buildFormatedMoneyIcon(boolean negative) {
        return _MaterialTextFieldMoneyIcon.from(negative);
    }

    public static MaterialTextField buildDouble() {
        return _MaterialTextFieldDouble.from();
    }

    public static MaterialTextFieldIcon buildDoubleIcon() {
        return _MaterialTextFieldDoubleIcon.from();
    }

    public static MaterialTextField buildInteger() {
        return _MaterialTextFieldInteger.from();
    }

    public static MaterialTextFieldIcon buildIntegerIcon() {
        return _MaterialTextFieldIntegerIcon.from();
    }
}
