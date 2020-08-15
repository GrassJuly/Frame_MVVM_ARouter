package com.runjing.home.bean.response.guild;

import org.frame.http.net.BaseResponse;

import java.util.List;

/**
 * @Created: qianxs  on 2020.07.20 13:48.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.07.20 13:48.
 * @Remark:
 */
public class GuildBean extends BaseResponse<GuildBean> {
    private List<GuildImageBean> img;

    public List<GuildImageBean> getImg() {
        return img;
    }

    public void setImg(List<GuildImageBean> img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "GuildBean{" +
                "img=" + img +
                '}';
    }
}
