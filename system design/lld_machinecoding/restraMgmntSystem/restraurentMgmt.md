RestaurentSystem
List<rstraurent>

Restaurent
id;
Location
name
zipCode;
type
List<Menu> or //Menu
List<Table>
}


{
Table
id
tableType;
List<Seat>

}

menu{
id
map<category, <MealItem>>
map<category, <Meal>>
}

Meal
{
id,
List<Mealitem>
type,
price
Slot
}

MealItem
{
id;
name
price,
type,
}


reservation
{
id;
customerid;
date;
startTime;
tablecategorgy;
headCount;
mealType;
List<Notification>
}
Notification
{
notificationId;
createdOn
conent;
}


OrderPlaced
{
WaiterAssigned,
Table;
Lit<meal>;
Lit<mealItem>
Invoice/Bill;
}

Invoice
{

txnId;
totalAmount;
tip;
isPaid;
tax,
List<Invoiceitem>
paymentType;

}

InvoiceItem{
id;
mealitem_id;
cost;
}



Food Ordering Service
{
orderFood();
addmealToEAchSeat()

}
BookinService{
reseve
cancel
}


