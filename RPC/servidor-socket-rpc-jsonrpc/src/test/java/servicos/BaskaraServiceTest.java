package servicos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.ramyres.servicos.BaskaraService;

public class BaskaraServiceTest {
    @Test
    public void testCalcularRaizes() {
        BaskaraService service = new BaskaraService();
        
        // Teste com delta positivo
        String[] params1 = {"1", "-3", "2"};
        String[] resultado1 = service.Run(params1);
        assert resultado1.length == 2;
        assert resultado1[0].equals("2.0");
        assert resultado1[1].equals("1.0");
        
        // Teste com delta zero
        String[] params2 = {"1", "-2", "1"};
        String[] resultado2 = service.Run(params2);
        assert resultado2.length == 1;
        assert resultado2[0].equals("1.0");
        
        // Teste com delta negativo
        String[] params3 = {"1", "0", "1"};
        String[] resultado3 = service.Run(params3);
        assert resultado3.length == 0;
    }
}
