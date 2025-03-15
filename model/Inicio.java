import java.util.Scanner;

public class Inicio extends Espaco {
    public Inicio(String nome) {
        super(nome);
    }

    @Override
    public void acao(Jogador jogador, Scanner scanner) {
        System.out.println(jogador.getNome() + " passou pelo início e recebeu $200!");
        jogador.receber(200);
    }

    @Override
    public void exibirInformacoes() {
        System.out.print("Início: " + getNome() + " (Bônus: $200)");
    }
}