package sj.app.model.entry.gson;

public class Aqi {


    /**
     * City : {"Aqi":"44","Pm25":"11"}
     */

    private CityBean City;

    public CityBean getCity() {
        return City;
    }

    public void setCity(CityBean City) {
        this.City = City;
    }

    public static class CityBean {
        /**
         * Aqi : 44
         * Pm25 : 11
         */
        private String Aqi;
        private String Pm25;

        public String getAqi() {
            return Aqi;
        }

        public void setAqi(String Aqi) {
            this.Aqi = Aqi;
        }

        public String getPm25() {
            return Pm25;
        }

        public void setPm25(String Pm25) {
            this.Pm25 = Pm25;
        }
    }
}
