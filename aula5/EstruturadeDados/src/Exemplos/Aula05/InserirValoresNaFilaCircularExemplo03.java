import java.util.Scanner;
import Bibliotecas.FilaCircularObjeto;

/**
 * Este programa permite ao usuário inserir valores em uma fila circular até que
 * um valor não positivo seja informado. O usuário deve especificar o tamanho
 * máximo da fila circular.
 */
public class InserirValoresNaFilaCircularExemplo03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Boas-vindas ao programa
        System.out.println("Bem-vindo ao programa de inserção em fila circular.");

        // Solicita ao usuário o tamanho máximo da fila circular e valida a entrada
        int tamanhoMaximo = lerTamanhoDaFila(scanner);

        // Cria uma instância de FilaCircularObjeto com o tamanho máximo especificado
        FilaCircularObjeto filaCircular = new FilaCircularObjeto(tamanhoMaximo);

        // Informa ao usuário que ele pode inserir valores na fila e define o critério de parada
        System.out.println("Informe os valores para inserir na fila circular (insira um valor não positivo para parar):");

        int valor = 0;

        // Mostra a quantidade atual de elementos e espaços vagos na fila
        System.out.println("Quantidade de elementos na fila: " + filaCircular.qtd());
        System.out.println("Espaços vagos na fila: " + filaCircular.vagos());
        System.out.print("Informe " + (filaCircular.qtd() + 1) + "º valor de no máximo " + filaCircular.capacidadeMaxima() + " : ");
        valor = scanner.nextInt();

        // Loop para inserção de valores na fila
        while (valor >= 0) {
            // Insere o valor na fila e verifica se a operação foi bem-sucedida
            Object resultado = filaCircular.inserir(valor);
            if (resultado != null) {
                System.out.println("Valor " + valor + " inserido com sucesso na fila circular (" + filaCircular.qtd() + "/" + filaCircular.capacidadeMaxima() + ").");
            } else {
                System.out.println("A fila está cheia. Não foi possível inserir o valor " + valor + ".");
            }

            // Solicita o próximo valor ao usuário
            System.out.print("Informe " + (filaCircular.qtd() + 1) + "º valor de no máximo " + filaCircular.capacidadeMaxima() + " : ");
            valor = scanner.nextInt();
        }

        // Exibe os valores na fila circular após a conclusão da inserção
        System.out.println("Valores na fila circular:");
        while (!filaCircular.vazia()) {
            Object elemento = filaCircular.retirar();
            System.out.println(elemento);
        }
    }

    // Método para ler e validar o tamanho da fila circular
    private static int lerTamanhoDaFila(Scanner scanner) {
        int tamanhoMaximo;
        do {
            System.out.print("Informe o tamanho máximo da fila circular (deve ser maior ou igual a 1): ");
            tamanhoMaximo = scanner.nextInt();
        } while (tamanhoMaximo < 1);
        return tamanhoMaximo;
    }
}
