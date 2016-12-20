/*
 * Copyright 2016 jiajunhui
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kk.taurus.finaldialog.config;

/**
 * Created by Taurus on 2016/12/20.
 */

public class DialogConfig {

    public static final float DEFAULT_DIALOG_WIDTH_PROPORTION_ON_LANDSCAPE = 0.4f;
    public static final float DEFAULT_DIALOG_WIDTH_PROPORTION_ON_PORTRAIT = 0.8f;

    private static float dialogWidthProportionOnLandScape = DEFAULT_DIALOG_WIDTH_PROPORTION_ON_LANDSCAPE;
    private static float dialogWidthProportionOnPortrait = DEFAULT_DIALOG_WIDTH_PROPORTION_ON_PORTRAIT;

    public static float getDialogWidthProportionOnLandScape() {
        if(dialogWidthProportionOnLandScape<=0)
            return DEFAULT_DIALOG_WIDTH_PROPORTION_ON_LANDSCAPE;
        return dialogWidthProportionOnLandScape;
    }

    public static void setDialogWidthProportionOnLandScape(float dialogWidthProportionOnLandScape) {
        DialogConfig.dialogWidthProportionOnLandScape = dialogWidthProportionOnLandScape;
    }

    public static float getDialogWidthProportionOnPortrait() {
        if(dialogWidthProportionOnPortrait<=0)
            return DEFAULT_DIALOG_WIDTH_PROPORTION_ON_PORTRAIT;
        return dialogWidthProportionOnPortrait;
    }

    public static void setDialogWidthProportionOnPortrait(float dialogWidthProportionOnPortrait) {
        DialogConfig.dialogWidthProportionOnPortrait = dialogWidthProportionOnPortrait;
    }
}
