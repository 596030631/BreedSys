package sj.app.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import sj.app.R;
import sj.app.model.entry.Page1Entry;
import sj.app.view.adapter.AdapterPage1;


public class FragmentHomePage1 extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Page1Entry> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page1,container,false);
        mRecyclerView = view.findViewById(R.id.recyclerViewpage1);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        init();
        mAdapter = new AdapterPage1(list,view.getContext());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
    public void init(){
        list = new ArrayList<>();
            list.add(new Page1Entry("添加记录",R.drawable.page1_1));
            list.add(new Page1Entry("饲料计划",R.drawable.page1_2));
            list.add(new Page1Entry("记录列表",R.drawable.page1_3));
            list.add(new Page1Entry("统计数据",R.drawable.page1_4));
            list.add(new Page1Entry("计 算 器",R.drawable.page1_5));
            list.add(new Page1Entry("温度管理",R.drawable.page1_6));
            list.add(new Page1Entry("饲养经验",R.drawable.page1_7));
            list.add(new Page1Entry("接种计划",R.drawable.page1_8));
    }
}