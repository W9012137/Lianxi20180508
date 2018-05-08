package chencheng.bwie.com.lianxi20180508.net;

import java.util.Map;

import chencheng.bwie.com.lianxi20180508.bean.LoginBean;
import chencheng.bwie.com.lianxi20180508.bean.Registerbean;
import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by dell on 2018/5/8.
 */

public interface ServerApi {
    @POST
    Flowable<LoginBean> login(@Url String url, @QueryMap Map<String,String> map);
    @POST
    Flowable<Registerbean> Register(@Url String url, @QueryMap Map<String,String> map);

}
