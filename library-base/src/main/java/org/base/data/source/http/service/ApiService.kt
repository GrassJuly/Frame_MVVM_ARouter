package org.base.data.source.http.service

import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody
import org.base.base.BaseRequest

/**
 * @Created: qianxs  on 2020.08.15 21:50.
 * @Describe：
 * @Review：
 * @Modify：
 * @Version:  v_1.0 on 2020.08.15 21:50.
 * @Remark:
 */
interface ApiService {
    companion object {
        //图片前缀
        const val BasePic = "https://img11.360buyimg.com/xstore/"
        //线上正式环境
        const val BaseUrl = "https://cxc.jd9sj.com/api/"
        //线上正式环境
//        const val String BaseUrl = "https://pre-cxc.jd9sj.com/api/";
        //测试环境
//        const val String BaseUrl = "http://116.196.90.67:9002/api/";
    }

    class BRequestBody private constructor() {
        companion object {
            @Volatile
            var instance: BRequestBody? = null

            fun getB(): BRequestBody {
                if (instance == null) {
                    synchronized(BRequestBody::class) {
                        if (instance == null) {
                            instance = BRequestBody()
                        }
                    }
                }
                return instance!!
            }

            fun destroyInstance() {
                instance = null
            }
        }

        fun createBody(request: BaseRequest?): RequestBody? {
            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), Gson().toJson(request))
        }
    }
}