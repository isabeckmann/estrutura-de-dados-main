package Exemplos.Aula04;

import Bibliotecas.FilaObjeto;

public class FilaExemplo02 {
    public static void main(String[] args) {
        FilaObjeto filaOriginal = new FilaObjeto(5);
        FilaObjeto filaAux = new FilaObjeto(5);
        FilaObjeto filaDestino = new FilaObjeto(5);

        int cont=1;
        while (!filaOriginal.cheia()){
            System.out.println("Inserido: "+cont);
            filaOriginal.inserir(cont);
            cont++;
        }
       
        while (!filaOriginal.vazia()) {
            Object elemento = filaOriginal.retirar();
            filaAux.inserir(elemento);
            System.out.println("Retirando: " + elemento);
        }
        filaOriginal.reiniciar();
        while (!filaAux.vazia()){
            Object elemento = filaAux.retirar();
            System.out.println("Inserido nas 2 filas: "+elemento);
            filaDestino.inserir(elemento);
            filaOriginal.inserir(elemento);
        }
   
        System.out.println("Destino vazia: "+filaDestino.vazia());
        while (!filaDestino.vazia()){
            Object elemento = filaDestino.retirar();
            System.out.println(" "+elemento);
        }
        System.out.println("Original vazia? "+filaOriginal.vazia());
        while (!filaOriginal.vazia()){
            Object elemento = filaOriginal.retirar();
            System.out.println(" "+elemento);
        }
       
       
       
     }
}