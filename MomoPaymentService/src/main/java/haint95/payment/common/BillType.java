package haint95.payment.common;

/**
 * @author haint95
 */
public enum BillType {
    ELECTRIC("ELECTRIC"),
    WATER("WATER"),
    INTERNET("INTERNET");

    private final String type;

    BillType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
