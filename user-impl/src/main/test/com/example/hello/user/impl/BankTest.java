package com.example.hello.user.impl;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BankTest {

    @Mocked
    static DBManager dbManager = new DBManager();

    /**
     * Although not needed here but if interface is to be mocked no need to write new
     */
    @Mocked
    static BankUsage bankUsage;

    private static Bank bank = new Bank(dbManager);

    @Before
    public void setUp() {

        bank = new Bank(dbManager) {
            {
                this.dbManager = dbManager;
                this.bankUsage = dbManager;
            }
        };
        new MockUp<DBManager>() {
            @Mock
            public Long getValue() {
                return 45L;
            }
        };
    }

    @Test
    public <T extends BankUsage> void fakingImplementationClassesFromAGivenBaseType() {
        new MockUp<Bank>() {
            @Mock
            public void $init(String name) {
                name = "abc";
            }
        };

/*
        new MockUp<T>() {
            */
/*@Mock
            public void $init() {
            }*//*

            @Mock Long getValue() { return 2L; }
        };
*/

        Long actualResult = bank.getValue3();//new Bank("abc").getValue3();

        assertEquals(new Long(48L), actualResult);
    }

    @Test
    public void testGetValue1() {

        /*new MockUp<DBManager>() {
            new Expectations() {
                {
                    dbManager.getValue();
                    result = 1L;
                }
            };

            @Mock
            public Long getValue() {
                return 1L;
            }*/
        //  Bank bank1 = new Bank("jas");
        //   };


        Long actualResult = bank.getValue1();
        assertEquals("static block check", new Long(45), actualResult);

    }

    @Test
    public void testBank() {
        new MockUp<DBManager>() {
            @SuppressWarnings("unused")
            @Mock
            public String retrieveAccountHolderName(int accountId) {
                return "Abhi";
            }
        };

        //Bank bank = new Bank("jassu");
        String actualResponse = bank.processAccount(100);
        assertEquals("Result checking", "Abhi", actualResponse);
    }

    @Test
    public void testGetName() {
        new MockUp<Bank>() {
            @Mock
            public void $init(String name) {
                name = "akkjaas";
            }


        };

        Bank bank = new Bank("jassu");
        String actualResult = bank.getName();
        assertNull("jassu", actualResult);
    }

    /*
        @Test
        public void testGetMiddleName() {
            new MockUp<Bank>() {
                @Mock
                public void $init(String name) {
                }

                *//*@SuppressWarnings("unused")
            @Mock
            public void $clinit(){
                Bank.getMiddleName();
            }*//*
        };

        Bank bank = new Bank("jassu");
        String actualResult = Bank.middleName;
        assertEquals("static block check", "kaur", actualResult);

    }*/
    @Test
    public void testGetValue2() {
      /*  new MockUp<BankUsage>() {

            @Mock
            public Long getValue(){
                return 1L;
            }
        };
*/
        /*Bank bank = new Bank("jassu");
        Long actualResult = bank.getValue2();*/

        Long actualResult = bank.getValue2();
        assertEquals("static block check", new Long(45L), actualResult);

    }

    @Test
    public void testGetValue3() {
       /* new MockUp<BankUsage>() {

            @Mock
            public Long getValue(){
                return 1L;
            }
        };
*/
        //   Bank bank = new Bank("jassu");

        Long actualResult = bank.getValue3();
        assertEquals("static block check", new Long(48L), actualResult);

    }

}