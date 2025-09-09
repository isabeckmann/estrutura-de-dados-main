import java.util.Scanner;
import Bibliotecas.Lista_AutoReferencia;

/**
 * Esta classe exemplifica o funcionamento de uma lista duplamente encadeada.
 * Uma lista duplamente encadeada é uma estrutura de dados linear onde cada elemento,
 * chamado de nó, contém um valor e referências tanto para o próximo quanto para
 * o nó anterior na lista. A lista é iniciada com dois nós especiais chamados de
 * "cabeça" e "cauda", que não contêm valores válidos e são usados apenas para
 * indicar o início e o fim da lista.
 *
 * Funcionamento da Lista Duplamente Encadeada:
 * +--------+    +------+     +------+     +------+     +------+
 * | Cabeça | <- |  X1  | <-> |  X2  | <-> |  X3  | <-> |  Xn  |
 * +--------+    +------+     +------+     +------+     +------+
 *   Início                                                Fim
 *
 * A classe permite inserir, retirar, inverter e criar cópias da lista, bem como
 * exibir seu conteúdo.
 */
public class ListaDuplamenteEncadeadaExemplo01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista_AutoReferencia lista = new Lista_AutoReferencia();

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir valor");
            System.out.println("2 - Retirar valor");
            System.out.println("3 - Inverter a lista");
            System.out.println("4 - Criar uma cópia da lista");
            System.out.println("5 - Mostrar lista");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor a ser inserido: ");
                    int valor = scanner.nextInt();
                    if (lista.inserir(valor) != null) {
                        System.out.println("Valor inserido com sucesso.");
                    } else {
                        System.out.println("Não foi possível inserir o valor.");
                    }
                    break;
                case 2:
                    System.out.print("Informe o valor a ser retirado: ");
                    int chave = scanner.nextInt();
                    Object itemRetirado = lista.retirar(chave);
                    if (itemRetirado != null) {
                        System.out.println("Valor " + itemRetirado + " retirado com sucesso.");
                    } else {
                        System.out.println("Valor não encontrado na lista.");
                    }
                    break;
                case 3:
                    lista.inverter();
                    System.out.println("Lista invertida.");
                    break;
                case 4:
                    Lista_AutoReferencia copiaLista = lista.copiar();
                    System.out.println("Cópia da lista criada.");
                    System.out.println("Conteúdo da cópia:");
                    copiaLista.mostrar();
                    break;
                case 5:
                    System.out.println("Conteúdo da lista:");
                    lista.mostrar();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}
