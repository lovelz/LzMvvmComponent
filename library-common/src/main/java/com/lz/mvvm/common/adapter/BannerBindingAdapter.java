package com.lz.mvvm.common.adapter;

import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.holder.ViewHolder;

import java.util.ArrayList;

import androidx.databinding.BindingAdapter;

/**
 * author: lovelz
 * date: on 2020-06-15
 */
public class BannerBindingAdapter {

    @BindingAdapter(value = {"bannerDataList"})
    public static void initBannerView(BannerViewPager<String, ViewHolder> bannerViewPager, ArrayList<String> pageList) {
        bannerViewPager.create(pageList);
    }


}
