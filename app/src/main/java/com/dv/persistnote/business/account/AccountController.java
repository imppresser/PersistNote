package com.dv.persistnote.business.account;

import android.os.Message;
import android.view.KeyEvent;

import com.dv.persistnote.business.LoginScreen;
import com.dv.persistnote.business.RegisterHomeScreen;
import com.dv.persistnote.business.RegisterPasswordScreen;
import com.dv.persistnote.business.RegisterUserInfoScreen;
import com.dv.persistnote.framework.ActionId;
import com.dv.persistnote.business.WelcomeScreen;
import com.dv.persistnote.framework.ui.AbstractScreen;
import com.dv.persistnote.framework.core.AbstractController;
import com.dv.persistnote.framework.core.BaseEnv;
import com.dv.persistnote.framework.core.MsgDef;

/**
 * Created by Hang on 2016/3/14.
 */
public class AccountController extends AbstractController{

    private WelcomeScreen mWelcomeScreen;

    private LoginScreen mLoginScreen;

    private RegisterHomeScreen mRegisterHomeScreen;

    private RegisterPasswordScreen mRegisterPasswordScreen;

    private RegisterUserInfoScreen mRegisterUserInfoScreen;

    public AccountController(BaseEnv baseEnv) {
        super(baseEnv);
    }

    @Override
    public void handleMessage(Message msg) {

        if(msg.what == MsgDef.MSG_SHOW_WELCOME_SCREEN){
            //未登录时显示登陆窗口
            mWelcomeScreen = new WelcomeScreen(mContext,this);
            mWindowMgr.pushScreen(mWelcomeScreen, false);
        }
    }



    @Override
    public void onWindowStateChange(AbstractScreen target, byte stateFlag) {

    }

    @Override
    public boolean onWindowKeyEvent(AbstractScreen target, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean handleAction(int actionId, Object arg, Object result) {
        switch (actionId) {
            case ActionId.OnLoginClick:
                //mWindowMgr.popScreen(true);
                mLoginScreen = new LoginScreen(mContext, this);
                mWindowMgr.pushScreen(mLoginScreen, false);
                break;
            case ActionId.OnRegisterClick:
                mRegisterHomeScreen = new RegisterHomeScreen(mContext, this);
                mWindowMgr.pushScreen(mRegisterHomeScreen, false);
                break;
            case ActionId.CommitLoginClick:
                // TODO: Login function.
                break;
            case ActionId.CommitRegisterHomeClick:
                mRegisterPasswordScreen = new RegisterPasswordScreen(mContext, this);
                mWindowMgr.pushScreen(mRegisterPasswordScreen, false);
                break;
            case ActionId.CommitRegisterUserInfoClick:
                mRegisterUserInfoScreen = new RegisterUserInfoScreen(mContext, this);
                mWindowMgr.pushScreen(mRegisterUserInfoScreen, false);
                break;
        }
        return false;
    }

}
