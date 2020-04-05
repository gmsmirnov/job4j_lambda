package gsmirnov.stream.bank;

import java.util.Objects;

/**
 * Account's model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-03
 */
public class Account {
    /**
     * Account's requisite.
     */
    private String requisite;

    /**
     * Account's balance.
     */
    private double balance;

    /**
     * Creates account with the specified parameters.
     *
     * @param requisite the specified requisite.
     * @param balance the specified balance amount.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Gets this account's requisite.
     *
     * @return this account's requisite.
     */
    public String getRequisite() {
        return this.requisite;
    }

    /**
     * Sets the specified requisite to this account.
     *
     * @param requisite the specified requisite.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Gets this account's balance.
     *
     * @return this account's balance.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Sets the specified balance amount to this account.
     *
     * @param balance the specified balance amount.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Checks this account for equivalence with another account.
     *
     * @param o another account.
     * @return true if both accounts are equals, false either.
     */
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Account account = (Account) o;
            result = Objects.equals(this.requisite, account.requisite);
        }
        return result;
    }

    /**
     * Calculates hash code for this account.
     *
     * @return calculates hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.requisite);
    }
}