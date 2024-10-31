package woongjin.hurryup.exception.meeting;

public class MeetingNotFoundException extends RuntimeException{

    public MeetingNotFoundException(String message){
        super(message);
    }

    public MeetingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
