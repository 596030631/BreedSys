package sj.app.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sj.app.R;
import sj.app.presenter.ILoginPresenter;
import sj.app.presenter.ILoginPresenterImpl;
import sj.app.view.activity.HomeActivity;

public class LoginActivity extends AppCompatActivity implements ILoginView,View.OnClickListener{
    private String mClear = "";
    private EditText login_name;
    private EditText login_password;
    private TextView btn_login;
    protected ILoginPresenter loginPresenter;
    private String name;
    private String passwd;

    private static boolean Exit = false;
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Exit = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullScreen(this);
        setContentView(R.layout.activity_login);
        login_name = findViewById(R.id.et_user_name);
        login_password = findViewById(R.id.et_user_password);
        btn_login = findViewById(R.id.btn_login);
//        btn_clear = findViewById(R.id.btn_clear);
        btn_login.setOnClickListener(this);
//        btn_clear.setOnClickListener(this);
        //绑定实现类将数据传递到实现类中实现相应逻辑
        loginPresenter = new ILoginPresenterImpl(this);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public void exit(){
        if(!Exit){
            Exit = true;
            Toast.makeText(this, "再按一次退出程序！", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0,2000);
        }else{
            finish();
            System.exit(0);
        }
    }
    //实现View接口两个方法
    @Override
    public void clearView() {
        //进行清除EditText内容
        login_name.setText(mClear);
        login_password.setText(mClear);
    }
    @Override
    public void loginResultView(Boolean result,int code) {
        btn_login.setEnabled(true);
        if(result){
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }else{
            Toast.makeText(this,"请检查！", Toast.LENGTH_SHORT).show();
        }
    }
//点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                name = login_name.getText().toString();
                passwd = login_password.getText().toString();
                //去presenter执行登陆逻辑
                if(!TextUtils.equals("",name) && !TextUtils.equals("",passwd)){
                    loginPresenter.doLogin(name,passwd);
                }else{
                    Toast.makeText(this, "用户名密码", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    /*通过设置全屏，设置状态栏透明*/
    private void fullScreen(Activity activity){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                //5.0开始需要设置颜色透明，否则会设置成浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }else{
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
                window.setAttributes(attributes);
            }
        }
    }
}
