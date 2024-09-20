import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreamingService {
    private List<Account> activeAccounts;
    /**
     * Constructor of class StreamingService.
     */
    public StreamingService() {
        activeAccounts = new ArrayList<>();
    }
    /**
     * Get the list of accounts.
     *
     * @return This streaming service active accounts.
     */
    public List<Account> getActiveAccounts() {
        return activeAccounts;
    }
    /**
     * Add an account.
     *
     * @param account to add.
     */
    public void addAccount(Account account) {
        activeAccounts.add(account);
    }
    /**
     * Remove an account.
     *
     * @param account to remove.
     */
    public void removeAccount(Account account) {
        activeAccounts.removeIf(it -> it.equals(account));
    }
    /**
     * Remove all accounts that didn't pay. Implementation using an iterator.
     */
    public void removeUnpaidAccounts() {

    }
    /**
     * Clear all payments. Implementation using functional
     * programming.
     */
    public void setAllAccountsAsUnpaid() {

    }
    /**
     * Remove all accounts that didn't pay. Implementation using removeIf method.
     */
    public void removeUnpaidAccountsRemoveIf() {

    }
    /**
     * Get the list of accounts that didn't pay. Implementation using functional
     * programming.
     *
     * @return A list with all accounts that didn't pay.
     */
    public List<Account> getListOfUnpaidAccounts() {
        return null;
    }
    /**
     * Count the amount of accounts that didn't pay. Implementation using
     * functional programming.
     *
     * @return The amount of accounts that didn't pay.
     */
    public long countUnpaidAccounts() {
        return -1;
    }
    @Override
    public String toString() {
        return null;
    }
}