package com.xapp.jiajunhui.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.kk.taurus.animeffect.EffectFactory;
import com.kk.taurus.finaldialog.base.KKDialog;
import com.kk.taurus.finaldialog.base.OnDialogCallBack;
import com.kk.taurus.finaldialog.dialog.KKStyleDialog;
import com.kk.taurus.finaldialog.dialog.TraditionalStyleDialog;

public class BottomDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_dialog);

        setTitle("BottomDialog");

        findViewById(R.id.tv_bottom_normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNormalDialog();
            }
        });

        findViewById(R.id.tv_bottom_custom_background).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomBackgroundDialog();
            }
        });

    }

    private void showNormalDialog() {
        //and you can use traditional style dialog.
        TraditionalStyleDialog dialog = new TraditionalStyleDialog(this);
        dialog.setShowAnimType(EffectFactory.SlideBottom.getAnimator());
        dialog.setTitle("LocationBottom")
                .setMessage("This is a location bottom dialog")
                .setPositiveText("OK")
                .setNegativeText("CANCEL")
                .show();
        dialog.setOnDialogListener(new OnDialogCallBack());
    }

    private void showCustomBackgroundDialog() {
        KKStyleDialog dialog = new KKStyleDialog(this, KKDialog.DIALOG_TYPE_LOCATION_BOTTOM);
        dialog.setMargin(20,20,20,20);
        dialog.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_cus_content_background));
        dialog.setShowAnimType(EffectFactory.SlideBottom.getAnimator());
        dialog.setTitle("LocationBottom")
                .setMessage("This is a location bottom dialog")
                .setPositiveText("OK")
                .setNegativeText("CANCEL")
                .setNeutralText("Neutral").show();
        dialog.setOnDialogListener(new OnDialogCallBack());
    }

}
