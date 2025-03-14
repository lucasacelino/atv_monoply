import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private List<Espaco> espacos;

    public Tabuleiro() {
        espacos = new ArrayList<>();
        espacos.add(new Inicio("Início"));
        espacos.add(new Propriedade("Avenida Mediterrânea", 60, 2, "Marrom"));
        espacos.add(new Propriedade("Avenida Baltica", 60, 4, "Marrom"));
        espacos.add(new Ferrovia("Ferrovia Reading", 200));
        espacos.add(new Propriedade("Avenida Oriental", 100, 6, "azul"));
        espacos.add(new Propriedade("Avenida Vermont", 100, 6, "azul "));
        espacos.add(new Propriedade("Avenida Connecticut", 120, 8, "azul"));
        espacos.add(new Propriedade("Avenida São Carlos", 140, 10, "Rosa"));
        espacos.add(new ServicoPublico("Companhia Elétrica", 150));
        espacos.add(new Propriedade("Avenida dos Estados", 140, 10, "Rosa"));
        espacos.add(new Propriedade("Avenida Virginia", 160, 12, "Rosa"));
        espacos.add(new Ferrovia("Ferrovia Pensilvânia", 200));
        espacos.add(new Propriedade("Avenida São James", 180, 14, "Laranja"));
        espacos.add(new Propriedade("Avenida Tennessee", 180, 14, "Laranja"));
        espacos.add(new Propriedade("Avenida Nova York", 200, 16, "Laranja"));
        espacos.add(new Propriedade("Avenida Kentucky", 220, 18, "Vermelho"));
        espacos.add(new Propriedade("Avenida Indiana", 220, 18, "Vermelho"));
        espacos.add(new Propriedade("Avenida Illinois", 240, 20, "Vermelho"));
        espacos.add(new Ferrovia("Ferrovia B&O", 200));
        espacos.add(new Propriedade("Avenida Atlântica", 260, 22, "Amarelo"));
        espacos.add(new Propriedade("Avenida Ventnor", 260, 22, "Amarelo"));
        espacos.add(new ServicoPublico("Companhia de Água", 150));
        espacos.add(new Propriedade("Avenida Marvin Gardens", 280, 24, "Amarelo"));
        espacos.add(new Propriedade("Avenida Pacífico", 300, 26, "Verde"));
        espacos.add(new Propriedade("Avenida Carolina do Norte", 300, 26, "Verde"));
        espacos.add(new Propriedade("Avenida Pensilvânia", 320, 28, "Verde"));
        espacos.add(new Ferrovia("Ferrovia Short Line", 200));
        espacos.add(new Propriedade("Avenida Park Place", 350, 35, "Azul Escuro"));
        espacos.add(new Propriedade("Avenida Boardwalk", 400, 50, "Azul Escuro"));
    }

    public Espaco getEspaco(int posicao) {
        return espacos.get(posicao % espacos.size());
    }
}
