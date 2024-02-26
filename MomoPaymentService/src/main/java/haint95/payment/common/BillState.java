package haint95.payment.common;

/**
 * @author haint95
 */
public enum BillState {
    NOT_PAID("NOT_PAID"),
    PROCESSED("PROCESSED"),
    PENDING("PENDING");

    private final String type;

    BillState(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
