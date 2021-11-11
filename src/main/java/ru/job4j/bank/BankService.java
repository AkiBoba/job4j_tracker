package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**Класс описывает работу банковской системы,
 * клиентов и их счетов
 * @author Vladimir Likhachev
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     * содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя
     * и регистрирует в системе аккаунт "пользователь + его счета"
     * @param user пользователь, который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод должен добавить новый счет к пользователю
     * @param passport номер паспорта по которому идентифицируется пользователь
     * @param account номер счета, который надо добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null
        && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод должен вернуть пользователя по номеру паспорта
     * @param passport паспорт пользователя
     * @return возвращает пользователя или null, если он не найден
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport паспорт пользователя
     * @param requisite номер счета
     * @return возвращает счет пользователя, иначе - null
     */
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

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport номер паспорта пользователя у которого списывают деньги
     * @param srcRequisite номер счета на который переводят деньги
     * @param destPassport номер паспорта пользователя у которого списывают деньги
     * @param destRequisite номер счета  на который переводят деньги
     * @param amount сумма переводимых денег
     * @return возвращает результат сделки false - неудачно, true - успешно
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
        && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}