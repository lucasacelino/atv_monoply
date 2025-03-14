import java.util.Scanner;

public class ServicoPublico extends Espaco implements Compravel, Alugavel {
    private int preco;
    private Jogador dono;

    public ServicoPublico(String nome, int preco) {
        super(nome);
        this.preco = preco;
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
            System.out.println(jogador.getNome() + ", você deve pagar $" + aluguel + " de aluguel para " + dono.getNome() + ".");
            jogador.pagar(aluguel);
            dono.receber(aluguel);
        }
    }

    @Override
    public void comprar(Jogador jogador, Scanner scanner) {
        if (jogador.getDinheiro() >= preco) {
            jogador.pagar(preco);
            dono = jogador;
            jogador.adicionarServicoPublico(this);
            System.out.println("Parabéns! Agora você é o dono de " + getNome() + ".");
        } else {
            System.out.println("Você não tem dinheiro suficiente para comprar " + getNome() + ".");
        }
    }

    @Override
    public int calcularAluguel(Jogador jogador) {
        int numServicos = dono.getNumServicosPublicos();
        int multiplicador = (numServicos == 1) ? 4 : 10;
        return multiplicador * jogador.getUltimoValorDados();
    }

    @Override
    public Jogador getDono() {
        return dono;
    }
}