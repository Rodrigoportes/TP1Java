package org.example;

import org.example.batalha.SimulaBatalha;
import personagens.Personagem;
import utilidade.Relatorio;

import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Personagem heroi = null;
        Personagem monstro = null;

        System.out.println("Qual é o seu nickName ?");
        String nickname = ler.nextLine();

        Relatorio relatorio = new Relatorio(nickname);
        relatorio.gerarRelatorio();

        System.out.println("Escolha a sua classe:");
        System.out.println("[1] - Guerreiro");
        System.out.println("[2] - Bárbaro");
        System.out.println("[3] - Paladino");

        try {
            String classEscolhida = ler.nextLine();

            switch (classEscolhida) {

                case "1":
                    heroi = new Personagem(12, 4, 3, 3, 1, "Guerreiro");
                    int novoFatorGue = heroi.fatorDeDano(4);
                    heroi.setFatorDeDano(novoFatorGue);
                    break;

                case "2":
                    heroi = new Personagem(13, 6, 1, 3, 1, "Bárbaro");
                    int novoFatorBar = heroi.fatorDeDano(6);
                    heroi.setFatorDeDano(novoFatorBar);
                    break;

                case "3":
                    heroi = new Personagem(15, 2, 5, 1, 1, "Paladino");
                    int novoFatorPala = heroi.fatorDeDano(4);
                    heroi.setFatorDeDano(novoFatorPala);
                    break;

                default:
                    System.out.println("Escolha inválida");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erro ao escolher a classe: " + e.getMessage());
        }

        Random random = new Random();
        int aleatorio = random.nextInt(3) + 1;
        switch(aleatorio){

            case 1:
                monstro = new Personagem(25,4,0,1,1,"Morto-Vivo");
                int novoFatorGue = monstro.fatorDeDano(4);
                monstro.setFatorDeDano(novoFatorGue);
                break;

            case 2:
                monstro = new Personagem(20,6,2,2,1,"Orc");
                int novoFatorBar = monstro.fatorDeDano(8);
                monstro.setFatorDeDano(novoFatorBar);
                break;

            case 3:
                monstro = new Personagem(20,2,2,4,1,"Kobold");
                int novoFatorPala = monstro.fatorDeDanoKobald(2);
                monstro.setFatorDeDano(novoFatorPala);
                break;

            default:
                System.out.println("Escolha inválida");
                break;
        }


        assert heroi != null;
        SimulaBatalha.batalha(monstro, heroi, nickname);

    }
}
