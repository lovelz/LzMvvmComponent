package com.lz.module.main.binding;

import com.blankj.utilcode.util.ColorUtils;
import com.lz.module.main.R;

import androidx.databinding.BindingAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;

/**
 * PageNavigationView属性定义
 *
 * author: lovelz
 * date: on 2020-06-10
 */
public class PageNavigationAdapter {

    /**
     * 初始化主页PageNavigationView
     * @param pageNavigationView
     * @param initPage
     */
    @BindingAdapter(value = {"initMainPageNavigation", "adapter"}, requireAll = false)
    public static void initMainPageNavigation(PageNavigationView pageNavigationView, boolean initPage, PagerAdapter pagerAdapter) {
        NavigationController pageController = pageNavigationView.material()
                .addItem(R.drawable.main_home,
                        "首页",
                        ColorUtils.getColor(R.color.main_bottom_check_color))
                .addItem(R.drawable.main_community,
                        "社区",
                        ColorUtils.getColor(R.color.main_bottom_check_color))
                .addItem(R.drawable.main_notify,
                        "通知",
                        ColorUtils.getColor(R.color.main_bottom_check_color))
                .addItem(R.drawable.main_user,
                        "我的",
                        ColorUtils.getColor(R.color.main_bottom_check_color))
                .setDefaultColor(
                        ColorUtils.getColor(R.color.main_bottom_default_color))
                .enableAnimateLayoutChanges()
                .build();
        //获取view pager
        ViewPager viewPager = (pageNavigationView.getRootView()).findViewById(R.id.view_pager);
        if (viewPager != null) {
            viewPager.setOffscreenPageLimit(1);
            viewPager.setAdapter(pagerAdapter);
            pageController.setupWithViewPager(viewPager);
        }

    }

}
