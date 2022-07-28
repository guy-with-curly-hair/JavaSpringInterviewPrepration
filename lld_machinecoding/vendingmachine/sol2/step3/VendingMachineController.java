package lld_machinecoding.vendingmachine.sol2.step3;

public interface VendingMachineController {

    CoinBundle calculateChange(VendingMachineRequest request);
}
