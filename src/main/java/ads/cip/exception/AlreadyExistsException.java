package ads.cip.exception;

public class AlreadyExistsException extends ApplicationException{
    public AlreadyExistsException(String message) {
        super(message, "ALREADY_EXISTS");
    }
}