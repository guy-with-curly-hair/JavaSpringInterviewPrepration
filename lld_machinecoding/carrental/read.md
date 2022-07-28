System sud support renting of different automobiles like cars/SUVs,Van>MoterBike
Each vechile sud have unique barCode & other details inclusing parking stall number to help t lcoate <<FULFILLED BY PUTTIN BARCODEINFO IN VEHICLE>>
System sud able to retrieve information like which member took a particualr vehcile or
what vehicle has been rent out by a specific member
System sud collect lateFees 
System sud able to send notification whe reservation is approaching the pickup date
or vechile need to return back when clsoer to due date 
Members sud able to cancel the reservation
Ssytem sud maintain vehcile log to track all events related to vehicles.
members can add rental insurance to theri reservation
Members can rent additonal quipments 
members can add additonal services to their reservation

Actors
member 
System,


RentalCabService{
List<RentalLocation>
}

RentalLocation {

List<Vechicle>
} 


Vehicle{
id;
barCodeiD; 
id;
OwnerInfo;
VehicleInfo;
List<VechicleLog>;
vehicleStatus ( enum )

APIs;
reserve();
return()
}
BarCode( id, issuedAt active)
Car(carType) Truck SUV Van(VanType) MotorCycle(motorCycleType) extends vehicle
carType { luxury,compact}

VechicleLog
{
id;
vehicleLogType;
creationDate;
description;

API:
searchByLogType
}

vechicleLogType
{
Accident
Fuelling
service
OILFilling
REpairing
Other
}


VechicleInventoryhService()
{
List<Vehicle>
searchbyType(String type)
searchbyModel(String model)
}

VehicleReservation
{
id;
Vehicle
creationDate;
customerId;
List<AdditonalDriver>
Bill
List<Notification>
List<equipments>
List<Services>
List<Insurenace>

getch(reservation details)

}

Bill{
totalAmount
Payment;
List<BillItem>
addBillitem();
}

Payment will extend by creditCardTxn & CashTxn

VehicleBookingService
{

Book(Cab CABBookingRequst, user)
{

bookinservice,book(CABBooking )
{
//costValidiation
//reserve

}

}
CABBookingRequst()
{
cabType;SEDAN/BLUE
Duration;
List<Equpment>
cost
}

Cost
{
CabPrice


}
}

costingPrice()










