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
import android.widget.TextView;

/**
 * Created by Taurus on 2016/12/13.
 */

public interface IDialog {
    /**
     * set the dialog cancelable.
     * @param enable
     * @return
     */
    IDialog setCancelable(boolean enable);

    /**
     * set the dialog call back on show.
     * @param onShowListener
     */
    void setOnShowListener(DialogInterface.OnShowListener onShowListener);

    /**
     * set the dialog call back on dismiss.
     * @param onDismissListener
     */
    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    /**
     * get title view.
     * @return
     */
    TextView getTitleTextView();

    /**
     * set dialog title.
     * @param title
     * @return
     */
    IDialog setTitle(String title);

    /**
     * set dialog message.
     * @param message
     * @return
     */
    IDialog setMessage(String message);

    /**
     * set dialog negative text.
     * @param text
     * @return
     */
    IDialog setNegativeText(String text);

    /**
     * set dialog neutral text.
     * @param text
     * @return
     */
    IDialog setNeutralText(String text);

    /**
     * set dialog positive text.
     * @param text
     * @return
     */
    IDialog setPositiveText(String text);

    /**
     * set text button property according to your needs.
     * @param propertyCaller
     * @return
     */
    IDialog textButtonProperty(OnPreparedTextButtonPropertyCaller propertyCaller);

    /**
     * set dialog click call back on button.
     * @param onDialogListener
     */
    void setOnDialogListener(KKDialog.OnDialogListener onDialogListener);

    /**
     * cancel dialog.
     */
    void cancel();

    /**
     * dismiss dialog.
     */
    void dismiss();

    /**
     * show dialog.
     */
    void show();

    interface OnPreparedTextButtonPropertyCaller{
        void onPrepareTextButton(TextView neutral, TextView negative, TextView positive);
    }

}
