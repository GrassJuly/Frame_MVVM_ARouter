package com.runjing.home.ui

import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.runjing.home.R
import com.runjing.home.bean.response.home.*
import com.socks.library.KLog
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.util.BannerUtils
import org.base.utils.AppMethod
import org.frame.http.net.BaseApiService
import org.frame.utils.GlideUtils
import org.frame.utils.ToastUtils
import org.frame.utils.constant.BaseConfig

/**
 * @Created: qianxs  on 2020.08.23 22:15.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.23 22:15.
 * @Remark:
 */

class HomeAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var response: HomeBean? = null

    fun setData(data: HomeBean?) {
        KLog.e(response)
        if (data != null) {
            response = data
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (response != null) {
            if (viewType == BaseConfig.CONFIG_ONE) {
                return GoodHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_layout_good, null))
            } else if (viewType == BaseConfig.CONFIG_TWO) {
                return StoreHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_store_msg, parent, false))
            } else if (viewType == BaseConfig.CONFIG_THREE) {
                return ProvincesHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_item_proviences, parent, false))
            }
        }
        return ProvincesHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_item_proviences, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (response != null) {
            if (response?.getItemTpye() === BaseConfig.CONFIG_ONE) {
                (holder as GoodHolder).setData(response?.getHomeGoodBean()?.getData()?.getList(), position)
            } else if (response?.getItemTpye() === BaseConfig.CONFIG_TWO) {
                (holder as StoreHolder).setData(response?.getHomeStoreBean()?.getData()?.getFreshStoreVOList(), position)
            } else if (response?.getItemTpye() === BaseConfig.CONFIG_THREE) {
                (holder as ProvincesHolder).setData(response?.getDistrictBean()?.getData()!!, position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return response?.itemTpye!!
    }

    override fun getItemCount(): Int {
        if (response != null) {
            if (response?.itemTpye == BaseConfig.CONFIG_ONE) {
                return if (response?.homeGoodBean?.data?.list != null) response?.homeGoodBean?.data?.list?.size!! else 0
            } else if (response?.itemTpye == BaseConfig.CONFIG_TWO) {
                return if (response?.homeStoreBean?.data?.freshStoreVOList != null) response?.homeStoreBean?.data?.freshStoreVOList?.size!! else 0
            } else if (response?.itemTpye == BaseConfig.CONFIG_THREE) {
                return if (response?.districtBean?.data != null) response?.districtBean?.data?.size!! else 0
            }
        }
        return 0
    }


    class GoodHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ll_detail: LinearLayout
        private val iv_good: ImageView
        private val tv_name: TextView
        private val tv_desc: TextView
        private val tv_price: TextView
        private var tv_favprice: TextView
        private val rv_tag: RecyclerView
        private val ll_plus: LinearLayout
        private val tv_PlusPrice: TextView? = null
        fun setData(goods: List<GoodBean.DataBean.ListBean>?, position: Int) {
            if (goods != null && goods.size > 0) {
//                setMargin(ll_detail, position);
                GlideUtils.getInstance().glideLoad(iv_good.context, BaseApiService.BasePic + goods[position].getImages().get(0).getImgUrl(), iv_good)
                tv_name.setText(AppMethod.setDefault(goods[position].getGoodsName()))
                val promoDescList: List<GoodBean.DataBean.ListBean.SkuPromotionResultBean.PromoDescListBean> = goods[position].getSkuPromotionResult().getPromoDescList()
                val spanLayoutManager: ChipsLayoutManager = ChipsLayoutManager.newBuilder(rv_tag.context)
                        .setOrientation(ChipsLayoutManager.VERTICAL)
                        .setMaxViewsInRow(4)
                        .build()
                val manager: FlexboxLayoutManager = object : FlexboxLayoutManager(rv_tag.context, FlexDirection.ROW, FlexWrap.WRAP) {
                    override fun canScrollVertically(): Boolean {
                        return false
                    }
                }
                rv_tag.layoutManager = manager
                rv_tag.adapter = TagAdapter(promoDescList)
                if (TextUtils.isEmpty(privilegePrice(promoDescList))) {
                    tv_price.text = "¥" + AppMethod.changTVsize(AppMethod.setDefault(AppMethod.setDefault(goods[position].getSalesPrice().toString() + "")))
                    tv_favprice.visibility = View.INVISIBLE
                } else {
                    tv_price.text = "¥" + privilegePrice(promoDescList)
                    tv_favprice.visibility = View.VISIBLE
                }
                AppMethod.setTextViewLine(tv_favprice)
                tv_favprice.text = "¥" + AppMethod.changTVsize(AppMethod.setDefault(AppMethod.setDefault(goods[position].getMarketPrice().toString() + "")))
                ll_detail.setOnClickListener {
                    ToastUtils.showLong("跳转商品详情界面")
                }
            }
        }

        /**
         * 获取优惠价格
         * @param promoDescList
         * @return
         */
        fun privilegePrice(promoDescList: List<GoodBean.DataBean.ListBean.SkuPromotionResultBean.PromoDescListBean>?): String {
            if (promoDescList != null && promoDescList.size > 0) {
                for (desc in promoDescList) {
                    if (desc.getPromoSubType() === 100) {
                        return AppMethod.changTVsize(AppMethod.setDefault(desc.getPrivilegePrice().toString() + "")).toString() + ""
                    }
                }
            }
            return ""
        }

        /**
         * 设置编剧
         *
         * @param n
         * @return
         */
        fun isOne(n: Int): Boolean {
            var n = n
            return if (n <= 0) false else (n - 1).let { n = n and it; n } == 0
        }

        init {
            ll_detail = itemView.findViewById(R.id.lay_ll_order_detail)
            iv_good = itemView.findViewById(R.id.lay_iv_good)
            tv_name = itemView.findViewById(R.id.lay_tv_name)
            tv_desc = itemView.findViewById(R.id.lay_tv_desc)
            tv_price = itemView.findViewById(R.id.lay_tv_price)
            tv_favprice = itemView.findViewById(R.id.lay_tv_favorablePrice)
            rv_tag = itemView.findViewById(R.id.lay_rv_tag)
            rv_tag.setHasFixedSize(false)
            rv_tag.isNestedScrollingEnabled = false
            ll_plus = itemView.findViewById(R.id.lay_ll_plus)
            tv_favprice = itemView.findViewById(R.id.lay_tv_Plus_price)
        }
    }

    class StoreHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iv_store: ImageView
        private val tv_name: TextView
        private val tv_address: TextView
        private val tv_distance: TextView
        private val tv_rest: TextView
        private val ll_location: LinearLayout
        private val tv_store: TextView
        fun setData(stores: List<HomeStoreBean.DataBean.FreshStoreVOListBean>?, position: Int) {
            if (stores != null && stores.size > 0) {
                GlideUtils.getInstance().glideLoad(iv_store.context, stores[position].getImage(), iv_store)
                tv_name.setText(AppMethod.setDefault(stores[position].getName()))
                tv_address.setText(AppMethod.setDefault(stores[position].getAddressDetail()))
                tv_distance.setText(AppMethod.setDefault(stores[position].getDistance()).toString() + "km")
                if (stores[position].getStatus() === 1) {
                    tv_rest.visibility = View.GONE
                } else if (stores[position].getStatus() === 2) {
                    tv_rest.visibility = View.VISIBLE
                }
                ll_location.setOnClickListener {
                    //                        ViewInject.longToast("导航页面");
                }
                tv_store.setOnClickListener {

                }
            }
        }

        init {
            iv_store = itemView.findViewById(R.id.lay_item_iv_store)
            tv_name = itemView.findViewById(R.id.lay_item_tv_name)
            tv_rest = itemView.findViewById(R.id.lay_item_tv_rest)
            tv_address = itemView.findViewById(R.id.lay_item_tv_address)
            tv_distance = itemView.findViewById(R.id.lay_item_tv_distance)
            ll_location = itemView.findViewById(R.id.lay_item_ll_location)
            tv_store = itemView.findViewById(R.id.lay_item_tv_store)
        }
    }

    class ProvincesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tv_provinces: TextView
        private val rv_city: RecyclerView
        fun setData(provinces: List<DistrictBean.DataBean>, position: Int) {
            tv_provinces.setText(AppMethod.setDefault(provinces[position].getName()))
            val adapter = CityAdapter(tv_provinces.context)
            rv_city.setHasFixedSize(false)
            rv_city.layoutManager = GridLayoutManager(tv_provinces.context, 3)
            rv_city.isNestedScrollingEnabled = false //禁止滑动
            rv_city.adapter = adapter
            adapter.setData(provinces[position].childrenList)
        }

        init {
            tv_provinces = itemView.findViewById(R.id.lay_item_tv_proviences)
            rv_city = itemView.findViewById(R.id.lay_item_rv_city)
        }
    }


}

/**
 * @Created: qianxs  on 2020.07.19 04:16.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.07.19 04:16.
 * @Remark:
 */
class TagAdapter(tags: List<GoodBean.DataBean.ListBean.SkuPromotionResultBean.PromoDescListBean>?) : RecyclerView.Adapter<TagAdapter.TagHolder>() {
    private val tags: List<GoodBean.DataBean.ListBean.SkuPromotionResultBean.PromoDescListBean>? = tags
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagHolder {
        return TagHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_item_tag, parent, false))
    }

    override fun onBindViewHolder(holder: TagHolder, position: Int) {
        //后期可以放图片自行决定， 后来人看你了。
        if (tags != null) {
            val type: Int = tags[position].getPromoSubType()
            when (type) {
                100 -> holder.tv_tag.text = "直降"
                101 -> holder.tv_tag.text = "单品折扣"
                102 -> holder.tv_tag.text = "买赠"
                200 -> holder.tv_tag.text = "买赠"
                300 -> holder.tv_tag.text = "满减"
                301 -> holder.tv_tag.text = "满折"
                302 -> holder.tv_tag.text = "满赠"
                307 -> holder.tv_tag.text = "几元几件"
                1001 -> holder.tv_tag.text = "酒币抵现"
                1002 -> holder.tv_tag.text = "买送酒币"
                1003 -> holder.tv_tag.text = "PLUS专享"
                else -> {
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return tags?.size ?: 0
    }

    class TagHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_tag: TextView = itemView.findViewById(R.id.lay_tv_tag)
    }

}

/**
 * @Created: qianxs  on 2020.07.19 04:16.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.07.19 04:16.
 * @Remark:
 */
class CityAdapter(private val context: Context) : RecyclerView.Adapter<CityAdapter.CityHolder>() {
    private var citys: List<DistrictBean.DataBean.ChildrenListBean> = ArrayList<DistrictBean.DataBean.ChildrenListBean>()
    fun setData(data: List<DistrictBean.DataBean.ChildrenListBean>?) {
        if (data != null && data.size > 0) {
            citys = data
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        return CityHolder(LayoutInflater.from(context).inflate(R.layout.home_item_city, parent, false))
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.tv_city.text = AppMethod.setDefault(citys[position].name)
        holder.tv_city.setOnClickListener {
            ToastUtils.showLong(citys[position].name)
        }
    }

    override fun getItemCount(): Int {
        return if (citys.size > 0) citys.size else 0
    }

    class CityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_city: TextView = itemView.findViewById(R.id.lay_item_tv_)

    }

}

/**
 * @Created: qianxs  on 2020.07.19 04:16.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.07.19 04:16.
 * @Remark:
 */
class BannerItemAdapter(mDatas: List<BannerBean.DataBean>?) : BannerAdapter<BannerBean.DataBean?, BannerItemAdapter.BannerViewHolder?>(mDatas) {
    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
        val imageView = BannerUtils.getView(parent!!, R.layout.layout_item_banner) as ImageView
        //通过裁剪实现圆角
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            BannerUtils.setBannerRound(imageView, 20f)
        }
        return BannerViewHolder(imageView)
    }

    override fun onBindView(holder: BannerViewHolder?, data: BannerBean.DataBean?, position: Int, size: Int) {
        GlideUtils.getInstance().glideLoad(holder?.imageView?.context, data?.getImgUrl(), holder?.imageView)
        holder?.imageView?.setOnClickListener {
        }
    }

    inner class BannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView

        init {
            imageView = view as ImageView
        }
    }

    init {
        //设置数据，也可以调用banner提供的方法,或者自己在adapter中实现
    }
}