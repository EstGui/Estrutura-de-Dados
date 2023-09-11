class No {
    constructor(conteudo) {
        this.noEsq = null
        this.noDir = null
        this.conteudo = conteudo
    }
}


class ArvoreBinaria {
    constructor () {
        this.raiz = null;
    }


    insert(conteudo) {
        const novoNo = new No(conteudo);
        this.raiz = this.Insert(this.raiz, novoNo)
    }

    Insert(noAtual, novoNo) {
        if (noAtual == null) {
            return novoNo;

        } else if (novoNo.conteudo > noAtual.conteudo) {
            noAtual.noDir = this.Insert(noAtual.noDir, novoNo);

        } else if (novoNo.conteudo < noAtual.conteudo) {
            noAtual.noEsq = this.Insert(noAtual.noEsq, novoNo);
        }

        return noAtual;
    }


    inOrder() {
        console.log("Exibição InOrder:");
        this.InOrder(this.raiz);
    }

    InOrder(noAtual) {
        if (noAtual != null) {
            this.InOrder(noAtual.noEsq);
            console.log(noAtual.conteudo);
            this.InOrder(noAtual.noDir);
        }
    }

    preOrder() {
        console.log("Exibição PreOrder:");
        this.PreOrder(this.raiz);
    }

    PreOrder(noAtual) {
        if (noAtual != null) {
            console.log(noAtual.conteudo);
            this.PreOrder(noAtual.noEsq);
            this.PreOrder(noAtual.noDir);
        }
    }

    posOrder() {
        console.log("Exibição PosOrder:");
        this.PosOrder(this.raiz);
    }

    PosOrder(noAtual) {
        if (noAtual != null) {
            this.PosOrder(noAtual.noEsq);
            this.PosOrder(noAtual.noDir);
            console.log(noAtual.conteudo);
        }
    }


    remove(valor, noAtual = null) {
        if (noAtual == null) {
            noAtual = this.raiz;
        }

        if (valor > noAtual.conteudo) {
            noAtual.noDir = this.remove(valor, noAtual.noDir);

        } else if (valor < noAtual.conteudo) {
            noAtual.noEsq = this.remove(valor, noAtual.noEsq);

        } else {
            if (noAtual.noEsq == null) {
                let aux = noAtual.noDir;
                noAtual = null;
                return aux;

            } else if (noAtual.noDir == null) {
                let aux = noAtual.noEsq;
                noAtual = null;
                return aux;

            } else {
                let aux = this.menorDireita(noAtual.noDir);
                noAtual.conteudo = aux.conteudo;
                noAtual.noDir = this.remove(aux.conteudo, noAtual.noDir);
            }
        }

        return noAtual;
    }

    menorDireita(noAtual) {
        while (noAtual.noEsq) {
            noAtual = noAtual.noEsq;
        }

        return noAtual;
    }
}

const arvoreBinaria = new ArvoreBinaria();

arvoreBinaria.insert(5)
arvoreBinaria.insert(8)
arvoreBinaria.insert(2)
arvoreBinaria.insert(4)
arvoreBinaria.insert(9)

console.log(arvoreBinaria.inOrder())
console.log(arvoreBinaria.preOrder())
console.log(arvoreBinaria.posOrder())

arvoreBinaria.remove(9)

console.log(arvoreBinaria.inOrder())
console.log(arvoreBinaria.preOrder())
console.log(arvoreBinaria.posOrder())