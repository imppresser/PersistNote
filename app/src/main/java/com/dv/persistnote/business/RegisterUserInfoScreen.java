package com.dv.persistnote.business;

import android.content.Context;
import android.view.View;

import com.dv.persistnote.R;
import com.dv.persistnote.base.ResTools;
import com.dv.persistnote.framework.DefaultScreen;
import com.dv.persistnote.framework.ui.UICallBacks;

/**
 * Created by Admin2 on 2016/4/5.
 */
public class RegisterUserInfoScreen extends DefaultScreen implements View.OnClickListener{

    public RegisterUserInfoScreen(Context context, UICallBacks callBacks) {
        super(context, callBacks);
        init();
        setTitle(ResTools.getString(R.string.register));
    }

    private void init() {

    }

    @Override
    public void onClick(View v) {

    }
}
