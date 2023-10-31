package utilidade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Relatorio {
    private String nickname;

    public Relatorio(String nickname) {
        this.nickname = nickname;
    }

    public void gerarRelatorio() {
        try {

            String arquivoJogador = "temp/" + nickname + ".csv";
            BufferedReader reader = new BufferedReader(new FileReader(arquivoJogador));

            Map<String, Integer> herois = new HashMap<>();
            Map<String, Integer> monstros = new HashMap<>();
            int totalPontos = 0;

            String linha;
            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");
                if (partes.length >= 4) {
                    String primata = partes[1];
                    String resultado = partes[2];
                    String felino = partes[3];
                    int quantidadeDeRodadas = Integer.parseInt(partes[4]);

                    if ("Ganhou".equals(resultado)) {
                        totalPontos += 100 - quantidadeDeRodadas;
                    }

                    herois.put(primata, herois.getOrDefault(primata, 0) + 1);
                    monstros.put(felino, monstros.getOrDefault(felino, 0) + 1);
                }
            }

            reader.close();

            System.out.println("Relatório para o jogador " + nickname);
            System.out.println("Heroi mais jogado:");
            maisJodago(herois);
            System.out.println("Monstro mais enfrentado:");
            maisEnfrentado(monstros);
            System.out.println("Quantidade total de pontos: " + totalPontos);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Seu relatorio de jogo não foi encontrado.");
            System.err.println("Jogue uma partida para que seus dados sejam salvos.");
        }
    }

    private void maisJodago(Map<String, Integer> herois) {
        String heroiMaisJogado = null;
        int maxJogado = 0;

        for (Map.Entry<String, Integer> entry : herois.entrySet()) {
            if (entry.getValue() > maxJogado) {
                maxJogado = entry.getValue();
                heroiMaisJogado = entry.getKey();
            }
        }

        if (heroiMaisJogado != null) {
            System.out.println(heroiMaisJogado + " - Jogado " + maxJogado + " vezes.");
        }
    }

    private void maisEnfrentado(Map<String, Integer> monstros) {
        String mostroMaisEnfrent = null;
        int maxEnfrentado = 0;

        for (Map.Entry<String, Integer> entry : monstros.entrySet()) {
            if (entry.getValue() > maxEnfrentado) {
                maxEnfrentado = entry.getValue();
                mostroMaisEnfrent = entry.getKey();
            }
        }

        if (mostroMaisEnfrent != null) {
            System.out.println(mostroMaisEnfrent + " - Enfrentado " + maxEnfrentado + " vezes.");
        }
    }
}
