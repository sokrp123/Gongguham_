package com.example.gongguham_;

public class accountInfo {
    private String accountValue;
    private String account;

    accountInfo(String accountValue, String account){
        this.accountValue = accountValue;
        this.account = account;
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
}
