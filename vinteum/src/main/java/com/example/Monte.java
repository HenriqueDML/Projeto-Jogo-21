package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte{

    private List<Carta> cartas = new ArrayList<>();

    //Este construtor cria o monte de cartas com seus naipes.
    public Monte(){
        for(int numero = 1; numero <= 13; numero++){
            for(Naipe naipe: Naipe.values()){
            cartas.add(new Carta(numero, naipe));
            }
        }
    }
    //Collections é uma classe utilitaria, ela é usando para listas no geral.
    public void embaralhar(){
        Collections.shuffle(cartas);
    }

    public Carta virar(){
        return cartas.remove(0);
    }
}
