package haint95.payment.model.proxy.cashin;

import haint95.payment.database.DatabaseFromCache;
import haint95.payment.model.CashInIF;
import haint95.payment.orm.UserAccount;

import java.util.Map;
import java.util.Objects;

/**
 * @author haint95
 */
public class CashIn implements CashInIF {

    private static class CashInHolder{
        private static final CashIn INSTANCE = new CashIn();
    }

    private CashIn(){
    }

    public static CashIn getInstance(){
        return CashInHolder.INSTANCE;
    }

    @Override
    public boolean cashIn(int userId, long amount) {
        if (userId <= 0) {
            return false;
        }

        if (amount <= 0) {
            return false;
        }

        Map<Integer, UserAccount> data = DatabaseFromCache.getInstance().getData();
        if (Objects.isNull(data.get(userId))) {
            return false;
        }

        UserAccount currentAccount = data.get(userId);
        currentAccount.setBalance(currentAccount.getBalance() + amount);

        return true;
    }
}
