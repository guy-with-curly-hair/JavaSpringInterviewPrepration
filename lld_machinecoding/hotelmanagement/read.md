System sud support different type of rooms like standard delux family suite
guest sud able to search the room invertory & book any avialble room.
System sud able to retriee info regarding booking
System sud allow cancellation their booking & provide full refund if cancellation before 24 hours
System sud able to send notification when booking is nearby
Customer sud able to add room service & foos items
Customer can ask for amenties 
payment can be done via CC or cash

Main users of our system..
Guest
Receptionist
System
HouseKeeper

top uses cases:

add/remove/edit room ;
search room;
book/cancel room;
checkIn room;
checkout room;
add romm chanrges 
update housekeeping logs

HotelService
{
 List<Hotels>
}

hotel
{
id;
name
Address
RatingInfo;
List<Room> rooms;
}
RatingInfo{
AvgRatingForFood;
AvgRatingForCleaniness;
List<UserRating>
}


Room
{
id
roomType;
RoomKey
room_status;
List<HouseKeeingLogs>
List<Amenties>
underMaintence;
bool

}

HousekeepLogs
{
id
type
date
HouseKeeper
}

RoomBooking
{
servartionId;
createdDate;
status:BookingStatus
checkin
checkout
List<Rooms>
List<HotelServices>
Invoice;
}

Invoice
{
id;
List<InvoiceItem>
Bill;
}
Invoiceitem
{
id;
Item;
ItemType;
}

Bill{
RoomCharge
ServicsCharge
paymentObj
}






APIs in controller
bookRoom()
LeaveRoom()
CheckInROom()
ChecoutRoom()

