package haint95.payment.test.command;

import haint95.payment.command.CashInCommand;
import haint95.payment.command.ListBillCommand;
import haint95.payment.common.DefaultConfig;
import haint95.payment.database.DatabaseFromCache;
import haint95.payment.orm.UserAccount;
import haint95.payment.test.SampleTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author haint95
 */
public class ListBillTest {
    @Before
    public void setUp() {
        SampleTest.initData();
    }

    @After
    public void tearDown() {
        SampleTest.clearData();
    }

    @Test
    public void testListBillSize() {
        UserAccount account = DatabaseFromCache.getInstance().getData().get(DefaultConfig.USER_DEFAULT);
        new ListBillCommand().execute(DefaultConfig.USER_DEFAULT);
        assertEquals(2, account.getBills().size());
    }

    @Test
    public void testListBillContain() {
        UserAccount account = DatabaseFromCache.getInstance().getData().get(DefaultConfig.USER_DEFAULT);
        new ListBillCommand().execute(DefaultConfig.USER_DEFAULT);
        assertTrue(account.getBills().containsKey(1));
    }
}
