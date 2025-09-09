package Bibliotecas;

public class Comodidades {
    public static void delay(int milliseconds) {
    try {
        Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
    }
}

}
