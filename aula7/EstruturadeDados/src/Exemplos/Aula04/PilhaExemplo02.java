package Exemplos.Aula04;

import Bibliotecas.PilhaObjeto;

public class PilhaExemplo02 {
     public static void main(String[] args) {
        PilhaObjeto pilhaOriginal = new PilhaObjeto(5);
        PilhaObjeto pilhaAux = new PilhaObjeto(5);
        PilhaObjeto pilhaDestino = new PilhaObjeto(5);
       
        //Inserindo na Original
        int cont=1;
        while (!pilhaOriginal.cheia()){
            System.out.println("Empilhando "+ cont);
            pilhaOriginal.empilha(cont);
            cont++;
        }
        // Copinado para AUX
        while (!pilhaOriginal.vazia()) {
            Object elemento = pilhaOriginal.desempilha();
            System.out.println("Desempilhando: " + elemento);
            pilhaAux.empilha(elemento);
        }
       
        //Retiando da AUX e Inserindo nas outras 2
        System.out.println("---------Aux-------");
        while (!pilhaAux.vazia()) {
            Object elemento = pilhaAux.desempilha();
            pilhaOriginal.empilha(elemento);
            pilhaDestino.empilha(elemento);
            System.out.println("Desempilhando: " + elemento);
        }
    }
}