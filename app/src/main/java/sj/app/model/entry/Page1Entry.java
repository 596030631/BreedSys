package sj.app.model.entry;

public class Page1Entry {
    private String mName;
    private int mImg;

    public Page1Entry(String s, int img) {
        mName = s;
        mImg = img;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmImg() {
        return mImg;
    }

    public void setmImg(int mImg) {
        this.mImg = mImg;
    }
}
