public class No<T extends Comparable<T>> {
    private T conteudo;
    private No<T> NoEsq;
    private No<T> NoDir;

    public No () {
        this.conteudo = null;
        this.NoEsq = this.NoDir = null;
    }

    public No (T conteudo) {
        this.conteudo = conteudo;
        this.NoEsq = this.NoDir = null;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getNoEsq() {
        return NoEsq;
    }

    public void setNoEsq(No<T> noEsq) {
        NoEsq = noEsq;
    }

    public No<T> getNoDir() {
        return NoDir;
    }

    public void setNoDir(No<T> noDir) {
        NoDir = noDir;
    }
}
