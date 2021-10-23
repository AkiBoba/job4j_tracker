package ru.job4j.ex;

/**
 * @author Vladimir Likhachev
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
