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

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.util.Log;

import com.kk.taurus.finaldialog.utils.ScreenUtils;

/**
 * Created by Taurus on 2016/12/7.
 */

public abstract class AbsDialog implements IDialog,DialogInterface.OnShowListener, DialogInterface.OnDismissListener {

    protected Dialog mDialog;
    private boolean mCancelEnable = true;
    protected Context mContext;
    private DialogInterface.OnShowListener mOnShowListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    protected KKDialog.OnDialogListener mOnDialogListener;

    protected boolean isLandscape;
    protected int mScreenW,mScreenH;

    public AbsDialog(Context context){
        this.mContext = context;
        initScreenInfo(context);
        if(context instanceof Activity){
            isLandscape = ScreenUtils.getScreenOrientation(context)== ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        }
    }

    private void initScreenInfo(Context context){
        int[] screen = ScreenUtils.getScreenWH(context);
        mScreenW = screen[0];
        mScreenH = screen[1];
        Log.d("_AbsDialog","screenW = " + mScreenW + " screenH = " + mScreenH);
    }

    protected void onDialogInit(){
        mDialog.setOnShowListener(this);
        mDialog.setOnDismissListener(this);
    }

    @Override
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
    }

    @Override
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override
    public void setOnDialogListener(KKDialog.OnDialogListener onDialogListener) {
        this.mOnDialogListener = onDialogListener;
    }

    @Override
    public IDialog setCancelable(boolean enable) {
        this.mCancelEnable = enable;
        mDialog.setCancelable(enable);
        return this;
    }

    public boolean isCancelEnable() {
        return mCancelEnable;
    }

    @Override
    public void cancel() {
        mDialog.cancel();
    }

    @Override
    public void dismiss() {
        mDialog.dismiss();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if(mOnDismissListener!=null){
            mOnDismissListener.onDismiss(dialog);
        }
    }

    @Override
    public void onShow(DialogInterface dialog) {
        if(mOnShowListener!=null){
            mOnShowListener.onShow(dialog);
        }
    }

}
