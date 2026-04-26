package com.ramyres.model;

public class Raizes {
    public boolean temRaizesReais;
    public double raiz1;
    public double raiz2;

    public String toString() {
        if (!temRaizesReais) {
            return "A equação não possui raízes reais.";
        } else if (raiz1 == raiz2) {
            return "A equação possui uma raiz real: " + raiz1;
        } else {
            return "A equação possui duas raízes reais: " + raiz1 + " e " + raiz2;
        }
    }
}
