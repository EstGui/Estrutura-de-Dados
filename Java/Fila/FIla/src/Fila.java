public class Fila<T> {
    No<T> inicio;
    No<T> fim;

    public void enqueue(T conteudo) {
        No<T> novoNo = new No<>(conteudo);

        if (this.inicio == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.setProxNo(novoNo);
            this.fim = novoNo;
        }
    }

    public void dequeue() {
        this.inicio = this.inicio.getProxNo();
    }

    public T front() {
        return this.inicio.getConteudo();
    }

    public T rear() {
        return this.fim.getConteudo();
    }

    public int size() {
        int tamanhoFila = 0;

        No<T> noAux = this.inicio;

        while (noAux != null) {
            tamanhoFila ++;
            noAux = noAux.getProxNo();
        }

        return tamanhoFila;
    }

    public boolean isEmpty() {
        return (inicio == null) ? true : false;
    }
    
    public void clear() {
        this.inicio = null;
        this.fim = null;
    }

    public String show() {
        String str = "";
        
        No<T> noAux = this.inicio;

        while (noAux != null) {
            if (noAux.getProxNo() == null) {
                str += noAux.getConteudo();
            } else {
                str += noAux.getConteudo() + " -> ";
            }
            noAux = noAux.getProxNo();
        }

        return str;
    }
}
