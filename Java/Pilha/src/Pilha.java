public class Pilha<T> {
    No<T> topo;

    public Pilha() {
        topo = null;
    }

    public void push(T conteudo) {
        No<T> novoNo = new No<>(conteudo);
        No<T> noAuxiliar = topo;
        topo = novoNo;
        topo.setProxNo(noAuxiliar);
    }

    public No<T> pop() {
        if (!isEmpty()) {
            No<T> noRemovido = topo;   
            topo = topo.getProxNo();
            return noRemovido;
        }

        return null;
    }

    public T top() {
        return topo.getConteudo();
    }

    public boolean isEmpty() {
        return (topo == null) ? true : false;
    }

    public int size() {
        int tamanhoPilha = 0;
        No<T> noAuxiliar = topo;

        while (noAuxiliar != null) {
            tamanhoPilha ++;
            noAuxiliar = noAuxiliar.getProxNo();
        }

        return tamanhoPilha;
    }

    public void clear() {
        topo = null;
    }

    @Override
    public String toString() {
        String str = "";

        for (No<T> noAuxiliar = topo; noAuxiliar != null; noAuxiliar = noAuxiliar.getProxNo()) {
            str += noAuxiliar.getConteudo() + " --> ";
        }

        str += "null";

        return str;
    }
}
