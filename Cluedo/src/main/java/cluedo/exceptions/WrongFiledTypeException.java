package game.exceptions;

import java.lang.Exception;

public class WrongFiledTypeException extends Exception {
    public WrongFiledTypeException(String message){
        super(message);
    }
}
