package com.example.hello.user.impl;

import javax.inject.Inject;

import static javafx.scene.input.KeyCode.L;

public class Bank {

    DBManager dbManager;
    BankUsage bankUsage;

    @Inject
    public Bank(DBManager dbManager){

        this.dbManager = dbManager;
        this.bankUsage = dbManager;
    }

   // DBManager dbManager = new DBManager();
    //bankUsage = new DBManager();

     BankUsage bankUsage1 = new DBManager();
     BankUsage bankUsage2 = new BankUsage() {
        @Override
        public Long getValue() {
            return 3L;
        }
    };


    public Long getValue1(){
        return dbManager.getValue();
    }

    public Long getValue2(){
        return bankUsage.getValue();
    }

    public Long getValue3(){
        return bankUsage1.getValue() + bankUsage2.getValue();
    }

    static int balanceAmount;

    //Static block begins
    static {
        updateBalance(100);
    }

    public static void updateBalance(float balance) {
        balanceAmount += balance;
    }
    static String middleName;
    public String name;

    static {
        getMiddleName();
    }

    public static String getMiddleName(){
        middleName = "kaur";
        return middleName;
    }

    public Bank(String name){

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String processAccount(int accountID) {

        //Some other code goes here

        String accountHolderName = dbManager.retrieveAccountHolderName(accountID);

        return accountHolderName;
    }

}
