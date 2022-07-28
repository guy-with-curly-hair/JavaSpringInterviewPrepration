package lld_machinecoding.vendingmachine.sol2.step3;

public interface VendingMachineInterface {

    void displayProducts();

    void selectProduct(int product);

    void displayEnterCoinsMessage();

    void enterCoins(int... coins);

    void displayChangeMessage();
}
