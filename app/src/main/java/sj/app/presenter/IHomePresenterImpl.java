package sj.app.presenter;

import android.app.Fragment;
import android.app.FragmentTransaction;
import sj.app.R;
import sj.app.view.activity.IHomeActivity;
public class IHomePresenterImpl implements IHomePresenter{
    public FragmentTransaction mFt;

    //view
    IHomeActivity mView;

    public IHomePresenterImpl(FragmentTransaction ft){
        mFt = ft;
    }
    @Override
    public void initFrag(Fragment fragmentHomePage1, Fragment fragmentHomePage2, Fragment fragmentHomePage3, Fragment fragmentHomePage4) {
        mFt.add(R.id.fragment_home,fragmentHomePage1).show(fragmentHomePage1)
                .add(R.id.fragment_home, fragmentHomePage2).hide(fragmentHomePage2)
                .add(R.id.fragment_home,fragmentHomePage3).hide(fragmentHomePage3)
                .add(R.id.fragment_home,fragmentHomePage4).hide(fragmentHomePage4).commit();
    }
    @Override
    public void showFrag(int pageNum,FragmentTransaction mft,Fragment fragmentHomePage1, Fragment fragmentHomePage2, Fragment fragmentHomePage3, Fragment fragmentHomePage4) {
        switch (pageNum){
            case 1:
                mft.show(fragmentHomePage1)
                    .hide(fragmentHomePage2)
                    .hide(fragmentHomePage3)
                    .hide(fragmentHomePage4).commit();
                break;
            case 2:  mft.hide(fragmentHomePage1)
                    .show(fragmentHomePage2)
                    .hide(fragmentHomePage3)
                    .hide(fragmentHomePage4).commit();
                break;
            case 3:  mft.hide(fragmentHomePage1)
                    .hide(fragmentHomePage2)
                    .show(fragmentHomePage3)
                    .hide(fragmentHomePage4).commit();
                break;
            case 4:
                    mft.hide(fragmentHomePage1)
                    .hide(fragmentHomePage2)
                    .hide(fragmentHomePage3)
                    .show(fragmentHomePage4).commit();
                break;
        }
    }
}
