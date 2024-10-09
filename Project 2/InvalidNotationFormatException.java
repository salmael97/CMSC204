package Package;
/**
 * Custom exception to indicate that an invalid notation format 
 * has been encountered in an infix expression.
 */
public class InvalidNotationFormatException extends RuntimeException {

    // Unique identifier for serialization

	private static final long serialVersionUID = 7409145447544459252L;
	/**
     * Default constructor for InvalidNotationFormatException.
     * This constructor initializes the exception with a 
     * default error message indicating that the infix expression format is invalid.
     */
	public InvalidNotationFormatException() {
		super("Infix expression format is invalid.");
	}
}
