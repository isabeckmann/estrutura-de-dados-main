package Exemplos.Aula04;

import java.util.Scanner;
import Bibliotecas.PilhaObjeto;
import Bibliotecas.FilaObjeto;

/**
 * Este programa exemplifica a cópia do conteúdo de uma fila para uma pilha e
 * a posterior exibição do conteúdo da pilha, invertendo a ordem dos elementos.
 * 
 * O usuário informará o tamanho da fila e os elementos que serão inseridos nela.
 * Em seguida, os elementos serão copiados da fila para uma pilha e o conteúdo
 * da pilha será exibido, resultando na inversão da ordem original dos elementos.
 */
public class FilaParaPilhaExemplo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o tamanho da fila: ");
        int tamanhoFila = scanner.nextInt();

        FilaObjeto fila = new FilaObjeto(tamanhoFila);

        // Solicita ao usuário os elementos da fila
        for (int i = 0; i < tamanhoFila; i++) {
            System.out.print("Informe o elemento para a posição " + i + ": ");
            Object elemento = scanner.next();
            fila.inserir(elemento);
        }

        // Cria uma pilha para copiar os elementos da fila
        PilhaObjeto pilha = new PilhaObjeto(tamanhoFila);

        // Copia os elementos da fila para a pilha
        while (!fila.vazia()) {
            Object elemento = fila.retirar();
            pilha.empilha(elemento);
        }

        // Mostra o conteúdo da pilha
        System.out.println("Conteúdo da pilha (invertido):");
        while (!pilha.vazia()) {
            Object elemento = pilha.desempilha();
            System.out.println(elemento);
        }
    }
}
