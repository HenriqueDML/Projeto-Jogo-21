package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte {
    private List<Carta> cartas = new ArrayList<>();

    //ao criar o monte, criar as 52 cartas na caixinha
    public Monte(){
        //melhor para manutenção - cartas de 1 a 13 para cada um do naipe
        for(int numero = 1; numero <= 13; numero++){
            //foreach
            for(Naipe naipe : Naipe.values()){
                cartas.add(new Carta(numero, naipe));
            }
        }
    }

    public void embaralhar(){
        Collections.shuffle(cartas);
    }

    //tirar uma carta do monte e entrega uma carta
    public Carta virar(){
        // .remove tira da lista e retorna o que eliminou
        return cartas.remove(0); //remove a primeira carta da lista (indice =0)
    }
}
