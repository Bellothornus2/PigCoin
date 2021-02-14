package edu.ping.damian.pigcoin.develop;

import java.security.PublicKey;

public class Transaction {
    //propiedades
    private String hash = "";
    private String prevHash = "";
    private PublicKey pKeySender = null;
    private PublicKey pKeyRecipient = null;
    private double pigCoins = 0;
    private String message = "";
    private byte[] signature = null;
    //Constructor
    public Transaction(){}

    public Transaction(String hash, String prevHash, PublicKey pKeySender,
    PublicKey pKeyRecipient, double pigCoins, String message){
        this.hash = hash;
        this.prevHash = prevHash;
        this.pKeySender = pKeySender;
        this.pKeyRecipient = pKeyRecipient;
        this.pigCoins = pigCoins;
        this.message = message;
    }
    //getters

    //setters

    //Overrides
    public String toString(){
        return String.format("hash = %s\n"+
        "prev_hash = %s\n"+
        "pKey_Sender = %s\n"+
        "pKey_recipient = %s\n"+
        "pigCoins = %s\n"+
        "message = %s", 
        this.hash,
        this.prevHash,
        this.pKeySender.hashCode(),
        this.pKeyRecipient.hashCode(),
        this.pigCoins,
        this.message);
    }
}
