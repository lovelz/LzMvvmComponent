package com.lz.module.home.ui.page.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.lz.module.home.R;
import com.lz.module.home.data.bean.NominateInfo;
import com.lz.module.home.ui.page.adapter.provider.BannerProvider;
import com.lz.module.home.ui.page.adapter.provider.CollectionProvider;
import com.lz.module.home.ui.page.adapter.provider.FollowCardProvider;
import com.lz.module.home.ui.page.adapter.provider.SingleTitleProvider;
import com.lz.module.home.ui.page.adapter.provider.VideoCardProvider;
import com.lz.module.home.ui.page.adapter.type.NominateItemType;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author: lovelz
 * date: on 2020-06-12
 */
public class NominateProviderAdapter extends BaseProviderMultiAdapter<NominateInfo.ItemListBeanX> {

    public NominateProviderAdapter() {
        super();

//        addItemProvider(new BannerProvider());
        addItemProvider(new SingleTitleProvider());
        addItemProvider(new FollowCardProvider());
        addItemProvider(new VideoCardProvider());
        addItemProvider(new CollectionProvider());

    }


    @Override
    protected int getItemType(@NotNull List<? extends NominateInfo.ItemListBeanX> list, int position) {
        String type = list.get(position).getType();
        switch (type) {
            case "textCard":
                return NominateItemType.SINGLE_TITLE_VIEW;
            case "followCard":
                return NominateItemType.FOLLOW_CARD_VIEW;
            case "videoSmallCard":
                return NominateItemType.VIDEO_CARD_VIEW;
            case "squareCardCollection":
                return NominateItemType.COLLECTION_VIEW;
        }
        return NominateItemType.SINGLE_TITLE_VIEW;
    }

}
