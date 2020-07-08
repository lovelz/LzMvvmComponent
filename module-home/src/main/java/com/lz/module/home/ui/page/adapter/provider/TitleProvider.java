package com.lz.module.home.ui.page.adapter.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lz.module.home.R;
import com.lz.module.home.ui.page.adapter.type.NominateItemType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import androidx.databinding.DataBindingUtil;

/**
 * author: lovelz
 * date: on 2020-06-12
 */
public class TitleProvider extends BaseItemProvider {

    @Override
    public int getItemViewType() {
        return NominateItemType.TITLE_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item_title_left_right;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, @Nullable Object o) {

    }
}
