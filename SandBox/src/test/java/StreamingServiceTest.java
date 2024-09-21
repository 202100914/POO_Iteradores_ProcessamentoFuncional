import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StreamingServiceTest {

    private static StreamingService streamingService;
    private static Account account;

    @BeforeEach
    public void setup() {
        streamingService = new StreamingService();
    }

    private void populateAccounts() {
        Account account1 = new Account("José Manuel", true);
        Account account2 = new Account("Francisco Silva", false);
        Account account3 = new Account("Maria Clara", false);
        Account account4 = new Account("Clotilde Matias", true);
        Account account5 = new Account("Fernanda Costa", false);

        streamingService.addAccount(account1);
        streamingService.addAccount(account2);
        streamingService.addAccount(account3);
        streamingService.addAccount(account4);
        streamingService.addAccount(account5);
    }

    @Test
    public void constructorTest(){
        // Verifica se o objeto StreamingService não é nulo
        assertNotNull(streamingService);

        // Verifica se a lista de activeAccounts foi inicializada corretamente
        assertNotNull(streamingService.getActiveAccounts());
    }

    @Test
    public void addAccountTest(){

        assertThat(streamingService.getActiveAccounts()).isEmpty();

        Account account = new Account("dummy1", true);
        streamingService.addAccount(account);

        assertThat(streamingService.getActiveAccounts())
                .hasSize(1);

        streamingService.removeAccount(account);

        assertThat(streamingService.getActiveAccounts()).isEmpty();
    }

    @Test
    public void testRemoveUnpaidAccounts(){
        populateAccounts();

        streamingService.removeUnpaidAccounts();

        List<Account> activeAccounts = streamingService.getActiveAccounts();
        assertThat(activeAccounts).hasSize(2); // Apenas 2 contas pagaram

        // Verifica que as contas pagantes ainda estão na lista
        assertTrue(activeAccounts.stream().anyMatch(account -> account.getName().equals("José Manuel")));
        assertTrue(activeAccounts.stream().anyMatch(account -> account.getName().equals("Clotilde Matias")));

        // Verifica que as contas não pagantes foram removidas
        assertFalse(activeAccounts.stream().anyMatch(account -> account.getName().equals("Francisco Silva")));
        assertFalse(activeAccounts.stream().anyMatch(account -> account.getName().equals("Maria Clara")));
        assertFalse(activeAccounts.stream().anyMatch(account -> account.getName().equals("Fernanda Costa")));
    }

    @Test
    public void testSetAllAccountsAsUnpaid(){
        populateAccounts();

        streamingService.setAllAccountsAsUnpaid();

        List<Account> activeAccounts = streamingService.getActiveAccounts();
        assertThat(activeAccounts.stream().allMatch(account -> !account.isPaid())).isTrue();
    }

    @Test
    public void testRemoveUnpaidAccountsRemoveIf(){
        populateAccounts();

        streamingService.removeUnpaidAccountsRemoveIf();

        List<Account> activeAccounts = streamingService.getActiveAccounts();
        assertThat(activeAccounts).hasSize(2); // Apenas 2 contas pagaram

        // Verifica que as contas pagantes ainda estão na lista
        assertTrue(activeAccounts.stream().anyMatch(account -> account.getName().equals("José Manuel")));
        assertTrue(activeAccounts.stream().anyMatch(account -> account.getName().equals("Clotilde Matias")));

        // Verifica que as contas não pagantes foram removidas
        assertFalse(activeAccounts.stream().anyMatch(account -> account.getName().equals("Francisco Silva")));
        assertFalse(activeAccounts.stream().anyMatch(account -> account.getName().equals("Maria Clara")));
        assertFalse(activeAccounts.stream().anyMatch(account -> account.getName().equals("Fernanda Costa")));
    }

    @Test
    public void testGetListOfUnpaidAccounts(){
        populateAccounts();

        List<Account> activeAccounts = streamingService.getListOfUnpaidAccounts();

        assertThat(activeAccounts.stream().noneMatch(Account::isPaid)).isTrue();
    }

    @Test
    public void countUnpaidAccounts(){
        populateAccounts();

        long unpaidCount = streamingService.countUnpaidAccounts();

        assertThat(unpaidCount).isEqualTo(3);
    }

    @Test
    public void testToString() {
        populateAccounts(); // Preenche as contas para o teste

        String expected = "Nome                Pago\n" +
                "José Manuel         true\n" +
                "Francisco Silva     false\n" +
                "Maria Clara         false\n" +
                "Clotilde Matias     true\n" +
                "Fernanda Costa      false\n";

        assertThat(streamingService.toString()).isEqualTo(expected);
    }




}