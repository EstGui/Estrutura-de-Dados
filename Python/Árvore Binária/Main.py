import ArvoreBinaria as arvore_arq
from os import system

system('cls')

opts = """1. Inserir Valor na árvore
2. Remover Valor da árvore 
3. Exibição InOrder
4. Exibição PreOrder
5. Exibição PosOrder
\n0. Finalizar Programa\n"""

ArvoreBinaria = arvore_arq.ArvoreBinaria()

while True:
    print(opts)

    opt = int(input("Digite a opção que deseja: "))
    system("cls")

    if opt == 1:
        print("1. Inserir Valor na árvore\n")

        value = int(input("Digite o valor que deseja inserir: "))
        ArvoreBinaria.Insert(value)
        system("cls")

    elif opt == 2:
        print("2. Remover Valor da árvore\n")

        value = int(input("Digite o valor que deseja remover: "))
        print(f"O valor foi removido da árvore.")

    elif opt == 3:
        ArvoreBinaria.InOrder()

    elif opt == 4:
        ArvoreBinaria.PreOrder()

    elif opt == 5:
        ArvoreBinaria.PosOrder()

    elif opt == 0:
        break

print("Programa Finalizado")
