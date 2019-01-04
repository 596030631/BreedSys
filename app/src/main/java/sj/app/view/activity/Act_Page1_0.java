package sj.app.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import org.litepal.crud.DataSupport;
import java.util.List;
import sj.app.R;
import sj.app.model.entry.Purchase;
import sj.app.view.adapter.AdapterPage1_0_add;
public class Act_Page1_0 extends AppCompatActivity implements View.OnClickListener {

    private List<Purchase> list;
    private AdapterPage1_0_add adapter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__page1_0);
        LinearLayout btn_back = findViewById(R.id.btn_page1_0_back);
        LinearLayout btn_delete = findViewById(R.id.btn_page1_0_delete);
        LinearLayout btn_edit = findViewById(R.id.btn_page1_0_edit);
        LinearLayout btn_add = findViewById(R.id.btn_page1_0_add);
        LinearLayout btn_refresh = findViewById(R.id.refresh);
        btn_add.setOnClickListener(this);
        btn_edit.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_refresh.setOnClickListener(this);
        rv = findViewById(R.id.page1_0_add_purchase_rv);
        //数据库赋值给集合
        list = DataSupport.findAll(Purchase.class);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new AdapterPage1_0_add(list,this);
        rv.setAdapter(adapter);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_page1_0_add:
                startActivity(new Intent(this,Act_Page1_0_add_purchase.class));
                break;
            case R.id.btn_page1_0_delete:
                break;
            case R.id.btn_page1_0_back:
                finish();
                break;
            case R.id.btn_page1_0_edit:
                break;
            case R.id.refresh:
                list = DataSupport.findAll(Purchase.class);
                adapter = new AdapterPage1_0_add(list,this);
                rv.setAdapter(adapter);
                Log.e("TAG",list.get(list.size()-1).getName());
                break;
        }
    }
}
