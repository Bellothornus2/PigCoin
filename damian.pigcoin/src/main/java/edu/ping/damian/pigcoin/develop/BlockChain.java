package edu.ping.damian.pigcoin.develop;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    //propiedades
    List<Transaction> blockChain = new ArrayList<Transaction>();
    //Constructores

    //getters
    List<Transaction> getBlockChain(){
        return this.blockChain;
    }
    void summarize(){
        ////// ZONA DE PRUEBAS
        this.getBlockChain().stream().forEach(
            t -> System.out.print(t.toString())
        );
        ///// FIN ZONA DE PRUEBAS
        /*
        for (Transaction transaction : this.getBlockChain()) {
            System.out.print(transaction.toString());
        }
        */
    }
    void summarize(int position){
        System.out.print(this.blockChain.get(position).toString());
    }
    //setters
    void addOrigin(Transaction transaction){
        this.blockChain.add(transaction);
    }
    //Overrides
}
