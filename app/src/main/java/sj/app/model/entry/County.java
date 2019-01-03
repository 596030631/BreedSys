package sj.app.model.entry;

import org.litepal.crud.DataSupport;

public class County extends DataSupport {

    /**
     * id : 942
     * name : 吴江
     * weather_id : CN101190407
     */
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private String countyName;
    private String weather_id;
    private int cityId;

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(String weather_id) {
        this.weather_id = weather_id;
    }
}
