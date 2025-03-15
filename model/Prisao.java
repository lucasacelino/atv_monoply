import java.util.Scanner;

public class Prisao extends Espaco {
    public Prisao(String nome) {
        super(nome);
    }

    @Override
    public void acao(Jogador jogador, Scanner scanner) {
        System.out.println(jogador.getNome() + ", você está visitando a prisão. Apenas passe por aqui.");
    }

    @Override
    public void exibirInformacoes() {
        System.out.print("Ir Para a Prisão: " + getNome());
    }
}
