package chencheng.bwie.com.lianxi20180508.presenter;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import chencheng.bwie.com.lianxi20180508.bean.Registerbean;
import chencheng.bwie.com.lianxi20180508.model.IRegisterModel;
import chencheng.bwie.com.lianxi20180508.model.RegsiterModel;
import chencheng.bwie.com.lianxi20180508.net.OnNetListener;
import chencheng.bwie.com.lianxi20180508.view.IRegisterActivity;

/**
 * Created by dell on 2018/5/8.
 */

public class RegisterPresenter {
    private IRegisterActivity iRegisterActivity;
    private IRegisterModel iRegisterModel;


    public RegisterPresenter(IRegisterActivity iRegisterActivity) {
        this.iRegisterActivity = iRegisterActivity;
        iRegisterModel = new RegsiterModel();
    }




    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            //给用户提示，输入的账号不能为空
            iRegisterActivity.show("请输入密码");
            return false;
        }


        if (pwd.length() != 6) {
            iRegisterActivity.show("请输入6位密码");
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
            iRegisterActivity.show("请输入账号");
            return false;
        }
        if (!isMobileNO(account)) {
            iRegisterActivity.show("请输入正确的手机号");
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
        String account = iRegisterActivity.getAccount();
        String pwd = iRegisterActivity.getPwd();
        //判断账号密码是否正确
        if (checkAccount(account) && checkPwd(pwd)) {
            iRegisterModel.getRegister(account, pwd, new OnNetListener<Registerbean>() {
                @Override
                public void onSuccess(Registerbean registerbean) {
                    //成功以后，回到登陆界面
                    if (registerbean.getCode().equals("1")) {
                        iRegisterActivity.show(registerbean.getMsg());
                    } else {
                        iRegisterActivity.show(registerbean.getMsg());
                        iRegisterActivity.finishAc();
                    }
                }


                @Override
                public void onFailure(Exception e) {


                }
            });
        }


    }
}
