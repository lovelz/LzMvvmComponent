package com.lz.module.home.ui.page.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.ui.page.adapter.provider.CategoryCardProvider;
import com.lz.module.home.ui.page.adapter.provider.SingleTitleProvider;
import com.lz.module.home.ui.page.adapter.provider.TopBannerProvider;
import com.lz.module.home.ui.page.adapter.type.DiscoverItemType;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * author: lovelz
 * date: on 2020-07-02
 */
public class DiscoverProviderAdapter extends BaseProviderMultiAdapter<NominateInfo.ItemListBeanX> {

    public DiscoverProviderAdapter() {
        super();
        addItemProvider(new TopBannerProvider());
        addItemProvider(new CategoryCardProvider());
        addItemProvider(new SingleTitleProvider());
    }

    @Override
    protected int getItemType(@NotNull List<? extends NominateInfo.ItemListBeanX> list, int position) {
        String type = list.get(position).getType();
        switch (type) {
            case "horizontalScrollCard":
                return DiscoverItemType.TOP_BANNER_VIEW;
            case "specialSquareCardCollection":
                return DiscoverItemType.CATEGORY_CARD_VIEW;
        }
        return DiscoverItemType.TITLE_VIEW;
    }

}
