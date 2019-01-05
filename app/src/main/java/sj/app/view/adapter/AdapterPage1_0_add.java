package sj.app.view.adapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import sj.app.R;
import sj.app.model.entry.Purchase;
public class AdapterPage1_0_add extends RecyclerView.Adapter<AdapterPage1_0_add.MyViewHolder> {
    private  Context mContext;
    private  List<Purchase> mList;
    private MyViewHolder myViewHolder;
    private View view;
    private List<Integer> list_point;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    public AdapterPage1_0_add(List list, Context context) {
        this.mList = list;
        mContext = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page1_0_add,parent,false);
        myViewHolder = new MyViewHolder(view);
        list_point = new ArrayList<Integer>();
        sp = view.getContext().getSharedPreferences("position",Context.MODE_PRIVATE);
        editor = sp.edit();
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        position = mList.size()-1-position;
        holder.tv1.setText(""+mList.get(position).getPur_num());
        holder.tv2.setText(""+mList.get(position).getName());
        holder.tv3.setText(""+mList.get(position).getQuity());
        holder.tv4.setText(""+mList.get(position).getPrice());
        holder.tv5.setText(""+mList.get(position).getAmount());
        holder.tv6.setText(""+mList.get(position).getDate());

        final TextView tvbg1 = view.findViewById(R.id.btn_page1_0_add_text1);
        final TextView tvbg2 = view.findViewById(R.id.btn_page1_0_add_text2);
        final TextView tvbg3 = view.findViewById(R.id.btn_page1_0_add_text3);
        final TextView tvbg4 = view.findViewById(R.id.btn_page1_0_add_text4);
        final TextView tvbg5 = view.findViewById(R.id.btn_page1_0_add_text5);
        final TextView tvbg6 = view.findViewById(R.id.btn_page1_0_add_text6);
        /**
         * OnItemClilck*/
        final int  point = position;
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            private boolean sign = true;
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
                if(sign){
                    tvbg1.setBackgroundResource(R.drawable.background_item);
                    tvbg2.setBackgroundResource(R.drawable.background_item);
                    tvbg3.setBackgroundResource(R.drawable.background_item);
                    tvbg4.setBackgroundResource(R.drawable.background_item);
                    tvbg5.setBackgroundResource(R.drawable.background_item);
                    tvbg6.setBackgroundResource(R.drawable.background_item);
                    sign = false;
                }else{
                    tvbg1.setBackgroundResource(R.drawable.shape_ret);
                    tvbg2.setBackgroundResource(R.drawable.shape_ret);
                    tvbg3.setBackgroundResource(R.drawable.shape_ret);
                    tvbg4.setBackgroundResource(R.drawable.shape_ret);
                    tvbg5.setBackgroundResource(R.drawable.shape_ret);
                    tvbg6.setBackgroundResource(R.drawable.shape_ret);
                    sign = true;
                }
                //拿到选定的数据，暂存起来等删除按钮读取删除相应的序号
                if(!sign){
                    list_point.add(point);
                }else {
                    for (int i=0;i<list_point.size();i++){
                       if(list_point.get(i)==point){
                           list_point.remove(i);
                       }
                    }
                }
                String str = "";
                for(int i=0;i<list_point.size();i++){
                    str = str + list_point.get(i).toString()+"#";
                }
                    editor.putString("id",str);
                editor.commit();
            }
        });
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
        public TextView tv4;
        public TextView tv5;
        public TextView tv6;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.btn_page1_0_add_text1);
            tv2 = itemView.findViewById(R.id.btn_page1_0_add_text2);
            tv3 = itemView.findViewById(R.id.btn_page1_0_add_text3);
            tv4 = itemView.findViewById(R.id.btn_page1_0_add_text4);
            tv5 = itemView.findViewById(R.id.btn_page1_0_add_text5);
            tv6 = itemView.findViewById(R.id.btn_page1_0_add_text6);
        }
    }
}