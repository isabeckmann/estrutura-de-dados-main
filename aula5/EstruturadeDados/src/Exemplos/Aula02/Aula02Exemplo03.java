package Exemplos.Aula02;

import Bibliotecas.Ordenacao;
import java.util.Scanner;

public class Aula02Exemplo03 {
    private static int tamanhoVetor = 10;
    private static int menorValor = 1;
    private static int maiorValor = 100;
    private static int[] vetorAleatorio;

    public static void inicializarVetor() {
        vetorAleatorio = new int[tamanhoVetor];
    }

    public static void inicializarVetor(int tamanho) {
        tamanhoVetor = tamanho;
        inicializarVetor();
    }

    public static void gerarVetorAleatorio() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o menor valor possível para os elementos do vetor: ");
        menorValor = scanner.nextInt();

        System.out.print("Informe o maior valor possível para os elementos do vetor: ");
        maiorValor = scanner.nextInt();

        gerarArrayAleatorio(tamanhoVetor, menorValor, maiorValor);
    }

    public static void gerarArrayAleatorio(int tamanho, int menorValor, int maiorValor) {
        inicializarVetor(tamanho);
        java.util.Random random = new java.util.Random();

        int i = 0;
        while (i < tamanho) {
            vetorAleatorio[i] = random.nextInt(maiorValor - menorValor + 1) + menorValor;
            i++;
        }
    }

    public static void solicitarValoresVetor(Scanner scanner) {
        inicializarVetor(tamanhoVetor);

        int i = 0;
        while (i < tamanhoVetor) {
            System.out.print("Informe o valor para a posição " + i + ": ");
            vetorAleatorio[i] = scanner.nextInt();
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
    
    
    public static void ordenaDemonstracao() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Deseja gerar um vetor aleatório? (S/N): ");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("S")) {
                System.out.print("Informe o tamanho do vetor: ");
                tamanhoVetor = scanner.nextInt();
                inicializarVetor(tamanhoVetor);
                gerarVetorAleatorio();
            } else {
                System.out.print("Informe o tamanho do vetor: ");
                tamanhoVetor = scanner.nextInt();
                inicializarVetor(tamanhoVetor);
                solicitarValoresVetor(scanner);
            }

            System.out.println("Vetor Original: ");
            mostrarVetor(vetorAleatorio);

            int[] vetorBubble = vetorAleatorio.clone();
            Ordenacao.bubbleSort(vetorBubble);
            System.out.print("Depois do uso do Bubble Sort: ");
            mostrarVetor(vetorBubble);

            int[] vetorSelection = vetorAleatorio.clone();
            Ordenacao.selectionSort(vetorSelection);
            System.out.print("Depois do uso do Selection Sort: ");
            mostrarVetor(vetorSelection);

            int[] vetorShell = vetorAleatorio.clone();
            Ordenacao.shellSort(vetorShell);
            System.out.print("Depois do uso do Shell Sort: ");
            mostrarVetor(vetorShell);

            int[] vetorInsertion = vetorAleatorio.clone();
            Ordenacao.insertionSort(vetorInsertion);
            System.out.print("Depois do uso do Insertion Sort: ");
            mostrarVetor(vetorInsertion);

            int[] vetorQuick = vetorAleatorio.clone();
            Ordenacao.quickSort(vetorQuick, 0, vetorQuick.length - 1);
            System.out.print("Depois do uso do Quick Sort: ");
            mostrarVetor(vetorQuick);

            int[] vetorHeap = vetorAleatorio.clone();
            Ordenacao.heapSort(vetorHeap);
            System.out.print("Depois do uso do Heap Sort: ");
            mostrarVetor(vetorHeap);

            int[] vetorMerge = vetorAleatorio.clone();
            Ordenacao.mergeSort(vetorMerge, 0, vetorMerge.length - 1);
            System.out.print("Depois do uso do Merge Sort: ");
            mostrarVetor(vetorMerge);
            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        ordenaDemonstracao();
    }
    
    
}
