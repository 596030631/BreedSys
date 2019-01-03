package sj.app.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

import sj.app.R;
import sj.app.view.other.Tmpe;
public class AdapterPage1_5 extends BaseAdapter {
    private List<Tmpe> mList;
    private Context mContext;

    public AdapterPage1_5(Context context,List list){
        mContext = context;
        mList = list;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        view = View.inflate(mContext,R.layout.item_page1_5,null);
        TextView tv1 = view.findViewById(R.id.item_page1_5_tv1);
        TextView tv2 = view.findViewById(R.id.item_page1_5_tv2);
        Tmpe temp = mList.get(i);
        tv1.setText(temp.getmTmp1());
        tv2.setText(temp.getmTmp2());
        return view;
    }
}
