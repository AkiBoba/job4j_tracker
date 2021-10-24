package ru.job4j.ex;

/**
 * @author Vladimir Likhachev
 */
public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User usr = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                usr = user;
                break;
            }
        }
        if (usr == null) {
            throw new UserNotFoundException("User not found");
        }
        return usr;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() <= 2) {
            throw new UserInvalidException("User Invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                    System.out.println("This user has an access");
                }
            } catch (UserInvalidException e) {
                e.printStackTrace();
            } catch (UserNotFoundException e) {
                e.printStackTrace();
        }
    }
}
