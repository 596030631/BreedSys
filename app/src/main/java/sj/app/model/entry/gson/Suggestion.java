package sj.app.model.entry.gson;

public class Suggestion {

    /**
     * Comf : {"comfTxt":""}
     * Cw : {"cwTxt":""}
     * Sport : {"sportTxt":""}
     */

    private ComfBean Comf;
    private CwBean Cw;
    private SportBean Sport;

    public ComfBean getComf() {
        return Comf;
    }

    public void setComf(ComfBean Comf) {
        this.Comf = Comf;
    }

    public CwBean getCw() {
        return Cw;
    }

    public void setCw(CwBean Cw) {
        this.Cw = Cw;
    }

    public SportBean getSport() {
        return Sport;
    }

    public void setSport(SportBean Sport) {
        this.Sport = Sport;
    }

    public static class ComfBean {
        /**
         * comfTxt :
         */

        private String comfTxt;

        public String getComfTxt() {
            return comfTxt;
        }

        public void setComfTxt(String comfTxt) {
            this.comfTxt = comfTxt;
        }
    }

    public static class CwBean {
        /**
         * cwTxt :
         */

        private String cwTxt;

        public String getCwTxt() {
            return cwTxt;
        }

        public void setCwTxt(String cwTxt) {
            this.cwTxt = cwTxt;
        }
    }

    public static class SportBean {
        /**
         * sportTxt :
         */

        private String sportTxt;

        public String getSportTxt() {
            return sportTxt;
        }

        public void setSportTxt(String sportTxt) {
            this.sportTxt = sportTxt;
        }
    }
}
