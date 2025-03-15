import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private Peao peao;
    private int dinheiro;
    private int posicao;
    private List<Propriedade> propriedades;
    private List<Ferrovia> ferrovias;
    private List<ServicoPublico> servicosPublicos;
    private boolean naPrisao;
    private int ultimoValorDados;

    public Jogador(String nome, Peao peao) {
        this.nome = nome;
        this.peao = peao;
        this.dinheiro = 1500;
        this.posicao = 0;
        this.propriedades = new ArrayList<>();
        this.ferrovias = new ArrayList<>();
        this.servicosPublicos = new ArrayList<>();
        this.naPrisao = false;
        this.ultimoValorDados = 0;
    }

    public String getNome() {
        return nome;
    }

    public Peao getPeao() {
        return peao;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public boolean isNaPrisao() {
        return naPrisao;
    }

    public void setNaPrisao(boolean naPrisao) {
        this.naPrisao = naPrisao;
    }

    public List<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void adicionarPropriedade(Propriedade propriedade) {
        propriedades.add(propriedade);
    }

    public void removerPropriedade(Propriedade propriedade) {
        propriedades.remove(propriedade);
    }

    public List<Ferrovia> getFerrovias() {
        return ferrovias;
    }

    public void adicionarFerrovia(Ferrovia ferrovia) {
        ferrovias.add(ferrovia);
    }

    public void removerFerrovia(Ferrovia ferrovia) {
        ferrovias.remove(ferrovia);
    }

    public List<ServicoPublico> getServicosPublicos() {
        return servicosPublicos;
    }

    public void adicionarServicoPublico(ServicoPublico servicoPublico) {
        servicosPublicos.add(servicoPublico);
    }

    public void removerServicoPublico(ServicoPublico servicoPublico) {
        servicosPublicos.remove(servicoPublico);
    }

    public void mover(int passos) {
        posicao += passos;
        if (posicao >= 40) { // Volta ao início após completar uma volta no tabuleiro
            posicao -= 40;
            receber(200); // Recebe $200 ao passar pelo início
            System.out.println(nome + " passou pelo início e recebeu $200!");
        }
    }

    public void pagar(int quantia) {
        dinheiro -= quantia;
        if (dinheiro < 0) {
            System.out.println(nome + " entrou em falência!");
        }
    }

    public void receber(int quantia) {
        dinheiro += quantia;
    }

    public List<Propriedade> getPropriedadesDoGrupo(String grupoCor) {
        List<Propriedade> propriedadesDoGrupo = new ArrayList<>();
        for (Propriedade propriedade : propriedades) {
            if (propriedade.getGrupoCor().equals(grupoCor)) {
                propriedadesDoGrupo.add(propriedade);
            }
        }
        return propriedadesDoGrupo;
    }

    public int getNumFerrovias() {
        return ferrovias.size();
    }

    public int getNumServicosPublicos() {
        return servicosPublicos.size();
    }

    public int getUltimoValorDados() {
        return ultimoValorDados;
    }

    public void setUltimoValorDados(int ultimoValorDados) {
        this.ultimoValorDados = ultimoValorDados;
    }

    public void irParaPrisao() {
        this.posicao = 10; 
        System.out.println(this.nome + " foi movido para a prisão.");
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", dinheiro=" + dinheiro +
                ", posicao=" + posicao +
                ", propriedades=" + propriedades.size() +
                ", ferrovias=" + ferrovias.size() +
                ", servicosPublicos=" + servicosPublicos.size() +
                ", naPrisao=" + naPrisao +
                '}';
    }
}
