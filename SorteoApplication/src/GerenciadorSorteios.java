
import java.util.ArrayList;
import java.util.List;

public class GerenciadorSorteios {
    private List<SorteioIndividual> sorteios;

    public GerenciadorSorteios() {
        sorteios = new ArrayList<>();
    }

    public void adicionarSorteio(SorteioIndividual sorteio) {
        sorteios.add(sorteio);
    }

    public List<SorteioIndividual> getSorteios() {
        return sorteios;
    }

    public void registrarSorteio(SorteioIndividual sorteio) {
        sorteios.add(sorteio);
    }
}

