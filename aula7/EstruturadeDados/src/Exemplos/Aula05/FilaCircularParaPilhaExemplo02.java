import java.util.Scanner;
import Bibliotecas.PilhaObjeto;
import Bibliotecas.FilaCircularObjeto;

/**
 * Este programa exemplifica a cópia do conteúdo de uma fila circular para uma
 * pilha e a posterior exibição do conteúdo da pilha, invertendo a ordem dos
 * elementos.
 * 
 * O usuário informará o tamanho da fila circular e os elementos que serão
 * inseridos nela. Em seguida, os elementos serão copiados da fila circular para
 * uma pilha e o conteúdo da pilha será exibido, resultando na inversão da ordem
 * original dos elementos.
 */
public class FilaCircularParaPilhaExemplo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário o tamanho da fila circular
        System.out.print("Informe o tamanho da fila circular: ");
        int tamanhoFilaCircular = scanner.nextInt();

        // Cria uma fila circular com o tamanho especificado
        FilaCircularObjeto filaCircular = new FilaCircularObjeto(tamanhoFilaCircular);

        // Solicita ao usuário os elementos da fila circular
        for (int i = 0; i < tamanhoFilaCircular; i++) {
            System.out.print("Informe o elemento para a posição " + i + ": ");
            Object elemento = scanner.next();
            filaCircular.inserir(elemento);
        }

        // Cria uma pilha para copiar os elementos da fila circular
        PilhaObjeto pilha = new PilhaObjeto(tamanhoFilaCircular);

        // Copia os elementos da fila circular para a pilha
        while (!filaCircular.vazia()) {
            Object elemento = filaCircular.retirar();
            pilha.empilha(elemento);
        }

        // Mostra o conteúdo da pilha (invertido)
        System.out.println("Conteúdo da pilha (invertido):");
        while (!pilha.vazia()) {
            Object elemento = pilha.desempilha();
            System.out.println(elemento);
        }
    }
}
