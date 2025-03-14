public class Peao {
    private String cor;

    public Peao(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Peao{" +
                "cor='" + cor + '\'' +
                '}';
    }
}