package org.example.batalha;

import personagens.Personagem;
import utilidade.GravacaoLog;

import java.util.Random;
import java.util.Date;

public class SimulaBatalha {
    public static void batalha(Personagem monstro, Personagem heroi, String nomeJogador) {

        int iniciativaMonstro = 1;
        int iniciativaHeroi = 1;
        int vidaRestante;
        int contador = 0;
        Personagem atacante = null;
        Personagem defensor = null;
        Date dataAtual = new Date();
        String result = "";

        System.out.println("------------------------------------------------");
        System.out.println("==============  A batalha começa!  =============");
        System.out.println("------------------------------------------------");
        System.out.println("");
        System.out.println("------------ " + heroi.getNome() + " contra " + monstro.getNome() + " ------------");
        System.out.println("");
        while (true) {
            contador++;
            // Fator de iniciativa

            Random random = new Random();
            int sorteio1 = random.nextInt(10) + 1;
            int sorteio2 = random.nextInt(10) + 3;
            int agilHeroi = heroi.getAgilidade();
            int agilMonstro = monstro.getAgilidade();

            iniciativaMonstro = sorteio1 + agilMonstro;
            iniciativaHeroi = sorteio2 + agilHeroi;

            System.out.println("------------------------------------------------");

            System.out.println("A " + contador + "° rodada inicia!");

            if (iniciativaHeroi > iniciativaMonstro) {

                System.out.println("O " + heroi.getNome() + " avança em direção ao alvo!");
                atacante = heroi;
                defensor = monstro;

            } else if (iniciativaHeroi < iniciativaMonstro) {

                atacante = monstro;
                defensor = heroi;
                System.out.println("O " + monstro.getNome() + " ataca com fúria!");

            } else if (iniciativaHeroi == iniciativaMonstro) {
                iniciativaMonstro = 0;
                iniciativaHeroi = 0;
            }

            // Fator de ataque

            int ataque = (random.nextInt(10) + 1) + atacante.getAgilidade() + atacante.getForca();
            int defesa = (random.nextInt(10) + 1) + defensor.getAgilidade() + defensor.getDefesa();

            if (ataque > defesa) {
                int dano = atacante.getFatorDeDano() + atacante.getForca();
                vidaRestante = defensor.getPontosDeVida() - dano;
                defensor.setPontosDeVida(vidaRestante);
                System.out.println("O " + atacante.getNome() + " desfere um golpe com sucesso! ");

                if (defensor.getPontosDeVida() > 0) {
                    System.out.println("O " + defensor.getNome() + " sobrevive ao ataque e permanece com "
                            + defensor.getPontosDeVida() + " pontos de vida");
                    System.out.println("------------------------------------------------");

                } else {
                    System.out.println("A batalha acabou, VITÓRIA do  " + atacante.getNome());
                    if (atacante.getNome().equals("Morto-Vivo") || atacante.getNome().equals("Orc")
                            || atacante.getNome().equals("Kobold")) {
                        result = "Perdeu";
                    } else {
                        result = "Ganhou";
                    }

                    System.out.println("------------------------------------------------");

                    GravacaoLog registrar = new GravacaoLog(nomeJogador, dataAtual, heroi.getNome(), result, monstro.getNome(),
                            contador);
                    registrar.registroBatalha(registrar);
                    break;

                }
            } else {
                System.out.println("O " + defensor.getNome() + " defende o ataque!");
                System.out.println("------------------------------------------------");

            }
        }
    }

}
