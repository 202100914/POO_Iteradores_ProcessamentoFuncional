import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
        Iterator <Account> it = this.activeAccounts.iterator();

        while (it.hasNext()){
            Account account = it.next();
            if (!account.isPaid())
                it.remove();
        }
    }
    /**
     * Clear all payments. Implementation using functional
     * programming.
     */
    public void setAllAccountsAsUnpaid() {
        activeAccounts.forEach(account -> account.setPaid(false));
    }

    /**
     * Remove all accounts that didn't pay. Implementation using removeIf method.
     */
    public void removeUnpaidAccountsRemoveIf() {
        activeAccounts.removeIf(account -> !account.isPaid());
    }
    /**
     * Get the list of accounts that didn't pay. Implementation using functional
     * programming.
     *
     * @return A list with all accounts that didn't pay.
     */
    public List<Account> getListOfUnpaidAccounts() {


        return activeAccounts.stream()
                .filter(account -> !account.isPaid())
                .collect(Collectors.toList());
    }
    /**
     * Count the amount of accounts that didn't pay. Implementation using
     * functional programming.
     *
     * @return The amount of accounts that didn't pay.
     */
    public long countUnpaidAccounts() {
        return activeAccounts.stream()
                .filter(account -> !account.isPaid())
                .map(account -> 1L)
                .reduce(0L, Long::sum);
    }

    @Override
    public String toString() {
        return activeAccounts.stream()
                .map(account -> String.format("%-20s %s", account.getName(), account.isPaid()))
                .collect(Collectors.joining("\n", "Nome                Pago\n", ""));
    }



}