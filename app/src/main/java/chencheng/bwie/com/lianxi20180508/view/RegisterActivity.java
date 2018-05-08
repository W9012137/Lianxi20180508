package chencheng.bwie.com.lianxi20180508.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import chencheng.bwie.com.lianxi20180508.R;
import chencheng.bwie.com.lianxi20180508.presenter.RegisterPresenter;

/**
 * Created by dell on 2018/5/8.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener,IRegisterActivity{
    /**
     * 注册界面
     */
    private TextView mTextView;
    private ImageView mIvRegister;
    /**
     * 请输入账号
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPwd;
    /**
     * 注册
     */
    private Button mLogin;
 private RegisterPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        presenter=new RegisterPresenter(this);
        initView();
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
        mIvRegister = (ImageView) findViewById(R.id.iv_register);
        mIvRegister.setOnClickListener(this);
        mPhone = (EditText) findViewById(R.id.phone);
        mPwd = (EditText) findViewById(R.id.pwd);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_register:

                break;
            case R.id.login:
                presenter.register();
                break;
        }
    }

    @Override
    public String getAccount() {
        return mPhone.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mPwd.getText().toString().trim();
    }

    @Override
    public void finishAc() {
        finish();
    }

    @Override
    public void show(String str) {
        Toast.makeText(RegisterActivity.this, str, Toast.LENGTH_SHORT).show();
    }
}
