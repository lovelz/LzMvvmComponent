package com.lz.module.home.ui.page.adapter.provider;

import android.database.DatabaseUtils;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lz.module.home.R;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.databinding.HomeItemFollowCardViewBinding;
import com.lz.module.home.ui.page.adapter.type.NominateItemType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import androidx.databinding.DataBindingUtil;

/**
 * author: lovelz
 * date: on 2020-06-16
 */
public class FollowCardProvider extends BaseItemProvider<NominateInfo.ItemListBeanX> {

    @Override
    public int getItemViewType() {
        return NominateItemType.FOLLOW_CARD_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item_follow_card_view;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, NominateInfo.@Nullable ItemListBeanX itemListBeanX) {
        HomeItemFollowCardViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setData(itemListBeanX.getData().getContent().getData());
        }

    }
}
