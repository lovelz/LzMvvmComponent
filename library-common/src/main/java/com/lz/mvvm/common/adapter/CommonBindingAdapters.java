package com.lz.mvvm.common.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.ClickUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zhpan.idea.utils.DensityUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

/**
 * BindingAdapter中的一些自定义属性
 *
 * author: lovelz
 * date: on 2020-06-08
 */
public class CommonBindingAdapters {

    /**
     *
     * @param view
     * @param url 图片路径
     * @param cornersSize 图片圆角大小
     * @param placeHolder
     */
    @BindingAdapter(value = {"imageUrl", "corners", "placeHolder"}, requireAll = false)
    public static void loadUrl(ImageView view, String url, int cornersSize, Drawable placeHolder) {
        Glide.with(view.getContext())
                .load(url)
                .apply(cornersSize > 0 ? RequestOptions.bitmapTransform(new RoundedCorners(DensityUtils.dp2px(view.getContext(), cornersSize))) : new RequestOptions())
                .placeholder(placeHolder)
                .into(view);
    }

    @BindingAdapter(value = {"circleImageUrl"})
    public static void loadCircleImageUrl(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(view);
    }

    @BindingAdapter(value = {"visible"}, requireAll = false)
    public static void visible(View view, boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter(value = {"onClickWithDebouncing"}, requireAll = false)
    public static void onClickWithDebouncing(View view, View.OnClickListener clickListener) {
        ClickUtils.applySingleDebouncing(view, clickListener);
    }

}
