import java.util.Scanner;

public class Propriedade extends Espaco implements Compravel, Alugavel {
    private int preco;
    private int aluguelBase;
    private String grupoCor;
    private Jogador dono;

    public Propriedade(String nome, int preco, int aluguelBase, String grupoCor) {
        super(nome);
        this.preco = preco;
        this.aluguelBase = aluguelBase;
        this.grupoCor = grupoCor;
        this.dono = null;
    }

    @Override
    public void acao(Jogador jogador, Scanner scanner) {
        if (dono == null) {
            System.out.println(jogador.getNome() + ", você deseja comprar " + getNome() + " por $" + preco + "? [sim/nao]");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                comprar(jogador, scanner);
            }
        } else if (dono != jogador) {
            int aluguel = calcularAluguel(jogador);
            System.out.println(jogador.getNome() + ", você pagou $" + aluguel + " de aluguel para " + dono.getNome() + ".");
            jogador.pagar(aluguel);
            dono.receber(aluguel);
        }
    }

    @Override
    public void comprar(Jogador jogador, Scanner scanner) {
        if (jogador.getDinheiro() >= preco) {
            jogador.pagar(preco);
            dono = jogador;
            jogador.adicionarPropriedade(this);
            System.out.println("Parabéns! Agora você é o dono de " + getNome() + ".");
        } else {
            System.out.println("Você não tem dinheiro suficiente para comprar " + getNome() + ".");
        }
    }

    @Override
    public int calcularAluguel(Jogador jogador) {
        int propriedadesDoGrupo = dono.getPropriedadesDoGrupo(grupoCor).size();
        return aluguelBase * propriedadesDoGrupo;
    }

    @Override
    public Jogador getDono() {
        return dono;
    }

    public String getGrupoCor() {
        return grupoCor;
    }

    @Override
    public void exibirInformacoes() {
        System.out.print("Propriedade: " + getNome());
        if (getDono() != null) {
            System.out.print(" (Dono: " + getDono().getNome() + ")");
        } else {
            System.out.print(" (Sem dono)");
        }
    }

    @Override
    public String toString() {
        return getNome() + " (Preço: $" + preco + ", Aluguel Base: $" + aluguelBase + ", Grupo: " + grupoCor + ")";
    }
}
