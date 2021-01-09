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
package com.root101.swing.prepared.button;

import java.awt.Dimension;
import com.root101.module.util.personalization.core.domain.Personalization;
import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;

/**
 * MaterialButton con background getColorButtonAdd, e icon iconButtonAdd de la
 * personalizacion.
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
