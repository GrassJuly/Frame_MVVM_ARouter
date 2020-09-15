package com.runjing.home.bean.request;

import org.base.base.BaseRequest;

/**
 * @Created: qianxs  on 2020.08.01 21:41.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.08.01 21:41.
 * @Remark:
 */
public class HomeRequest extends BaseRequest {
    private int pageSize;
    private int pageNo;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "HomeRequest{" +
                "pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                '}';
    }
}
