package com.business.electr.clothes.ui.activity.mine;


import android.widget.EditText;
import android.widget.TextView;

import com.business.electr.clothes.R;
import com.business.electr.clothes.constants.Constant;
import com.business.electr.clothes.mvp.presenter.mine.ForgetPassPresenter;
import com.business.electr.clothes.mvp.view.mine.ForgetPassView;
import com.business.electr.clothes.router.RouterCons;
import com.business.electr.clothes.ui.activity.BaseActivity;
import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.common.DefaultUriRequest;

import butterknife.BindView;
import butterknife.OnClick;

@RouterUri(path = {RouterCons.CREATE_SET_NEW_PASSWORD})
public class ForgetPassActivity extends BaseActivity<ForgetPassPresenter> implements ForgetPassView {


    @BindView(R.id.tv_nick_name)
    TextView tvNickName;
    @BindView(R.id.et_new_password)
    EditText etNewPassword;
    @BindView(R.id.et_new_again_password)
    EditText etNewAgainPassword;
    private String phone;//手机号
    private String area_code;//验证码
    private int type;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget_pass;
    }

    @Override
    protected ForgetPassPresenter getPresenter() {
        return new ForgetPassPresenter(this);
    }

    @Override
    protected void initDataAndEvent() {
        initTitle("重置新密码");
        phone = getIntent().getStringExtra(Constant.EXTRA_PHONE);
        area_code = getIntent().getStringExtra(Constant.EXTRA_CODE);
        type = getIntent().getIntExtra(Constant.TYPE, 3);
        tvNickName.setText(phone);
    }


    @OnClick(R.id.tv_commit)
    public void onViewClicked() {
        mPresenter.forgetPassword(phone,area_code,etNewPassword.getText().toString(),etNewAgainPassword.getText().toString());
    }

    @Override
    public void modifyPasswordSuccess() {
        switch (type){
            case 2:
                new DefaultUriRequest(this, RouterCons.CREATE_LOGIN)
                        .start();
                finish();
                break;
            case 3:
                finish();
                break;
        }
    }
}
