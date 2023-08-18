public class ArvoreBinaria<T extends Comparable<T>> {
    private No<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

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

    public void inOrder() {
        System.out.println("Exibição InOrder: ");
        inOrder(this.raiz);
    }

    private void inOrder(No<T> atual) {
        if (atual != null) {
            inOrder(atual.getNoEsq());
            System.out.println(atual.getConteudo() + ", ");
            inOrder(atual.getNoDir());
        }
    }

    public void posOrder() {
        System.out.println("Exibição posOrder: ");
        posOrder(this.raiz);
    }

    private void posOrder(No<T> atual) {
        if (atual != null) {
            posOrder(atual.getNoEsq());
            posOrder(atual.getNoDir());
            System.out.println(atual.getConteudo() + ", ");
        }
    }

    public void preOrder() {
        System.out.println("Exibição preOrder: ");
        preOrder(this.raiz);
    }

    private void preOrder(No<T> atual) {
        if (atual != null) {
            System.out.println(atual.getConteudo() + ", ");
            preOrder(atual.getNoEsq());
            preOrder(atual.getNoDir());
        }
    }
}
