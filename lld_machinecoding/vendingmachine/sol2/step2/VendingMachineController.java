package lld_machinecoding.vendingmachine.sol2.step2;

public interface VendingMachineController {

    CoinBundle calculateChange(VendingMachineRequest request);
}
