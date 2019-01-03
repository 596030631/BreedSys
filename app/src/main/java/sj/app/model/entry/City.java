package sj.app.model.entry;

import org.litepal.crud.DataSupport;

public class City extends DataSupport {

    /**
     * id : 113
     * name : 南京
     */
    private int id;
    private String cityName;
    private int cityCode;
    private int provinceId;

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
