package com.example.feilerr.androiddemo;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.feilerr.view.UserView;
import com.example.viewFactory.LayoutFactory;
import com.example.viewFactory.MButton;
import com.example.viewFactory.MEditText;
import com.example.viewFactory.MTextView;

import zframework.base.BaseActivity;
import zframework.support.ShareData;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private boolean isShowPassword;
    private MButton showPassword;
    private EditText usernameET;
    private MEditText passwordET;
    private MButton loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutFactory rootLayout = new LayoutFactory(new RelativeLayout(this));
        rootLayout.layout.setBackgroundColor(Color.WHITE);
        this.addContentView(rootLayout.layout, (RelativeLayout.LayoutParams) rootLayout.matchParent(true));

        int userLayoutHeight = (int) (ShareData.getInstance().DENSITY * 260);
        LayoutFactory userLayout = new LayoutFactory(new RelativeLayout(this));
        userLayout.layout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                userLayoutHeight));
        rootLayout.layout.addView(userLayout.layout);
        userLayout.layout.setY(50 * ShareData.getInstance().DENSITY);

        TextView title = new MTextView(this);
        title.setTextSize(18);
        title.setText("登录");
        title.setId(R.id.layout_title);
        title.setGravity(Gravity.CENTER);
        title.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        userLayout.layout.addView(title);

        int shortWidth = (int) (80 * ShareData.getInstance().DENSITY);
        UserView usernameView = new UserView(this);
        usernameView.shortWidth = shortWidth;
        usernameView.setId(R.id.username_layout);
        usernameView.addContent(R.id.username_pre,R.id.username,"用户名","请输入手机号");
        userLayout.layout.addView(usernameView);
        usernameView.layoutParams.addRule(RelativeLayout.BELOW,R.id.layout_title);
        usernameView.setY(ShareData.getInstance().MARGIN);
        usernameET = (EditText) usernameView.findViewById(R.id.username);
        usernameET.setInputType(InputType.TYPE_CLASS_NUMBER);


        UserView passwordView = new UserView(this);
        passwordView.shortWidth = shortWidth;
        passwordView.layoutParams.addRule(RelativeLayout.BELOW,R.id.username_layout);
        passwordView.setY(ShareData.getInstance().MARGIN*2);
        passwordView.addContent(R.id.password_pre,R.id.password,"密码","请输入密码");
        userLayout.layout.addView(passwordView);
        passwordET = (MEditText) passwordView.findViewById(R.id.password);
        passwordET.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        RelativeLayout.LayoutParams etParams = new RelativeLayout.LayoutParams((int) ShareData.getInstance().ITEM_WIDTH-
                shortWidth-(int) ShareData.getInstance().MARGIN*3,
                (int)ShareData.getInstance().ITEM_HEIGHT);
        etParams.addRule(RelativeLayout.RIGHT_OF,R.id.password_pre);
        passwordET.setLayoutParams(etParams);

        showPassword = new MButton(this);
        showPassword.setId(R.id.password_show);
        int btnRedius = (int)(32*ShareData.getInstance().DENSITY);
        RelativeLayout.LayoutParams showParams = new RelativeLayout.LayoutParams((int)(ShareData.getInstance().DENSITY*24),
                (int)(ShareData.getInstance().DENSITY*16));
        showParams.addRule(RelativeLayout.RIGHT_OF,R.id.password);
        showPassword.setLayoutParams(showParams);
        showPassword.setBackgroundResource(R.drawable.icon_loginyincang);
        showPassword.setOnClickListener(this);
        showPassword.setX(ShareData.getInstance().MARGIN/2);
        showPassword.setY(13*ShareData.getInstance().DENSITY);
        isShowPassword = false;
        passwordView.addView(showPassword);

        passwordET.refreshObject = showPassword;
        showPassword.setVisibility(View.GONE);

        loginBtn = new MButton(this);
        loginBtn.setText("登录");
        loginBtn.setId(R.id.submit_btn_id);
        loginBtn.setOnClickListener(this);
        loginBtn.setY(userLayoutHeight-ShareData.getInstance().ITEM_HEIGHT);
        userLayout.layout.addView(loginBtn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.password_show:
                if (isShowPassword){
                    showPassword.setBackgroundResource(R.drawable.icon_loginkejian);
                    passwordET.setInputType(InputType.TYPE_CLASS_TEXT);
                }else{
                    showPassword.setBackgroundResource(R.drawable.icon_loginyincang);
                    passwordET.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                isShowPassword = !isShowPassword;
                break;
            case R.id.submit_btn_id:
                Toast.makeText(this,"哈哈",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
