import java.util.Scanner;

public class ParadaLivre extends Espaco{
    public ParadaLivre(String nome) {
        super(nome);
    }

    @Override
    public void acao(Jogador jogador, Scanner scanner) {
        System.out.println(jogador.getNome() + ", você caiu em " + getNome() + ". Aproveite para descansar!");
    }

    @Override
    public void exibirInformacoes() {
        System.out.print("Parada Livre: " + getNome());
    }
}
