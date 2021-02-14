package edu.ping.damian.pigcoin.develop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WalletTest {
    private Wallet wallet = null;

    @Before
    public void setupWallet(){
        this.wallet = new Wallet();
        this.wallet.generateKeyPair();
        Assert.assertEquals(
            "Wallet = "+this.wallet.getAddress().hashCode()+"\n"+
            "Total input = "+this.wallet.getTotalInput()+"\n"+
            "Total output = "+this.wallet.getTotalOutput()+"\n"+
            "Balance = "+this.wallet.getBalance()+"\n",
            this.wallet.toString());
    }
    @Test
    public void getAddressTest(){
        Assert.assertNotNull(this.wallet.getAddress());;
    }
    @Test
    public void getSKeyTest(){
        Assert.assertNotNull(this.wallet.getSKey());
    }
}
