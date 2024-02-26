package haint95.payment.orm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haint95
 */
public class UserAccount {
    private int userId;
    private String userName;
    private String fullName;
    private long balance;
    private Map<Integer,Bill> bills;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public long getBalance() {
        return balance;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setBills(Map<Integer, Bill> bills) {
        this.bills = bills;
    }

    public Map<Integer, Bill> getBills() {
        return bills;
    }

    public static class Builder {
        private int userId;
        private String userName;

        private String fullName = "";
        private long balance = 0;
        private Map<Integer, Bill> bills = new HashMap<>();

        public Builder userId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder balance(long balance) {
            this.balance = balance;
            return this;
        }

        public Builder addBill(int billId, Bill bill) {
            this.bills.put(billId, bill);
            return this;
        }

        public Builder addBills(Map<Integer, Bill> bills) {
            this.bills = bills;
            return this;
        }

        public UserAccount build() {
            return new UserAccount(this);
        }
    }

    private UserAccount(Builder builder) {
        userId = builder.userId;
        userName = builder.userName;
        fullName = builder.fullName;
        balance = builder.balance;
        bills = builder.bills;
    }

}
