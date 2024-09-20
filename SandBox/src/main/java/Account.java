import java.time.LocalDate;
import java.util.Objects;

public class Account {
    private static int nextAccountNumber;
    private final int number;
    private String name;
    private boolean paid;
    private LocalDate startDate;
    /**
     * Constructor of class Account.
     *
     * @param name of the account to create.
     * @param paid wether it was paid, or not.
     */
    public Account(String name, boolean paid) {
        number = ++nextAccountNumber;
        this.name = (name != null) ? name : "Sem nome";
        this.paid = paid;
        this.startDate = LocalDate.now();
    }
    /**
     * Get the number.
     *
     * @return This member number.
     */
    public int getNumber() {
        return number;
    }
    /**
     * Get the name.
     *
     * @return This member name.
     */
    public String getName() {
        return name;
    }
    /**
     * Set the name.
     *
     * @param name The new name. Must not be null.
     */
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }
    /**
     * Is the payment done?
     *
     * @return Wether it was paid, or not.
     */
    public boolean isPaid() {
        return paid;
    }
    /**
     * Set payment status.
     *
     * @param paid The new payment status.
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    /**
     * Get the start date.
     *
     * @return This account start date.
     */
    public LocalDate getStartDate() {
        return startDate;
    }
    @Override
    public String toString() {
        return name + "\t\t" + paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return number == account.number &&
                Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

}