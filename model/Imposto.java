import java.util.Scanner;

public class Imposto extends Espaco {
    private int valorImposto;

    public Imposto(String nome, int valorImposto) {
        super(nome);
        this.valorImposto = valorImposto;
    }

    @Override
    public void acao(Jogador jogador, Scanner scanner) {
        System.out.println(jogador.getNome() + ", você caiu em " + getNome() + " e pagou $" + valorImposto + " de imposto.");
        jogador.pagar(valorImposto); 
    }

    public void exibirInformacoes() {
        System.out.print("Imposto: " + getNome() + " (Valor: $" + valorImposto + ")");
    }
}
