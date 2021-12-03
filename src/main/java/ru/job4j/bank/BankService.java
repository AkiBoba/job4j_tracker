package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод должен вернуть пользователя по номеру паспорта
     * @param passport паспорт пользователя
     * @return возвращает пользователя или null, если он не найден
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.of(users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()).get();

        return rsl;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport паспорт пользователя
     * @param requisite номер счета
     * @return возвращает счет пользователя, иначе - null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> res = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            res = users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return res;
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
                String destPassport, String destRequisite,double amount) {
            boolean rsl = false;
            Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
            Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
            if (srcAccount.isPresent()
                    && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                rsl = true;
            }
            return rsl;
    }
}