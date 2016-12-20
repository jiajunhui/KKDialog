package com.xapp.jiajunhui.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Taurus on 16/12/15.
 */

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.tv_center_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CenterDialogActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_top_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TopDialogActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_bottom_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),BottomDialogActivity.class);
                startActivity(intent);
            }
        });
    }
}
