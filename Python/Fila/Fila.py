from os import system

class Node:
    def __init__(self, content) -> None:
        self.content = content
        self.nextNode = None

    def __str__(self) -> str:
        return self.content
    

class Queue:
    def __init__(self) -> None:
        self.end = None
        self.start = None


    def enqueue(self, content):
        newNode = Node(content)

        if self.start == None:
            self.start = newNode
            self.end = newNode

        else:
            self.end.nextNode = newNode
            self.end = newNode            
            

    def dequeue(self):
        self.start = self.start.nextNode

    def front(self):
        return self.start.content

    def rear(self):
        return self.end.content


    def size(self) -> int:
        queueSize = 0

        auxNode = self.start

        while auxNode != None:
            queueSize += 1
            auxNode = auxNode.nextNode

        return queueSize


    def isEmpty(self) -> bool:
        if self.start == None == self.end:
            return True
        
        else:
            return False
        

    def clear(self):
        self.start = None
        self.end = None
        

    def show(self):
        auxNode = self.start

        string = ""

        while auxNode != None:
            if auxNode.nextNode != None:
                string += f"{auxNode.content} -> "
            else:
                string += f"{auxNode.content}\n"
            auxNode = auxNode.nextNode

        print(string)


system("cls")

queue = Queue()

opts = """1. Inserir valor na fila (enqueue)
2. Remover valor da fila (dequeue)
3. Primeiro elemento da fila (front)
4. Último elemento da fila (rear)
5. Verificar tamanho da fila (size)
6. Verificar se a fila está vazia (isEmpty)
7. Imprimir fila
8. Limpar fila (clear)\n
0. Encerrar programa\n"""

while True:
    print(opts)
    opt = int(input("Digite a opção que deseja: "))

    system("cls")

    if opt == 1:
        print("1. Inserir valor na fila (enqueue)\n")

        value = str(input("DIgite o valor que deseja inserir na fila: "))

        queue.enqueue(value)

    elif opt == 2:
        print("2. Remover valor da fila (dequeue)")

        queue.dequeue()

    elif opt == 3:
        print("3. Primeiro elemento da fila (front)")

        print(f"O primeiro elemento da fila é: {queue.front()}\n")

    elif opt == 4:
        print("4. Último elemento da fila (rear)")

        print(f"O último elemento da fila é: {queue.rear()}\n")

    elif opt == 5:
        print("5. Verificar tamanho da fila (size)")

        print(f"O tamanho da fila é: {queue.size()}\n")

    elif opt == 6:
        print("6. Verificar se a fila está vazia (isEmpty)")

        print(f"A fila está vazia? {queue.isEmpty()}\n")

    elif opt == 7:
        print("7. Imprimir fila")

        queue.show()

    elif opt == 8:
        print("8. Limpar fila (clear)")

        queue.clear()

    elif opt == 0:
        break

    else:
        print("Opção inválida. Digite novamente...\n")

print("Programa Finalizado")