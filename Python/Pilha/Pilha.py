from os import system

system("cls")

class Node:
    def __init__(self, content=None) -> None:
        self.content = content
        self.nextNode = None

    def __str__(self) -> str:
        return self.content


class Stack:
    def __init__(self) -> None:
        self.top = None


    def push(self, content) -> None:
        newNode = Node(content)

        auxNode = self.top
        self.top = newNode
        self.top.nextNode = auxNode


    def pop(self) -> Node:
        remNode = self.top
        self.top = self.top.nextNode

        return remNode
    

    def peek(self) -> str:
        return self.top.content


    def isEmpty(self) -> bool:
        return True if self.top == None else False


    def size(self) -> int:
        size = 0
        auxNode = self.top
        
        while True:
            if auxNode != None:
                size += 1
                auxNode = auxNode.nextNode
            else:
                break

        return size
    

    def show(self) -> str:
        auxNode = self.top
        string = ""

        while auxNode != None:
            string += f"{auxNode.content} -> "
            auxNode = auxNode.nextNode

        string += "None"

        return string


    def clear(self) -> None:
        self.top = None


opts = """1. Inserir Valor na pilha (push())
2. Remover Último Valor da pilha (pop())
3. Retornar Último Valor da pilha (top())
4. Verificar se a pilha está vazia (isEmpty())
5. Verificar tamanho da pilha (size())
6. Limpar pilha (clear())
7. Imprimir pilha
\n0. Finalizar Programa"""

stack = Stack()

while True:
    print(opts)

    opt = int(input("Digite a opção que deseja: "))

    if opt == 1:
        print("1. Inserir Valor na pilha (push())\n")

        value = str(input("Digite o valor que deseja inserir: "))
        stack.push(value)

    elif opt == 2:
        print("2. Remover Último Valor da pilha (pop())\n")
        print(f"O valor {stack.pop()} foi removido da pilha.")

    elif opt == 3:
        print("3. Retornar Último Valor da pilha (top())\n")
        print(f"O topo da pilha é: {stack.peek()}")

    elif opt == 4:
        print("4. Verificar se a pilha está vazia (isEmpty())\n")
        print(f'A pilha está vazia? {stack.isEmpty()}')

    elif opt == 5:
        print("5. Verificar tamanho da pilha (size())\n")
        print(f"O tamanho da pilha é: {stack.size()}")

    elif opt == 6:
        print("6. Limpar pilha (clear())\n")
        stack.clear()

    elif opt == 7:
        print("7. Imprimir pilha\n")
        print(stack.show())

    elif opt == 0:
        break
        
    else:
        print("Opção inválida. Digite novamente...")

print("Programa Finalizado.")