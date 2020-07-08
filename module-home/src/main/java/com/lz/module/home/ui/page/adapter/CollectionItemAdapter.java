package com.lz.module.home.ui.page.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lz.module.home.R;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.databinding.HomeItemFollowCardViewBinding;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import androidx.databinding.DataBindingUtil;

/**
 * author: lovelz
 * date: on 2020-06-23
 */
public class CollectionItemAdapter extends BaseQuickAdapter<NominateInfo.ItemListBeanX.DataBeanXX.ItemListBean, BaseViewHolder> {

    public CollectionItemAdapter() {
        super(R.layout.home_item_follow_card_view);
    }

    @Override
    protected void onItemViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NominateInfo.ItemListBeanX.DataBeanXX.ItemListBean dataBeanXX) {
        HomeItemFollowCardViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setData(dataBeanXX.getData().getContent().getData());
        }
    }
}
