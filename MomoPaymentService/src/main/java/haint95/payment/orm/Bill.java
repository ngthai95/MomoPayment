package haint95.payment.orm;

import haint95.payment.common.BillState;
import haint95.payment.common.BillType;

/**
 * @author haint95
 */
public class Bill {
    private int billId;
    private BillType type;
    private long amount;
    private String dueDate;
    private String paymentDate;
    private BillState state;
    private String provider;

    public int getBillId() {
        return billId;
    }

    public BillType getType() {
        return type;
    }

    public long getAmount() {
        return amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public BillState getState() {
        return state;
    }

    public String getProvider() {
        return provider;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public void setType(BillType type) {
        this.type = type;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setState(BillState state) {
        this.state = state;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public static class Builder {
        private int billId;
        private BillType type;
        private long amount;
        private String dueDate;
        private String paymentDate;
        private BillState state;
        private String provider;

        public Builder billId(int billId) {
            this.billId = billId;
            return this;
        }

        public Builder type(BillType type) {
            this.type = type;
            return this;
        }

        public Builder amount(long amount) {
            this.amount = amount;
            return this;
        }

        public Builder dueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder paymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder state(BillState state) {
            this.state = state;
            return this;
        }

        public Builder provider(String provider) {
            this.provider = provider;
            return this;
        }

        public Bill build() {
            return new Bill(this);
        }
    }

    private Bill(Builder builder) {
        billId = builder.billId;
        type = builder.type;
        amount = builder.amount;
        dueDate = builder.dueDate;
        paymentDate = builder.paymentDate;
        state = builder.state;
        provider = builder.provider;
    }
}
