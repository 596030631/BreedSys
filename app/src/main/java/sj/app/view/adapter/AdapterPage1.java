package sj.app.view.adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import sj.app.R;
import sj.app.model.entry.Page1Entry;
import sj.app.view.activity.Act_Page1_0;
import sj.app.view.activity.Act_Page1_1;
import sj.app.view.activity.Act_Page1_2;
import sj.app.view.activity.Act_Page1_3;
import sj.app.view.activity.Act_Page1_4;
import sj.app.view.activity.Act_Page1_5;
import sj.app.view.activity.Act_Page1_6;
import sj.app.view.activity.Act_Page1_7;

public class AdapterPage1 extends RecyclerView.Adapter<AdapterPage1.ViewHolder> {
    private List<Page1Entry> mList;
    private Context mContext;
    private View view;

    public AdapterPage1(List<Page1Entry> list, Context context) {
            this.mList = list;
            mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page1, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
        }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        Page1Entry page1Entry = mList.get(position);
        String name = page1Entry.getmName();
        int img = page1Entry.getmImg();
        holder.mText.setText(name);
        holder.mImg.setBackgroundResource(img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goActivity(position);
            }
        });
    }
    private void goActivity(int position) {
        Context context = view.getContext();
        switch (position){
            case 0:
                context.startActivity(new Intent(context,Act_Page1_0.class));
                break;
            case 1:
                context.startActivity(new Intent(context,Act_Page1_1.class));
                break;
            case 2:
                context.startActivity(new Intent(context,Act_Page1_2.class));
                break;
            case 3:
                context.startActivity(new Intent(context,Act_Page1_3.class));
                break;
            case 4:
                context.startActivity(new Intent(context,Act_Page1_4.class));
                break;
            case 5:
                context.startActivity(new Intent(context,Act_Page1_5.class));
                break;
            case 6:
                context.startActivity(new Intent(context,Act_Page1_6.class));
                break;
            case 7:
                context.startActivity(new Intent(context,Act_Page1_7.class));
                break;
        }
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mText;
        private ImageView mImg;
        public ViewHolder(View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.item_name);
            mImg = itemView.findViewById(R.id.item_png);
        }
    }
}

