package Bibliotecas;
// Considerações:
// * Versão de estratégia de alocação estática.
// * Versão simplificada, considerando a orientação objeto precisamos de melhorias

public class FilaObjeto {

    private Object item[];
    private int tamanhoMax;
    private int inicio;
    private int fim;

    public FilaObjeto() { // Cria uma Fila vazia       
        this.tamanhoMax = 5;
        this.item = new Object[this.tamanhoMax];
        this.inicio = 0;
        this.fim = -1;
    }

    public FilaObjeto(int TamMax) { //Cria uma Fila vazia
        this.tamanhoMax = TamMax;
        this.item = new Object[TamMax];
        this.inicio = 0;
        this.fim = -1;
    }

    // Mantem o mesmo tamanho do vetor alocado
    // Reinicializa os marcadores de Inicio e Fim
    public void reiniciar() { 
        this.inicio = 0;
        this.fim = -1;
    }

    // inserir(e) <= insere um elemento
    public Object inserir(Object novo) {
        if (((this.fim + 1) == this.tamanhoMax))// if (this.cheia())
        {
            return null;
        }
        this.fim = this.fim + 1;
        this.item[this.fim] = novo;
        // this.item[++this.fim] = novo;
        return novo;
    }

    // retirar() => retira um elemento
    public Object retirar() {
        if (this.vazia()) //
        {
            return null;
        }
        //return this.item[this.inicio++];
        Object aux = this.item[this.inicio];
        this.item[this.inicio] = null;
        this.inicio = this.inicio + 1;
        return aux;
    }

    //FIRST()=> e    Retorna o lemento do topo mas não retira.
    /*  public Object primeiro() {
        if (this.vazia()) //if (this.topo == -1)
        {
            return null;
        }
        Object aux = this.item[this.inicio];
        return aux;
    }
     */
    // isEmpty  => retorna boolenado  
    //            (se vazio então retrona True  senão retorna False)
    public boolean vazia() {
        return (this.inicio > this.fim);
    }

    // isFULL  => retorna boolenado  
    //           (se cheia então retrona True  senão retorna False)
    public boolean cheia() {
        return (this.fim + 1 == this.tamanhoMax);
    }

    // Retorna a quantidade de elementos na fila
    public int qtd() {
        return (this.fim - this.inicio + 1);
    }

    //Retorna quantos ainda podem serem inseridos na fila
    //a ser implementada pelos estudantes.
    public int vagos() {
        return (this.tamanhoMax - (this.fim + 1));
    }
    
    // Retorna a quantidade de espaços disponíveis na fila
    // lembrando que o mais indicado é usar o método vagos
    public int capacidadeMaxima() {
        return (this.tamanhoMax);
    }
}
