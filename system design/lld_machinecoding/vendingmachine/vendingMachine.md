Its not typical system design since this ystem is used by 1 person at a time or max 1000s

Requirement
1) Avability to select an item
2) Ability to pay for the selected item
3) Dispense the item & remaining Change
4) Noitfy The owner ( serving agent) aboout inventory status



itemSelection --------------->> paymentSystem--------------->Dispense Item
                      calcultingMoney      dispensing the change


VendingMachine
{
Invnetory<Item>
Inventory<Coin>

APIs
selectAndGetPrice
collectItemAndChange
{
ValidateMoneyWithCurrentItemPrice ( amount >= item.getPrice)
List<Coin> getChange( amount) if not change then throuw exception saying not sufficent change
Item - collectItem()
return Pair<Item,List<Coin>
}

}

ITEM (ENUM)
{
Coke (1,25) , Pepsi ( 1, 30).
int price;
}

COin enum()
{
PENNY(1), NICKE(5,DIME(10))
}
Inventory<T>
{
Map<T,integer> availableInvetory

getQuanitity( T item)
deduct( T item)
addItem( T item)
hasite()
}