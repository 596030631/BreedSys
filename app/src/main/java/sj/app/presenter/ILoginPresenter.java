package sj.app.presenter;

public interface ILoginPresenter {
    //登陆逻辑接口
    public void doClear();
    public void doLogin(String user_name, String user_password);//需要传入user，passwd执行对应的逻辑
}
