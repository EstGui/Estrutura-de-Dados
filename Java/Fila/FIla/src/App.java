import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Fila<String> fila = new Fila<>();
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
        String title = "FILA DINÂMICA - JAVA";
        int len = (50 - title.length()) / 2;

        System.out.println(String.valueOf("-").repeat(Math.max(0, 50)));
        System.out.println(String.format("%" + len + "s%s%" + len + "s", "", title, ""));
        System.out.println(String.valueOf("-").repeat(Math.max(0, 50)));
        
        do {
            System.out.println(opts);

            System.out.print("Digite a opção que deseja: ");
            opt = in.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("1. Inserir valor na fila (enqueue)\n");

                    System.out.print("Digite o valor que deseja adicionar na fila: ");
                    String conteudo = in.next();

                    fila.enqueue(conteudo);
                    break;

                case 2:
                System.out.println("2. Remover valor da fila (dequeue)\n");
                    fila.dequeue();
                    break;

                case 3:
                    System.out.println("3. Retornar primeiro valor da fila (front)\n");

                    System.out.println("O primeiro valor da fila é: " + fila.front());
                    break;

                case 4:
                    System.out.println("4. Retornar último valor da fila (rear)\n");

                    System.out.println("O primeiro último valor da fila é: " + fila.rear());
                    break;

                case 5:
                    System.out.println("5. Verificar se a fila está vazia (isEmpty)\n");

                    System.out.println("A fila está vazia? " + fila.isEmpty());
                    break;

                case 6:
                    System.out.println("6. Verificar tamanho da fila (size)\n");

                    System.out.println("O tamanho da fila é: " + fila.size());
                    break;

                case 7:
                    System.out.println("7. Limpar fila (clear)\n");

                    fila.clear();
                    break;

                case 8:
                    System.out.println("8. Imprimir fila\n");

                    System.out.println(fila.show());
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida. Digite novamente...\n");
            }
        } while (opt != 0);

        System.out.println("Programa finalizado.");

        in.close();
    }
}
