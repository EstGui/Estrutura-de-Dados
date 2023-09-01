class No:
    def __init__(self, conteudo):
        self.conteudo = conteudo
        self.noEsq = None
        self.noDir = None


class ArvoreBinaria:
    def __init__(self) -> None:
        self.raiz = None


    # INSERT
    def Insert(self, conteudo):
        novoNo = No(conteudo)
        self.raiz = self.insert(self.raiz, novoNo)

    def insert(self, atual, novoNo):
        if atual == None:
            return novoNo;
        elif atual.conteudo > novoNo.conteudo:
            atual.noEsq = self.insert(atual.noEsq, novoNo)
        else:
            atual.noDir = self.insert(atual.noDir, novoNo)

        return atual


    # REMOVE
    def remove(self, valor, atual=None):
        if atual is None:
            atual = self.raiz

        if valor < atual.conteudo:
            atual.noEsq = self.remove(valor, atual.noEsq)
        elif valor > atual.conteudo:
            atual.noDir = self.remove(valor, atual.noDir)

        else:
            if atual.noEsq is None:
                aux = atual.noDir
                atual = None
                return aux
            
            elif atual.noDir is None:
                aux = atual.noEsq
                atual = None
                return aux
            
            else:
                aux = self.menorDireita(atual.noDir)
                atual.conteudo = aux.conteudo
                atual.noDir = self.remove(aux.conteudo, atual.noDir)

        return atual

    def menorDireita(self, no):
        while no.noEsq:
            no = no.noEsq
        return no


    # INORDER
    def InOrder(self):
        print("Exibição inOrder: ")
        self.inOrder(self.raiz)
        print("None\n")

    def inOrder(self, atual):
        if atual != None:
            self.inOrder(atual.noEsq)
            print(atual.conteudo, end=" -> ")
            self.inOrder(atual.noDir)


    # PREORDER
    def PreOrder(self):
        print("Exibição PreOrder: ")
        self.preOrder(self.raiz)
        print("None\n")

    def preOrder(self, atual):
        if atual != None:
            print(atual.conteudo, end=" -> ")
            self.preOrder(atual.noEsq)
            self.preOrder(atual.noDir)


    # POSORDER
    def PosOrder(self):
        print("Exibição PosOrder: ")
        self.posOrder(self.raiz)
        print("None\n")

    def posOrder(self, atual):
        if atual != None:
            self.posOrder(atual.noEsq)
            self.posOrder(atual.noDir)
            print(atual.conteudo, end=" -> ")