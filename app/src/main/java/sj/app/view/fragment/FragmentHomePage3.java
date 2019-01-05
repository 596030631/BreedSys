package sj.app.view.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import sj.app.R;
import sj.app.model.gson.Result;
import sj.app.presenter.Util.HttpUtil;
import sj.app.presenter.Util.Utility;

public class FragmentHomePage3 extends Fragment {
    private View view;
    private TextView tv;
    private static final String TAG = "PAGE3";
    private Result result;
    private String text;
    private ImageView iv;
    private String url;
    private String address;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_page3,container,false);
        tv = view.findViewById(R.id.tv_page3);
        iv = view.findViewById(R.id.iv_page3);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        address = "https://api.seniverse.com/v3/weather/now.json?key=kctbohllbv19h96o&location=ip&language=zh-Hans&unit=c";
        //设置每日一图
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        url = preferences.getString("bingUrl",null);
        //url = "http://guolin.tech/api/bing_pic";
        Glide.with(this).load(url).into(iv);
        //onloadWeather();
        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                onload(call, response);
                if(result == null){
                    onload(call, response);
                }else{
                    tv.setText(result.location.getName()+"\n"+result.getNow().getText()+"\n"+result.last_update
                            +"\n"+result.now.getTemperature()+" ℃");
                    //存储数据
                }
            }
        });
    }
    public void onloadWeather(){
        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                onload(call, response);
                if(result == null){
                    onload(call, response);
                }else{
                    tv.setText(result.location.getName()+"\n"+result.getNow().getText()+"\n"+result.last_update
                            +"\n"+result.now.getTemperature()+" ℃");
                }
            }
        });
    }

    /**加载天气*/
    public void onload(Call call, Response response){
        try {
            text = response.body().string();
            Log.e(TAG,text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(text != null){
            result = Utility.handleResultResponse(text);
        }
    }
    private void loadBingPic(){
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingpic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(view.getContext()).edit();
                editor.putString("pic",bingpic);
                editor.apply();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(view.getContext()).load(url).into(iv);
                    }
                });
            }
        });
    }
}
