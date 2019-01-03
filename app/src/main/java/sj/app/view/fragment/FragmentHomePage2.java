package sj.app.view.fragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import org.litepal.crud.DataSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import sj.app.R;
import sj.app.model.entry.City;
import sj.app.model.entry.County;
import sj.app.model.entry.Province;
import sj.app.model.entry.gson.Weather;
import sj.app.presenter.Util.HttpUtil;
import sj.app.presenter.Util.Utility;

public class FragmentHomePage2 extends Fragment {
    private final int LEVEL_PROVINCE = 0;
    private final int LEVEL_CITY = 1;
    private final int LEVEL_COUNTY = 2;
    private int currentLevel;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<>();
    private ListView listView;
    private TextView backButton;
    private Province selectedProvince;
    private City selectedCity;
    private List<Province> provinceList;
    private List<City> cityList;
    private List<County> countyList;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_page2,container,false);
        listView = view.findViewById(R.id.lv_page2);
        backButton = view.findViewById(R.id.btn_back_page2);
        adapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(currentLevel == LEVEL_PROVINCE){
                    selectedProvince = provinceList.get(i);
                    queryCity();
                }else if(currentLevel == LEVEL_CITY){
                    selectedCity = cityList.get(i);
                    queryCounty();
                }else if(currentLevel == LEVEL_COUNTY){
                    //获取需要查询天气的县
                    String weatherId = countyList.get(i).getWeather_id();
                    requestWeather(weatherId);
                }
            }
        });
        /**返回按键逻辑*/
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentLevel == LEVEL_COUNTY){
                    queryCity();
                }else if(currentLevel == LEVEL_CITY){
                    queryProvince();
                }
            }
        });
        queryProvince();
    }
    /**根据id请求城市天气信息*/
    public void requestWeather(final String weatherId){
        String weatherUrl = "http://guolin.tech/api/weather?cityid="+weatherId+
                "&key=725c6b5e8b1043a7915ad7720a3a19c7";
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final Weather weather = Utility.handleWeatherResponse(responseText);//接收json
                if(weather != null && "ok".equals(weather.status)){
                    Toast.makeText(view.getContext(),weather.basic.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    /**查询省*/
    //数据库优先查询，否则服务器查询
    private void queryProvince(){
        backButton.setVisibility(View.GONE);
        provinceList = DataSupport.findAll(Province.class);
        if(provinceList.size()>0){
            dataList.clear();
            for (Province province:provinceList){
                dataList.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_PROVINCE;
        }else {
            String address = "http://guolin.tech/api/china";
            queryFromServer(address,"province");
        }
    }
    /**查询市*/
    //数据库优先查询，否则服务器查询
    private void queryCity(){
        backButton.setVisibility(View.VISIBLE);
        cityList = DataSupport.where("provinceid = ?",String.valueOf(selectedProvince.getId())).find(City.class);
        if(cityList.size()>0){
            dataList.clear();
            for (City city:cityList){
                dataList.add(city.getCityName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_CITY;
        }else {
            int provinceCode = selectedProvince.getProvinceCode();
            String address = "http://guolin.tech/api/china/"+provinceCode;
            queryFromServer(address,"city");
        }
    }
    /**查询县*/
    //数据库优先查询，否则服务器查询
    private void queryCounty(){

        backButton.setVisibility(View.VISIBLE);
        countyList = DataSupport.where("cityid = ?",String.valueOf(selectedCity.getId())).find(County.class);
        if(countyList.size()>0){
            dataList.clear();
            for (County county:countyList){
                dataList.add(county.getCountyName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_COUNTY;
        }else {
            int provinceCode = selectedProvince.getProvinceCode();
            int cityCode = selectedCity.getCityCode();
            String address = "http://guolin.tech/api/china/"+provinceCode+"/"+cityCode;
            queryFromServer(address,"county");
        }
    }
    /**根据传入的地址和类型从服务器查询省市县数据*/
    private void queryFromServer(String address,final String type){
        //可以设置progress
        //请求
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(listView.getContext(), "加载失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                boolean result = false;
                if("province".equals(type)){
                    result = Utility.handleProvinceResponse(responseText);
                }else if("city".equals(type)){
                    result = Utility.handleCityResponse(responseText,selectedProvince.getId());
                }else if("county".equals(type)){
                    result = Utility.handleCountyResponse(responseText,selectedCity.getId());
                }
                if(result){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //关闭进度提示
                            if("province".equals(type)){
                                queryProvince();
                            }else if("city".equals(type)){
                                queryCity();
                            }else if("county".equals(type)){
                                queryCounty();
                            }
                        }
                    });
                }
            }
        });
    }
}
