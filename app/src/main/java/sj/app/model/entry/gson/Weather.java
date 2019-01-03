package sj.app.model.entry.gson;

import java.util.List;

public class Weather {
    public String status;
    public Basic basic;
    public Aqi aqi;
    public Now now;
    public Suggestion suggestion;
    //public List<Forecast> forecasts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Basic getBasic() {
        return basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public Aqi getAqi() {
        return aqi;
    }

    public void setAqi(Aqi aqi) {
        this.aqi = aqi;
    }

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }

//    public List<Forecast> getForecasts() {
//        return forecasts;
//    }
//
//    public void setForecasts(List<Forecast> forecasts) {
//        this.forecasts = forecasts;
//    }
}
