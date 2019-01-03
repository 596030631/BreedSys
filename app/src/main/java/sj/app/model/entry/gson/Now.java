package sj.app.model.entry.gson;

public class Now {

    /**
     * Tmp : 29
     * Cond : {"Txt":"sujhk"}
     */

    private String Tmp;
    private CondBean Cond;

    public String getTmp() {
        return Tmp;
    }

    public void setTmp(String Tmp) {
        this.Tmp = Tmp;
    }

    public CondBean getCond() {
        return Cond;
    }

    public void setCond(CondBean Cond) {
        this.Cond = Cond;
    }

    public static class CondBean {
        /**
         * Txt : sujhk
         */

        private String Txt;

        public String getTxt() {
            return Txt;
        }

        public void setTxt(String Txt) {
            this.Txt = Txt;
        }
    }
}
