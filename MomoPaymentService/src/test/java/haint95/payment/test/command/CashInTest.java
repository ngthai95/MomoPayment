package haint95.payment.test.command;

import haint95.payment.command.CashInCommand;
import haint95.payment.common.DefaultConfig;
import haint95.payment.database.DatabaseFromCache;
import haint95.payment.test.SampleTest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author haint95
 */
public class CashInTest {

    @Before
    public void setUp() {
        SampleTest.initData();
    }

    @Test
    public void testCashInDefault2(){
        new CashInCommand(-1000000).execute();
        long balance = DatabaseFromCache.getInstance().getData().get(DefaultConfig.USER_DEFAULT).getBalance();
        assertEquals(0, balance);
    }

    @Test
    public void testCashInDefault1(){
        new CashInCommand(1000000).execute();
        long balance = DatabaseFromCache.getInstance().getData().get(DefaultConfig.USER_DEFAULT).getBalance();
        assertEquals(1000000, balance);
    }



}
