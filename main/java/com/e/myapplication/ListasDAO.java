package com.e.myapplication;

import java.util.ArrayList;

/*
* Esse objeto é criado no intuito de ser um intermediário entre
* o objeto que quer ter acesso aos dados e aos dados. Como está
* no seu nome: DAO -> Data Access Object, ou seja, um objeto com
* acesso aos Dados.
*
* */
public class ListasDAO {

    /*
    * O ArrayList abaixo é um ArrayList do tipo Contato com o nome
    * "listaDeContatos". Ele possui a atribuição estática para que
    * ele pertença à classe, e não ao objeto. Quando uma variável
    * pertence ao objeto, toda vez que um objeto desta classe for
    * instanciado, as variáveis serão sempre criadas, e cada um tem
    * suas próprias variáveis. Quando uma variável é da classe, não
    * importa se ele vai ser instanciado ou não, ele permanece do
    * mesmo jeito: alterado ou não alterado, seu valor
    *
    * */
    public static ArrayList<Contato> listaDeContatos = new ArrayList<>();

}
