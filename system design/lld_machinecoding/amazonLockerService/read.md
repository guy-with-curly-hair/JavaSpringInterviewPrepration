Locker
{
id,
location,
lockerSize,
lockerStatus
}


Order
{
id;
List<Item>
status

--getOrder
}

Packing
{
List<Item>
getPackSize
}

deliverService
{
Order order = orderService.getorder(orderid);
List<Item> items = getitems();
Package = pack = new Package( orderid, items)
lockerSize = package.getpackageSize;
LockerService.getLocker(lockerSize, order.getGeoLocation)
locker_system( id , code, order_id,locker_id)
notifyuser

}