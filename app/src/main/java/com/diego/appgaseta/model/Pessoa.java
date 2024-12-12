package com.diego.appgaseta.model;

public class Pessoa {
    private String primeiroNome;
    private String sobreNome;
    private String nomeCurso;
    private String telefoneContato;

    public Pessoa() {
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Nome='" + primeiroNome + '\'' +
                ", Sobrenome='" + sobreNome + '\'' +
                ", Curso='" + nomeCurso + '\'' +
                ", Telefone='" + telefoneContato + '\'' +
                '}';
    }



}
