package sj.app.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.PluralRules;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import sj.app.R;
import sj.app.model.entry.Purchase;
import sj.app.view.adapter.AdapterPage1_0_add;
public class Act_Page1_0 extends AppCompatActivity implements View.OnClickListener {

    private List<Purchase> list;
    private AdapterPage1_0_add adapter;
    private RecyclerView rv;
    private List<Purchase> newlist;
    private LinearLayout btn_back;
    private LinearLayout btn_delete;
    private LinearLayout btn_edit;
    private LinearLayout btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__page1_0);
        //初始化
        btnInit();
        setAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //刷新寄存器
        list = DataSupport.findAll(Purchase.class);
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
                //删除数据库中的选定内容
                SharedPreferences sp =  getSharedPreferences("position",MODE_PRIVATE);
                String str = sp.getString("id","null");
                String[] array = str.split("#");
                newlist = new ArrayList<Purchase>();
                try{
                    if(list.size()!=0&&array.length!=0){
                        for(int i = 0;i<array.length;i++){
                            //根据序号一次性删除多个会错乱
                            //我先拿到要删除的数据特征，再去根据特征去删除
                            newlist.add(list.get(Integer.parseInt(array[i])));
                            Log.e("TAG",list.get(Integer.parseInt(array[i])).getPur_num());
                        }
                        // 删除数据库信息
                        for(int j = 0;j<newlist.size();j++){
                            Purchase pur = newlist.get(j);
                            Log.e("TAG",j+"");
                            Log.e("TAG",pur.getPur_num());
                            DataSupport.deleteAll(Purchase.class,"pur_num = ?",pur.getPur_num());
                        }
                        list = DataSupport.findAll(Purchase.class);
                        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                        adapter = new AdapterPage1_0_add(list,this);
                        rv.setAdapter(adapter);
                    }
                }catch (Exception e){
                    Toast.makeText(this, "请先选择记录行", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_page1_0_back:
                finish();
                break;

            case R.id.btn_page1_0_edit:
                break;
        }
    }

    protected void btnInit(){
        btn_back = findViewById(R.id.btn_page1_0_back);
        btn_delete = findViewById(R.id.btn_page1_0_delete);
        btn_edit = findViewById(R.id.btn_page1_0_edit);
        btn_add = findViewById(R.id.btn_page1_0_add);

        btn_add.setOnClickListener(this);
        btn_edit.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }

    protected void setAdapter(){
        rv = findViewById(R.id.page1_0_add_purchase_rv);
        //接收数据库信息
        list = DataSupport.findAll(Purchase.class);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new AdapterPage1_0_add(list,this);
        rv.setAdapter(adapter);
    }
}
