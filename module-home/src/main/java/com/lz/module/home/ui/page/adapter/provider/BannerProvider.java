package com.lz.module.home.ui.page.adapter.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lz.module.home.R;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.databinding.HomeItemBannerViewBinding;
import com.lz.module.home.ui.page.adapter.type.NominateItemType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * author: lovelz
 * date: on 2020-06-15
 */
public class BannerProvider extends BaseItemProvider<NominateInfo.ItemListBeanX> {

    @Override
    public int getItemViewType() {
        return NominateItemType.BANNER_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item_banner_view;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, NominateInfo.@Nullable ItemListBeanX itemListBeanX) {
        ArrayList<String> bannerDataList = new ArrayList<>();
        bannerDataList.add(
                "http://img.kaiyanapp.com/b5b00c67dfc759a02c8b457e104b3ec6.png?imageMogr2/quality/60/format/jpg");
        bannerDataList.add(
                "http://img.kaiyanapp.com/b5b00c67dfc759a02c8b457e104b3ec6.png?imageMogr2/quality/60/format/jpg");
        bannerDataList.add(
                "http://img.kaiyanapp.com/1eaf8827688ea3b910b7b6b6cb192a5f.png?imageMogr2/quality/60/format/jpg");
        bannerDataList.add(
                "http://img.kaiyanapp.com/1eaf8827688ea3b910b7b6b6cb192a5f.png?imageMogr2/quality/60/format/jpg");

//        HomeItemBannerViewBinding binding = baseViewHolder.getBinding();
//        if (binding != null) {
//            binding.setBannerDataList(bannerDataList);
//            binding.setHolder(new NetBannerProvider());
//        }
    }
}
