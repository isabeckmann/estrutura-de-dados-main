package Bibliotecas;
// Considerações:
// * Versão de estratégia de alocação estática.
// * Versão simplificada, considerando a orientação objeto precisamos de melhorias

public class PilhaObjeto {
    private Object item[];
    private int topo;
    private int tamanhoMax;

    public PilhaObjeto() { // Cria uma Pilha vazia       
        this.tamanhoMax = 30;
        this.item = new Object[30];
        this.topo = -1;
    }

    public PilhaObjeto(int TamMax) { //Cria uma Pilha vazia
        this.tamanhoMax = TamMax;
        this.item = new Object[TamMax];
        this.topo = -1; 
    } 
    
    // PUSH(e) <= insere um elemento
    public Object empilha(Object novo) {
        if (this.topo == this.tamanhoMax - 1)// if (this.cheia())
        {
            return null;
        }
        this.topo = this.topo + 1;
        this.item[this.topo] = novo;
        // this.item[++this.topo] = novo;
        return novo;
    }

    // POP() => retira um elemento
    public Object desempilha() {
        if (this.vazia()) //if (this.topo == -1)
        {
            return null;
        }
     //   return this.item[this.topo--];
        Object aux = this.item[this.topo];
        this.item[this.topo--] = null;
        return aux;
    }

    //TOP()=> e    Retorna o lemento do topo mas não retira.
    public Object doTopo() {
        if (this.vazia()) //if (this.topo == -1)
        {
            return null;
        }
        return this.item[this.topo];
    }

    // isEmpty  => retorna boolenado  
    //            (se vazio então retrona True  senão retorna False)
    public boolean vazia() {
        return (this.topo == -1);
    }

    // isFULL  => retorna boolenado  
    //           (se cheia então retrona True  senão retorna False)
    public boolean cheia() {
       // return (this.topo == this.tamanhoMax - 1);
        return ((this.topo+1) == this.tamanhoMax );
    }

    // Retorna a quantidade de elementos na pilha
    public int qtd() {
        return (this.topo + 1);
    }

    //Retorna quantos ainda podem serem inseridos na pilha.
    //a ser implementada pelos estudantes.
    public int vagos() {
       //return ( this.tamanhoMax - this.qtd());
       return ( this.tamanhoMax - (this.topo+1));
    }
    
        
    // Retorna a quantidade de espaços disponíveis na fila
    // lembrando que o mais indicado é usar o método vagos
    public int capacidadeMaxima() {
        return (this.tamanhoMax);
    }
    
}
