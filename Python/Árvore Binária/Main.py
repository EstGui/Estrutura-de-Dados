import ArvoreBinaria as arvore_arq
from os import system

system('cls')

ArvoreBinaria = arvore_arq.ArvoreBinaria()

ArvoreBinaria.Insert(15)
ArvoreBinaria.Insert(10)
ArvoreBinaria.Insert(17)
ArvoreBinaria.Insert(16)
ArvoreBinaria.Insert(8)
ArvoreBinaria.Insert(23)
ArvoreBinaria.Insert(12)
ArvoreBinaria.Insert(14)

ArvoreBinaria.InOrder()
ArvoreBinaria.PreOrder()
ArvoreBinaria.PosOrder()


ArvoreBinaria.remove(17)

ArvoreBinaria.InOrder()
ArvoreBinaria.PreOrder()
ArvoreBinaria.PosOrder()