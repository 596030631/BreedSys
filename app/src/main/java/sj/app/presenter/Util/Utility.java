package sj.app.presenter.Util;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sj.app.model.entry.City;
import sj.app.model.entry.County;
import sj.app.model.entry.Province;
import sj.app.model.entry.gson.Weather;
import sj.app.model.gson.Result;

public class Utility {
    private final static String TAG = "Utility";
    /**解析成Result类*/
    public static Result handleResultResponse(String response){
        try{
            Log.e(TAG,response);
            JSONObject resultObject = new JSONObject(response);
            JSONArray jsonArray = resultObject.getJSONArray("results");
            String resultcontent = jsonArray.getJSONObject(0).toString();
            Log.e(TAG,jsonArray.getString(0));
            return new Gson().fromJson(resultcontent,Result.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 解析成weather类*/
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /*解析返回的数据----省份*/
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces = new JSONArray(response);
                for (int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();//继承数据库，实现保存方法
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
/**市数据*/
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities = new JSONArray(response);
                for (int i=0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    /**市数据*/
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounties = new JSONArray(response);
                for (int i=0;i<allCounties.length();i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeather_id(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
