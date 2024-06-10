package ads.cip.exception;

public class NotFoundException extends ApplicationException{
    public NotFoundException(String message) {
        super(message, "Not found");
    }
}