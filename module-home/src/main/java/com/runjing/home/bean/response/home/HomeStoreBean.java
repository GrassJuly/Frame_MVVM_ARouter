package com.runjing.home.bean.response.home;

import java.util.List;

/**
 * @Created: qianxs  on 2020.07.30 16:33.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.07.30 16:33.
 * @Remark:
 */
public class HomeStoreBean {


    /**
     * code : 200
     * data : {"freshStoreVOList":[{"addressDetail":"北京市朝阳区吉庆里14号楼1层101内C","distance":"720.00","freshShopType":6,"id":131422,"image":"https://img.jd9sj.com/WechatIMG418.jpeg","latitude":"39.927925","longitude":"116.440563","name":"京东酒世界仟禧名酒行","openTimeEnd":"23:30","openTimeStart":"09:00","shopMap":"","status":2,"storeType":0},{"addressDetail":"北京市东城区国瑞城中区9号楼1层107","distance":"3020.00","freshShopType":6,"id":131423,"image":"https://img.jd9sj.com/WechatIMG418.jpeg","latitude":"39.898772","longitude":"116.424899","name":"京东酒世界顺雅华盛（国瑞城店）","openTimeEnd":"23:30","openTimeStart":"09:00","shopMap":"","status":2,"storeType":0}],"type":1}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * freshStoreVOList : [{"addressDetail":"北京市朝阳区吉庆里14号楼1层101内C","distance":"720.00","freshShopType":6,"id":131422,"image":"https://img.jd9sj.com/WechatIMG418.jpeg","latitude":"39.927925","longitude":"116.440563","name":"京东酒世界仟禧名酒行","openTimeEnd":"23:30","openTimeStart":"09:00","shopMap":"","status":2,"storeType":0},{"addressDetail":"北京市东城区国瑞城中区9号楼1层107","distance":"3020.00","freshShopType":6,"id":131423,"image":"https://img.jd9sj.com/WechatIMG418.jpeg","latitude":"39.898772","longitude":"116.424899","name":"京东酒世界顺雅华盛（国瑞城店）","openTimeEnd":"23:30","openTimeStart":"09:00","shopMap":"","status":2,"storeType":0}]
         * type : 1
         */

        private int type;
        private List<FreshStoreVOListBean> freshStoreVOList;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<FreshStoreVOListBean> getFreshStoreVOList() {
            return freshStoreVOList;
        }

        public void setFreshStoreVOList(List<FreshStoreVOListBean> freshStoreVOList) {
            this.freshStoreVOList = freshStoreVOList;
        }

        public static class FreshStoreVOListBean {
            /**
             * addressDetail : 北京市朝阳区吉庆里14号楼1层101内C
             * distance : 720.00
             * freshShopType : 6
             * id : 131422
             * image : https://img.jd9sj.com/WechatIMG418.jpeg
             * latitude : 39.927925
             * longitude : 116.440563
             * name : 京东酒世界仟禧名酒行
             * openTimeEnd : 23:30
             * openTimeStart : 09:00
             * shopMap :
             * status : 2
             * storeType : 0
             */

            private String addressDetail;
            private String distance;
            private int freshShopType;
            private int id;
            private String image;
            private String latitude;
            private String longitude;
            private String name;
            private String openTimeEnd;
            private String openTimeStart;
            private String shopMap;
            private int status;
            private int storeType;

            public String getAddressDetail() {
                return addressDetail;
            }

            public void setAddressDetail(String addressDetail) {
                this.addressDetail = addressDetail;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public int getFreshShopType() {
                return freshShopType;
            }

            public void setFreshShopType(int freshShopType) {
                this.freshShopType = freshShopType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOpenTimeEnd() {
                return openTimeEnd;
            }

            public void setOpenTimeEnd(String openTimeEnd) {
                this.openTimeEnd = openTimeEnd;
            }

            public String getOpenTimeStart() {
                return openTimeStart;
            }

            public void setOpenTimeStart(String openTimeStart) {
                this.openTimeStart = openTimeStart;
            }

            public String getShopMap() {
                return shopMap;
            }

            public void setShopMap(String shopMap) {
                this.shopMap = shopMap;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getStoreType() {
                return storeType;
            }

            public void setStoreType(int storeType) {
                this.storeType = storeType;
            }

            @Override
            public String toString() {
                return "FreshStoreVOListBean{" +
                        "addressDetail='" + addressDetail + '\'' +
                        ", distance='" + distance + '\'' +
                        ", freshShopType=" + freshShopType +
                        ", id=" + id +
                        ", image='" + image + '\'' +
                        ", latitude='" + latitude + '\'' +
                        ", longitude='" + longitude + '\'' +
                        ", name='" + name + '\'' +
                        ", openTimeEnd='" + openTimeEnd + '\'' +
                        ", openTimeStart='" + openTimeStart + '\'' +
                        ", shopMap='" + shopMap + '\'' +
                        ", status=" + status +
                        ", storeType=" + storeType +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "type=" + type +
                    ", freshStoreVOList=" + freshStoreVOList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HomeStoreBean{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
