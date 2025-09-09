package Exemplos.Aula02;

import java.util.Scanner;

public class Aula02Exemplo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Deseja mostrar o passo a passo? (S/N): ");
        String resposta = scanner.next();

        int[] vetorOrdenado = {10, 20, 30, 40, 50};
        int[] vetorInverso = {50, 40, 30, 20, 10};
        int[] vetorAleatorio = {50, 20, 10, 30, 40};

        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("\nOrdenação Insertion Sort - Vetor Ordenado:");
            mostrarPassoAPasso(vetorOrdenado);
            System.out.println("\nOrdenação Insertion Sort - Vetor Inverso:");
            mostrarPassoAPasso(vetorInverso);
            System.out.println("\nOrdenação Insertion Sort - Vetor Aleatório:");
            mostrarPassoAPasso(vetorAleatorio);
        } else {
            System.out.println("\nOrdenação Insertion Sort - Vetor Ordenado:");
            insertionSort(vetorOrdenado);
            mostrarVetor(vetorOrdenado);
            System.out.println("\nOrdenação Insertion Sort - Vetor Inverso:");
            insertionSort(vetorInverso);
            mostrarVetor(vetorInverso);
            System.out.println("\nOrdenação Insertion Sort - Vetor Aleatório:");
            insertionSort(vetorAleatorio);
            mostrarVetor(vetorAleatorio);
        }
        scanner.close();
    }

    public static void insertionSort(int[] vetor) {
        int n = vetor.length;
        int i = 1;
        while (i < n) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
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
        int i = 1;
        while (i < n) {
            System.out.println("----------- Iteração: " + i + "º  --------------------");
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
            mostrarVetor(vetor);
            i++;
        }
        System.out.println("\nVetor Ordenado:");
        mostrarVetor(vetor);
    }
}
