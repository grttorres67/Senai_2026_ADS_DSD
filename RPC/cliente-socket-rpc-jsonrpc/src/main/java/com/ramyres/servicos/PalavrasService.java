package com.ramyres.servicos;

import com.ramyres.model.EstatisticaDoTexto;
import com.ramyres.stub.ClienteRpc;

public class PalavrasService {
    public EstatisticaDoTexto ObterEstatistica(String texto) {
        String[] results = ClienteRpc.executar("palavras", new String[]{ texto });
        EstatisticaDoTexto estatistica = new EstatisticaDoTexto();
        if (results.length == 9) {
            estatistica.qtdLetras = Integer.parseInt(results[0]);
            estatistica.qtdPalavras = Integer.parseInt(results[1]);
            estatistica.qtdVogal = Integer.parseInt(results[2]);
            estatistica.qtdVogalAcentuada = Integer.parseInt(results[3]);
            estatistica.qtdConsoantes = Integer.parseInt(results[4]);
            estatistica.qtdEspacos = Integer.parseInt(results[5]);
            estatistica.qtdPalavrasPar = Integer.parseInt(results[6]);
            estatistica.qtdPalavrasImpar = Integer.parseInt(results[7]);
            estatistica.qtdDeLinhas = Integer.parseInt(results[8]);
        }
        return estatistica;
    }
}
