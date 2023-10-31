package personagens;

public abstract class Atributo {
    private int pontosDeVida;
    private int forca;
    private int defesa;
    private int agilidade;
    private int fatorDeDano;
    private String nome;

    public Atributo(int pontosDeVida, int forca, int defesa, int agilidade, int fatorDeDano, String nome) {
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.fatorDeDano = fatorDeDano;
        this.nome = nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getFatorDeDano() {
        return fatorDeDano;
    }

    public void setFatorDeDano(int fatorDeDano) {
        this.fatorDeDano = fatorDeDano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract int fatorDeDano(int num);
}
