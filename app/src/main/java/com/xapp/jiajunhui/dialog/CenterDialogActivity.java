package com.xapp.jiajunhui.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.kk.taurus.animeffect.anims.AnimatorBookFlipLeft;
import com.kk.taurus.animeffect.anims.AnimatorBookFlipRight;
import com.kk.taurus.animeffect.anims.AnimatorBottomOpen;
import com.kk.taurus.animeffect.anims.AnimatorCalendarFlipBottom;
import com.kk.taurus.animeffect.anims.AnimatorCalendarFlipTop;
import com.kk.taurus.animeffect.anims.AnimatorFadeIn;
import com.kk.taurus.animeffect.anims.AnimatorFall;
import com.kk.taurus.animeffect.anims.AnimatorFlipH;
import com.kk.taurus.animeffect.anims.AnimatorFlipHCircle;
import com.kk.taurus.animeffect.anims.AnimatorFlipV;
import com.kk.taurus.animeffect.anims.AnimatorFlipVCircle;
import com.kk.taurus.animeffect.anims.AnimatorNewsPaper;
import com.kk.taurus.animeffect.anims.AnimatorReboundBottom;
import com.kk.taurus.animeffect.anims.AnimatorReboundLeft;
import com.kk.taurus.animeffect.anims.AnimatorReboundRight;
import com.kk.taurus.animeffect.anims.AnimatorReboundTop;
import com.kk.taurus.animeffect.anims.AnimatorRotateBottom;
import com.kk.taurus.animeffect.anims.AnimatorRotateCardLeftTop;
import com.kk.taurus.animeffect.anims.AnimatorRotateCardRightBottom;
import com.kk.taurus.animeffect.anims.AnimatorRotateLeft;
import com.kk.taurus.animeffect.anims.AnimatorRotateShake;
import com.kk.taurus.animeffect.anims.AnimatorShakeH;
import com.kk.taurus.animeffect.anims.AnimatorShakeHV;
import com.kk.taurus.animeffect.anims.AnimatorShakeV;
import com.kk.taurus.animeffect.anims.AnimatorSlideBottom;
import com.kk.taurus.animeffect.anims.AnimatorSlideFall;
import com.kk.taurus.animeffect.anims.AnimatorSlideLeft;
import com.kk.taurus.animeffect.anims.AnimatorSlideRight;
import com.kk.taurus.animeffect.anims.AnimatorSlideTop;
import com.kk.taurus.animeffect.anims.AnimatorSlitH;
import com.kk.taurus.animeffect.anims.AnimatorSlitHV;
import com.kk.taurus.animeffect.anims.AnimatorSlitV;
import com.kk.taurus.animeffect.anims.AnimatorZoomCenter;
import com.kk.taurus.animeffect.base.BaseAnimator;
import com.kk.taurus.finaldialog.base.IDialog;
import com.kk.taurus.finaldialog.base.OnDialogCallBack;
import com.kk.taurus.finaldialog.dialog.KKStyleDialog;
import com.xapp.jiajunhui.dialog.adapter.AnimatorAdapter;

import java.util.ArrayList;
import java.util.List;

public class CenterDialogActivity extends AppCompatActivity implements AnimatorAdapter.OnItemClickListener {

    private List<Class> effects = new ArrayList<>();
    private RecyclerView mRecycler;
    private AnimatorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_dialog);

        mRecycler = (RecyclerView) findViewById(R.id.recycler);

        mRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        initEffectsList();

        mAdapter = new AnimatorAdapter(getApplicationContext(),effects);
        mRecycler.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AnimatorAdapter.ItemHolder holder, int position) {
        Class effect = effects.get(position);
        try {
            BaseAnimator animator = (BaseAnimator) effect.newInstance();
            showDialog(animator);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void showDialog(BaseAnimator animator) {
        KKStyleDialog dialog = new KKStyleDialog(this);
        dialog.setCancelable(false);
        //set dialog animation type
        dialog.setShowAnimType(animator);
        dialog.setTitle("")
                .setMessage("this animation effect is " + animator.getClass().getSimpleName())
                .setPositiveText("确定")
                .setNegativeText("取消")
                .setNeutralText("忽略").show();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

            }
        });

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });

        dialog.setOnDialogListener(new OnDialogCallBack(){
            @Override
            public void onPositiveClick(IDialog dialog) {
                super.onPositiveClick(dialog);
                Toast.makeText(CenterDialogActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegativeClick(IDialog dialog) {
                super.onNegativeClick(dialog);
                Toast.makeText(CenterDialogActivity.this, "CANCEL", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNeutralClick(IDialog dialog) {
                super.onNeutralClick(dialog);
                Toast.makeText(CenterDialogActivity.this, "NEUTRAL", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initEffectsList() {
        effects.add(AnimatorFadeIn.class);
        effects.add(AnimatorFall.class);
        effects.add(AnimatorFlipH.class);
        effects.add(AnimatorFlipV.class);
        effects.add(AnimatorSlideBottom.class);
        effects.add(AnimatorSlideFall.class);
        effects.add(AnimatorSlideLeft.class);
        effects.add(AnimatorSlideRight.class);
        effects.add(AnimatorSlideTop.class);
        effects.add(AnimatorSlitH.class);
        effects.add(AnimatorSlitHV.class);
        effects.add(AnimatorSlitV.class);
        effects.add(AnimatorZoomCenter.class);
        effects.add(AnimatorReboundBottom.class);
        effects.add(AnimatorReboundLeft.class);
        effects.add(AnimatorReboundRight.class);
        effects.add(AnimatorReboundTop.class);
        effects.add(AnimatorRotateBottom.class);
        effects.add(AnimatorRotateLeft.class);
        effects.add(AnimatorBookFlipLeft.class);
        effects.add(AnimatorBookFlipRight.class);
        effects.add(AnimatorCalendarFlipBottom.class);
        effects.add(AnimatorCalendarFlipTop.class);
        effects.add(AnimatorBottomOpen.class);
        effects.add(AnimatorRotateCardLeftTop.class);
        effects.add(AnimatorRotateCardRightBottom.class);
        effects.add(AnimatorFlipHCircle.class);
        effects.add(AnimatorFlipVCircle.class);
        effects.add(AnimatorNewsPaper.class);
        effects.add(AnimatorShakeH.class);
        effects.add(AnimatorShakeHV.class);
        effects.add(AnimatorShakeV.class);
        effects.add(AnimatorRotateShake.class);
    }

}
