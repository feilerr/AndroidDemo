package com.example.feilerr.androiddemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.feilerr.androiddemo.R;
import com.example.feilerr.view.UserView;
import com.example.viewFactory.LayoutFactory;
import com.example.viewFactory.MButton;
import com.example.viewFactory.MEditText;
import com.example.viewFactory.MTextView;

import zframework.base.ViewFactory;
import zframework.support.ShareData;

/**
 * Created by feilerr on 2016/9/28.
 */

public class UserFragment extends Fragment implements ViewFactory{
    private MEditText usernameET;
    private MEditText passwordET;
    private MButton showPassword;
    private MButton loginBtn;
    private boolean isShowPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user, container, false);
        addSubView(view);
        return view;
    }

    @Override
    public void init() {

    }

    @Override
    public void addSubView(View rootView){
        RelativeLayout rootLayout = (RelativeLayout)rootView;
        int userLayoutHeight = (int) (ShareData.getInstance().DENSITY * 260);
        LayoutFactory userLayout = new LayoutFactory(new RelativeLayout(this.getActivity()));
        userLayout.layout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                userLayoutHeight));
        rootLayout.addView(userLayout.layout);
        userLayout.layout.setY(50 * ShareData.getInstance().DENSITY);

        TextView title = new MTextView(this.getActivity());
        title.setTextSize(18);
        title.setText("登录");
        title.setId(R.id.layout_title);
        title.setGravity(Gravity.CENTER);
        title.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        userLayout.layout.addView(title);

        int shortWidth = (int) (80 * ShareData.getInstance().DENSITY);
        UserView usernameView = new UserView(this.getActivity());
        usernameView.shortWidth = shortWidth;
        usernameView.setId(R.id.username_layout);
        usernameView.addContent(R.id.username_pre,R.id.username,"用户名","请输入手机号");
        userLayout.layout.addView(usernameView);
        usernameView.layoutParams.addRule(RelativeLayout.BELOW,R.id.layout_title);
        usernameView.setY(ShareData.getInstance().MARGIN);
        usernameET = (MEditText) usernameView.findViewById(R.id.username);
        usernameET.setInputType(InputType.TYPE_CLASS_NUMBER);


        UserView passwordView = new UserView(this.getActivity());
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

        showPassword = new MButton(this.getActivity());
        showPassword.setId(R.id.password_show);
        int btnRedius = (int)(32*ShareData.getInstance().DENSITY);
        RelativeLayout.LayoutParams showParams = new RelativeLayout.LayoutParams((int)(ShareData.getInstance().DENSITY*24),
                (int)(ShareData.getInstance().DENSITY*16));
        showParams.addRule(RelativeLayout.RIGHT_OF,R.id.password);
        showPassword.setLayoutParams(showParams);
        showPassword.setBackgroundResource(R.drawable.icon_loginkejian);
        showPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowPassword){
                    showPassword.setBackgroundResource(R.drawable.icon_loginkejian2);
                    passwordET.setInputType(InputType.TYPE_CLASS_TEXT);
                }else{
                    showPassword.setBackgroundResource(R.drawable.icon_loginkejian);
                    passwordET.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                isShowPassword = !isShowPassword;
            }
        });
        showPassword.setX(ShareData.getInstance().MARGIN/2);
        showPassword.setY(13*ShareData.getInstance().DENSITY);
        isShowPassword = false;
        passwordView.addView(showPassword);

        passwordET.refreshObject = showPassword;
        showPassword.setVisibility(View.GONE);

        loginBtn = new MButton(this.getActivity());
        loginBtn.setText("登录");
        loginBtn.setId(R.id.submit_btn_id);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(this,"哈哈",Toast.LENGTH_LONG).show();
            }
        });
        loginBtn.setY(userLayoutHeight-ShareData.getInstance().ITEM_HEIGHT);
        userLayout.layout.addView(loginBtn);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
