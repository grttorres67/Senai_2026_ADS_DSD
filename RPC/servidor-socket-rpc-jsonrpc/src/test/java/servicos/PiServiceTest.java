package servicos;

import org.junit.jupiter.api.Test;

import com.ramyres.servicos.PiService;

public class PiServiceTest {
    @Test
    public void testCalcularPi() {
        int qtdCasas = 15;
        PiService service = new PiService();
        String[] params = {String.valueOf(qtdCasas)};
        String[] resultado = service.Run(params);
        assert resultado.length == 1;
        assert resultado[0] != null;
        assert resultado[0].matches("\\d+(\\.\\d+)?"); // Verifica se o resultado é um número
        assert resultado[0].length() > 0; // Verifica se o resultado não é vazio
        assert resultado[0].length() > qtdCasas; // Verifica se o resultado não é vazio

        double piCalculado = Double.parseDouble(resultado[0]);
        double piReal = Math.PI;
        double delta = Math.abs(piCalculado - piReal);
        assert delta < 0.001; // Verifica se o valor calculado está próximo de PI
    }
}
