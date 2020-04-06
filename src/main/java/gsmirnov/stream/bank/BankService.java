package gsmirnov.stream.bank;

import java.util.*;

/**
 * Bank services. Stores users and accounts. Provides transfer operations.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-03
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Adds a new user to the bank system. New user has empty account list.
     *
     * @param user a new user.
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Add a new account to the user with the specified passport. Not adds if account with the same requisite already
     * exists in the user's account list.
     *
     * @param passport the specified user's passport.
     * @param account the specified user's account.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = Optional.ofNullable(findByPassport(passport));
        if (user.isPresent()) {
            List<Account> accounts = this.users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Finds user from users by passport.
     *
     * @param passport the specified passport.
     * @return the user if exists.
     */
    public User findByPassport(String passport) {
        return this.users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst().orElse(null);
    }

    /**
     * Finds an account by user's passport and requisite.
     *
     * @param passport the specified user's password.
     * @param requisite the specified user's requisite.
     * @return an account matched to the specified passport and requisite.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        Optional<List<Account>> accounts = Optional.ofNullable(this.users.get(findByPassport(passport)));
        if (accounts.isPresent()) {
            result = accounts.get().stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst().orElse(null);
        }
        return result;
    }

    /**
     * Transfers money from the source account to the destination account.
     *
     * @param srcPassport sources's user passport.
     * @param srcRequisite source's user account requisite.
     * @param dstPassport destination's user passport.
     * @param dstRequisite destination's user account requisite.
     * @param amount transfer's amount.
     * @return true if transfers ends, false either (not enough money on source account, or account not found etc.).
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String dstPassport, String dstRequisite, double amount) {
        boolean result = false;
        Optional<Account> src = Optional.ofNullable(this.findByRequisite(srcPassport, srcRequisite));
        Optional<Account> dst = Optional.ofNullable(this.findByRequisite(dstPassport, dstRequisite));
        if (src.isPresent() && dst.isPresent() && src.get().getBalance() - amount >= 0) {
            src.get().setBalance(src.get().getBalance() - amount);
            dst.get().setBalance(dst.get().getBalance() + amount);
            result = true;
        }
        return result;
    }
}