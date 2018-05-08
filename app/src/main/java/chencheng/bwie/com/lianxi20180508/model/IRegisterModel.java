package chencheng.bwie.com.lianxi20180508.model;

import chencheng.bwie.com.lianxi20180508.bean.Registerbean;
import chencheng.bwie.com.lianxi20180508.net.OnNetListener;

/**
 * Created by dell on 2018/5/8.
 */

public interface IRegisterModel {
    void getRegister(String mobile, String password , OnNetListener<Registerbean> netListener );
}
