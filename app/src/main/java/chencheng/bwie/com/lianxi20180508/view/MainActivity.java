package chencheng.bwie.com.lianxi20180508.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import chencheng.bwie.com.lianxi20180508.R;
import chencheng.bwie.com.lianxi20180508.presenter.LoginPresenter;

public class MainActivity extends BaseActivity implements View.OnClickListener ,IMainActivity{

    /**
     * 登录界面
     */
    private TextView mTextView;
    private ImageView mIvLogin;
    /**
     * 请输入账号
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPwd;
    /**
     * 注册账号
     */
    private TextView mRegister;
    /**
     * 登录
     */
    private Button mLogin;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new LoginPresenter(this);
        initView();

    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
        mIvLogin = (ImageView) findViewById(R.id.iv_login);
        mPhone = (EditText) findViewById(R.id.phone);
        mPwd = (EditText) findViewById(R.id.pwd);
        mRegister = (TextView) findViewById(R.id.register);
        mRegister.setOnClickListener(this);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.register:
                //跳转到注册页面
                presenter.register();
                break;
            case R.id.login:
                presenter.login();
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
    public void show(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void toRegisterAc() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);

    }

    @Override
    public void toClassAc() {
        Intent intent = new Intent(MainActivity.this,Other.class);
        startActivity(intent);

    }
}
