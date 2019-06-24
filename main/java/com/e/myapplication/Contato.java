package com.e.myapplication;

public class Contato {

    // Variáveis do objeto.
    // É necessário colocar? Não sei, o Professor provavelmente deixará passar, sei lá.
    private String nome;
    private String telefone;

    // Construtor
    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /*
    * O método toString é a forma simples de conversão de um objeto para String.
    * É necessário ser sobrescrevido pois, inicialmente, seu toString é (salvo engano):
    *
    *           NOME_DA_CLASSE@NÚMERO_DE_LOCAÇÃO_NA_MEMÓRIA
    *
    * E esse não é o retorno adequado que precisamos nesse objeto. Logo, o retorno que
    * devemos colocar nesse objeto é uma string que exponha o nome e o telefone do
    * objeto.
    *
    * */
    @Override
    public String toString() {
        return "Contato: Nome: " + this.nome + ";\nTelefone: " + this.telefone + ".";
    }
}
