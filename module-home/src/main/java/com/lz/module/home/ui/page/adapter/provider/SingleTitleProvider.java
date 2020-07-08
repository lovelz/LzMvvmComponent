package com.lz.module.home.ui.page.adapter.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lz.module.home.R;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.databinding.HomeItemSingleTitleViewBinding;
import com.lz.module.home.ui.page.adapter.type.NominateItemType;
import com.orhanobut.logger.Logger;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import androidx.databinding.DataBindingUtil;

/**
 * author: lovelz
 * date: on 2020-06-15
 */
public class SingleTitleProvider extends BaseItemProvider<NominateInfo.ItemListBeanX> {

    @Override
    public int getItemViewType() {
        return NominateItemType.SINGLE_TITLE_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item_single_title_view;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, NominateInfo.@Nullable ItemListBeanX itemListBeanX) {
        HomeItemSingleTitleViewBinding binding = baseViewHolder.getBinding();
        if (binding != null && itemListBeanX != null) {
            binding.setData(itemListBeanX.getData());
        }
    }
}
