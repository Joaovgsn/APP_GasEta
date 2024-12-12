package com.diego.appgaseta.model;

public class Combustivel {

    private Double gasolina;
    private Double etanol;
    private String resultado;

    public Double getGasolina() {
        return gasolina;
    }

    public void setGasolina(Double gasolina) {
        this.gasolina = gasolina;
    }

    public Double getEtanol() {
        return etanol;
    }

    public void setEtanol(Double etanol) {
        this.etanol = etanol;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Combustivel{" +
                "gasolina=" + gasolina +
                ", etanol=" + etanol +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
