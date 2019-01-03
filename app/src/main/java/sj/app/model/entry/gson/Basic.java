package sj.app.model.entry.gson;

public class Basic {

    /**
     * City : 苏州
     * Id : sss
     * update : {"Loc":"ee"}
     */

    private String City;
    private String Id;
    private UpdateBean update;
    public String getCity() {
        return City;
    }
    public void setCity(String City) {
        this.City = City;
    }
    public String getId() {
        return Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
    public UpdateBean getUpdate() {
        return update;
    }
    public void setUpdate(UpdateBean update) {
        this.update = update;
    }
    public static class UpdateBean {
        /**
         * Loc : ee
         */

        private String Loc;
        public String getLoc() {
            return Loc;
        }
        public void setLoc(String Loc) {
            this.Loc = Loc;
        }
    }
}
