public class No<T> {
    T conteudo;
    No<T> proxNo;
    
    public No(T conteudo, No<T> proxNo) {
        this.conteudo = conteudo;
        this.proxNo = proxNo;
    }

    public No(T conteudo) {
        this.conteudo = conteudo;
        this.proxNo = null;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getProxNo() {
        return proxNo;
    }

    public void setProxNo(No<T> proxNo) {
        this.proxNo = proxNo;
    }

    @Override
    public String toString() {
        return "No [conteudo=" + conteudo + ", proxNo=" + proxNo + "]";
    }
}