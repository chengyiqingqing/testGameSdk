package com.sww.testgamesdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ledong.lib.leto.MgcAccountManager;
import com.leto.game.base.bean.LoginResultBean;
import com.leto.game.base.listener.SyncUserInfoListener;
import com.leto.game.base.util.ToastUtil;


public class SyncAccountActivity extends FragmentActivity {
    ImageView iv_back;

    TextView tv_title;
    private Button btn_sync_mobile, btn_cancel;
    private EditText et_mobile, et_uid,et_nickname,et_portrait;

    CheckBox cb_login;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        setContentView(R.layout.sync_account_activity);

        iv_back = findViewById(R.id.iv_back);
        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("账号同步");

        btn_sync_mobile = findViewById(R.id.btn_sync_mobile);
        et_uid = findViewById(R.id.et_uid);
        et_mobile = findViewById(R.id.et_mobile);
        et_portrait = findViewById(R.id.et_portrait);
        et_nickname = findViewById(R.id.et_nickname);
        btn_cancel = findViewById(R.id.btn_cancel);
        cb_login = findViewById(R.id.cb_login);
        cb_login.setChecked(true);

        btn_sync_mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mobile = et_mobile.getText().toString();
                String guid = et_uid.getText().toString();
                String usename = et_nickname.getText().toString();
                String photoUrl = et_portrait.getText().toString();

                boolean isLogin = cb_login.isChecked();

                MgcAccountManager.syncAccount(SyncAccountActivity.this, guid, mobile, usename, photoUrl, isLogin,  new SyncUserInfoListener() {
                    @Override
                    public void onSuccess(LoginResultBean data) {
                        ToastUtil.s(SyncAccountActivity.this, "同步账号：" + mobile);
                    }

                    @Override
                    public void onFail(String code, String message) {

                    }
                });
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }
}

