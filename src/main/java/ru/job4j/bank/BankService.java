package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vladimir Likhachev
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.keySet().contains(user.getPassport())) {
            users.put(user, new ArrayList<>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null
               && findByRequisite(passport, account.getRequisite()) == null) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (!user.getPassport().equals(passport)) {
                rsl = null;
            } else {
                rsl = user;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User srcUser = findByPassport(srcPassport);
        User destUser = findByPassport(destPassport);
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcUser != null && destUser != null && srcAccount != null
        && destAccount != null && srcAccount.getBalance() >= amount) {
            Double resBalance = srcAccount.getBalance();
            resBalance -= amount;
            srcAccount.setBalance(resBalance);
            Double destBalance = destAccount.getBalance();
            destBalance += amount;
            destAccount.setBalance(destBalance);
            rsl = true;
        }
        return rsl;
    }
}