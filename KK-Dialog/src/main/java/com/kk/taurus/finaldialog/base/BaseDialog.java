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

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by Taurus on 2016/12/13.
 */

public class BaseDialog extends Dialog {

    /**
     * the dialog location type.
     */
    private int mLocationType = KKDialog.DIALOG_TYPE_DEFAULT;
    private float mDimAmount = KKDialog.DEFAULT_WINDOW_DIM_AMOUNT;

    public BaseDialog(Context context) {
        this(context,0,KKDialog.DIALOG_TYPE_DEFAULT);
    }

    public BaseDialog(Context context, int themeResId,int mLocationType) {
        this(context, themeResId, mLocationType,KKDialog.DEFAULT_WINDOW_DIM_AMOUNT);
    }

    public BaseDialog(Context context, int themeResId, int mLocationType, float dimAmount) {
        super(context, themeResId);
        this.mLocationType = mLocationType;
        this.mDimAmount = dimAmount;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        int gravity;
        //set window gravity.
        switch (mLocationType){
            case KKDialog.DIALOG_TYPE_DEFAULT:
                gravity = Gravity.CENTER;
                params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                break;
            case KKDialog.DIALOG_TYPE_LOCATION_TOP:
                gravity = Gravity.TOP;
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                break;
            case KKDialog.DIALOG_TYPE_LOCATION_BOTTOM:
                gravity = Gravity.BOTTOM;
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                break;
            default:
                gravity = Gravity.CENTER;
                params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                break;
        }
        //set window background dim amount.
        getWindow().setDimAmount(mDimAmount);
        getWindow().setGravity(gravity);
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(params);
    }

}
