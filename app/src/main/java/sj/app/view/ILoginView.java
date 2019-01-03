package sj.app.view;
//注册界面接口
public interface ILoginView {
    public void clearView();
    public void loginResultView(Boolean result, int code);//可以传入注册结果和错误代码
}
