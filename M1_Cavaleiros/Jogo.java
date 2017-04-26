public class Jogo {
    private static void imprimirArgumentos (String [] args) {
        try {
            System.out.println(args[0]);
        } catch (Exception e) {
            System.out.println("O índice não existe");
            e.printStackTrace();
        }
    }
    public static void main (String [] args) {
        imprimirArgumentos (args);
    }
}