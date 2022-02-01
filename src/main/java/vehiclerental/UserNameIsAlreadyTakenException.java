package vehiclerental;

public class UserNameIsAlreadyTakenException extends RuntimeException{

    // String message;
    public UserNameIsAlreadyTakenException(String message) {
        super(message);
    }


/*
    @Override
    public String getMessage() {
        return message;
    }

 */
}
