package org.frame.binding.viewadapter.recyclerview;


import com.runjing.utils.SpacesItemDecoration;
import org.runjing.rjframe.utils.DensityUtils;
import org.frame.binding.command.BindingCommand;
import org.frame.utils.constant.BaseConfig;

import java.util.concurrent.TimeUnit;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

import static com.runjing.utils.SpacesItemDecoration.GRIDLAYOUT;
import static com.runjing.utils.SpacesItemDecoration.LINEARLAYOUT;
import static com.runjing.utils.SpacesItemDecoration.STAGGEREDGRIDLAYOUT;

/**
 * Created by goldze on 2017/6/16.
 */
public class ViewAdapter {

    @BindingAdapter("lineManager")
    public static void setLineManager(RecyclerView recyclerView, LineManagers.LineManagerFactory lineManagerFactory) {
        recyclerView.addItemDecoration(lineManagerFactory.create(recyclerView));
    }

    /**
     *
     * @param recyclerView
     * @param type
     * @param num
     * @param o
     * @param size
     */
    @BindingAdapter({"mangerType", "typeNum", "orientation", "itemDecSize"})
    public static void setLayoutManager(RecyclerView recyclerView, int type, int num, int o, int size) {
        if (type == BaseConfig.CONFIG_LINEAR) {
            LinearLayoutManager manager = new LinearLayoutManager(recyclerView.getContext());
            recyclerView.setLayoutManager(manager);
            recyclerView.addItemDecoration(new SpacesItemDecoration(DensityUtils.dip2dp(recyclerView.getContext(), size), LINEARLAYOUT));
        } else if (type == BaseConfig.CONFIG_GRIDE){
            GridLayoutManager manager = new GridLayoutManager(recyclerView.getContext(), num);
            recyclerView.setLayoutManager(manager);
            recyclerView.addItemDecoration(new SpacesItemDecoration(DensityUtils.dip2dp(recyclerView.getContext(), size), GRIDLAYOUT));
        } else if (type == BaseConfig.CONFIG_STAGGER){
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(num, o);
            recyclerView.setLayoutManager(manager);
            recyclerView.addItemDecoration(new SpacesItemDecoration(DensityUtils.dip2dp(recyclerView.getContext(), size), STAGGEREDGRIDLAYOUT));
        }
    }


    @BindingAdapter(value = {"onScrollChangeCommand", "onScrollStateChangedCommand"}, requireAll = false)
    public static void onScrollChangeCommand(final RecyclerView recyclerView,
                                             final BindingCommand<ScrollDataWrapper> onScrollChangeCommand,
                                             final BindingCommand<Integer> onScrollStateChangedCommand) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int state;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (onScrollChangeCommand != null) {
                    onScrollChangeCommand.execute(new ScrollDataWrapper(dx, dy, state));
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                state = newState;
                if (onScrollStateChangedCommand != null) {
                    onScrollStateChangedCommand.execute(newState);
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    @BindingAdapter({"onLoadMoreCommand"})
    public static void onLoadMoreCommand(final RecyclerView recyclerView, final BindingCommand<Integer> onLoadMoreCommand) {
        RecyclerView.OnScrollListener listener = new OnScrollListener(onLoadMoreCommand);
        recyclerView.addOnScrollListener(listener);

    }

    @BindingAdapter("itemAnimator")
    public static void setItemAnimator(RecyclerView recyclerView, RecyclerView.ItemAnimator animator) {
        recyclerView.setItemAnimator(animator);
    }

    public static class OnScrollListener extends RecyclerView.OnScrollListener {

        private PublishSubject<Integer> methodInvoke = PublishSubject.create();

        private BindingCommand<Integer> onLoadMoreCommand;

        public OnScrollListener(final BindingCommand<Integer> onLoadMoreCommand) {
            this.onLoadMoreCommand = onLoadMoreCommand;
            methodInvoke.throttleFirst(1, TimeUnit.SECONDS)
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            onLoadMoreCommand.execute(integer);
                        }
                    });
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            int pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();
            if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                if (onLoadMoreCommand != null) {
                    methodInvoke.onNext(recyclerView.getAdapter().getItemCount());
                }
            }
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }


    }

    @BindingAdapter("hasFixedSize")
    public static void setHasFixedSize(RecyclerView recyclerView, boolean able){
        recyclerView.setHasFixedSize(able);
    }

    public static class ScrollDataWrapper {
        public float scrollX;
        public float scrollY;
        public int state;

        public ScrollDataWrapper(float scrollX, float scrollY, int state) {
            this.scrollX = scrollX;
            this.scrollY = scrollY;
            this.state = state;
        }
    }
}
