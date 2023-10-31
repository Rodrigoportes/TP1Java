package personagens;

import java.util.Random;

public class Personagem extends Atributo {
    public Personagem(int pontosDeVida, int forca, int defesa, int agilidade, int fatorDeDano, String nome) {
        super(pontosDeVida, forca, defesa, agilidade, fatorDeDano, nome);
    }

    @Override
    public int fatorDeDano(int num) {
        Random random = new Random();
        int sorteio1 = random.nextInt(num) + 1;
        int sorteio2 = random.nextInt(num) + 1;
        int sort = sorteio1 + sorteio2;
        return sort;
    }

    public int fatorDeDanoOrc(int num) {
        Random random = new Random();
        int sorteio = random.nextInt(num) + 1;
        int sort = sorteio;
        return sort;
    }

    public int fatorDeDanoKobald(int num) {
        Random random = new Random();
        int sorteio1 = random.nextInt(num) + 1;
        int sorteio2 = random.nextInt(num) + 1;
        int sorteio3 = random.nextInt(num) + 1;
        int sort = sorteio1 + sorteio2 + sorteio3;
        return sort;
    }



}
