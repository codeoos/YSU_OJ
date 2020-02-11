package com.ysu.acm.user;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class user {
    @Id
    @GeneratedValue //Id自增
    private Integer id;
    private String nick_name;
    private String usr_name;
    private String pwd;
    private String e_mail;
    private String tel;
    private int ac_num;
    private int submission_num;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public user(){

    }
    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getUsr_name() {
        return usr_name;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAc_num() {
        return ac_num;
    }

    public void setAc_num(int ac_num) {
        this.ac_num = ac_num;
    }

    public int getSubmission_num() {
        return submission_num;
    }

    public void setSubmission_num(int submission_num) {
        this.submission_num = submission_num;
    }
}
