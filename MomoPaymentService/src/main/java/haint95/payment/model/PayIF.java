package haint95.payment.model;

/**
 * @author haint95
 */
public interface PayIF {
    public void pay(int firstBillId, int... billIds);
}
