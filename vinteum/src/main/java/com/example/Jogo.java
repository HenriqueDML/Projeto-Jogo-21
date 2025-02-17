package com.example;

public class Jogo {
    // # - protected -> só quem estiver dentro do pacote pode acessar os atributos
    // PrimaryController -> vai acessar coisas do jogo

    protected Monte monte = new Monte();
    protected  Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo(){
        monte.embaralhar();
    }

    // Jogador é a classe pai de computador
    // parametro polimorfico (esse método recebe qualquer coisa que for jogador, ou seja um computador também)

    public Carta distribuirCartaParaJogador(Jogador jogador){
        if(jogador.parou()){
            return null;
        }

        var carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;
    }

    public String resultado(){
        if (jogadorEstourou() && computadorEstourou() || jogador.getPontos() == computador.getPontos()){
            return "Empatou";
        }

        if(computadorEstourou() || !jogadorEstourou() && jogador.getPontos() > computador.getPontos()){
            return "Você ganhou";
        }

        return "Você perdeu";
    }
    public boolean acabou(){
        // alguém estourou ou os dos dois pararam
        // esse método retorna true ou false
        return jogadorEstourou() || computadorEstourou() || osDoisPararam();
    }

    //métodos auxiliares
    private boolean jogadorEstourou(){
        return jogador.getPontos() > 21;
    }
    private boolean computadorEstourou(){
        return computador.getPontos() > 21;
    }

    private boolean osDoisPararam(){
        return jogador.parou() && computador.parou();
    }
}
