
package Exceptions;

// custom exception class for handling notEnough space cases
public class NotEnoughSpaceException extends CustomException {
    // constructor that takes a custom error message as an argument
    public NotEnoughSpaceException(String message) {
        super(message);
    }
}
