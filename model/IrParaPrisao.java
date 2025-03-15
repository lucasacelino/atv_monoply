import java.util.Scanner;

public class IrParaPrisao extends Espaco {
    public IrParaPrisao(String nome) {
        super(nome);
    }

    @Override
    public void acao(Jogador jogador, Scanner scanner) {
        System.out.println(jogador.getNome() + ", você caiu em " + getNome() + ". Você foi direto para a prisão!");
        jogador.irParaPrisao(); 
    }

    public void exibirInformacoes() {
        System.out.print("Ir Para a Prisão: " + getNome());
    }
}
