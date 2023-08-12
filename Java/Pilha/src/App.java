import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int opt;

        Pilha<String> pilha = new Pilha<>();

        String opts = "1. Inserir Valor na pilha (push())\n" +
                    "2. Remover Último Valor da pilha (pop())\n" +
                    "3. Retornar Último Valor da pilha (top())\n" +
                    "4. Verificar se a pilha está vazia (isEmpty())\n" +
                    "5. Verificar tamanho da pilha (size())\n" +
                    "6. Limpar pilha (clear())\n" +
                    "7. Imprimir pilha\n" +
                    "\n0. Finalizar Programa\n";


        // Formatação para Título no Terminal
        String title = "PILHA DINÂMICA - JAVA";
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
                    System.out.println("1. Inserir Valor na Pilha (push())\n");

                    System.out.print("Informe o valor que deseja adicionar na pilha: ");
                    String valor = in.next();

                    pilha.push(valor);
                    break;

                case 2:
                    System.out.println("2. Remover Topo da Pilha (pop())\n");
                    System.out.println("O valor " + pilha.pop() + " foi removido da pilha.\n");
                    break;

                case 3:
                    System.out.println("3. Retornar o Topo da Pilha (top())\n");
                    System.out.println(pilha.top() + "\n");
                    break;

                case 4:
                    System.out.println("4. Verificar se a pilha está vazia (isEmpty())\n");
                    System.out.println(pilha.isEmpty() + "\n");
                    break;

                case 5:
                    System.out.println("5. Verificar tamanho da pilha (size())\n");
                    System.out.println("O tamanho da pilha é: " + pilha.size() + "\n");
                    break;

                case 6:
                    System.out.println("6. Limpar pilha (clear())\n");
                    pilha.clear();
                    break;

                case 7:
                    System.out.println( "7. Imprimir pilha\n");
                    System.out.println(pilha + "\n");
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida. Digite novamente...\n");
            }

        } while (opt != 0);
        in.close();
    }
}
