package com.lz.mvvm.base.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 对于那些需要分页请求的页面而言，你可以继承此model,他只是提供共用参数page，当然你也可以直接写在具体的model中
 *
 * author: lovelz
 * date: on 2020-06-29
 */
public class BasePageModel extends ViewModel {

    public int page = 0;

    /**
     * 为了更好的管理刷新、加载更多的方法，只好添加这个了
     * q:为啥不和page统一起来？ a:因为在{@link com.lz.mvvm.common.adapter.RecyclerViewBindingAdapter.bindList()}中
     * 已经跟list相关联了，再加一个page不好管理，如果只是单一跟page相关联，则list这个何时改变又将是个问题
     */
    public MutableLiveData<Integer> changePage = new MutableLiveData<>();

}
