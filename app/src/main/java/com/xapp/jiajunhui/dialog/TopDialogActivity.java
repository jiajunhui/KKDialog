package com.xapp.jiajunhui.dialog;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kk.taurus.animeffect.EffectFactory;
import com.kk.taurus.finaldialog.base.IDialog;
import com.kk.taurus.finaldialog.base.KKDialog;
import com.kk.taurus.finaldialog.base.OnDialogCallBack;
import com.kk.taurus.finaldialog.dialog.KKStyleDialog;

public class TopDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_dialog);

        setTitle("TopDialog");

        findViewById(R.id.tv_top_normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNormalDialog();
            }
        });

        findViewById(R.id.tv_top_custom_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomContentDialog();
            }
        });

        findViewById(R.id.tv_top_custom_message_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomMessageContentNormalDialog();
            }
        });


    }

    private void showNormalDialog() {
        KKStyleDialog dialog = new KKStyleDialog(this, KKDialog.DIALOG_TYPE_LOCATION_TOP,0.1f);
        dialog.setMargin(0,0,0,0);
        dialog.setShowAnimType(EffectFactory.SlideTop.getAnimator());
        dialog.setTitle("LocationTop")
                .setMessage("This is a location top dialog")
                .setPositiveText("OK")
                .setNegativeText("CANCEL")
                .show();
        dialog.setOnDialogListener(new OnDialogCallBack());
    }

    private void showCustomContentDialog() {
        KKStyleDialog dialog = new KKStyleDialog(this, KKDialog.DIALOG_TYPE_LOCATION_TOP);
        dialog.setMargin(0,0,0,0);
        dialog.setContentView(R.layout.layout_cus_dialog,
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ((TextView)dialog.findViewById(R.id.tv_cus_text)).setText("this is custom content view.");
        dialog.setShowAnimType(EffectFactory.SlideTop.getAnimator());
        dialog.show();
        dialog.setOnDialogListener(new OnDialogCallBack());
    }

    private void showCustomMessageContentNormalDialog() {
        KKStyleDialog dialog = new KKStyleDialog(this, KKDialog.DIALOG_TYPE_LOCATION_TOP);
        dialog.setMargin(0,0,0,0);
        dialog.setMessageContentView(R.layout.layout_cus_dialog_message_content,
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        dialog.setShowAnimType(EffectFactory.SlideTop.getAnimator());
        dialog.textButtonProperty(new IDialog.OnPreparedTextButtonPropertyCaller() {
            @Override
            public void onPrepareTextButton(TextView neutral, TextView negative, TextView positive) {
                neutral.setTextColor(Color.RED);
                negative.setTextColor(Color.BLUE);
                positive.setTextColor(Color.GREEN);
            }
        });
        dialog.getTitleTextView().setTextColor(Color.parseColor("#f83d46"));
        dialog.setTitle("LocationTop")
                .setPositiveText("OK")
                .setNegativeText("CANCEL")
                .setNeutralText("Neutral").show();
        dialog.setOnDialogListener(new OnDialogCallBack());
    }

}
