import java.util.Objects;

public class SorteioIndividual {
    private int id;
    private String nome;
    private int numeroSorteado;

    public SorteioIndividual(int id, String nome, int numeroSorteado) {
        this.id = id;
        this.nome = nome;
        this.numeroSorteado = numeroSorteado;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroSorteado() {
        return numeroSorteado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        SorteioIndividual other = (SorteioIndividual) obj;
        return id == other.id &&
                numeroSorteado == other.numeroSorteado &&
                Objects.equals(nome, other.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, numeroSorteado);
    }
}
