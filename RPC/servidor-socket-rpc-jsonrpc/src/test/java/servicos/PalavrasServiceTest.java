package servicos;

import org.junit.jupiter.api.Test;

import com.ramyres.servicos.PalavrasService;

public class PalavrasServiceTest {
    @Test
    public void testContarLetras() {
        PalavrasService service = new PalavrasService();
        String[] params = {"A vingança nunca é plena, mata a alma e envenena."};
        String[] resultado = service.Run(params);
        assert resultado.length == 9;
        
        assert resultado[0].equals("38"); // qtdLetras
        assert resultado[1].equals("10"); // qtdPalavras
        assert resultado[2].equals("18"); // qtdVogal
        assert resultado[3].equals("1"); // qtdVogalAcentuada
        assert resultado[4].equals("19"); // qtdConsoantes
        assert resultado[5].equals("9"); // qtdEspacos
        assert resultado[6].equals("4"); // qtdPalavrasPar
        assert resultado[7].equals("6"); // qtdPalavrasImpar
        assert resultado[8].equals("1"); // qtdDeLinhas
    }
}
