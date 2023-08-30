public class ArvoreBinaria<T extends Comparable<T>> {
    private No<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    // Insert
    public void insert(T conteudo) {
        No<T> novoNo = new No<>(conteudo);
        raiz = insert(raiz, novoNo);
    }

    private No<T> insert(No<T> atual, No<T> novoNo) {
        if (atual == null) {
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsq(insert(atual.getNoEsq(), novoNo));
        } else {
            atual.setNoDir(insert(atual.getNoDir(), novoNo));
        }

        return atual;
    }

    // InOrder
    public void inOrder() {
        System.out.println("\nExibição InOrder: ");
        inOrder(this.raiz);
    }

    private void inOrder(No<T> atual) {
        if (atual != null) {
            inOrder(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ", ");
            inOrder(atual.getNoDir());
        }
    }

    // PosOrder
    public void posOrder() {
        System.out.println("\nExibição posOrder: ");
        posOrder(this.raiz);
    }

    private void posOrder(No<T> atual) {
        if (atual != null) {
            posOrder(atual.getNoEsq());
            posOrder(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    // PreOrder
    public void preOrder() {
        System.out.println("\nExibição preOrder: ");
        preOrder(this.raiz);
    }

    private void preOrder(No<T> atual) {
        if (atual != null) {
            System.out.print(atual.getConteudo() + ", ");
            preOrder(atual.getNoEsq());
            preOrder(atual.getNoDir());
        }
    }

    // Remove
    public void remove(T conteudo) {
        try {
            No<T> atual = this.raiz;
            No<T> pai = null;
            No<T> filho = null;
            No<T> aux = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)) {
                pai = atual;
                if (conteudo.compareTo(atual.getConteudo()) < 0) {
                    atual = atual.getNoEsq();
                } else {
                    atual = atual.getNoDir();
                }
            }

            if (atual == null) {
                System.out.println("Conteúdo não encontrado.");
            }

            if (pai == null) {
                if (atual.getNoDir() == null) {
                    this.raiz = atual.getNoEsq();

                } else if (atual.getNoEsq() == null) {
                    this.raiz = atual.getNoDir();

                } else {
                    for (aux = atual, filho = atual.getNoEsq(); filho.getNoDir() != null; aux = filho, filho = filho.getNoEsq()) {
                        if (filho != atual.getNoEsq()) {
                            aux.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(raiz.getNoEsq());
                        }
                    }
                    filho.setNoDir(raiz.getNoDir());
                    raiz = filho;
                }

            } else if (atual.getNoEsq() == null) {
                if (pai.getNoEsq() == atual) {
                    pai.setNoEsq(atual.getNoDir());
                } else {
                    pai.setNoDir(atual.getNoDir());
                }

            } else if (atual.getNoDir() == null) {
                if (pai.getNoEsq() == atual) {
                    pai.setNoEsq(atual.getNoEsq());
                } else {
                    pai.setNoDir(atual.getNoEsq());
                }

            } else {
               for (aux = atual, filho = atual.getNoEsq(); filho.getNoDir() != null; aux = filho, filho = filho.getNoDir()) {
                    if (filho != atual.getNoEsq()) {
                        aux.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(atual.getNoEsq());
                    }
                    filho.setNoDir(atual.getNoDir());

                    if (pai.getNoEsq() == atual) {
                        pai.setNoEsq(filho);

                    } else {
                        pai.setNoDir(filho);
                    }
               }
            }

        } catch (NullPointerException e) {
            System.out.println("Conteúdo não encontrado.");
        }
    }
}
