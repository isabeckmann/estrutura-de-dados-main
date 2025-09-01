// Aluna Isadora Beckmann

import java.util.Scanner;

// Classe Nodo (para Pilha e Fila)
// valor: guarda o dado. proximo: referência para o próximo nodo na estrutura (pilha ou fila). 
// Usando referências encadeadas (lista ligada).
class Nodo {
    int valor;
    Nodo proximo;

    Nodo(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

// Classe Pilha
// Pilha LIFO (Last In, First Out) – último que entra é o primeiro que sai.
// push: adiciona um valor no topo. pop: remove o valor do topo. isEmpty: verifica se a pilha está vazia.
class PilhaObjeto {
    private Nodo topo;

    public PilhaObjeto() {
        topo = null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(int valor) {
        Nodo novo = new Nodo(valor);
        novo.proximo = topo;
        topo = novo;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia!");
        }
        int valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }
}

// Classe Fila
// Fila FIFO (First In, First Out) – primeiro que entra é o primeiro que sai.
// enqueue: adiciona no fim da fila. dequeue: remove do início da fila. isEmpty: verifica se está vazia.
class FilaObjeto {
    private Nodo inicio;
    private Nodo fim;

    public FilaObjeto() {
        inicio = fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(int valor) {
        Nodo novo = new Nodo(valor);
        if (isEmpty()) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia!");
        }
        int valor = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        return valor;
    }
}

// Classe FilaCircular
// Fila circular tem tamanho limitado (capacidade). Ao chegar no final, volta ao início, mantendo a lógica de circularidade.
// enqueue: adiciona um valor, atualizando fim.proximo para manter circularidade.
// dequeue: remove o valor do início, ajustando fim.proximo para o novo início.
//isEmpty e isFull: ajudam a controlar a fila sem arrays.
class FilaCircular {
    private Nodo inicio;
    private Nodo fim;
    private int tamanho;
    private int capacidade;

    public FilaCircular(int capacidade) {
        this.capacidade = capacidade;
        this.inicio = this.fim = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public void enqueue(int valor) {
        if (isFull()) {
            throw new RuntimeException("Fila Circular cheia!");
        }
        Nodo novo = new Nodo(valor);
        if (isEmpty()) {
            inicio = fim = novo;
            fim.proximo = inicio; // circular
        } else {
            fim.proximo = novo;
            fim = novo;
            fim.proximo = inicio;
        }
        tamanho++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila Circular vazia!");
        }
        int valor = inicio.valor;
        if (tamanho == 1) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
            fim.proximo = inicio;
        }
        tamanho--;
        return valor;
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaCircular filaCircular = new FilaCircular(10);
        PilhaObjeto pilhaAux = new PilhaObjeto();
        FilaObjeto filaAux = new FilaObjeto();

        // Passo b: Inserir 7 valores digitados pelo usuário
        // Guardamos na fila auxiliar, porque não podemos inserir diretamente na fila circular com lógica de pilha/fila.
        System.out.println("Digite 7 valores inteiros para a fila circular:");
        for (int i = 0; i < 7; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            int valor = sc.nextInt();
            filaAux.enqueue(valor); // Armazenando na fila auxiliar
        }

        // Transferir para a fila circular
        // Retiramos os elementos da fila auxiliar e colocamos na fila circular. Mantemos a ordem original digitada pelo usuário.
        while (!filaAux.isEmpty()) {
            filaCircular.enqueue(filaAux.dequeue());
        }

        // Passo c: Inverter a fila circular usando pilha
        // Retiramos todos os elementos da fila circular e colocamos na pilha → ordem invertida. Depois retiramos da pilha e colocamos de volta na fila circular → agora a fila está invertida.
        while (!filaCircular.isEmpty()) {
            pilhaAux.push(filaCircular.dequeue());
        }
        while (!pilhaAux.isEmpty()) {
            filaCircular.enqueue(pilhaAux.pop());
        }

        // Passo d: Mostrar valores invertidos
        System.out.println("\nValores da Fila Circular invertida:");
        while (!filaCircular.isEmpty()) {
            System.out.print(filaCircular.dequeue() + " ");
        }
        System.out.println();
        sc.close();
    }
}
