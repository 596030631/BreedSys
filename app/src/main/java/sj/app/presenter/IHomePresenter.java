package sj.app.presenter;

import android.app.Fragment;
import android.app.FragmentTransaction;
public interface IHomePresenter {
    public void initFrag(Fragment fragmentHomePage1, Fragment fragmentHomePage2, Fragment fragmentHomePage3, Fragment fragmentHomePage4);
    public void showFrag(int pageNum, FragmentTransaction mft, Fragment fragmentHomePage1, Fragment fragmentHomePage2, Fragment fragmentHomePage3, Fragment fragmentHomePage4);
}
