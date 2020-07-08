package com.lz.mvvm.common.adapter;

import android.database.DatabaseUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author: lovelz
 * date: on 2020-06-12
 */
public class RecyclerViewBindingAdapter {

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"adapter", "refreshList", "page"}, requireAll = false)
    public static void bindList(RecyclerView recyclerView, BaseQuickAdapter quickAdapter, List list, int page) {
        if (recyclerView != null && list != null) {
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(quickAdapter);
            }

            if (page == 0) {
                ((BaseQuickAdapter) recyclerView.getAdapter()).setNewData(list);
            } else {
                ((BaseQuickAdapter) recyclerView.getAdapter()).addData(list);
            }

            if (recyclerView.getParent() instanceof SmartRefreshLayout) {
                ((SmartRefreshLayout) recyclerView.getParent()).finishRefresh();
                ((SmartRefreshLayout) recyclerView.getParent()).finishLoadMore();
            }
        }
    }

    /**
     * 那些简单的文字列表（如选择类型、地点啥的），就不需要写adapter了
     *
     * @param recyclerView
     * @param list         数据（记得内容是String类型）
     * @param layoutId     列表展示的布局
     * @param variableId   绑定视图数据对象所对应的variable id
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"items", "item_layout", "variable_id"}, requireAll = false)
    public static void bindSimpleList(RecyclerView recyclerView, List list, int layoutId, int variableId) {
        if (recyclerView != null) {
            if (recyclerView.getAdapter() == null) {
                BaseQuickAdapter quickAdapter = new BaseQuickAdapter<String, BaseViewHolder>(layoutId) {

                    @Override
                    protected void onItemViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
                        DataBindingUtil.bind(viewHolder.itemView);
                    }

                    @Override
                    protected void convert(@NotNull BaseViewHolder baseViewHolder, @Nullable String data) {
                        ViewDataBinding binding = baseViewHolder.getBinding();
                        if (binding != null) {
                            binding.setVariable(variableId, data);
                        }
                    }
                };
                recyclerView.setAdapter(quickAdapter);
                quickAdapter.setNewData(list);

            }
        }
    }

}
