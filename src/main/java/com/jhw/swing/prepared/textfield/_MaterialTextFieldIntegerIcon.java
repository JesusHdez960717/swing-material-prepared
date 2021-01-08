/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.prepared.textfield;

import com.root101.swing.material.components.textfield.MaterialTextFieldIcon;
import com.root101.swing.material.components.textfield._MaterialTextFieldIcon;
import com.root101.swing.material.standards.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldIntegerIcon extends _MaterialTextFieldIcon<Integer> {

    public static MaterialTextFieldIcon from() {
        return new _MaterialTextFieldIntegerIcon();
    }

    public static MaterialTextFieldIcon from(boolean negative) {
        return new _MaterialTextFieldIntegerIcon(negative);
    }

    public _MaterialTextFieldIntegerIcon() {
        this(false);
    }

    public _MaterialTextFieldIntegerIcon(boolean negative) {
        super(new _MaterialTextFieldInteger(negative));
        this.setIcon(MaterialIcons.EDIT);
    }

}
