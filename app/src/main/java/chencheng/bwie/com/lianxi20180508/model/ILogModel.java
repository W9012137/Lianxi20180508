package chencheng.bwie.com.lianxi20180508.model;

import chencheng.bwie.com.lianxi20180508.bean.LoginBean;
import chencheng.bwie.com.lianxi20180508.net.OnNetListener;

/**
 * Created by dell on 2018/5/8.
 */

public interface ILogModel {
    void getLogin(String mobile, String password , OnNetListener<LoginBean> netListener);
}
