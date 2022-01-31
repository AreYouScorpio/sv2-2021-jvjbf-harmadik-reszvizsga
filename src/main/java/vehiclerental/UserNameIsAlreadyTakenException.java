package vehiclerental;

public class UserNameIsAlreadyTakenException extends RuntimeException{

    String message;
    public UserNameIsAlreadyTakenException(String s) {
        message=s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
