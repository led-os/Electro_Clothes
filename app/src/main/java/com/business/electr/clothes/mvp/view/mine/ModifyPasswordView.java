package com.business.electr.clothes.mvp.view.mine;

import com.business.electr.clothes.bean.UserBean;
import com.business.electr.clothes.mvp.view.IView;

/**
 * @ClassName: ModifyPasswordView
 * @Description: java类作用描述
 * @Author: 曾海强
 * @CreateDate: 2019/4/25 22:12
 */
public interface ModifyPasswordView extends IView {
    /**
     * 注册成功
     */
    void registerSuccess(UserBean userBean);

    /**
     * 登陆成功
     * @param userBean
     */
    void loginSuccess(UserBean userBean);
}
