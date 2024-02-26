package haint95.payment.database;

import haint95.payment.orm.UserAccount;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haint95
 */
public class DatabaseFromCache {

    private Map<Integer, UserAccount> data;


    private static class DatabaseFromCacheHolder{
        private static final DatabaseFromCache INSTANCE = new DatabaseFromCache();
    }

    public static DatabaseFromCache getInstance(){
        return DatabaseFromCacheHolder.INSTANCE;
    }

    private DatabaseFromCache() {
        this.data = new HashMap<>();
    }

    public Map<Integer, UserAccount> getData() {
        return data;
    }

    public void setData(Map<Integer, UserAccount> data) {
        this.data = data;
    }

    public void clearData() {
        this.data.clear();
    }


}
