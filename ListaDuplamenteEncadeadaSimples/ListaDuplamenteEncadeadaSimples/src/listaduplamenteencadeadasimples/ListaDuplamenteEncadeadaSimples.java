package listaduplamenteencadeadasimples;

public class ListaDuplamenteEncadeadaSimples {

    private static class Celula {
        Object item;
        Celula prox;
        Celula ant;
    }

    private Celula inicio; // primeiro nó real (ou null se vazia)
    private Celula fim;    // último nó real (ou null se vazia)
    private int qtd;

    public ListaDuplamenteEncadeadaSimples() {
        this.inicio = null;
        this.fim = null;
        this.qtd = 0;
    }

    public boolean vazia() {
        return this.inicio == null;
    }

    public int qtd() {
        return this.qtd;
    }

    // ============================
    // Insere sempre no INÍCIO
    // ============================
    public void inserirNoInicio(Integer valor) {
        Celula novo = new Celula();
        novo.item = valor;

        if (this.vazia()) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            novo.prox = this.inicio;
            this.inicio.ant = novo;
            this.inicio = novo;
        }
        this.qtd++;
    }

    // ============================
    // Insere sempre no FIM
    // ============================
    public void inserirNoFim(Integer valor) {
        Celula novo = new Celula();
        novo.item = valor;

        if (this.vazia()) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            novo.ant = this.fim;
            this.fim.prox = novo;
            this.fim = novo;
        }
        this.qtd++;
    }

    // ============================
    // Remove do INÍCIO
    // ============================
    public Integer removerDoInicio() {
        if (this.vazia()) return null;

        Integer item = (Integer) this.inicio.item;
        if (this.qtd == 1) {
            this.inicio = null;
            this.fim = null;
        } else {
            this.inicio = this.inicio.prox;
            this.inicio.ant = null;
        }
        this.qtd--;
        return item;
    }

    // ============================
    // Remove do FIM
    // ============================
    public Integer removerDoFim() {
        if (this.vazia()) return null;

        Integer item = (Integer) this.fim.item;
        if (this.qtd == 1) {
            this.inicio = null;
            this.fim = null;
        } else {
            this.fim = this.fim.ant;
            this.fim.prox = null;
        }
        this.qtd--;
        return item;
    }

    // ============================
    // Remove pela chave
    // ============================
    public Integer removerChave(Integer chave) {
        if (this.vazia()) return null;

        Celula atual = this.inicio;
        while (atual != null) {
            if (atual.item.equals(chave)) {
                Integer item = (Integer) atual.item;

                if (atual == this.inicio) {
                    return removerDoInicio();
                }
                if (atual == this.fim) {
                    return removerDoFim();
                }

                // nó no meio
                atual.ant.prox = atual.prox;
                atual.prox.ant = atual.ant;

                this.qtd--;
                return item;
            }
            atual = atual.prox;
        }
        return null; // não encontrou
    }

    // ============================
    // Mostrar do início ao fim
    // ============================
    public void mostrar() {
        Celula p = this.inicio;
        System.out.print("Lista = [ ");
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.prox;
        }
        System.out.println("]");
    }

    // ============================
    // Mostrar do fim ao início
    // ============================
    public void mostrarReverso() {
        Celula p = this.fim;
        System.out.print("Lista (reversa) = [ ");
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.ant;
        }
        System.out.println("]");
    }
}
