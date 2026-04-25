package com.ramyres.servicos;

public class BaskaraService implements ServiceInterface {

    private double[] CalcularRaizes(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            return new double[] {};
        } 
        
        if (delta == 0) {
            double raiz = -b / (2 * a);
            return new double[] {raiz};
        }

        double raiz1 = (-b + Math.sqrt(delta)) / (2 * a);
        double raiz2 = (-b - Math.sqrt(delta)) / (2 * a);
        return new double[] {raiz1, raiz2};
    }

    @Override
    public String[] Run(String[] params) {
        if(params.length != 3) {
            throw new IllegalArgumentException("Parâmetros inválidos. Esperado: a, b, c");
        }
        double a = Double.parseDouble(params[0]);
        double b = Double.parseDouble(params[1]);
        double c = Double.parseDouble(params[2]);
        
        double[] resultados = CalcularRaizes(a, b, c);
        
        String[] resposta = new String[resultados.length];
        
        for (int i = 0; i < resultados.length; i++) {
            resposta[i] = String.valueOf(resultados[i]);
        }

        return resposta;
    }
}
