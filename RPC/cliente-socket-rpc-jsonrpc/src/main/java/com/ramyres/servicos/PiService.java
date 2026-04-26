package com.ramyres.servicos;

import java.math.BigDecimal;

import com.ramyres.stub.ClienteRpc;

public class PiService {
    public BigDecimal CalcularPi(long termos) {
        String[] params = new String[]{ String.valueOf(termos) };
        String[] results = ClienteRpc.executar("pi", params);
        if(results.length > 0) {
            return new BigDecimal(results[0]);
        }
        return new BigDecimal("0.0");
    }
}
