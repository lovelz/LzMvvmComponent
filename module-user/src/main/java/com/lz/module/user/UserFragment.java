package com.lz.module.user;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.mvvm.base.base.DataBindingConfig;
import com.lz.mvvm.base.base.MvvmBaseFragment;
import com.lz.mvvm.common.router.RouterFragmentPath;

/**
 * 我的fragment
 *
 * author: lovelz
 * date: on 2020-06-11
 */
@Route(path = RouterFragmentPath.User.PAGER_USER)
public class UserFragment extends MvvmBaseFragment {

    @Override
    protected void initViewModel() {

    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.user_fragment_user);
    }
}
