import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.assertj.core.api.Assertions.assertThat;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StreamingServiceTest {

    private static StreamingService streamingService;
    private static Account account;

    @BeforeAll
    static void setup() {
        streamingService = new StreamingService();

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

        // Verifica que no início não há contas ativas
        assertThat(streamingService.getActiveAccounts()).isEmpty();

        // Adiciona uma conta ativa
        Account account = new Account("dummy1", true);
        streamingService.addAccount(account);

        // Verifica que agora há uma conta ativa
        assertThat(streamingService.getActiveAccounts())
                .hasSize(1);

        streamingService.removeAccount(account);

        assertThat(streamingService.getActiveAccounts()).isEmpty();
    }




}