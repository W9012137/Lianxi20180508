package chencheng.bwie.com.lianxi20180508.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2018/5/8.
 */

public class RetrofitUtils {
    private static OkHttpClient client;
    private static ServerApi serverApi;
    //静态
    static {
        getClient();
    }
    //单例模式
    public static OkHttpClient getClient(){
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (client==null){
            synchronized (RetrofitUtils.class){
                if (client==null){
                    client=new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .connectTimeout(3000, TimeUnit.MILLISECONDS)
                            .build();
                }
            }
        }
        return client;
    }
    //单例模式
    public static ServerApi getServerApi(){
        if (serverApi==null){
            synchronized (OkHttpClient.class){
                if (serverApi==null){
                    serverApi=RetrofitUtils.onCreate(ServerApi.class,Api.HOME);
                }
            }
        }
        return serverApi;
    }
    public static <T> T onCreate(Class<T> tClass,String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        return  retrofit.create(tClass);
    }
}
