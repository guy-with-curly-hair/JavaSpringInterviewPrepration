package lld_machinecoding.vendingmachine.sol2.step2;


public interface Calculator {

    int calculateTotal(CoinBundle enteredCoins);
    CoinBundle calculateChange(int enteredByUserMoney);

}
