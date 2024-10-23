package br.com.uniceplac.model.enums;

public enum Categoria {
    MAGREZA,
    NORMAL,
    SOBREPESO,
    OBESIDADE;


    public static Categoria getCategoria(double imc) {
        if (imc < 18.5) {
            return MAGREZA;
        } else if (imc < 25) {
            return NORMAL;
        } else if (imc < 30) {
            return SOBREPESO;
        } else {
            return OBESIDADE;
        }
    }
}
