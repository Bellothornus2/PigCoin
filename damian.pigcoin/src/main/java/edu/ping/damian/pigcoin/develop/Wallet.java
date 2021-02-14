package edu.ping.damian.pigcoin.develop;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {
    //atributos
    private PublicKey address = null;
    private PrivateKey sKey = null;
    private double totalInput = 0;
    private double totalOutput = 0;
    private double balance = 0;
    //private Map<PublicKey,int> inputTransactions = new HashMap<PublicKey,int>();
    //private Map<PublicKey,int> outputTransactions = new HashMap<PublicKey,int>();
    //constructor
    
    //getters
    PublicKey getAddress(){
        return this.address;
    }
    PrivateKey getSKey(){
        return this.sKey;
    }
    double getTotalInput(){
        return this.totalInput;
    }
    double getTotalOutput(){
        return this.totalOutput;
    }
    double getBalance(){
        return this.balance;
    }
    //setters
    void generateKeyPair(){
        KeyPair pair = GenSig.generateKeyPair();
        this.address = pair.getPublic();
        this.sKey = pair.getPrivate();
    }
    void setAddress(PublicKey pKey){
        this.address = pKey;
    }
    void setSK(PrivateKey pKey){
        this.sKey = pKey;
    }

    //Overrides
    @Override
    public String toString(){
        return String.format("Wallet = %s\n"+
        "Total input = %s\n"+
        "Total output = %s\n"+
        "Balance = %s\n",
        this.address.hashCode(),
        this.totalInput,
        this.totalOutput,
        this.balance);
    }

}
