package Exemplos.Aula04;

import Bibliotecas.PilhaObjeto;

public class PilhaExemplo01 {
     public static void main(String[] args) {
        PilhaObjeto pilha = new PilhaObjeto(5);

        System.out.println("Pilha vazia? " + pilha.vazia());

        pilha.empilha("Primeiro elemento");
        pilha.empilha("Segundo elemento");
        pilha.empilha("Terceiro elemento");

        System.out.println("Pilha vazia? " + pilha.vazia());
        System.out.println("Quantidade de elementos na pilha: " + pilha.qtd());
        System.out.println("Elemento no topo da pilha: " + pilha.doTopo());

        Object desempilhado = pilha.desempilha();
        System.out.println("Elemento desempilhado: " + desempilhado);

        System.out.println("Quantidade de elementos na pilha após desempilhar: " + pilha.qtd());

        System.out.println("Pilha cheia? " + pilha.cheia());
        System.out.println("Espaços vagos na pilha: " + pilha.vagos());

        while (!pilha.vazia()) {
            Object topo = pilha.desempilha();
            System.out.println("Desempilhando: " + topo);
        }

        System.out.println("Pilha vazia? " + pilha.vazia());
    }
   
}
