package haint95.payment.test;

import haint95.payment.common.BillState;
import haint95.payment.common.BillType;
import haint95.payment.common.DefaultConfig;
import haint95.payment.database.DatabaseFromCache;
import haint95.payment.orm.Bill;
import haint95.payment.orm.UserAccount;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haint95
 */
public class SampleTest {
    public static void initData() {
        Map<Integer, Bill> bills = new HashMap<>();
        bills.put(1, new Bill.Builder()
                .amount(100000)
                .billId(1)
                .dueDate("31/03/2024")
                .state(BillState.NOT_PAID)
                .type(BillType.ELECTRIC)
                .provider("VIETEL")
                .build());

        bills.put(2, new Bill.Builder()
                .amount(100000)
                .billId(2)
                .dueDate("31/04/2024")
                .state(BillState.NOT_PAID)
                .type(BillType.WATER)
                .provider("VNPT")
                .build());

        UserAccount account = new UserAccount.Builder()
                .userId(DefaultConfig.USER_DEFAULT)
                .balance(0)
                .fullName("Nguyen Thanh Hai")
                .userName("haint95")
                .addBills(bills)
                .build();

        Map<Integer, UserAccount> mapAccount = new HashMap<>();
        mapAccount.put(DefaultConfig.USER_DEFAULT, account);
        DatabaseFromCache.getInstance().setData(mapAccount);
    }
}
