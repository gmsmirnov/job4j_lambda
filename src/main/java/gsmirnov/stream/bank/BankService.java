package gsmirnov.stream.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        User user = findByPassport(passport);
        List<Account> accounts = this.users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Finds user from users by passport.
     *
     * @param passport the specified passport.
     * @return the user if exists.
     */
    public User findByPassport(String passport) {
        List<User> filteredUsers = this.users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .collect(Collectors.toList());
        return filteredUsers.isEmpty() ? null : filteredUsers.get(0);
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
        List<Account> accounts = this.users.get(findByPassport(passport));
        if (accounts != null) {
            List<Account> filteredAcc = accounts.stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .collect(Collectors.toList());
            result = filteredAcc.isEmpty() ? null : filteredAcc.get(0);
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
        Account src = this.findByRequisite(srcPassport, srcRequisite);
        Account dst = this.findByRequisite(dstPassport, dstRequisite);
        if (src != null && dst != null && src.getBalance() - amount >= 0) {
            src.setBalance(src.getBalance() - amount);
            dst.setBalance(dst.getBalance() + amount);
            result = true;
        }
        return result;
    }
}