import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        ArvoreBinaria<Integer> arvBin = new ArvoreBinaria<>();
        int opt;

        String opts = "1. Inserir valor na fila (enqueue)\n" +
                "2. Remover valor da fila (dequeue)\n" +
                "3. Retornar primeiro valor da fila (front)\n" +
                "4. Retornar último valor da fila (rear)\n" +
                "5. Verificar se a fila está vazia (isEmpty)\n" +
                "6. Verificar tamanho da fila (size)\n" +
                "7. Limpar fila (clear)\n" +
                "8. Imprimir fila\n" +
                "\n0. Finalizar Programa\n";

        // Formatação para Título no Terminal
        String title = "ÁRVORE - JAVA";
        int len = (50 - title.length()) / 2;

        System.out.println(String.valueOf("-").repeat(Math.max(0, 50)));
        System.out.println(String.format("%" + len + "s%s%" + len + "s", "", title, ""));
        System.out.println(String.valueOf("-").repeat(Math.max(0, 50)));
    }
}
