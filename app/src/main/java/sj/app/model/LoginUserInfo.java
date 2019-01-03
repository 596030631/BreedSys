package sj.app.model;

public class LoginUserInfo {
    protected String user_name;
    protected String user_passwd;

    public LoginUserInfo(String name,String passwd){
        user_name = name;
        user_passwd = passwd;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_passwd() {
        return user_passwd;
    }

    public void setUser_passwd(String user_passwd) {
        this.user_passwd = user_passwd;
    }
}
