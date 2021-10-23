package ru.job4j.ex;

/**
 * @author Vladimir Likhachev
 */
public class UserInvalidException extends UserNotFoundException {
    public UserInvalidException(String message) {
        super(message);
    }
}
