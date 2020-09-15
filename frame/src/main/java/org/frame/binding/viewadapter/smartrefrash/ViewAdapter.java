package org.frame.binding.viewadapter.smartrefrash;


import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.frame.binding.command.BindingCommand;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;


public class ViewAdapter {
    //下拉刷新命令
    @BindingAdapter({"onRefreshCallBack"})
    public static void onRefreshCommand(SmartRefreshLayout smartRefreshLayout, final BindingCommand onRefreshCommand) {
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (onRefreshCommand != null) {
                    onRefreshCommand.execute();
                }
            }
        });
    }

    //是否刷新中
    @BindingAdapter({"onLoadMoreCallBack"})
    public static void setLoadMore(SmartRefreshLayout smartRefreshLayout, final BindingCommand onLoadMoreCommand) {
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (onLoadMoreCommand != null) {
                    onLoadMoreCommand.execute();
                }
            }
        });
    }

}
