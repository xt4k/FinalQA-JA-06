package com.academy.lesson22.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("data")
public class LoginData {
    private String login;
    private String password;
    private String msg;

    public LoginData(String login, String password, String msg) {
        this.login = login;
        this.password = password;
        this.msg = msg;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
