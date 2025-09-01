package Exemplos.Aula02;

import java.util.Scanner;

public class Aula02Exemplo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Deseja mostrar o passo a passo? (S/N): ");
        String resposta = scanner.next();

        int[] vetorOrdenado = {10, 20, 30, 40, 50};
        int[] vetorInverso = {50, 40, 30, 20, 10};
        int[] vetorAleatorio = {50, 20, 10, 30, 40};

        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("\nOrdenação Bubble Sort - Vetor Ordenado:");
            mostrarPassoAPasso(vetorOrdenado);
            mostrarVetor(vetorOrdenado);
            System.out.println("\nOrdenação Bubble Sort - Vetor Inverso:");
            mostrarPassoAPasso(vetorInverso);
            mostrarVetor(vetorInverso);
            System.out.println("\nOrdenação Bubble Sort - Vetor Aleatório:");
            mostrarPassoAPasso(vetorAleatorio);
            mostrarVetor(vetorAleatorio);
        } else {
            System.out.println("\nOrdenação Bubble Sort - Vetor Ordenado:");
            bubbleSort(vetorOrdenado);
            mostrarVetor(vetorOrdenado);
            System.out.println("\nOrdenação Bubble Sort - Vetor Inverso:");
            bubbleSort(vetorInverso);
            mostrarVetor(vetorInverso);
            System.out.println("\nOrdenação Bubble Sort - Vetor Aleatório:");
            bubbleSort(vetorAleatorio);
            mostrarVetor(vetorAleatorio);
        }

        scanner.close();
    }

    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        int i = 0;
        while (i < n - 1) {
            int j = 0;
            while (j < n - i - 1) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
                j++;
            }
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

    public static void mostrarPassoAPasso(int[] vetor) {
        System.out.println("Vetor Original: ");
        mostrarVetor(vetor);

        System.out.println("Passo\t\tVetor");

        int n = vetor.length;
        int i = 0;
        while (i < n - 1) {
            System.out.println("----------- Iteração: " + (i + 1) + "º  --------------------");
            int j = 0;
            while (j < n - i - 1) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;

                    System.out.print((i * n + j + 1) + "  Trocou: " + vetor[j + 1] + " por " + vetor[j] + "\t\t");
                    mostrarVetor(vetor);
                }
                j++;
            }
            i++;
        }
        System.out.println("\nVetor Ordenado:");
        mostrarVetor(vetor);
    }
}
