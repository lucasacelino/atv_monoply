import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SorteOuReves extends Espaco {
    private List<String> cartas;

    public SorteOuReves(String nome) {
        super(nome);
        cartas = new ArrayList<>();
        inicializarCartas();
    }

    private void inicializarCartas() {
        // Adicionar cartas de Sorte ou Revés
        cartas.add("Avance para a Avenida Boardwalk.");
        cartas.add("Pague $100 de multa por excesso de velocidade.");
        cartas.add("Receba $200 de herança.");
        cartas.add("Vá para a prisão. Não passe pelo Início.");
        Collections.shuffle(cartas);
    }

    private String comprarCarta() {
        if (cartas.isEmpty()) {
            inicializarCartas();
        }
        return cartas.remove(0);
    }

    @Override
    public void acao(Jogador jogador, Scanner scanner) {
        System.out.println(jogador.getNome() + ", você caiu em Sorte ou Revés. Compre uma carta!");
        String carta = comprarCarta();
        executarAcao(jogador, carta);
    }

    public void executarAcao(Jogador jogador, String descricaoCarta) {
        System.out.println(jogador.getNome() + " comprou uma carta de Sorte ou Revés: " + descricaoCarta);

        // Executar a ação correspondente à carta
        switch (descricaoCarta) {
            case "Pague $100 de multa por excesso de velocidade.":
                jogador.pagar(100);
                break;
            case "Receba $200 de herança.":
                jogador.receber(200);
                break;
            case "Vá para a prisão. Não passe pelo Início.":
                jogador.irParaPrisao();
                break;
        }
    }

    @Override
    public void exibirInformacoes() {
        System.out.print("Sorte ou Revés: " + getNome());
    }
}
