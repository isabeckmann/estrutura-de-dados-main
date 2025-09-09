package Bibliotecas;
//Funcionamento da Lista Encadeada:

// +--------+    +------+    +------+    +------+    +------+
// | Cabeça | -> |  X1  | -> |  X2  | -> |  X3  | -> |  Xn  |
// +--------+    +------+    +------+    +------+    +------+
//   Início


public class Lista_AutoReferencia {
    public static class Celula {
        Object item;
        Celula prox;
    }

    private Celula inicio;
    private int qtd;

    public Lista_AutoReferencia() { // Cria uma Lista vazia
        this.inicio = new Celula();
        this.inicio.prox = null;
        this.qtd = 0;
    }

    public Celula posInserir(Integer chave) {
        Celula pos = this.inicio.prox;
        Celula ant = this.inicio;

        while (pos != null) {
            if (pos.item.equals(chave)) {
                System.out.println("Já existe = " + pos.item);
                return null;
            }
            if ((Integer) pos.item > chave) {
                return ant;
            }
            ant = pos;
            pos = pos.prox;
        }
        return ant;
    }

    public Integer retirarUltimo() {
        if (!vazia()) {
            Celula pos = this.inicio;
            Celula ant = null;

            while (pos.prox != null) {
                ant = pos;
                pos = pos.prox;
            }
            ant.prox = null;
            this.qtd--;
            return (Integer) pos.item;
        }
        return null;
    }

    public Object inserir(Object novaChave) {
        Celula aux = posInserir((Integer) novaChave);

        if (aux == null) {
            return null;
        }

        Celula novo = new Celula();
        novo.item = novaChave;
        novo.prox = aux.prox;
        aux.prox = novo;
        this.qtd++;
        return novaChave;
    }

    public boolean vazia() {
        return (this.inicio.prox == null);
    }

    public int qtd() {
        return (this.qtd);
    }

    public boolean mostrar() {
        Celula pos = this.inicio.prox;
        int cont = 0;
        System.out.print("Lista=[ ");
        while (pos != null) {
            System.out.print((Integer) pos.item + " ");
            pos = pos.prox;
            cont++;
            if (cont % 50 == 0)
                System.out.println("");
        }
        System.out.println("]   \nCont= " + cont);
        return (true);
    }

    public Object retirar(Integer chave) {
        if (!vazia()) {
            Celula pos = this.inicio.prox;
            Celula ant = this.inicio;

            while (pos != null) {
                if (pos.item.equals(chave)) {
                    ant.prox = pos.prox;
                    this.qtd--;
                    return chave;
                }
                ant = pos;
                pos = pos.prox;
            }
        }
        return null;
    }

    public void inverter() {
        Celula anterior = null;
        Celula atual = this.inicio.prox;
        Celula proximo = null;

        while (atual != null) {
            proximo = atual.prox;
            atual.prox = anterior;
            anterior = atual;
            atual = proximo;
        }

        this.inicio.prox = anterior;
    }

    public Lista_AutoReferencia copiar() {
        Lista_AutoReferencia novaLista = new Lista_AutoReferencia();
        Celula pos = this.inicio.prox;

        while (pos != null) {
            novaLista.inserir(pos.item);
            pos = pos.prox;
        }

        return novaLista;
    }

    public Celula posInserir(String chave) {
        Celula pos = this.inicio.prox;
        Celula ant = this.inicio;

        while (pos != null) {
            if (pos.item.equals(chave)) {
                System.out.println("Já existe = " + pos.item);
                return null;
            }
            if (pos.item.toString().compareTo(chave) > 0) {
                return ant;
            }
            ant = pos;
            pos = pos.prox;
        }
        return ant;
    }
}
