package Bibliotecas;
/*
Funcionamento da Lista Duplamente Encadeada:
+------+      +------+     +------+     +------+     +------+
| Cabeça | <- |  X1  | <-> |  X2  | <-> |  X3  | <-> |  Xn  |
+------+      +------+     +------+     +------+     +------+
  Início                                              Fim
*/



public class ListaDuplamenteEncadeada {
    private static class Celula {
        Object item;
        Celula prox;
        Celula ant;
    }

    private Celula inicio, aux, fim;
    private int qtd;

    public ListaDuplamenteEncadeada() { // Cria uma Lista vazia
        this.inicio = new Celula();
        this.inicio.prox = null;
        this.inicio.ant = null;
        this.fim = this.inicio;
        this.qtd = 0;
    }

    public Celula posInserir(Integer chave) {
        Celula pos = new Celula();
        Celula ant = new Celula();
        pos = this.inicio.prox;
        ant = this.inicio;

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
        if (this.vazia()) {
            return null;
        }

        Celula pos = this.fim;
        Object item = pos.item;

        if (this.qtd == 1) {
            this.inicio.prox = null;
            this.fim = this.inicio;
        } else {
            pos.ant.prox = null;
            this.fim = pos.ant;
        }

        this.qtd--;
        return (Integer) item;
    }

    public Object inserir(Object novaChave) {
        Celula aux = null;
        aux = posInserir((Integer) novaChave);

        if (aux == null) {
            return null;
        }

        Celula novo = new Celula();
        if (novo == null) {
            return null;
        }

        novo.item = novaChave;
        novo.prox = aux.prox;
        novo.ant = aux;
        if (aux.prox != null) {
            aux.prox.ant = novo;
        }
        aux.prox = novo;

        if (aux == this.fim) {
            this.fim = novo;
        }

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
        Celula pos = new Celula();
        pos = this.inicio.prox;
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
        Object item = null;
        if (!this.vazia()) {
            Celula pos = this.inicio.prox;
            Celula ant = this.inicio;

            while (pos != null) {
                if (pos.item.equals(chave)) {
                    item = pos.item;
                    ant.prox = pos.prox;
                    if (pos.prox != null) {
                        pos.prox.ant = ant;
                    }
                    if (pos == this.fim) {
                        this.fim = ant;
                    }
                    this.qtd--;
                    break;
                }
                ant = pos;
                pos = pos.prox;
            }
        }
        return item;
    }

    public void inverter() {
        Celula pos = this.fim;
        Celula temp;

        while (pos != null) {
            temp = pos.prox;
            pos.prox = pos.ant;
            pos.ant = temp;
            pos = pos.prox;
        }

        temp = this.inicio;
        this.inicio = this.fim;
        this.fim = temp;
    }

    public ListaDuplamenteEncadeada copiar() {
        ListaDuplamenteEncadeada copia = new ListaDuplamenteEncadeada();
        Celula pos = this.inicio.prox;

        while (pos != null) {
            copia.inserir(pos.item);
            pos = pos.prox;
        }

        return copia;
    }

    public Celula posInserir(String chave) {
        Celula pos = new Celula();
        Celula ant = new Celula();
        pos = this.inicio.prox;
        ant = this.inicio;

        while (pos != null) {
            if (pos.item.equals(chave)) {
                System.out.println("Já existe = " + pos.item);
                return null;
            }
            if (pos.item.toString().compareToIgnoreCase(chave) > 0) {
                return ant;
            }
            ant = pos;
            pos = pos.prox;
        }
        return ant;
    }
}
