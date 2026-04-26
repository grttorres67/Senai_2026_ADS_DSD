package com.ramyres.servicos;

import com.ramyres.model.Raizes;
import com.ramyres.stub.ClienteRpc;

public class BaskaraService {
    public Raizes CalcularRaizes(double a, double b, double c) {
        String[] params = new String[]{ String.valueOf(a), String.valueOf(b), String.valueOf(c) };
        String[] results = ClienteRpc.executar("baskara", params);
        
        Raizes raizes = new Raizes();
        if(results.length > 0) {
            raizes.temRaizesReais = true;
            raizes.raiz1 = Double.parseDouble(results[0]);
            if (results.length > 1) {
                raizes.raiz2 = Double.parseDouble(results[1]);
            }
            return raizes;
        }
        raizes.temRaizesReais = false;
        return raizes;
    }
}
