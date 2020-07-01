package com.mchat.entity;

/**
 * User
 * table  user_info
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/7/1 10:45
 */
public class User {
    private String userid;
    private String login_name;
    private String username;
    private String mm;
    private String state;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
