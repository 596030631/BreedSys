package sj.app.view.activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import sj.app.R;
import sj.app.presenter.IHomePresenter;
import sj.app.presenter.IHomePresenterImpl;
import sj.app.view.fragment.FragmentHomePage1;
import sj.app.view.fragment.FragmentHomePage2;
import sj.app.view.fragment.FragmentHomePage3;
import sj.app.view.fragment.FragmentHomePage4;

public class HomeActivity extends AppCompatActivity implements IHomeActivity, View.OnClickListener {
    FragmentHomePage1 fragmentHomePage1 = new FragmentHomePage1();
    FragmentHomePage2 fragmentHomePage2 = new FragmentHomePage2();
    FragmentHomePage3 fragmentHomePage3 = new FragmentHomePage3();
    FragmentHomePage4 fragmentHomePage4 = new FragmentHomePage4();
    private IHomePresenter iter;
    private FragmentTransaction fragmentTransaction;
    private ArrayList<Fragment> list;
    private ImageView bt1;
    private ImageView bt2;
    private ImageView bt3;
    private ImageView bt4;
    private static boolean Exit = false;
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Exit = false;
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.btn_home_frag1).setOnClickListener(this);
        findViewById(R.id.btn_home_frag2).setOnClickListener(this);
        findViewById(R.id.btn_home_frag3).setOnClickListener(this);
        findViewById(R.id.btn_home_frag4).setOnClickListener(this);
        bt1 = findViewById(R.id.btn_home_frag1);
        bt2 = findViewById(R.id.btn_home_frag2);
        bt3 = findViewById(R.id.btn_home_frag3);
        bt4 = findViewById(R.id.btn_home_frag4);
        pages();
        fragmentTransaction = getFragmentManager().beginTransaction();
        iter = new IHomePresenterImpl(fragmentTransaction);
        iter.initFrag(list.get(0),list.get(1),list.get(2),list.get(3));
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
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        FragmentTransaction mft = getFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btn_home_frag1:
                bt1.setBackgroundResource(R.drawable.page11);
                bt2.setBackgroundResource(R.drawable.page2);
                bt3.setBackgroundResource(R.drawable.page3);
                bt4.setBackgroundResource(R.drawable.page4);
                iter.showFrag(1,mft,list.get(0),list.get(1),list.get(2),list.get(3));
                break;
            case R.id.btn_home_frag2:
                bt1.setBackgroundResource(R.drawable.page1);
                bt2.setBackgroundResource(R.drawable.page22);
                bt3.setBackgroundResource(R.drawable.page3);
                bt4.setBackgroundResource(R.drawable.page4);
                iter.showFrag(2,mft,list.get(0),list.get(1),list.get(2),list.get(3));
                break;
            case R.id.btn_home_frag3:
                bt1.setBackgroundResource(R.drawable.page1);
                bt2.setBackgroundResource(R.drawable.page2);
                bt3.setBackgroundResource(R.drawable.page33);
                bt4.setBackgroundResource(R.drawable.page4);
                iter.showFrag(3,mft,list.get(0),list.get(1),list.get(2),list.get(3));
                break;
            case R.id.btn_home_frag4:
                bt1.setBackgroundResource(R.drawable.page1);
                bt2.setBackgroundResource(R.drawable.page2);
                bt3.setBackgroundResource(R.drawable.page3);
                bt4.setBackgroundResource(R.drawable.page44);
                iter.showFrag(4,mft,list.get(0),list.get(1),list.get(2),list.get(3));
                break;
        }
    }
    private void pages() {
        list = new ArrayList();
        list.add(fragmentHomePage1);
        list.add(fragmentHomePage2);
        list.add(fragmentHomePage3);
        list.add(fragmentHomePage4);
    }
}
