package sj.app.model.gson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class Result {
    /**
     * location : {"id":"WS0QU43YTBHW","name":"清远","country":"CN","path":"清远,清远,广东,中国","timezone":"Asia/Shanghai","timezone_offset":"+08:00"}
     * now : {"text":"中雨","code":"14","temperature":"5"}
     * last_update : 2018-12-31T11:15:08+08:00
     */
    public LocationBean location;
    public NowBean now;
    public String last_update;
    public List<ResultsBean> results;

    public LocationBean getLocation() {
        return location;
    }
    public void setLocation(LocationBean location) {
        this.location = location;
    }
    public NowBean getNow() {
        return now;
    }

    public void setNow(NowBean now) {
        this.now = now;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class LocationBean {
        /**
         * id : WS0QU43YTBHW
         * name : 清远
         * country : CN
         * path : 清远,清远,广东,中国
         * timezone : Asia/Shanghai
         * timezone_offset : +08:00
         */
        private String id;
        private String name;
        private String country;
        private String path;
        private String timezone;
        private String timezone_offset;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getTimezone_offset() {
            return timezone_offset;
        }

        public void setTimezone_offset(String timezone_offset) {
            this.timezone_offset = timezone_offset;
        }
    }

    public static class NowBean {
        /**
         * text : 中雨
         * code : 14
         * temperature : 5
         */

        private String text;
        private String code;
        private String temperature;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }
    }

    public static class ResultsBean {
        /**
         * location : {"id":"WS0QU43YTBHW","name":"清远","country":"CN","path":"清远,清远,广东,中国","timezone":"Asia/Shanghai","timezone_offset":"+08:00"}
         * now : {"text":"多云","code":"4","temperature":"7"}
         * last_update : 2018-12-31T14:20:08+08:00
         */

        @SerializedName("location")
        private LocationBean locationX;
        @SerializedName("now")
        private NowBean nowX;
        @SerializedName("last_update")
        private String last_updateX;

        public LocationBean getLocationX() {
            return locationX;
        }

        public void setLocationX(LocationBean locationX) {
            this.locationX = locationX;
        }

        public NowBean getNowX() {
            return nowX;
        }

        public void setNowX(NowBean nowX) {
            this.nowX = nowX;
        }

        public String getLast_updateX() {
            return last_updateX;
        }

        public void setLast_updateX(String last_updateX) {
            this.last_updateX = last_updateX;
        }
    }
}
