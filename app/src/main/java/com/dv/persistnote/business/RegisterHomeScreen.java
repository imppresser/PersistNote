package com.dv.persistnote.business;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dv.persistnote.R;
import com.dv.persistnote.base.ResTools;
import com.dv.persistnote.framework.ActionId;
import com.dv.persistnote.framework.DefaultScreen;
import com.dv.persistnote.framework.ui.CircleView;
import com.dv.persistnote.framework.ui.UICallBacks;

import java.lang.reflect.Field;

/**
 * Created by Admin2 on 2016/3/29.
 */
public class RegisterHomeScreen extends DefaultScreen implements View.OnClickListener {

    private RelativeLayout mContainer;

    private RelativeLayout containerPhoneNumber;

    private RelativeLayout containerCode;

    private RelativeLayout containerOKButton;

    private EditText etPhoneNumber;

    private EditText etCode;

    private Boolean isOkButtonAvailable = false;

    private Button getCode;

    private View linePhoneNumber;

    private View lineCode;

    private ImageView removeCode;

    private CircleView okButton;

    private ImageView okButtonArrow;

    private TextView wrongPhoneNumber;

    public RegisterHomeScreen(Context context, UICallBacks callBacks) {
        super(context, callBacks);
        init();
        setTitle(ResTools.getString(R.string.register));
    }

    private void init() {
        mContainer = new RelativeLayout(getContext());
        setContent(mContainer);

        mContainer.removeAllViews();

        /************** containerPhoneNumber ******************/

        containerPhoneNumber = new RelativeLayout(getContext());
        containerPhoneNumber.setId(R.id.register_rl_phone_number);

        RelativeLayout.LayoutParams lpC1 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, ResTools.getDimenInt(R.dimen.common_rl_height));
        lpC1.topMargin = ResTools.getDimenInt(R.dimen.register_rl_phone_number_margin_top);
        lpC1.leftMargin = ResTools.getDimenInt(R.dimen.common_rl_margin_left);
        lpC1.rightMargin = ResTools.getDimenInt(R.dimen.common_rl_margin_right);

        etPhoneNumber = new EditText(getContext());
        etPhoneNumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.h1));
        etPhoneNumber.setPadding(0, ResTools.getDimenInt(R.dimen.common_et_padding_top),
                0, ResTools.getDimenInt(R.dimen.common_et_padding_bottom));
        etPhoneNumber.setId(R.id.register_et_phone_number);
        etPhoneNumber.setBackgroundColor(ResTools.getColor(R.color.c4));
        etPhoneNumber.setHint(R.string.common_et_hint_phone_number);
        etPhoneNumber.setSingleLine(true);
        etPhoneNumber.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    etPhoneNumber.setHint(R.string.common_et_hint_phone_number);
                } else {
                    etPhoneNumber.setHint(null);
                }
            }
        });
        try {
            // https://github.com/android/platform_frameworks_base/blob/kitkat-release/core/java/android/widget/TextView.java#L562-564
            Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
            f.setAccessible(true);
            f.set(etPhoneNumber, R.drawable.color_cursor);
        } catch (Exception ignored) {
            Log.e(TAG, "Register Init : color_cursor Error");
        }

        etPhoneNumber.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() > 0 && etCode.getText().toString().length() > 0) {
                    isOkButtonAvailable = true;
                    okButton.setAlpha(1.0f);
                } else {
                    isOkButtonAvailable = false;
                    okButton.setAlpha(0.3f);
                }
            }
        });

        RelativeLayout.LayoutParams lpC1V1 =
                new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        containerPhoneNumber.addView(etPhoneNumber, lpC1V1);

        linePhoneNumber = new View(getContext());
        linePhoneNumber.setId(R.id.register_line_phone_number);
        linePhoneNumber.setBackgroundColor(ResTools.getColor(R.color.c1));

        RelativeLayout.LayoutParams lpC1V2 =
                new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, ResTools.getDimenInt(R.dimen.common_line_height));
        lpC1V2.addRule(RelativeLayout.BELOW, R.id.register_et_phone_number);

        containerPhoneNumber.addView(linePhoneNumber, lpC1V2);

        wrongPhoneNumber = new TextView(getContext());
        wrongPhoneNumber.setId(R.id.register_tv_phone_number_wrong);
        wrongPhoneNumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.h4));
        wrongPhoneNumber.setTextColor(ResTools.getColor(R.color.c10));
        wrongPhoneNumber.setText(ResTools.getString(R.string.register_tv_wrong_phone_number));
        wrongPhoneNumber.setVisibility(View.GONE);
        RelativeLayout.LayoutParams lpC1V3 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpC1V3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        lpC1V3.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lpC1V3.bottomMargin = ResTools.getDimenInt(R.dimen.common_margin_bottom);

        containerPhoneNumber.addView(wrongPhoneNumber, lpC1V3);

        mContainer.addView(containerPhoneNumber, lpC1);

        /************** containerCode ******************/

        containerCode = new RelativeLayout(getContext());
        containerCode.setId(R.id.register_rl_code);
        RelativeLayout.LayoutParams lpC2 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                ResTools.getDimenInt(R.dimen.common_rl_height));
        lpC2.topMargin = ResTools.getDimenInt(R.dimen.register_rl_code_margin_top);
        lpC2.leftMargin = ResTools.getDimenInt(R.dimen.common_rl_margin_left);
        lpC2.rightMargin = ResTools.getDimenInt(R.dimen.common_rl_margin_right);
        lpC2.addRule(RelativeLayout.BELOW, R.id.register_rl_phone_number);

        getCode = new Button(getContext());
        getCode.setId(R.id.register_bt_code);
        getCode.setBackgroundColor(ResTools.getColor(R.color.c2));
        getCode.setAlpha(0.2f);
        getCode.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.h4));
        getCode.setTextColor(ResTools.getColor(R.color.c4));
        getCode.setText(ResTools.getString(R.string.register_bt_code));

        RelativeLayout.LayoutParams lpC2V1 = new RelativeLayout.LayoutParams(ResTools.getDimenInt(R.dimen.register_bt_code_width),
                ResTools.getDimenInt(R.dimen.register_bt_code_height));
        lpC2V1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        containerCode.addView(getCode, lpC2V1);

        etCode = new EditText(getContext());
        etCode.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.h1));
        etCode.setId(R.id.register_et_code);
        etCode.setPadding(0, ResTools.getDimenInt(R.dimen.common_et_padding_top),
                0, ResTools.getDimenInt(R.dimen.common_et_padding_bottom));
        etCode.setBackgroundColor(ResTools.getColor(R.color.c4));
        etCode.setHint(R.string.register_et_hint_code);
        etCode.setSingleLine(true);
        etCode.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    etCode.setHint(R.string.register_et_hint_code);
                } else {
                    etCode.setHint(null);
                }
            }
        });
        try {
            // https://github.com/android/platform_frameworks_base/blob/kitkat-release/core/java/android/widget/TextView.java#L562-564
            Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
            f.setAccessible(true);
            f.set(etCode, R.drawable.color_cursor);
        } catch (Exception ignored) {
            Log.e(TAG, "Register Init : color_cursor Error");
        }

        etCode.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() > 0 && etPhoneNumber.getText().toString().length() > 0) {
                    isOkButtonAvailable = true;
                    okButton.setAlpha(1.0f);
                } else {
                    isOkButtonAvailable = false;
                    okButton.setAlpha(0.3f);
                }
            }
        });

        RelativeLayout.LayoutParams lpC2V2 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        lpC2V2.addRule(RelativeLayout.LEFT_OF, R.id.register_bt_code);
        lpC2V2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        lpC2V2.rightMargin = ResTools.getDimenInt(R.dimen.register_et_code_margin_right);

        containerCode.addView(etCode, lpC2V2);

        lineCode = new View(getContext());
        lineCode.setId(R.id.register_line_code);
        lineCode.setBackgroundColor(ResTools.getColor(R.color.c1));
        RelativeLayout.LayoutParams lpC2V3 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                ResTools.getDimenInt(R.dimen.common_line_height));
        lpC2V3.addRule(RelativeLayout.BELOW, R.id.register_et_code);
        lpC2V3.addRule(RelativeLayout.LEFT_OF, R.id.register_bt_code);
        lpC2V3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        lpC2V3.rightMargin = ResTools.getDimenInt(R.dimen.register_et_code_margin_right);

        containerCode.addView(lineCode, lpC2V3);

        removeCode = new ImageView(getContext());
        removeCode.setId(R.id.register_iv_code);
        removeCode.setImageDrawable(ResTools.getDrawable(R.drawable.cross_wrong));
        removeCode.setOnClickListener(this);
        removeCode.setVisibility(View.GONE);

        RelativeLayout.LayoutParams lpC2V4 = new RelativeLayout.LayoutParams(ResTools.getDimenInt(R.dimen.h1),
                ResTools.getDimenInt(R.dimen.h1));
        lpC2V4.addRule(RelativeLayout.LEFT_OF, R.id.register_bt_code);
        lpC2V4.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lpC2V4.rightMargin = ResTools.getDimenInt(R.dimen.register_iv_code_margin_right);
        lpC2V4.bottomMargin = ResTools.getDimenInt(R.dimen.common_margin_bottom);

        containerCode.addView(removeCode, lpC2V4);

        mContainer.addView(containerCode, lpC2);

        /************** containerOKButton ******************/

        containerOKButton = new RelativeLayout(getContext());
        containerOKButton.setId(R.id.register_rl_ok);
        containerOKButton.setOnClickListener(this);

        RelativeLayout.LayoutParams lpC3 = new RelativeLayout.LayoutParams(ResTools.getDimenInt(R.dimen.common_rl_ok_width_height),
                ResTools.getDimenInt(R.dimen.common_rl_ok_width_height));
        lpC3.topMargin = ResTools.getDimenInt(R.dimen.common_rl_ok_margin_top);
        lpC3.addRule(RelativeLayout.BELOW, R.id.register_rl_code);
        lpC3.addRule(RelativeLayout.CENTER_HORIZONTAL);

        okButton = new CircleView(getContext(), ResTools.getDimenInt(R.dimen.common_cv_radius),
                ResTools.getDimenInt(R.dimen.common_cv_radius), ResTools.getDimenInt(R.dimen.common_cv_radius));
        okButton.setId(R.id.register_v_ok);
        okButton.setColor(ResTools.getColor(R.color.c1));
        okButton.setAlpha(0.3f);

        containerOKButton.addView(okButton);

        okButtonArrow = new ImageView(getContext());
        okButtonArrow.setId(R.id.register_iv_ok);
        okButtonArrow.setImageDrawable(ResTools.getDrawable(R.drawable.arrow_right));

        RelativeLayout.LayoutParams lpC3V1 = new RelativeLayout.LayoutParams(ResTools.getDimenInt(R.dimen.h1), ResTools.getDimenInt(R.dimen.h1));
        lpC3V1.addRule(RelativeLayout.CENTER_IN_PARENT);

        containerOKButton.addView(okButtonArrow, lpC3V1);

        mContainer.addView(containerOKButton, lpC3);

    }

    @Override
    public void onClick(View v) {
        if (v == containerOKButton) {
            if(isOkButtonAvailable)
                mCallBacks.handleAction(ActionId.CommitRegisterHomeClick, null, null);
        }
    }
}
