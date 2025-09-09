package Bibliotecas;

public class PesquisaVetor {

    public static int realizarBuscaSequencial(int valor, int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public static int realizarBuscaBinariaNaoRecursiva(int valor, int[] vetor) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == valor) {
                return meio;
            } else if (vetor[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static int realizarBuscaBinariaRecursiva(int valor, int[] vetor) {
        return realizarBuscaBinariaRecursiva(valor, vetor, 0, vetor.length - 1);
    }

    private static int realizarBuscaBinariaRecursiva(int valor, int[] vetor, int inicio, int fim) {
        if (inicio > fim) {
            return -1;
        }

        int meio = (inicio + fim) / 2;
        if (vetor[meio] == valor) {
            return meio;
        } else if (vetor[meio] < valor) {
            return realizarBuscaBinariaRecursiva(valor, vetor, meio + 1, fim);
        } else {
            return realizarBuscaBinariaRecursiva(valor, vetor, inicio, meio - 1);
        }
    }

}
