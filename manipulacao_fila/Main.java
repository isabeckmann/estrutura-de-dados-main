//Isadora Beckmann

import java.util.Scanner;

// Classe PilhaObjeto
// implementação de uma pilha LIFO usada para inverter a ordem da fila.
class PilhaObjeto {
    private Node topo;

    private static class Node {
        Object dado;
        Node prox;
        Node(Object dado) {
            this.dado = dado;
            this.prox = null;
        }
    }

    public PilhaObjeto() {
        topo = null;
    }

    public void push(Object valor) {
        Node novo = new Node(valor);
        novo.prox = topo;
        topo = novo;
    }

    public Object pop() {
        if (isEmpty()) return null;
        Object valor = topo.dado;
        topo = topo.prox;
        return valor;
    }

    public boolean isEmpty() {
        return topo == null;
    }
}

// Classe FilaObjeto (fila simples)
// implementação de uma fila FIFO, é a fila principal onde os elementos do usuário são armazenados.
class FilaObjeto {
    private Node frente, tras;
    private int tamanho;
    private int capacidade;

    private static class Node {
        Object dado;
        Node prox;
        Node(Object dado) {
            this.dado = dado;
            this.prox = null;
        }
    }

    public FilaObjeto(int capacidade) {
        this.frente = this.tras = null;
        this.tamanho = 0;
        this.capacidade = capacidade;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public void enqueue(Object valor) {
        if (isFull()) {
            System.out.println("Fila cheia!");
            return;
        }
        Node novo = new Node(valor);
        if (tras != null) tras.prox = novo;
        tras = novo;
        if (frente == null) frente = novo;
        tamanho++;
    }

    public Object dequeue() {
        if (isEmpty()) return null;
        Object valor = frente.dado;
        frente = frente.prox;
        if (frente == null) tras = null;
        tamanho--;
        return valor;
    }

    public int size() {
        return tamanho;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a) Criar fila com capacidade 10
        FilaObjeto fila = new FilaObjeto(10);

        // b) Usuário insere 7 elementos
        System.out.println("Digite 7 valores inteiros para inserir na fila:");
        for (int i = 0; i < 7; i++) {
            int valor = sc.nextInt();
            fila.enqueue(valor);
        }

        System.out.println("\nFila original:");
        mostrarFilaCopia(fila);

        // c) Inverter a fila usando pilha
        PilhaObjeto pilha = new PilhaObjeto();

        // Passa todos da fila para a pilha
        while (!fila.isEmpty()) {
            pilha.push(fila.dequeue());
        }

        // Volta da pilha para a fila
        while (!pilha.isEmpty()) {
            fila.enqueue(pilha.pop());
        }

        // d) Mostrar fila invertida
        System.out.println("\nFila invertida:");
        mostrarFila(fila);

        sc.close();
    }

    // Função para exibir a fila sem esvaziar (faz uma cópia temporária)
    public static void mostrarFilaCopia(FilaObjeto fila) {
        FilaObjeto temp = new FilaObjeto(10);
        while (!fila.isEmpty()) {
            Object valor = fila.dequeue();
            System.out.print(valor + " ");
            temp.enqueue(valor);
        }
        System.out.println();

        // devolve os elementos para a fila original
        while (!temp.isEmpty()) {
            fila.enqueue(temp.dequeue());
        }
    }

    // Função para exibir e esvaziar a fila (para etapa final)
    public static void mostrarFila(FilaObjeto fila) {
        while (!fila.isEmpty()) {
            System.out.print(fila.dequeue() + " ");
        }
        System.out.println();
    }
}