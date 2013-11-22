package ee.ut.math.tvt.salessystem.domain.exception;

/**
 * Thrown when domain controller's verification fails.
 */
public class OutOfStockException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs new <code>OutOfStockException</code>.
	 */
	public OutOfStockException() {
		super();
	}

	/**
	 * Constructs new <code>OutOfStockException</code> with with the specified
	 * detail message.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public OutOfStockException(final String message) {
		super(message);
	}
}
