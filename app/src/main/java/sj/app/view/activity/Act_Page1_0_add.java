package sj.app.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import sj.app.R;
//新增页面采购单（例子）
public class Act_Page1_0_add extends AppCompatActivity {
    private List list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__page1_0_add_purchase);
        ListView lv = findViewById(R.id.page1_0_add_purchase_lv);
        list = new ArrayList();
        init();
        ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        setListViewHeightBasedOnChildren(lv);

    }
    private void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
    public void init(){
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");

    }
}
