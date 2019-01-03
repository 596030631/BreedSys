package sj.app.presenter;
import sj.app.model.LoginUserInfo;
import sj.app.view.ILoginView;
import sj.app.view.LoginActivity;

public class ILoginPresenterImpl implements ILoginPresenter{
    //Presenter与View的联系
    protected ILoginView mView;//登陆view
    //Presenter与Model的联系
    protected LoginUserInfo mLoginUserInfo = new LoginUserInfo("admin","root");
    //进行对view的绑定
    public ILoginPresenterImpl (LoginActivity loginView){//接受login—— view
        mView = loginView;//登陆view的绑定
    }

    @Override
    public void doClear() {
        mView.clearView();//去执行View接口——Ilogin的方法进行清空
    }
    @Override
    public void doLogin(String user_name, String user_password) {
        String name = mLoginUserInfo.getUser_name().trim();
        String passwd = mLoginUserInfo.getUser_passwd().trim();
        if(user_name .equals(name) && user_password .equals(passwd)){//和数据层交互实现登陆admin
            mView.loginResultView(true,200);//带数据去显示view,200是成功code
        }else {
            mView.loginResultView(false,404);
        }
    }
}
