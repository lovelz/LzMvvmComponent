package com.lz.module.home.ui.page.adapter.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lz.module.home.R;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.databinding.HomeItemTopBannerViewBinding;
import com.lz.module.home.ui.page.adapter.type.DiscoverItemType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import androidx.databinding.DataBindingUtil;

/**
 * author: lovelz
 * date: on 2020-07-02
 */
public class TopBannerProvider extends BaseItemProvider<NominateInfo.ItemListBeanX> {

    @Override
    public int getItemViewType() {
        return DiscoverItemType.TOP_BANNER_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item_top_banner_view;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, NominateInfo.@Nullable ItemListBeanX itemListBeanX) {
        HomeItemTopBannerViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setData(itemListBeanX.getData().getItemList().get(0));
        }
    }
}
