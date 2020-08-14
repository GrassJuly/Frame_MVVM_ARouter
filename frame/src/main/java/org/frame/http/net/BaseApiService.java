package org.frame.http.net;


import com.google.gson.Gson;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Ｔａｍｉｃ on 2016-07-08.
 * {@link # https://github.com/NeglectedByBoss/RetrofitClient}
 */
public interface BaseApiService {
    public final static String BasePic = "https://img11.360buyimg.com/xstore/";//图片前缀

    public final static String BaseUrl = "https://cxc.jd9sj.com/api/";//线上正式环境
//    public final static String BaseUrl = "https://pre-cxc.jd9sj.com/api/";//线上正式环境
//    public final static String BaseUrl = "http://116.196.90.67:9002/api/";//测试环境

    class MyRequestBody {
        public static RequestBody createBody(Object request) {
            return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(request));
        }
    }

    @GET("{url}")
    Observable<BaseResponse<Object>> executeGet(
            @Path("url") String url,
            @QueryMap Map<String, String> maps
    );


    @POST("{url}")
    Observable<ResponseBody> executePost(
            @Path("url") String url,
            //  @Header("") String authorization,
            @QueryMap Map<String, String> maps);

    @POST("{url}")
    Observable<ResponseBody> json(
//            @Path("url") String url,
            //解决url 乱码问题
            @Path(value = "url", encoded = true) String url,
            @Body RequestBody jsonStr);

    @Multipart
    @POST("{url}")
    Observable<ResponseBody> upLoadFile(
            @Path("url") String url,
            @Part("image\"; filename=\"image.jpg") RequestBody requestBody);

    @POST("{url}")
    Call<ResponseBody> uploadFiles(
            @Path("url") String url,
            @Path("headers") Map<String, String> headers,
            @Part("filename") String description,
            @PartMap() Map<String, RequestBody> maps);

    @Streaming
    @GET
    Observable<ResponseBody> downloadFile(@Url String fileUrl);


//    /**
//     * 普通写法
//     */
//    @GET("service/getIpInfo.php")
//    Observable<BaseResponse<IpResult>> getData(@Query("ip") String ip);

    @POST("{url}")
    Observable<BaseResponse<Response>> onLogin(
            //解决url 乱码问题
            @Path(value = "url", encoded = true) String url,
            @Body RequestBody jsonStr);


    /*登陆接口*/
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("xx/xx")
    Observable<Response> testHttp(@Body RequestBody body);
}
