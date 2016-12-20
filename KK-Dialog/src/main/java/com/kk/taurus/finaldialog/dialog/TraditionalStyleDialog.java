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

package com.kk.taurus.finaldialog.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kk.taurus.animeffect.EffectFactory;
import com.kk.taurus.animeffect.base.BaseAnimator;
import com.kk.taurus.finaldialog.R;
import com.kk.taurus.finaldialog.base.AbsDialog;
import com.kk.taurus.finaldialog.base.BaseDialog;
import com.kk.taurus.finaldialog.base.IDialog;
import com.kk.taurus.finaldialog.base.KKDialog;
import com.kk.taurus.finaldialog.config.DialogConfig;

/**
 * Created by Taurus on 2016/12/7.
 */

public class TraditionalStyleDialog extends AbsDialog implements KKDialog{

    private long mDuration = ANIMATION_DURATION_DEFAULT;
    private int mLocationType = DIALOG_TYPE_DEFAULT;
    private BaseAnimator mShowAnimType = EffectFactory.SlideTop.getAnimator();
    private View mRootView;
    private RelativeLayout mPanelView;
    private RelativeLayout mContentView;
    private TextView mTitle;
    private TextView mMessage;
    private TextView mPositive;
    private TextView mNegative;
    private TextView mNeutral;

    public TraditionalStyleDialog(Context context){
        this(context,DIALOG_TYPE_DEFAULT);
    }

    public TraditionalStyleDialog(Context context, int locationType){
        this(context, locationType,DEFAULT_WINDOW_DIM_AMOUNT);
    }

    public TraditionalStyleDialog(Context context, int locationType, float backgroundDimAmount){
        super(context);
        this.mLocationType = locationType;
        mDialog = new BaseDialog(context,R.style.dialog_untran,mLocationType,backgroundDimAmount);
        onDialogInit();
        setupDefaultContentView();
        findDialogViewById();
        adjustmentWH();
        attachListener();
    }

    private void adjustmentWH() {
        int horizonMargin;
        if(isLandscape){
            horizonMargin = (mScreenW - ((int)(mScreenW* DialogConfig.getDialogWidthProportionOnLandScape())))/2;
        }else{
            horizonMargin = (mScreenW - ((int)(mScreenW* DialogConfig.getDialogWidthProportionOnPortrait())))/2;
        }
        setMargin(horizonMargin,0,horizonMargin,0);
    }

    private void findDialogViewById() {
        mPanelView = findViewById(R.id.kk_dialog_layout_dialog_panel_view);
        mContentView = findViewById(R.id.kk_dialog_layout_message_content_view);
        mTitle = findViewById(R.id.kk_dialog_layout_title_text_view);
        mMessage = findViewById(R.id.kk_dialog_layout_message_text_view);
        mNeutral = findViewById(R.id.kk_dialog_layout_neutral_text_view);
        mPositive = findViewById(R.id.kk_dialog_layout_positive_text_view);
        mNegative = findViewById(R.id.kk_dialog_layout_negative_text_view);
    }

    public void attachListener(){
        if(mRootView!=null){
            mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isCancelEnable()){
                        dismiss();
                    }
                }
            });
        }
        if(mPanelView!=null){
            mPanelView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        if(mPositive!=null){
            mPositive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnDialogListener!=null){
                        mOnDialogListener.onPositiveClick(TraditionalStyleDialog.this);
                    }
                }
            });
        }
        if(mNegative!=null){
            mNegative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnDialogListener!=null){
                        mOnDialogListener.onNegativeClick(TraditionalStyleDialog.this);
                    }
                }
            });
        }
        if(mNeutral!=null){
            mNeutral.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnDialogListener!=null){
                        mOnDialogListener.onNeutralClick(TraditionalStyleDialog.this);
                    }
                }
            });
        }
    }

    private void setupDefaultContentView() {
        View mDialogView = getDialogContentView();
        mRootView = mDialogView.findViewById(R.id.kk_dialog_layout_root_view);
        mDialog.setContentView(mDialogView);
    }

    protected View getDialogContentView(){
        return LayoutInflater.from(mContext).inflate(R.layout.layout_traditional_dialog,null);
    }

    @Override
    public <T> T findViewById(int id){
        if(mRootView==null)
            return null;
        return (T) mRootView.findViewById(id);
    }

    @Override
    public void setMargin(int left, int top, int right, int bottom) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mPanelView.getLayoutParams();
        params.leftMargin = left;
        params.topMargin = top;
        params.rightMargin = right;
        params.bottomMargin = bottom;
    }

    @Override
    public void setContentView(int layoutId, ViewGroup.LayoutParams layoutParams) {
        mPanelView.removeAllViews();
        mPanelView.addView(inflateView(layoutId),layoutParams);
    }

    @Override
    public void setMessageContentView(int layoutId, ViewGroup.LayoutParams params) {
        mContentView.removeAllViews();
        mContentView.addView(inflateView(layoutId),params);
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        if(Build.VERSION.SDK_INT > 15){
            mPanelView.setBackground(drawable);
        }else{
            mPanelView.setBackgroundDrawable(drawable);
        }
    }

    private View inflateView(int layoutId){
        return View.inflate(mContext,layoutId,null);
    }

    @Override
    public void setShowAnimType(BaseAnimator animType) {
        this.mShowAnimType = animType;
    }

    @Override
    public void setShowAnimType(BaseAnimator animator, long duration) {
        setShowAnimType(animator);
        this.mDuration = duration;
        mShowAnimType.setDuration(mDuration);
    }

    public BaseAnimator getShowAnimType() {
        return mShowAnimType;
    }

    @Override
    public void onShow(DialogInterface dialog) {
        startAnim(getShowAnimType());
        super.onShow(dialog);
    }

    private void startAnim(BaseAnimator animator) {
        animator.invokeAnim(mPanelView);
    }

    @Override
    public TextView getTitleTextView() {
        return mTitle;
    }

    @Override
    public IDialog setTitle(String title) {
        if(mTitle==null || TextUtils.isEmpty(title)) {
            mTitle.setVisibility(View.GONE);
            return this;
        }
        mTitle.setText(title);
        return this;
    }

    @Override
    public IDialog setMessage(String message) {
        if(mMessage==null) return this;
        mMessage.setText(message);
        return this;
    }

    @Override
    public IDialog setNegativeText(String text) {
        if(mNegative==null) return this;
        mNegative.setText(text);
        return this;
    }

    @Override
    public IDialog setNeutralText(String text) {
        if(mNeutral==null) return this;
        mNeutral.setVisibility(View.VISIBLE);
        mNeutral.setText(text);
        return this;
    }

    @Override
    public IDialog setPositiveText(String text) {
        if(mPositive==null) return this;
        mPositive.setText(text);
        return this;
    }

    @Override
    public IDialog textButtonProperty(OnPreparedTextButtonPropertyCaller propertyCaller) {
        if(propertyCaller!=null){
            propertyCaller.onPrepareTextButton(mNeutral,mNegative,mPositive);
        }
        return this;
    }

    @Override
    public void show() {
        mDialog.show();
    }

}
