package gsmirnov.stream.bank;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests bank service methods and utilities.
 */
public class BankServiceTest {
    @Test
    public void whenGetUserByPassport() {
        String passport = "5005 611347";
        String name = "Ivanov Ivan";
        User user = new User(passport, name);

        BankService bank = new BankService();
        bank.addUser(user);

        assertEquals(name, bank.findByPassport(passport).getUsername());
    }

    @Test
    public void whenAddUserWithSamePassport() {
        String passport1 = "5005 611347";
        String name1 = "Ivanov Ivan";
        User user1 = new User(passport1, name1);

        String passport2 = "5005 611347";
        String name2 = "Petrov Petr";
        User user2 = new User(passport2, name2);

        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);

        assertEquals(passport1, passport2);
        assertNotEquals(name2, bank.findByPassport(passport2).getUsername());
        assertEquals(name1, bank.findByPassport(passport1).getUsername());
    }

    @Test
    public void whenGetAccountByRequisite() {
        String passport = "5005 611347";
        String name = "Ivanov Ivan";
        User user = new User(passport, name);

        String requisite = "4658103780";
        double balance = 100.00;
        Account account = new Account(requisite, balance);

        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(passport, account);

        assertEquals(account, bank.findByRequisite(passport, requisite));
    }

    @Test
    public void whenAddAccountWithSameRequisite() {
        String passport = "5005 611347";
        String name = "Ivanov Ivan";
        User user = new User(passport, name);

        String requisite1 = "4658103780";
        double balance1 = 100.00;
        Account account1 = new Account(requisite1, balance1);
        String requisite2 = "4658103780";
        double balance2 = 200.00;
        Account account2 = new Account(requisite2, balance2);

        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(passport, account1);
        bank.addAccount(passport, account2);

        double delta = 0.1;
        assertEquals(requisite1, requisite2);
        assertNotEquals(balance2, bank.findByRequisite(passport, requisite2).getBalance(), delta);
        assertEquals(balance1, bank.findByRequisite(passport, requisite1).getBalance(), delta);
    }

    @Test
    public void whenAddAccountToInvalidUser() {
        String passport = "5005 611347";

        String requisite = "4658103780";
        double balance = 100.00;
        Account account = new Account(requisite, balance);

        BankService bank = new BankService();
        bank.addAccount(passport, account);

        assertNull(bank.findByPassport(passport));
        assertNull(bank.findByRequisite(passport, requisite));
    }

    @Test
    public void whenEnteredInvalidAccount() {
        String passport = "5005 611347";
        String name = "Ivanov Ivan";
        User user = new User(passport, name);

        String requisite = "4658103780";
        double balance = 100.00;
        Account account = new Account(requisite, balance);

        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(passport, account);

        String wrongRequisite = "0000000000";
        assertNull(bank.findByRequisite(passport, wrongRequisite));
    }

    @Test
    public void whenEnteredInvalidPassport() {
        String passport = "5005 611347";
        String name = "Ivanov Ivan";
        User user = new User(passport, name);

        String requisite = "4658103780";
        double balance = 100.00;
        Account account = new Account(requisite, balance);

        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(passport, account);

        String wrongPassport = "5000 611347";
        assertNull(bank.findByRequisite(wrongPassport, requisite));
    }

    @Test
    public void whenTransferMoneyThenTrue() {
        String srcPassport = "5005 611347";
        String srcName = "Ivanov Ivan";
        User srcUser = new User(srcPassport, srcName);
        String dstPassport = "5008 406975";
        String dstName = "Petrov Petr";
        User dstUser = new User(dstPassport, dstName);

        String srcRequisite = "4658103780";
        double srcBalance = 100.00;
        Account srcAccount = new Account(srcRequisite, srcBalance);
        String dstRequisite = "9871234578";
        double dstBalance = 200.00;
        Account dstAccount = new Account(dstRequisite, dstBalance);
        double amount = 50.00;

        BankService bank = new BankService();
        bank.addUser(srcUser);
        bank.addUser(dstUser);
        bank.addAccount(srcPassport, srcAccount);
        bank.addAccount(dstPassport, dstAccount);
        boolean result = bank.transferMoney(srcPassport, srcRequisite, dstPassport, dstRequisite, amount);

        double delta = 0.1;
        double srcExpected = 50.00;
        double dstExpected = 250.00;

        assertTrue(result);
        assertEquals(srcExpected, bank.findByRequisite(srcPassport, srcRequisite).getBalance(), delta);
        assertEquals(dstExpected, bank.findByRequisite(dstPassport, dstRequisite).getBalance(), delta);
    }

    @Test
    public void whenNotTransferMoneyThenFalse() {
        String srcPassport = "5005 611347";
        String srcName = "Ivanov Ivan";
        User srcUser = new User(srcPassport, srcName);
        String dstPassport = "5008 406975";
        String dstName = "Petrov Petr";
        User dstUser = new User(dstPassport, dstName);

        String srcRequisite = "4658103780";
        double srcBalance = 100.00;
        Account srcAccount = new Account(srcRequisite, srcBalance);
        String dstRequisite = "9871234578";
        double dstBalance = 200.00;
        Account dstAccount = new Account(dstRequisite, dstBalance);
        double amount = 500.00;

        BankService bank = new BankService();
        bank.addUser(srcUser);
        bank.addUser(dstUser);
        bank.addAccount(srcPassport, srcAccount);
        bank.addAccount(dstPassport, dstAccount);
        boolean result = bank.transferMoney(srcPassport, srcRequisite, dstPassport, dstRequisite, amount);

        double delta = 0.1;
        double srcExpected = 100.00;
        double dstExpected = 200.00;

        assertFalse(result);
        assertEquals(srcExpected, bank.findByRequisite(srcPassport, srcRequisite).getBalance(), delta);
        assertEquals(dstExpected, bank.findByRequisite(dstPassport, dstRequisite).getBalance(), delta);
    }
}