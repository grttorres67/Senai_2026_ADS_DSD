package com.ramyres.servicos;

public class PalavrasService implements ServiceInterface {

    @Override
    public String[] Run(String[] params) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'Run'");
        //[qtdLetras, qtdPalavras, qtdVogal, qtdVogalAcentuada, qtdConsoantes, qtdEspacos, qtdPalavrasPar, qtdPalavrasImpar, qtdDeLinhas ]
        return new String[]{
            "38",
            "10",
            "18",
            "1",
            "19",
            "9",
            "4",
            "6",
            "1"
        };
    }
}
