public class Sorteio {
    private int id;
    private int quantidadeSorteios;
    private Sorteio[] sorteios;
    private int numero;
    private String nome;

    public Sorteio() {
        id = 0;
        quantidadeSorteios = 0;
        sorteios = new Sorteio[5]; // Tamanho inicial do array
    }

    public Sorteio(int id, int numero) {
        this.id = id;
        this.numero = numero;
        quantidadeSorteios = 0;
        sorteios = new Sorteio[10]; // Tamanho inicial do array
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sorteio[] getSorteios() {
        return sorteios;
    }

    public void inserirSorteio(String nome, int numero) {
        Sorteio sorteio = new Sorteio();
        sorteio.setId(id++);
        sorteio.setNome(nome);
        sorteio.setNumero(numero);
    
        if (quantidadeSorteios == sorteios.length) {
            redimensionarArray();
        }
    
        sorteios[quantidadeSorteios] = sorteio;
        quantidadeSorteios++;
    }

    public boolean removerSorteio(int id) {
        int indice = buscarIndiceSorteio(id);
        if (indice != -1) {
            for (int i = indice; i < quantidadeSorteios - 1; i++) {
                sorteios[i] = sorteios[i + 1];
            }
            sorteios[quantidadeSorteios - 1] = null;
            quantidadeSorteios--;
            return true;
        }
        return false;
    }

    public boolean atualizarSorteio(int id, int numero) {
        Sorteio sorteio = pesquisarSorteio(id);
        if (sorteio != null) {
            sorteio.setNumero(numero);
            return true;
        }
        return false;
    }

    public Sorteio pesquisarSorteio(int id) {
        for (int i = 0; i < quantidadeSorteios; i++) {
            if (sorteios[i].getId() == id) {
                return sorteios[i];
            }
        }
        return null;
    }

    private int buscarIndiceSorteio(int id) {
        for (int i = 0; i < quantidadeSorteios; i++) {
            if (sorteios[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private void redimensionarArray() {
        int novoTamanho = sorteios.length * 2;
        Sorteio[] novoArray = new Sorteio[novoTamanho];
        for (int i = 0; i < quantidadeSorteios; i++) {
            novoArray[i] = sorteios[i];
        }
        sorteios = novoArray;
    }
}