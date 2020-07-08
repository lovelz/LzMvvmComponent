package com.lz.module.home.ui.page.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.ui.page.adapter.provider.FollowCardProvider;
import com.lz.module.home.ui.page.adapter.provider.SingleTitleProvider;
import com.lz.module.home.ui.page.adapter.type.NominateItemType;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * author: lovelz
 * date: on 2020-06-30
 */
public class DailyProviderAdapter extends BaseProviderMultiAdapter<NominateInfo.ItemListBeanX> {

    public DailyProviderAdapter() {
        super();
        addItemProvider(new FollowCardProvider());
        addItemProvider(new SingleTitleProvider());
    }

    @Override
    protected int getItemType(@NotNull List<? extends NominateInfo.ItemListBeanX> list, int position) {
        if (TextUtils.equals(list.get(position).getType(), "followCard")) {
            return NominateItemType.FOLLOW_CARD_VIEW;
        }
        return NominateItemType.SINGLE_TITLE_VIEW;
    }
}
