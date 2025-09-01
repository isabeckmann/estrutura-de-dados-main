package Exemplos.Aula04;

import Bibliotecas.FilaObjeto;

public class FilaExemplo01 {
    public static void main(String[] args) {
        FilaObjeto fila = new FilaObjeto(5);

        System.out.println("Fila vazia? " + fila.vazia());

        fila.inserir("Primeiro elemento");
        fila.inserir("Segundo elemento");
        fila.inserir("Terceiro elemento");

        System.out.println("Fila vazia? " + fila.vazia());
        System.out.println("Quantidade de elementos na fila: " + fila.qtd());

        Object retirado = fila.retirar();
        System.out.println("Elemento retirado: " + retirado);

        System.out.println("Quantidade de elementos na fila após retirar: " + fila.qtd());

        System.out.println("Fila cheia? " + fila.cheia());
        System.out.println("Espaços vagos na fila: " + fila.vagos());

        while (!fila.vazia()) {
            Object frente = fila.retirar();
            System.out.println("Retirando: " + frente);
        }

        System.out.println("Fila vazia? " + fila.vazia());
    }
}
