package org.base.base;

import org.frame.http.net.BaseResponse;
import org.frame.http.net.ExceptionHandle;

/**
 * @Created: qianxs  on 2020.08.15 23:11.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version: v_1.0 on 2020.08.15 23:11.
 * @Remark:
 */
public interface BCallBack<T> {
    
    void onResponse(T response);
    void onError(ExceptionHandle.ResponeThrowable throwable);
    void onCompleted();
}
