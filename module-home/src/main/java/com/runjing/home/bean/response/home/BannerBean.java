package com.runjing.home.bean.response.home;

import java.util.List;

/**
 * @Created: qianxs  on 2020.07.30 16:34.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.07.30 16:34.
 * @Remark:
 */
public class BannerBean {

    /**
     * code : 200
     * data : [{"activityTitle":"慢必赔","bannerId":"408","bannerType":2,"createTime":1596159083000,"imgUrl":"https://img.jd9sj.com/YmFubmVyXzIwMjAtMDgtMDhfMzAyNzFmOTQ0ZWRkNDVjNGI5NmQwMzNmMjc5MzhhZDFf5b6u5L-h5Zu-54mHXzIwMjAwODA4MjEwMDA1LnBuZw==","platformType":2,"ranked":"1","updateTime":1596891769000,"url":"/pages/webview/invite/invite?acid=11550"},{"activityTitle":"8月plus会员专区2","bannerId":"429","bannerType":2,"createTime":1596190533000,"imgUrl":"https://img.jd9sj.com/YmFubmVyXzIwMjAtMDctMzFfMGIxNjcxYmM3NjNhNGU2YjhlMWUxMDUzMjUyMWMxYjVf5b6u5L-h5Zu-54mHXzIwMjAwNzMxMTgwOTU3MTExMS5wbmc=","platformType":2,"ranked":"2","updateTime":1596207259000,"url":"/pages/webview/invite/invite?acid=11985"},{"activityTitle":"8月啤酒节","bannerId":"434","bannerType":2,"createTime":1596208247000,"imgUrl":"https://img.jd9sj.com/YmFubmVyXzIwMjAtMDctMzFfNTRjZjQ4NzlhMjY1NDY0NGEwMjI0MDU3MjAwOWNkYWVf5ZWk6YWS6IqCYmFubmVyLnBuZw==","platformType":2,"ranked":"3","updateTime":1596208594000,"url":"/pages/webview/invite/invite?acid=11991"},{"activityTitle":"北京进店必买","bannerId":"433","bannerType":2,"createTime":1596195585000,"imgUrl":"https://img.jd9sj.com/YmFubmVyXzIwMjAtMDctMzFfN2M2Yzg0YTEyNDFlNDIyZWFkZDU4ZDQ4Mjc5YjU2MzFf5LmY6aOO56C05rWq55qE576O6YWS4oCU4oCUYmFubmVyLnBuZw==","platformType":2,"ranked":"3","updateTime":1596206643000,"url":"/pages/webview/invite/invite?acid=11989"},{"activityTitle":"酒币抵扣","bannerId":"432","bannerType":2,"createTime":1596194085000,"imgUrl":"https://img.jd9sj.com/YmFubmVyXzIwMjAtMDctMzFfNTFhMzdkZmM4OGVhNDliZWJkNzZhOWIwMWMzZmIyYzRfYmFubmVyLnBuZw==","platformType":2,"ranked":"4","updateTime":1596195948000,"url":"/pages/webview/invite/invite?acid=11988"},{"activityTitle":"8月Plus会员权益","bannerId":"426","bannerType":2,"createTime":1596187280000,"imgUrl":"https://img.jd9sj.com/YmFubmVyXzIwMjAtMDctMzFfZjJlNTA0MTVhMDVmNDI2OWEyN2Q0YWM5YzczYTczNTBf5Zu-MS5qcGc=","platformType":2,"ranked":"6","updateTime":1596187691000,"url":"/pages/webview/invite/invite?acid=11981"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * activityTitle : 慢必赔
         * bannerId : 408
         * bannerType : 2
         * createTime : 1596159083000
         * imgUrl : https://img.jd9sj.com/YmFubmVyXzIwMjAtMDgtMDhfMzAyNzFmOTQ0ZWRkNDVjNGI5NmQwMzNmMjc5MzhhZDFf5b6u5L-h5Zu-54mHXzIwMjAwODA4MjEwMDA1LnBuZw==
         * platformType : 2
         * ranked : 1
         * updateTime : 1596891769000
         * url : /pages/webview/invite/invite?acid=11550
         */

        private String activityTitle;
        private String bannerId;
        private int bannerType;
        private long createTime;
        private String imgUrl;
        private int platformType;
        private String ranked;
        private long updateTime;
        private String url;

        public String getActivityTitle() {
            return activityTitle;
        }

        public void setActivityTitle(String activityTitle) {
            this.activityTitle = activityTitle;
        }

        public String getBannerId() {
            return bannerId;
        }

        public void setBannerId(String bannerId) {
            this.bannerId = bannerId;
        }

        public int getBannerType() {
            return bannerType;
        }

        public void setBannerType(int bannerType) {
            this.bannerType = bannerType;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getPlatformType() {
            return platformType;
        }

        public void setPlatformType(int platformType) {
            this.platformType = platformType;
        }

        public String getRanked() {
            return ranked;
        }

        public void setRanked(String ranked) {
            this.ranked = ranked;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "activityTitle='" + activityTitle + '\'' +
                    ", bannerId='" + bannerId + '\'' +
                    ", bannerType=" + bannerType +
                    ", createTime=" + createTime +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", platformType=" + platformType +
                    ", ranked='" + ranked + '\'' +
                    ", updateTime=" + updateTime +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
