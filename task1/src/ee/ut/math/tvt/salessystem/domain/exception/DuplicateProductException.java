package ee.ut.math.tvt.salessystem.domain.exception;

/**
 * Thrown when domain controller's verification fails.
 */
public class DuplicateProductException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs new <code>DuplicateProductException</code>.
	 */
	public DuplicateProductException() {
		super();
	}

	/**
	 * Constructs new <code>DuplicateProductException</code> with with the
	 * specified detail message.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public DuplicateProductException(final String message) {
		super(message);
	}
}
