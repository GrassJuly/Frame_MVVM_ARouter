package com.runjing.home.bean.response.home;

import androidx.databinding.ObservableField;

/**
 * @Created: qianxs  on 2020.07.30 18:38.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.07.30 18:38.
 * @Remark:
 */
public class HomeBean {
    public static final int TYPE_ITEM_GOOD = 0X120;
    public static final int TYPE_ITEM_STORE = 0X121;
    public static final int TYPE_ITEM_CITY = 0X122;

    private ObservableField<DistrictBean> districtBean = new ObservableField<>();
    private ObservableField<HomeStoreBean> homeStoreBean = new ObservableField<>();
    private ObservableField<BannerBean> bannerBean = new ObservableField<>();
    private ObservableField<GoodBean> homeGoodBean = new ObservableField<>();
    private ObservableField<Integer> itemTpye = new ObservableField<>();

    public HomeBean(DistrictBean districtBean, HomeStoreBean homeStoreBean) {
        this.districtBean.set(districtBean);
        this.homeStoreBean.set(homeStoreBean);
    }

    public HomeBean(DistrictBean districtBean, HomeStoreBean homeStoreBean, BannerBean bannerBean, GoodBean homeGoodBean) {
        this.districtBean.set(districtBean); ;
        this.homeStoreBean.set(homeStoreBean);
        this.bannerBean.set(bannerBean);
        this.homeGoodBean.set(homeGoodBean);
    }

    public DistrictBean getDistrictBean() {
        return districtBean.get();
    }

    public HomeStoreBean getHomeStoreBean() {
        return homeStoreBean.get();
    }

    public BannerBean getBannerBean() {
        return bannerBean.get();
    }

    public GoodBean getHomeGoodBean() {
        return homeGoodBean.get();
    }

    public void setItemTpye(int itemTpye) {
        this.itemTpye.set(itemTpye);
    }

    public int getItemTpye() {
        return itemTpye.get();
    }

    @Override
    public String toString() {
        return "HomeBean{" +
                "districtBean=" + districtBean +
                ", homeStoreBean=" + homeStoreBean +
                ", bannerBean=" + bannerBean +
                ", homeGoodBean=" + homeGoodBean +
                ", itemTpye=" + itemTpye +
                '}';
    }
}
