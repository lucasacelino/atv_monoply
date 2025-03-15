import java.util.Scanner;

public abstract class Espaco {
    private String nome;

    public Espaco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void acao(Jogador jogador, Scanner scanner);

    public abstract void exibirInformacoes();
}