package haint95.payment.model;

import haint95.payment.orm.Bill;

import java.util.List;
import java.util.Map;

/**
 * @author haint95
 */
public interface SearchIF {
    public Map<Integer,Bill> listBill(int userId);
    public Map<Integer,Bill> searchBillByProvider(int userId, String provider);
}
