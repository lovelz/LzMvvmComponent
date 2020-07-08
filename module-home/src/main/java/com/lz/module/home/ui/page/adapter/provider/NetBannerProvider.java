package com.lz.module.home.ui.page.adapter.provider;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.lz.module.home.R;
import com.zhpan.bannerview.holder.ViewHolder;

/**
 * author: lovelz
 * date: on 2020-06-15
 */
public class NetBannerProvider implements ViewHolder<String> {

    @Override
    public int getLayoutId() {
        return R.layout.home_item_banner_view_item;
    }

    @Override
    public void onBind(View itemView, String data, int position, int size) {
        ImageView imageView = itemView.findViewById(R.id.banner_image);
        Glide.with(imageView.getContext())
                .load(data)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(40)))
                .into(imageView);
    }
}
