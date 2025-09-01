package Exemplos.Aula03;

import static Bibliotecas.Comodidades.delay;
import Bibliotecas.Ordenacao;
import Bibliotecas.PesquisaVetor;

import java.util.Scanner;

public class Aula03Exemplo01 {

    private static int tamanhoVetor = 5;
    private static int[] vetorOriginal;

    public static void inicializarVetor() {
        vetorOriginal = new int[tamanhoVetor];
    }

    public static void inicializarVetor(int tamanho) {
        tamanhoVetor = tamanho;
        vetorOriginal = new int[tamanhoVetor];
    }

    public static void solicitarValoresVetor(Scanner scanner) {
        inicializarVetor(tamanhoVetor);

        int i = 0;
        while (i < tamanhoVetor) {
            System.out.print("Informe o valor para a posição " + i + ": ");
            vetorOriginal[i] = scanner.nextInt();
            i++;
        }
    }

    public static void mostrarVetor(int[] vetor) {
        System.out.print("[");
        int i = 0;
        while (i < vetor.length) {
            System.out.print(vetor[i]);
            if (i < vetor.length - 1) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println("]");
    }

    public static int menuPesquisaOrdenado(int valorPesquisa, int[] vetorOrdenado) {
        int posicao = -1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o método de busca:");
        System.out.println("1. Busca Sequencial");
        System.out.println("2. Busca Binária Não Recursiva");
        System.out.println("3. Busca Binária Recursiva");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                posicao = PesquisaVetor.realizarBuscaSequencial(valorPesquisa, vetorOrdenado);
                exibirResultadoBusca(posicao);
                break;
            case 2:
                posicao = PesquisaVetor.realizarBuscaBinariaNaoRecursiva(valorPesquisa, vetorOrdenado);
                exibirResultadoBusca(posicao);
                break;
            case 3:
                posicao = PesquisaVetor.realizarBuscaBinariaRecursiva(valorPesquisa, vetorOrdenado);
                exibirResultadoBusca(posicao);
                break;
            default:
                System.out.println("Opção inválida. Escolha novamente:");
                delay(2000);
        }
        return posicao;
    }

    public static void menuOrdenacao(Scanner scanner, int[] vetorOrdenado) {
        int escolhaOrdenacao = -1;
        while (escolhaOrdenacao < 1 || escolhaOrdenacao > 7) {
            System.out.println("Escolha o método de ordenação:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Selection Sort");
            System.out.println("4. Shell Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Heap Sort");
            System.out.println("7. Merge Sort");
            escolhaOrdenacao = scanner.nextInt();

            switch (escolhaOrdenacao) {
                case 1:
                    Ordenacao.bubbleSort(vetorOrdenado);
                    break;
                case 2:
                    Ordenacao.insertionSort(vetorOrdenado);
                    break;
                case 3:
                    Ordenacao.selectionSort(vetorOrdenado);
                    break;
                case 4:
                    Ordenacao.shellSort(vetorOrdenado);
                    break;
                case 5:
                    Ordenacao.quickSort(vetorOrdenado, 0, vetorOrdenado.length - 1);
                    break;
                case 6:
                    Ordenacao.heapSort(vetorOrdenado);
                    break;
                case 7:
                    Ordenacao.mergeSort(vetorOrdenado, 0, vetorOrdenado.length - 1);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente:");
                    delay(2000);
                    break;
            }
        }
    }

    public static void exibirResultadoBusca(int posicao) {
        if (posicao != -1) {
            System.out.println("Valor encontrado na posição: " + posicao);
        } else {
            System.out.println("Valor não encontrado no vetor.");
        }
    }

    public static int realizarPesquisaSequencial(int valor, int[] vetor) {
        int posicaoSequencial = PesquisaVetor.realizarBuscaSequencial(valor, vetor);
        exibirResultadoBusca(posicaoSequencial);
        return posicaoSequencial;
    }

    public static int realizarMenuPesquisa(int[] vetorOriginal, int[] vetorOrdenado, Scanner scanner) {
        int escolhaPesquisa = -1;
        while (escolhaPesquisa < 1 || escolhaPesquisa > 2) {
            System.out.println("Escolha a opção de pesquisa:");
            System.out.println("1. Pesquisa no vetor original");
            System.out.println("2. Pesquisa no vetor ordenado");
            escolhaPesquisa = scanner.nextInt();

            if (escolhaPesquisa == 2) {
                menuOrdenacao(scanner, vetorOrdenado);
            } else if (escolhaPesquisa != 1) {
                System.out.println("Opção inválida. Escolha novamente:");
                delay(2000);
            }
        }

        System.out.print("Informe um valor para pesquisa: ");
        int valorPesquisa = scanner.nextInt();

        switch (escolhaPesquisa) {
            case 1:
                realizarPesquisaSequencial(valorPesquisa, vetorOriginal);
                break;
            case 2:
                menuPesquisaOrdenado(valorPesquisa, vetorOrdenado);
                break;
        }

        return valorPesquisa;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o tamanho do vetor: ");
        tamanhoVetor = scanner.nextInt();

        inicializarVetor();
        solicitarValoresVetor(scanner);
        
        System.out.println("Vetor Informado: ");
        mostrarVetor(vetorOriginal);

        int[] vetorOrdenado = vetorOriginal.clone();

        int valorPesquisa = realizarMenuPesquisa(vetorOriginal, vetorOrdenado, scanner);

        scanner.close();
    }
}
