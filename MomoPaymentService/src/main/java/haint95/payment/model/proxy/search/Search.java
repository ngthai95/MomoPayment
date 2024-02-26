package haint95.payment.model.proxy.search;

import haint95.payment.database.DatabaseFromCache;
import haint95.payment.model.SearchIF;
import haint95.payment.orm.Bill;
import haint95.payment.orm.UserAccount;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haint95
 */
public class Search implements SearchIF {
    private final Map<Integer, Map<Integer, Bill>> cache = new HashMap<>();

    private Search(){

    }

    private static class SearchHolder{
        private static final Search INSTANCE = new Search();
    }

    public static Search getInstance(){
        return SearchHolder.INSTANCE;
    }

    @Override
    public Map<Integer, Bill> listBill(int userId) {
        if (cache.containsKey(userId)) {
            return cache.get(userId);
        }

        UserAccount account = DatabaseFromCache.getInstance().getData().get(userId);
        if (account != null && account.getBills() != null) {
            cache.put(userId, account.getBills());
            return cache.get(userId);
        }

        return null;
    }

    @Override
    public Map<Integer, Bill> searchBillByProvider(int userId, String provider) {
        return null;
    }
}
