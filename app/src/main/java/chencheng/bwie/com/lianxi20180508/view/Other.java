package chencheng.bwie.com.lianxi20180508.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import chencheng.bwie.com.lianxi20180508.R;

/**
 * Created by dell on 2018/5/8.
 */

public class Other extends AppCompatActivity {
    /**
     * 登陆成功
     */
    private TextView mText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        initView();
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text);
    }
}
