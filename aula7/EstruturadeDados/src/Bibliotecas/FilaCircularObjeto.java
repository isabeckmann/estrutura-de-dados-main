package Bibliotecas;

public class FilaCircularObjeto {

    private int inicio;
    private int fim;
    private int cont;
    private int tamMax;
    private Object[] item;

    public FilaCircularObjeto(int tamMax) {
        this.cont = 0;
        this.inicio = 0;
        this.fim = -1;
        this.tamMax = tamMax;
        this.item = new Object[tamMax];
    }

    // Inserção de um elemento na fila circular
    public Object inserir(Object novoElemento) {
        if (this.cont == this.tamMax) {
            return null; // A fila está cheia, não é possível inserir
        }
        this.cont++;
        this.fim++;
        if (this.fim == this.tamMax) {
            this.fim = 0; // Volta ao início se chegou ao final do array
        }
        this.item[this.fim] = novoElemento;
        return novoElemento;
    }

    // Remoção de um elemento da fila circular
    public Object retirar() {
        if (this.cont == 0) {
            return null; // A fila está vazia, não é possível retirar
        }
        Object aux = this.item[this.inicio];
        this.item[this.inicio++] = null;
        if (this.inicio == this.tamMax) {
            this.inicio = 0; // Volta ao início se chegou ao final do array
        }
        this.cont--;
        return aux;
    }

    // Verifica se a fila está vazia
    public boolean vazia() {
        return (this.cont == 0);
    }

    // Verifica se a fila está cheia
    public boolean cheia() {
        return (this.cont == this.tamMax);
    }

    // Retorna a quantidade de elementos na fila
    public int qtd() {
        return (this.cont);
    }

    // Retorna a quantidade de espaços disponíveis na fila
    public int vagos() {
        return (this.tamMax - this.cont);
    }
    
    // Retorna a quantidade de espaços disponíveis na fila
    public int capacidadeMaxima() {
        return (this.tamMax);
    }
}
