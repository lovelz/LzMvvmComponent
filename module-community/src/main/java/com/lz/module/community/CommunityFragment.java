package com.lz.module.community;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.mvvm.base.base.DataBindingConfig;
import com.lz.mvvm.base.base.MvvmBaseFragment;
import com.lz.mvvm.common.router.RouterFragmentPath;

/**
 * 社区fragment
 *
 * author: lovelz
 * date: on 2020-06-11
 */
@Route(path = RouterFragmentPath.Community.PAGER_COMMUNITY)
public class CommunityFragment extends MvvmBaseFragment {

    @Override
    protected void initViewModel() {

    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.community_fragment_community);
    }

}
