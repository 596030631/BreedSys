package sj.app.view.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import sj.app.R;
import sj.app.model.entry.Page1_0_add_demo1;

public class AdapterPage1_0_add extends RecyclerView.Adapter<AdapterPage1_0_add.MyViewHolder> {
    private  Context mContext;
    private  List<Page1_0_add_demo1> mList;
    public AdapterPage1_0_add(List list, Context context) {
        this.mList = list;
        mContext = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page1_0_add,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv1.setText(""+mList.get(position).getId());
        holder.tv2.setText(""+mList.get(position).getName());
        holder.tv3.setText(""+mList.get(position).getNum());
        holder.tv4.setText(""+mList.get(position).getPrice());
        holder.tv5.setText(""+mList.get(position).getAmount());
        holder.tv6.setText(""+mList.get(position).getDate());
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