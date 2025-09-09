package listaduplamenteencadeadasimples;

public class TesteLista {
    public static void main(String[] args) {
        ListaDuplamenteEncadeadaSimples lista = new ListaDuplamenteEncadeadaSimples();

        lista.inserirNoInicio(10);
        lista.inserirNoInicio(20);
        lista.inserirNoFim(5);
        lista.inserirNoFim(0);

        lista.mostrar();        // [ 20 10 5 0 ]
        lista.mostrarReverso(); // [ 0 5 10 20 ]

        System.out.println("Remover do início: " + lista.removerDoInicio()); // 20
        System.out.println("Remover do fim: " + lista.removerDoFim());       // 0
        System.out.println("Remover chave 10: " + lista.removerChave(10));   // 10
        System.out.println("Remover chave 99: " + lista.removerChave(99));   // null

        lista.mostrar();        // [ 5 ]
    }
}
