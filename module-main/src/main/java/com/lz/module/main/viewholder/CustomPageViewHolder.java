package com.lz.module.main.viewholder;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;

import com.lz.module.main.R;
import com.lz.module.main.bean.CustomBean;
import com.zhpan.bannerview.holder.ViewHolder;

/**
 * author: lovelz
 * date: on 2020-06-09
 */
public class CustomPageViewHolder implements ViewHolder<CustomBean> {

    @Override
    public int getLayoutId() {
        return R.layout.main_item_custom_view;
    }

    @Override
    public void onBind(View itemView, CustomBean data, int position, int size) {
        ImageView mImageView = itemView.findViewById(R.id.banner_image);
        mImageView.setImageResource(data.getImageRes());
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mImageView, "alpha", 0, 1);
        alphaAnimator.setDuration(1500);
        alphaAnimator.start();
    }
}
