package ru.job4j.ex;

/**
 * @author Vladimir Likhachev
 */
public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User usr = null;
        for (int i = 0; i < users.length; i++) {
            if (login.equals(users[i].getUsername())) {
                usr = users[i];
                break;
            }
        }
        if (usr != null) {
            return usr;
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() > 2) {
            return true;
        } else {
            throw new UserInvalidException("User Invalid");
        }
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            try {
                if (validate(user)) {
                    System.out.println("This user has an access");
                }
            } catch (UserInvalidException e) {
                e.printStackTrace();
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
