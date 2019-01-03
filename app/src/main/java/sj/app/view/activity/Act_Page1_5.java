package sj.app.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.List;

import sj.app.R;
import sj.app.view.adapter.AdapterPage1_5;
import sj.app.view.other.Tmpe;

public class Act_Page1_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__page1_5);
        GridView gv_1_5 = findViewById(R.id.gv_page1_5);
        List<Tmpe> list = new ArrayList();
        list.add(new Tmpe("棚舍1 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍2 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍3 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍4 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍5 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍6 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍7 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍8 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        list.add(new Tmpe("棚舍9 ： 20℃   ","  室外 ： 5℃   "));
        Adapter adapter = new AdapterPage1_5(this,list);
        gv_1_5.setAdapter((ListAdapter) adapter);
    }
}
