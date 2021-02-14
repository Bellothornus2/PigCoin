package edu.ping.damian.pigcoin.develop;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Wallet {
    //atributos
    private PublicKey address = null;
    private PrivateKey sKey = null;
    private double totalInput = 0.0d;
    private double totalOutput = 0.0d;
    private double balance = 0.0d;
    private List<Transaction> inputTransactions = new ArrayList<Transaction>();
    private List<Transaction> outputTransactions = new ArrayList<Transaction>();
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
    List<Transaction> getInputTransactions(){
        return this.inputTransactions;
    }
    List<Transaction> getOutputTransactions(){
        return this.outputTransactions;
    }
    HashMap<String,Double> collectCoins(Double pigCoins){
        //esto no tiene ni puto sentido
        HashMap<String, Double> temporalMap = new HashMap<>();
        List<Transaction> allTransaction = this.inputTransactions;
        allTransaction.addAll(this.outputTransactions);
        List<Transaction> notConsumedTransactions = (List<Transaction>) allTransaction.stream()
                .filter(n -> n.getHash() != n.getPrevHash());
        for (Transaction transaction : notConsumedTransactions) {
            if (transaction.getPigCoins()-pigCoins >= 0.0){
                temporalMap.put(transaction.getHash(), transaction.getPigCoins());
            } else {
                String newHash = "CA_"+transaction.getHash();
                Transaction newTransaction = new Transaction(newHash, )
            }
        }
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
    void setTotalOutput(double totalOutput){
        this.totalOutput += totalOutput;
    }
    void setTotalInput(double totalInput){
        this.totalInput += totalInput;
    }
    void setBalance(double balance){
        this.balance = balance;
    }
    void loadCoins(BlockChain blockChain){
        for (Transaction transaction : blockChain.getBlockChain()) {
            if (transaction.getPKeyRecipient() == this.getAddress()){
                this.setTotalInput(transaction.getPigCoins());
                double balanceNow = this.getTotalInput() - this.getTotalOutput();
                this.setBalance(balanceNow);
            } else if (transaction.getPKeySender() == this.getAddress()){
                this.setTotalOutput(transaction.getPigCoins());
                double balanceNow = this.getTotalInput() - this.getTotalOutput();
                this.setBalance(balanceNow);
            }
        }
    }
    void loadInputTransactions(BlockChain blockChain){
        for (Transaction transaction : blockChain.getBlockChain()) {
            if (transaction.getPKeyRecipient() == this.getAddress()){
                this.getInputTransactions().add(transaction);
            }
        }
    }
    void loadOutputTransactions(BlockChain blockChain){
        for (Transaction transaction : blockChain.getBlockChain()) {
            if (transaction.getPKeySender() == this.getAddress()){
                this.getOutputTransactions().add(transaction);
            }
        }
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
