package haint95.payment.command;

import haint95.payment.common.DefaultConfig;
import haint95.payment.model.proxy.search.Search;
import haint95.payment.orm.Bill;

import java.util.Map;

/**
 * @author haint95
 */
public class ListBillCommand implements CommandIF {
    @Override
    public void execute() {
        execute(DefaultConfig.USER_DEFAULT);
    }

    @Override
    public void execute(int userId) {
        Search.getInstance().listBill(userId);
        Map<Integer, Bill> bills = Search.getInstance().listBill(DefaultConfig.USER_DEFAULT);
        StringBuilder resultSB = new StringBuilder();
        resultSB.append("Bill No.").append("\t")
                .append("Type").append("\t")
                .append("Amount").append("\t")
                .append("Due Date").append("\t")
                .append("State").append("\t")
                .append("PROVIDER").append("\t")
                .append("\n");
        if(bills!= null){
            for (Map.Entry<Integer,Bill> entry:bills.entrySet()){
                Bill bill = entry.getValue();
                resultSB.append(entry.getKey()).append("\t")
                        .append(bill.getType()).append("\t")
                        .append(bill.getAmount()).append("\t")
                        .append(bill.getDueDate()).append("\t")
                        .append(bill.getState()).append("\t")
                        .append(bill.getProvider()).append("\t")
                        .append("\n");
            }
        }

        System.out.println(resultSB.toString());
    }
}
