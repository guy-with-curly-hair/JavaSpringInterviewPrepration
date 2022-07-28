package lld_machinecoding.vendingmachine;

import java.util.List;

public interface VendingMachine {
    public long selectItemAndGetPrice(Item item) throws SoldOutException;
    public void insertCoin(Coin coin);
    public List<Coin> refund() throws NotSufficientChangeException;
    public Bucket<Item, List<Coin>> collectItemAndChange() throws NotSufficientChangeException, NotFullPaidException;
    public void reset();
}