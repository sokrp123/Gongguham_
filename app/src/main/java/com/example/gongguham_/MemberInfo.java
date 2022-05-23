package com.example.gongguham_;

import android.widget.EditText;

public class MemberInfo {
    private String name;
    private String phoneNumber;
    private String gender;
    private String accountValue;
    private String account;
    private String birthday;
    private int point;

    MemberInfo(String name, String phoneNumber, String gender,String accountValue, String account, String birthday, int point){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.accountValue = accountValue;
        this.account = account;
        this.birthday = birthday;
        this.point = point;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public String getAccountValue(){
        return this.accountValue;
    }
    public void setAccountValue(String accountValue){
        this.accountValue = accountValue;
    }

    public String getAccount(){
        return this.account;
    }
    public void setAccount(String account){
        this.account = account;
    }

    public String getBirthday(){
        return this.birthday;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public int getPoint(){ return this.point;}
    public void setPoint(int point){ this.point = point; }
}
