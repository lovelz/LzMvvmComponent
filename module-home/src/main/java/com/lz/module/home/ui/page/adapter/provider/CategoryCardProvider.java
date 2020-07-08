package com.lz.module.home.ui.page.adapter.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lz.module.home.R;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.databinding.HomeItemCategoryCardViewBinding;
import com.lz.module.home.ui.page.adapter.DiscoverCategoryItemAdapter;
import com.lz.module.home.ui.page.adapter.type.DiscoverItemType;
import com.lz.mvvm.common.views.RecyclerItemDecoration;
import com.zhpan.idea.utils.DensityUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import androidx.databinding.DataBindingUtil;

/**
 * author: lovelz
 * date: on 2020-07-02
 */
public class CategoryCardProvider extends BaseItemProvider<NominateInfo.ItemListBeanX> {

    @Override
    public int getItemViewType() {
        return DiscoverItemType.CATEGORY_CARD_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item_category_card_view;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        HomeItemCategoryCardViewBinding binding = DataBindingUtil.bind(viewHolder.itemView);
        if (binding != null) {
            binding.recyclerview.addItemDecoration(new RecyclerItemDecoration(0, 0, DensityUtils.dp2px(getContext(), 5), 0));
        }
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, NominateInfo.@Nullable ItemListBeanX itemListBeanX) {
        HomeItemCategoryCardViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setData(itemListBeanX.getData());
            binding.setAdapter(new DiscoverCategoryItemAdapter());
        }
    }
}
