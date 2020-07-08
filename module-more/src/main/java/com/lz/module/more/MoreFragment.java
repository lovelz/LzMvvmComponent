package com.lz.module.more;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lz.mvvm.base.base.DataBindingConfig;
import com.lz.mvvm.base.base.MvvmBaseFragment;
import com.lz.mvvm.common.router.RouterFragmentPath;

/**
 * 更多fragment
 *
 * author: lovelz
 * date: on 2020-06-11
 */
@Route(path = RouterFragmentPath.More.PAGER_MORE)
public class MoreFragment extends MvvmBaseFragment {
    @Override
    protected void initViewModel() {

    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.more_fragment_more);
    }
}
