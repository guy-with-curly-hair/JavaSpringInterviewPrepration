Parking Lot should have multiple floors where customer can park
parking lot can have multiple entry & exit points
Customer can collect parking ticket from entry point & can pay at exit point
Customer can pay via cash or credit card

Each parking floor will have many parking spots
system should support many types of parking spots
Some parkng spot sud have electirc card & have electirc panel avilable with it
The system should support parking for different types of vehicles like car, truck, van, motorcycle, etc.
Each parking floor should have a display board showing any free parking spot for each spot type.

The system should support a per-hour parking fee model. For example, customers have to pay $4 for the first hour, 
$3.5 for the second and third hours, and $2.5 for all the remaining hours.



ParkingLot
{
id,
Address,
List<ParkingFloor>
undermaintence;
}

ParkingDisplayBoard will have parking floor



ParkingFloor{
id,
floor_id,
ParkingFloorSize;
List<ParkingSlot>
}

ParkingSlot{
id,
ParkingSlotType,
Vehicle 
isAvailable
EntraceGate
ExitGate
}

extends CompactSpot / LargeSpot/ MoterBikeSpot /electric Spot  ( if electinc then it can hav electirc panel)

Vehicle 
liscenceNumber
type
 Has --> Parking Ticket

extends Car / Trunk ?Electric ?van ?morobike

ParkingTicket
ParkingAttendent
ticketNumber
issuesAtdatetime
payedAt
payedAmount
status
has Payment oBject

Payment 
creationDate
amount
status
initlite trasanxtion

creditcardtxn
cashtxn



