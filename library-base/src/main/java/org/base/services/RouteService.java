package org.base.services;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @Created: qianxs  on 2020.08.19 18:11.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.08.19 18:11.
 * @Remark:
 */
public interface RouteService extends IProvider {
    <T> void set(T ...t);
}
