package chencheng.bwie.com.lianxi20180508.model;

import java.util.HashMap;

import chencheng.bwie.com.lianxi20180508.bean.Registerbean;
import chencheng.bwie.com.lianxi20180508.net.OnNetListener;
import chencheng.bwie.com.lianxi20180508.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/5/8.
 */

public class RegsiterModel implements IRegisterModel {
    @Override
    public void getRegister(String mobile, String password, final OnNetListener<Registerbean> netListener) {
        final HashMap<String,String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        Flowable flowable= RetrofitUtils.getServerApi().login("user/reg",map);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Registerbean>() {


                    @Override
                    public void accept(Registerbean registerbean) throws Exception {
                        netListener.onSuccess(registerbean);
                    }



                });

    }
}
