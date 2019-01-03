package sj.app.view.activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import sj.app.R;
import sj.app.model.entry.Page1_0_add_demo1;
import sj.app.view.adapter.AdapterPage1_0_add;

//新增页面采购单（例子）
public class Act_Page1_0_add extends AppCompatActivity {
    private List<Page1_0_add_demo1> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__page1_0_add_purchase);
        RecyclerView rv = findViewById(R.id.page1_0_add_purchase_rv);
        list = new ArrayList();
        init();
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        AdapterPage1_0_add adapter = new AdapterPage1_0_add(list,this);
        rv.setAdapter(adapter);
    }
    public void init(){
        for( int i = 1 ; i < 100000 ; i ++ ){
            list.add(new Page1_0_add_demo1(i,"玉米",1000,1.2,1200,"2019-1-3"));
        }
    }
}
