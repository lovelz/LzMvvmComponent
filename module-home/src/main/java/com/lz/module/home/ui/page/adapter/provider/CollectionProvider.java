package com.lz.module.home.ui.page.adapter.provider;

import android.view.ViewGroup;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lz.module.home.R;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.databinding.HomeItemCollectionViewBinding;
import com.lz.module.home.ui.page.adapter.CollectionItemAdapter;
import com.lz.module.home.ui.page.adapter.type.NominateItemType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import androidx.databinding.DataBindingUtil;

/**
 * author: lovelz
 * date: on 2020-06-23
 */
public class CollectionProvider extends BaseItemProvider<NominateInfo.ItemListBeanX> {

    @Override
    public int getItemViewType() {
        return NominateItemType.COLLECTION_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item_collection_view;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, NominateInfo.@Nullable ItemListBeanX itemListBeanX) {
        HomeItemCollectionViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setData(itemListBeanX.getData());
            binding.setAdapter(new CollectionItemAdapter());
        }
    }
}
