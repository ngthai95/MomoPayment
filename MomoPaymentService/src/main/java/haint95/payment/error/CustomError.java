package haint95.payment.error;

/**
 * @author haint95
 */
public class CustomError extends RuntimeException {
    public CustomError() {
        super();
    }

    public CustomError(String message) {
        super(message);
    }

    public CustomError(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomError(Throwable cause) {
        super(cause);
    }
}
