package com.example.hello.user.impl;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    @Test
    public void testBank(){
        new MockUp<DBManager>(){
          @SuppressWarnings("unused")
          @Mock
          public String retrieveAccountHolderName(int accountId ){
              return "Abhi";
          }
        };

        Bank bank = new Bank();
        String actualResponse = bank.processAccount(100);
        assertEquals("Result checking","Abhi",actualResponse);
    }

}