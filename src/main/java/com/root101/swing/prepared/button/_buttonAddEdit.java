package com.root101.swing.prepared.button;

import java.awt.Dimension;
import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import java.awt.Color;

/**
 * MaterialButton con background getColorButtonAdd, e icon iconButtonAdd de la
 * personalizacion.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _buttonAddEdit extends MaterialButtonAddEdit {

    public static _buttonAddEdit from() {
        return MaterialSwingInjector.getImplementation(_buttonAddEdit.class);
    }

    /**
     * Usar _buttonAddEdit.from() para proxy y AOP.
     *
     * @deprecated
     */
    @Deprecated
    protected _buttonAddEdit() {
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_ADD));
        this.setIcon(PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_ADD));
        this.setPreferredSize(new Dimension(125, 50));
        this.isCreated(true);
    }

    @Override
    public void isCreated(boolean created) {
        this.setIcon(created ? PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_ADD) : PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_EDIT));
        this.setText(created ? "Crear" : "Editar");
        this.setBackground(created ? PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_ADD) : PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_EDIT));
    }
}
