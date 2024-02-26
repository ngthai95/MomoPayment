package haint95.payment.command;

import haint95.payment.common.DefaultConfig;
import haint95.payment.database.DatabaseFromCache;
import haint95.payment.model.proxy.cashin.CashIn;

/**
 * @author haint95
 */
public class CashInCommand implements CommandIF{
    private final long amount;

    public CashInCommand(long amount){
        this.amount = amount;
    }

    @Override
    public void execute() {
        execute(DefaultConfig.USER_DEFAULT);
    }

    @Override
    public void execute(int userId) {
        CashIn.getInstance().cashIn(DefaultConfig.USER_DEFAULT, amount);
        System.out.println("Your available balance: " + DatabaseFromCache.getInstance().getData().get(userId).getBalance());
    }
}
