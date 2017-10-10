package com.example.hello.user.impl;

public class DBManager implements BankUsage{

    @Override
    public Long getValue(){
        return 1L;
    }

    public String retrieveAccountHolderName(int accountId ){
        String accountHolderName = null;
        return accountHolderName;
    }

}
