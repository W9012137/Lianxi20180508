package chencheng.bwie.com.lianxi20180508.model;

import java.util.HashMap;

import chencheng.bwie.com.lianxi20180508.bean.LoginBean;
import chencheng.bwie.com.lianxi20180508.net.OnNetListener;
import chencheng.bwie.com.lianxi20180508.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/5/8.
 */

public class LogModel implements ILogModel {
    @Override
    public void getLogin(String mobile, String password, final OnNetListener<LoginBean> netListener) {
        final HashMap<String,String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        Flowable flowable= RetrofitUtils.getServerApi().login("user/login ",map);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {

                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        netListener.onSuccess(loginBean);
                    }

                });
    }
}
