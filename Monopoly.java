import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly {
    private List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private int jogadorAtual;
    private Scanner scanner;

    public Monopoly() {
        jogadores = new ArrayList<>();
        tabuleiro = new Tabuleiro();
        scanner = new Scanner(System.in);
    }

    public void iniciarJogo() {
        System.out.println("Bem-vindo ao Monopoly!");

        // Coletar o número de jogadores
        int numeroJogadores = 0;
        while (numeroJogadores < 2 || numeroJogadores > 8) {
            System.out.print("Entre com o número de jogadores [2-8]: ");
            try {
                numeroJogadores = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número entre 2 e 8.");
            }
        }

        // Coletar informações dos jogadores
        for (int i = 1; i <= numeroJogadores; i++) {
            System.out.print("Entre com o nome do jogador no. " + i + ": ");
            String nome = scanner.nextLine();

            String corPeao = escolherCorPeao(i);
            Peao peao = new Peao(corPeao);
            jogadores.add(new Jogador(nome, peao));
        }

        // Iniciar o jogo
        System.out.println("\nO jogo Monopoly foi iniciado.");
        jogadorAtual = 0;
        while (jogadores.size() > 1) {
            Jogador jogador = jogadores.get(jogadorAtual);
            System.out.println("\n--- Vez de " + jogador.getNome() + " ---");
            System.out.println("Comandos disponíveis: [jogar][sair]");
            System.out.print("Entre com um comando: ");
            String comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("jogar")) {
                jogar(jogador);
            } else if (comando.equalsIgnoreCase("status")) {
                exibirStatusJogo();
            } else if (comando.equalsIgnoreCase("sair")) {
                System.out.println("Saindo do jogo...");
                break;
            } else {
                System.out.println("Comando inválido. Tente novamente.");
            }

            if (jogador.getDinheiro() < 0) {
                System.out.println(jogador.getNome() + " faliu e está fora do jogo!");
                jogadores.remove(jogador);
                if (jogadores.size() == 1) {
                    System.out.println(jogadores.get(0).getNome() + " venceu o jogo!");
                    break;
                }
            }

            jogadorAtual = (jogadorAtual + 1) % jogadores.size();
        }
    }

    public void exibirStatusJogo() {
        System.out.println("\n--- Status do Jogo ---");
    
        System.out.println("\n### Jogadores:");
        for (Jogador jogador : jogadores) {
            System.out.println("Nome: " + jogador.getNome());
            System.out.println("Saldo: $" + jogador.getDinheiro());
            System.out.println("Posição: " + jogador.getPosicao() + " - " + tabuleiro.getEspaco(jogador.getPosicao()).getNome());
            System.out.println("Propriedades: " + jogador.getPropriedades());
            System.out.println();
        }
    
        System.out.println("\n### Tabuleiro:");
        for (int i = 0; i < tabuleiro.getEspacos().size(); i++) {
            Espaco espaco = tabuleiro.getEspaco(i);
            System.out.print("Posição " + i + ": ");
            espaco.exibirInformacoes(); 
            System.out.println();
        }
    
        System.out.println("\n### Turno Atual: " + jogadores.get(jogadorAtual).getNome());
    }

    private void jogar(Jogador jogador) {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        int passos = dado1 + dado2;
        System.out.println(jogador.getNome() + " rolou " + dado1 + " e " + dado2 + " (" + passos + " passos).");
    
        jogador.setUltimoValorDados(passos);
        jogador.mover(passos);
        Espaco espacoAtual = tabuleiro.getEspaco(jogador.getPosicao());
        System.out.println(jogador.getNome() + " caiu em " + espacoAtual.getNome() + ".");
        espacoAtual.acao(jogador, scanner); 
    }

    private String escolherCorPeao(int numeroJogador) {
        String[] coresDisponiveis = { "preto", "branco", "vermelho", "verde", "azul", "amarelo", "laranja", "rosa" };
        String corEscolhida = "";

        while (true) {
            System.out.println("Escolha a cor do peão do jogador no. " + numeroJogador + " entre as opções seguintes:");
            for (String cor : coresDisponiveis) {
                System.out.print("[" + cor + "]");
            }
            System.out.print("\n: ");
            corEscolhida = scanner.nextLine().toLowerCase();

            for (String cor : coresDisponiveis) {
                if (cor.equals(corEscolhida)) {
                    return corEscolhida;
                }
            }
            System.out.println("Cor inválida. Tente novamente.");
        }
    }

    public static void main(String[] args) {
        Monopoly monopoly = new Monopoly();
        monopoly.iniciarJogo();
    }
}
