package chencheng.bwie.com.lianxi20180508.presenter;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import chencheng.bwie.com.lianxi20180508.bean.LoginBean;
import chencheng.bwie.com.lianxi20180508.model.ILogModel;
import chencheng.bwie.com.lianxi20180508.model.IRegisterModel;
import chencheng.bwie.com.lianxi20180508.model.LogModel;
import chencheng.bwie.com.lianxi20180508.model.RegsiterModel;
import chencheng.bwie.com.lianxi20180508.net.OnNetListener;
import chencheng.bwie.com.lianxi20180508.view.IMainActivity;

/**
 * Created by dell on 2018/5/8.
 */

public class LoginPresenter {
    private IMainActivity iMainActivity;
    private  ILogModel iLogModel;
    private IRegisterModel iRegisterModel;


    public LoginPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iLogModel = new LogModel();
        iRegisterModel = new RegsiterModel();
    }


    public void login() {
        String account = iMainActivity.getAccount();
        String pwd = iMainActivity.getPwd();
        //判断账号密码是否正确
        if (checkAccount(account) && checkPwd(pwd)) {
            //去调用model，进行登陆
            iLogModel.getLogin(account, pwd, new OnNetListener<LoginBean>() {
                @Override
                public void onSuccess(LoginBean loginBean) {
                    //保存登陆成功后的数据，可以保存到SP,也可以保存到数据库
                    iMainActivity.show(loginBean.getMsg());
                    //跳转到分类界面
                    iMainActivity.toClassAc();
                }


                @Override
                public void onFailure(Exception e) {


                }
            });
        }


    }


    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            //给用户提示，输入的账号不能为空
            iMainActivity.show("请输入密码");
            return false;
        }


        if (pwd.length() != 6) {
            iMainActivity.show("请输入6位密码");
            return false;
        }
        return true;
    }




    /**
     * 验证手机号是否正确
     *
     * @param account
     */
    private boolean checkAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            //给用户提示，输入的账号不能为空
            iMainActivity.show("请输入账号");
            return false;
        }
        if (!isMobileNO(account)) {
            iMainActivity.show("请输入正确的手机号");
            return false;
        }
        return true;
    }




    /*
    判断是否是手机号
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }




    public void register() {
        //其实就是跳转到注册页面
        iMainActivity.toRegisterAc();
    }
}
