package haint95.payment.command;

/**
 * @author haint95
 */
public interface CommandIF {
    void execute();
    void execute(int userId);
}
