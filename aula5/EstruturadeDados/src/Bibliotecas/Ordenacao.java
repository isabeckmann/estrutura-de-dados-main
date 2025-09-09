package Bibliotecas;

public class Ordenacao {

    // Bubble Sort (ordenação tipo bolha)
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
    // Insertion Sort (ordenação por inserção)
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
    
    
    // Select Sort (ordenação por seleção)
    public static void selectionSort(int[] vetor) {
        int n = vetor.length;
        int i = 0;
        while (i < n - 1) {
            int indiceMinimo = i;
            int j = i + 1;
            while (j < n) {
                if (vetor[j] < vetor[indiceMinimo]) {
                    indiceMinimo = j;
                }
                j++;
            }
            int temp = vetor[indiceMinimo];
            vetor[indiceMinimo] = vetor[i];
            vetor[i] = temp;
            i++;
        }
    }

    // Shell Sort (ordenação por divisão e inserção)
    public static void shellSort(int[] vetor) {
        int n = vetor.length;
        int intervalo = n / 2;
        while (intervalo > 0) {
            int i = intervalo;
            while (i < n) {
                int temp = vetor[i];
                int j = i;
                while (j >= intervalo && vetor[j - intervalo] > temp) {
                    vetor[j] = vetor[j - intervalo];
                    j -= intervalo;
                }
                vetor[j] = temp;
                i++;
            }
            intervalo /= 2;
        }
    }

    // Quick Sort (ordenação por divisão e conquista)
    public static void quickSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int pivo = particionar(vetor, esquerda, direita);
            quickSort(vetor, esquerda, pivo - 1);
            quickSort(vetor, pivo + 1, direita);
        }
    }

    private static int particionar(int[] vetor, int esquerda, int direita) {
        int pivo = vetor[direita];
        int i = (esquerda - 1);

        int j = esquerda;
        while (j < direita) {
            if (vetor[j] < pivo) {
                i++;

                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
            j++;
        }

        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[direita];
        vetor[direita] = temp;

        return i + 1;
    }

    // Heapsort (ordenação por seleção)
    public static void heapSort(int[] vetor) {
        int n = vetor.length;

        int i = n / 2 - 1;
        while (i >= 0) {
            ajustarHeap(vetor, n, i);
            i--;
        }

        i = n - 1;
        while (i > 0) {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            ajustarHeap(vetor, i, 0);
            i--;
        }
    }

    private static void ajustarHeap(int[] vetor, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && vetor[esquerda] > vetor[maior]) {
            maior = esquerda;
        }

        if (direita < n && vetor[direita] > vetor[maior]) {
            maior = direita;
        }

        if (maior != i) {
            int troca = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = troca;

            ajustarHeap(vetor, n, maior);
        }
    }

    // Merge Sort (ordenação por comparação)
    public static void mergeSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            mergeSort(vetor, esquerda, meio);
            mergeSort(vetor, meio + 1, direita);

            merge(vetor, esquerda, meio, direita);
        }
    }

    private static void merge(int[] vetor, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] arrEsquerda = new int[n1];
        int[] arrDireita = new int[n2];

        int i = 0;
        while (i < n1) {
            arrEsquerda[i] = vetor[esquerda + i];
            i++;
        }

        int j = 0;
        while (j < n2) {
            arrDireita[j] = vetor[meio + 1 + j];
            j++;
        }

        i = 0;
        j = 0;
        int k = esquerda;
        while (i < n1 && j < n2) {
            if (arrEsquerda[i] <= arrDireita[j]) {
                vetor[k] = arrEsquerda[i];
                i++;
            } else {
                vetor[k] = arrDireita[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            vetor[k] = arrEsquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            vetor[k] = arrDireita[j];
            j++;
            k++;
        }
    }
}
