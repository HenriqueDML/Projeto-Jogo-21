package com.example;

public class Jogo {

    //Foi usando o protected pois nesse cenário o jogador e o computador vai ser acessado pelo controler
    //O controler é como um controlador de voo, só as classe do mesmo pacote pode acessar com o protected
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo() {
        monte.embaralhar();
    }

    //ParametroPolimorfico Jogador classe pai de computador, nesse caso jogador pode ser os dois
    public Carta distribuiCartaParaJogador(Jogador jogador){
        if (jogador.parou()){
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
        if (computadorEstourou() || jogador.getPontos() > computador.getPontos()){
            return "Voce Ganhou";
        }
        return "Você Perdeu";
    }

    public boolean acabou(){
        return jogadorEstourou() || computadorEstourou() || osDoisPararam();
    }

    private boolean  jogadorEstourou(){
        return jogador.getPontos() > 21;
    }

    private boolean  computadorEstourou(){
        return jogador.getPontos() > 21;
    }

    private boolean osDoisPararam(){
        return jogador.parou() && computador.parou();
    }
}
