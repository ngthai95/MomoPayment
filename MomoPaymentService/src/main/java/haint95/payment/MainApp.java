package haint95.payment;

import haint95.payment.command.CashInCommand;
import haint95.payment.command.CommandInvoker;
import haint95.payment.command.ListBillCommand;
import haint95.payment.common.BillState;
import haint95.payment.common.BillType;
import haint95.payment.common.DefaultConfig;
import haint95.payment.database.DatabaseFromCache;
import haint95.payment.orm.Bill;
import haint95.payment.orm.UserAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haint95
 */
public class MainApp {
    public static void initData() {
        Map<Integer, Bill> bills = new HashMap<>();
        bills.put(1, new Bill.Builder()
                .amount(100000)
                .billId(1)
                .dueDate("31/03/2024")
                .state(BillState.NOT_PAID)
                .type(BillType.ELECTRIC)
                .provider("VIETEL")
                .build());

        bills.put(2, new Bill.Builder()
                .amount(100000)
                .billId(2)
                .dueDate("31/04/2024")
                .state(BillState.NOT_PAID)
                .type(BillType.WATER)
                .provider("VNPT")
                .build());

        UserAccount account = new UserAccount.Builder()
                .userId(DefaultConfig.USER_DEFAULT)
                .balance(0)
                .fullName("Nguyen Thanh Hai")
                .userName("haint95")
                .addBills(bills)
                .build();

        Map<Integer, UserAccount> mapAccount = new HashMap<>();
        mapAccount.put(DefaultConfig.USER_DEFAULT, account);
        DatabaseFromCache.getInstance().setData(mapAccount);
    }

    public static void main(String[] args) {

        initData();

        CommandInvoker invoker = new CommandInvoker();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Enter your command: ");
                String commandStr = reader.readLine();

                String[] commandParams = commandStr.split(" ");
                String command = commandParams[0];
                switch (command) {
                    case "CASH_IN":
                        long amount = Long.parseLong(commandParams[1]);
                        invoker.addCommand(new CashInCommand(amount));
                        break;
                    case "LIST_BILL":
                        invoker.addCommand(new ListBillCommand());
                        break;
                    case "EXIT":
                        return;
                    default:
                        System.out.println("Invalid Command");
                        break;
                }
                invoker.executeCommands();
            }

        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid age format: " + e.getMessage());
        }

    }
}
