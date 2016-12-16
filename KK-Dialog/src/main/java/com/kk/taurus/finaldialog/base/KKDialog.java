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

package com.kk.taurus.finaldialog.base;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

import com.kk.taurus.animeffect.base.BaseAnimator;

/**
 * Created by Taurus on 2016/12/6.
 */

public interface KKDialog extends DialogInterface{

    /**
     * default dialog style.
     */
    int DIALOG_STYLE_DEFAULT = 0;
    /**
     * traditional style dialog.
     */
    int DIALOG_STYLE_TRADITIONAL = 1;
    /**
     * default animation duration
     */
    int ANIMATION_DURATION_DEFAULT = 500;
    /**
     * default dialog window background dim amount
     */
    float DEFAULT_WINDOW_DIM_AMOUNT = 0.4f;

    /**
     * The default location dialog, which is in the middle position.
     */
    int DIALOG_TYPE_DEFAULT = 0;
    /**
     * The window in the top position
     */
    int DIALOG_TYPE_LOCATION_TOP = 1;
    /**
     * The window in the bottom position
     */
    int DIALOG_TYPE_LOCATION_BOTTOM = 2;

    /**
     * set the dialog content view layout.
     * @param layoutId
     * @param params
     */
    void setContentView(int layoutId, ViewGroup.LayoutParams params);

    /**
     * set the dialog message content layout.
     * @param layoutId
     * @param params
     */
    void setMessageContentView(int layoutId, ViewGroup.LayoutParams params);

    /**
     * set the dialog background drawable.
     * @param drawable
     */
    void setBackgroundDrawable(Drawable drawable);

    /**
     * find view by id from content view.
     * @param id
     * @param <T>
     * @return
     */
    <T> T findViewById(int id);

    /**
     * set animation type when dialog show.
     * @param animator
     */
    void setShowAnimType(BaseAnimator animator);

    /**
     * set animation type and duration when dialog show.
     * @param animator
     * @param duration
     */
    void setShowAnimType(BaseAnimator animator, long duration);

    /**
     * set the margin outside the window.
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    void setMargin(int left, int top, int right, int bottom);

    interface OnDialogListener{
        void onPositiveClick(IDialog dialog);
        void onNegativeClick(IDialog dialog);
        void onNeutralClick(IDialog dialog);
    }

}
