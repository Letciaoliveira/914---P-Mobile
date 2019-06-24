package com.e.myapplication;

// Essa atividade é a atividade de lista de contatos,
// onde terá um ListView e o botão de adicionar contato

// Ignore as importações
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AtividadeListaDeContatos extends AppCompatActivity {

    /*
    * ArrayAdapter -> é um array adaptador de objetos para views.
    * Nele não há uma forma de adaptar o objeto em uma view de forma
    * custumizada. Logo, os objetos nele adicionados serão exibidos
    * através do toString do objeto.
    *
    * */
    private ArrayAdapter adaptadorDeContatos;

    @Override
    protected void onCreate(Bundle meuBundle) {
        super.onCreate(meuBundle);
        setContentView(R.layout.layout_da_atividade_lista_de_contatos);

        /*
        * Instanciação do ArrayAdapter "adaptadorDeContatos".
        * Para sua instanciação, é necessário o contexto (a activity onde está
        * sendo instanciada) e um layout padrão para mostrar os objetos nele
        * adicionados. Como esse layout ainda não é feito por nós até o atual
        * momento, o layout padrão usado será o "simple_list_item_1" ou o que o
        * Professor coloca na aula.
        *
        * */
        this.adaptadorDeContatos = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1
        );

        /*
        * Aqui é adicionado todos os objetos que existem na nossa "listaDeContatos"
        * que está declarada lá na nossa classe "ListasDAO". Para mais informações,
        * acesse o arquivo "ListasDAO.java".
        *
        * addAll -> método responsável por adicionar uma coleção de objetos, ou, para
        * entender melhor, um array de objetos.
        *
        * */
        this.adaptadorDeContatos.addAll(ListasDAO.listaDeContatos);

        /*
        * Instanciação de um objeto do tipo ListView com nome "meuListView", pegando
        * referência do elemento ListView com id "listaDeContatos" declarado no layout
        * definido.
        *
        * */
        ListView meuListView = findViewById(R.id.listaDeContatos);

        /*
        * setAdapter -> método responsável por definir o adapter do ListView.
        * Para uma classe ser considerada um Adapter, ela precisa (básicamente)
        * herdar de BaseAdapter ou ter a implementação de ListAdapter para ser
        * considerado um.
        *
        * */
        meuListView.setAdapter(adaptadorDeContatos);

        /*
        * Instanciação de um objeto do tipo FloatingActionButton com nome
        * "botaoAdicionarContato" pegando referência do elemento FloatingActionButton
        * com id "botaoAdicionarContato" declarado lá no layout definido nessa
        * atividade. O FloatingActionButton é um botão, só que redondo '-' (sim, é
        * tem algumas características diferentes, mas é um botão redondo '-')...
        *
        * */
        FloatingActionButton botaoAdicionarContato = findViewById(R.id.botaoAdicionarContato);

        /*
        * Definindo o ouvinte de clique do "botaoAdicionarContato". Veja o arquivo
        * "AtividadeAdicionarContato" para ter mais informações sobre ele.
        *
        * */
        botaoAdicionarContato.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        /*
                        * Instanciação de um objeto do tipo Intent com nome "intent".
                        * Uma Intent serve para armazenar intenções. Uma inteção é
                        * básicamente uma ação advinda de um determinado contexto.
                        *
                        * Ex.: Pegar uma foto da galeria.
                        * Ex. 2: iniciar uma nova atividade.
                        *
                        * Para sua instanciação é necessário dizer o contexto, que se
                        * resume na atividade em questão, e na ação. Neste caso, a ação
                        * desta intent é uma classe. A ação passada vai ser executada quando
                        * passada para um método de execução de uma intenção (ex.:
                        * o método startActivity).
                        *
                        * */
                        Intent intent = new Intent(
                                AtividadeListaDeContatos.this,
                                AtividadeAdicionarContato.class
                        );

                        /*
                        * startActivity -> método responsável por iniciar uma activity a
                        * partir de uma intenção (Intent).
                        *
                        * */
                        startActivity(intent);
                    }

                }

        );
    }

    /*
    * Sobrescrição do método onResume -> método responsável por tornar atualizar o contexto
    * para essa atividade e continuar a execução dos processos necessários para o seu
    * funcionamento normal.
    *
    * */
    @Override
    protected void onResume() {
        /*
        * Como todo método herdado de uma classe mãe, o mesmo deve ser sobrescrevido e ainda
        * assim continuar o processo normal da classe mãe (utilizando o super.onResume()).
        *
        * */
        super.onResume();

        /*
        * clear -> método responsável por limpar o adaptador; excluir tudo que há nele.
        *
        * */
        adaptadorDeContatos.clear();

        /*
        * Adicionando todos os elementos que estão dentro do ArrayList listaDeContatos
        * (como antes dito).
        *
        * */
        adaptadorDeContatos.addAll(ListasDAO.listaDeContatos);
    }
}
