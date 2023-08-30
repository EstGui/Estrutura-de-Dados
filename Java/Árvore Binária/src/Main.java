import java.util.Scanner;

import model.Obj;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        ArvoreBinaria<Obj> arvBin = new ArvoreBinaria<>();
        int opt;

        arvBin.insert(new Obj(13));
        arvBin.insert(new Obj(10));
        arvBin.insert(new Obj(25));
        arvBin.insert(new Obj(2));
        arvBin.insert(new Obj(12));
        arvBin.insert(new Obj(20));
        arvBin.insert(new Obj(31));
        arvBin.insert(new Obj(29));

        arvBin.inOrder();
        arvBin.preOrder();
        arvBin.posOrder();

        /* String opts = "1. Inserir valor na fila (enqueue)\n" +
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
        System.out.println(String.valueOf("-").repeat(Math.max(0, 50))); */
    }
}
