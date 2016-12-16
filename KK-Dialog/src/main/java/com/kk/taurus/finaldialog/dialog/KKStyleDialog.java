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
import android.view.LayoutInflater;
import android.view.View;
import com.kk.taurus.finaldialog.R;

/**
 * Created by Taurus on 2016/12/7.
 */

public class KKStyleDialog extends TraditionalStyleDialog{

    public KKStyleDialog(Context context) {
        super(context);
    }

    public KKStyleDialog(Context context, int locationType) {
        super(context, locationType);
    }

    public KKStyleDialog(Context context, int locationType, float backgroundDimAmount) {
        super(context, locationType, backgroundDimAmount);
    }

    @Override
    protected View getDialogContentView(){
        return LayoutInflater.from(mContext).inflate(R.layout.layout_kk_dialog,null);
    }
}
