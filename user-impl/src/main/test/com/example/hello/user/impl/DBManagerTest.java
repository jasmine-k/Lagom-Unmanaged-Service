package com.example.hello.user.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class DBManagerTest {

    @Test
    public void testGetValue(){
        DBManager dbManager = new DBManager();
        assertEquals(new Long(1L),dbManager.getValue());
    }
    @Test
    public void testRetrieveAccountHolderName(){
        DBManager dbManager = new DBManager();
        assertNull("null checking", dbManager.retrieveAccountHolderName(12));
    }

}