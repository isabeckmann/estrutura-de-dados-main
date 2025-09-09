package Exemplos.Aula05;

import Bibliotecas.FilaCircularObjeto;

public class FilaCircularExemplo01 {
    public static void main(String[] args) {
        FilaCircularObjeto fila = new FilaCircularObjeto(5);

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
            Object elementoDaFrente = fila.retirar();
            System.out.println("Retirando da frente: " +elementoDaFrente+  "Restou: " + fila.qtd());
            if  ( fila.qtd()<1)
                return;
        }

        System.out.println("Fila vazia? " + fila.vazia());
    }
}
