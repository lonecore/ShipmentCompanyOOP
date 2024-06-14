
package Exceptions;

// custom exception class that extends the built-in exception class
public class CustomException extends Exception {
    // constructor that takes a custom error message as an argument
    public CustomException(String message) {
        super(message);
    }
}
