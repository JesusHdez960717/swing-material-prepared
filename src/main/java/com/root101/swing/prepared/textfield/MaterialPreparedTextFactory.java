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
import com.root101.swing.material.components.textfield.MaterialFormatedTextFieldIcon;
import com.root101.swing.material.components.textfield.MaterialTextField;
import com.root101.swing.material.components.textfield.MaterialTextFieldIcon;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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

    public static MaterialTextField buildDouble(boolean negative) {
        return _MaterialTextFieldDouble.from(negative);
    }

    public static MaterialTextFieldIcon buildDoubleIcon(boolean negative) {
        return _MaterialTextFieldDoubleIcon.from(negative);
    }

    public static MaterialTextField buildInteger() {
        return _MaterialTextFieldInteger.from();
    }

    public static MaterialTextField buildInteger(boolean negative) {
        return _MaterialTextFieldInteger.from(negative);
    }

    public static MaterialTextFieldIcon buildIntegerIcon() {
        return _MaterialTextFieldIntegerIcon.from();
    }

    public static MaterialTextFieldIcon buildIntegerIcon(boolean negative) {
        return _MaterialTextFieldIntegerIcon.from(negative);
    }
}
