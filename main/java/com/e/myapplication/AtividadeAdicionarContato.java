package com.e.myapplication;

/*
* Esta activity é a activity referente ao formulário para adicionar um contato
* à lista de contatos (ListView) em uma outra activity.
*
* */

// Ignore as importações
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AtividadeAdicionarContato /* herdando de uma activity -> */ extends AppCompatActivity
{
    /*
    * Seguindo o ciclo de vida de uma activity, um dos primeiros métodos
    * a serem chamados é o métodos onCreate. Nele, como parâmetro, se espera
    * um objeto do tipo Bundle (o nome do objeto pode ser qualquer um). Existem
    * dois métodos chamados onCreate (sobrecarga). O que será utilizado usa o
    * encapsulamento "protected" e tem retorno void, logo:
    *
    * */

    /* O onCreate é um método herdado da classe mãe, logo, precisa da anotação
    * de sobrescrição para adicionar coisas ao método.
    *
    * */

    @Override
    protected void onCreate(Bundle meuBundle) {
        /*
        * Como todo método herdado de uma classe mãe, tudo o que acontecia no
        * método da mãe deverá ser executado normalmente, por isso, é utilizado
        * o super (referência à classe mãe) . (acesso aos atributos/métodos do
        * objeto em questão) onCreate(meuBundle) (método onCreate da classe mãe
        * (classe herdada) passando o Bundle meuBundle).
        *
        * */
        super.onCreate(meuBundle);

        /*
        * setContentView -> método responsável por definir uma view como conteúdo
        * desta atividade.
        *
        * */
        setContentView(R.layout.layout_da_atividade_adicionar_contato);

        /*
        * Abaixo, instanciando um Button com nome "botaoSalvarContato", e pegando
        * a referência de um elemento Button declarado no layout
        * "layout_da_atividade_principal" usado no método setContentView.
        *
        * */
        Button botaoSalvarContato = findViewById(R.id.botaoSalvarContato);

        /*
        * setOnClickListener -> método responsável por definir um ouvinte de ações
        * de cliques no objeto "botaoSalvarContato". Nele é passado a instanciação
        * da interface OnClickListener existente lá na classe View de forma anônima.
        * Essa instanciação anônima pode ser interpretada da seguinte maneira:
        *
        *       A classe View foi instanciada de forma anônima com a implementação
        *   da interface OnClickListener.
        *
        * Logo, a instanciação deve ficar da seguinte maneira:
        *
        *       new View.OnClickListener() {
        *
        *       }
        *
        * Os parênteses são usados por conta da classe View, e as chaves por conta
        * da interface OnClickListener, pois, dentro dela, como muitas interfaces
        * existem métodos não implementados que, quando a interface é implementada,
        * precisam ser sobrescrevidos.
        *
        * A partir disso, sabemos que, quando uma interface é implementada, todos os
        * métodos existentes na interface devem ser sobrescrevidos. A interface
        * OnClickListener conta com o método publico, de retorno vazio, onClick,
        * tendo como parâmetro uma View, logo:
        *
        *           @Override
        *           public void onClick(View nomeQualquer){
        *
        *           }
        *
        * Dentro das chaves do método onClick ficam as ações que devem ser executadas
        * um clique (toque) for feito no botão botaoSalvarContato.
        *
        * No geral, deve ficar da seguinte maneira:
        *
        * new View.OnClickListener(){
        *
        *   @Override
        *   public void onClick(View v) {
        *
        *   }
        *
        * }
        *
        * E, finalmente, dentro do método setOnClickListener do botão:
        *
        * botaoSalvarContato.setOnClickListener(
        *
        *   new View.OnClickListener() {
        *
        *       @Override
        *       public void onClick(View v) {
        *
        *       }
        *
        *   }
        *
        * );
        *
        * Obs.: Os espaços e linhas a mais não influenciam: é só uma forma
        * de deixar um pouco mas organizado e mais simples.
        *
        * */
        botaoSalvarContato.setOnClickListener(

            new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    /*
                    * Instanciação de um EditText com nome "etNome" com referência
                    * ao EditText com id etNome, declarado no layout definido lá
                    * em cima. Objetivo: ter acesso ao que for digitado no EditText
                    * referente ao nome do contato.
                    *
                    * */
                    EditText etNome = findViewById(R.id.etNome);

                    /*
                     * Instanciação de um EditText com nome "etTelefone" com referência
                     * ao EditText com id etTelefone, declarado no layout definido lá
                     * em cima. Objetivo: ter acesso ao que for digitado no EditText
                     * referente ao telefone do contato.
                     *
                     * */
                    EditText etTelefone = findViewById(R.id.etTelefone);

                    /*
                    * Criação de variáveis do tipo String para armazenar o nome
                    * e telefone do contato digitadas nos EditTexts do layout.
                    *
                    * Os métodos getText() e toString() são usados por causa do
                    * seguinte:
                    *
                    *       O método getText() não retorna o texto do EditText, mas sim
                    *     um editável de um objeto de lista de caracteres (CharSequence).
                    *
                    *       O método toString(), é usado para retornar o objeto convertido
                    *     em formato de String.
                    *
                    * Nesta ocasião, quando temos um Editável do EditText (um objeto com
                    * o texto do EditText) precisamos usar o método toString() para pegar a
                    * conversão daquele objeto em String (acesse o arquivo Contato.java para
                    * ter mais detalhes sobre o método toString()).
                    *
                    * */
                    String nomeDoContato = etNome.getText().toString();
                    String telefoneDoContato = etTelefone.getText().toString();

                    /*
                    * Instanciação de um objeto do tipo Contato com o nome "contato",
                    * adquirindo o nomeDoContato e telefoneDoContato como argumentos do
                    * construtor da classe, que têm como parâmetro o nome e telefone,
                    * respectivamente.
                    *
                    * */
                    Contato contato = new Contato(
                            nomeDoContato,
                            telefoneDoContato
                    );

                    /*
                    * Utilização do ArrayList "listaDeContatos" da classe ListasDAO para
                    * adicionar o contato recentemente criado. Acesse o arquivo
                    * ListasDAO.java para ter mais informações.
                    *
                    * */
                    ListasDAO.listaDeContatos.add(contato);

                    /*
                    * finish() -> método responsável por finalizar a atividade em questão.
                    *
                    * */
                    finish();
                }

            }

        );
    }

}
