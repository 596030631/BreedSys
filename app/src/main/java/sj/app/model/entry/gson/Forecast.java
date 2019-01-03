package sj.app.model.entry.gson;

public class Forecast {

    /**
     * mDate : hk
     * mCond : {"mTxt":"ujk"}
     * mTmp : {"Max":"lkjlk","Min":"km"}
     */

    private String mDate;
    private MCondBean mCond;
    private MTmpBean mTmp;

    public String getMDate() {
        return mDate;
    }

    public void setMDate(String mDate) {
        this.mDate = mDate;
    }

    public MCondBean getMCond() {
        return mCond;
    }

    public void setMCond(MCondBean mCond) {
        this.mCond = mCond;
    }

    public MTmpBean getMTmp() {
        return mTmp;
    }

    public void setMTmp(MTmpBean mTmp) {
        this.mTmp = mTmp;
    }

    public static class MCondBean {
        /**
         * mTxt : ujk
         */

        private String mTxt;

        public String getMTxt() {
            return mTxt;
        }

        public void setMTxt(String mTxt) {
            this.mTxt = mTxt;
        }
    }

    public static class MTmpBean {
        /**
         * Max : lkjlk
         * Min : km
         */

        private String Max;
        private String Min;

        public String getMax() {
            return Max;
        }

        public void setMax(String Max) {
            this.Max = Max;
        }

        public String getMin() {
            return Min;
        }

        public void setMin(String Min) {
            this.Min = Min;
        }
    }
}
