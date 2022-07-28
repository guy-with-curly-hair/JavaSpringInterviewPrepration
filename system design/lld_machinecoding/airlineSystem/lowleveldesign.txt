AirlineSystem

//Flight
id; fightCode, airlineName , flightType smoke Seatingarrangments

//timetableModel

id; flight_id; source , destination, departureTime , arrivalTime, flightType, fate

flightattendants
{
id;
flight_id
start_time
end_time;
memeber_id;
membertype
}


//reservationModel
{
id;
fightid;
customer_id/account_id
date;
time;
notification
totalAmount
Map<flight,seat>
List<Services>
reservationStatus
Invoice
}


//ittenroy
{
startingAirport
FinalAirport
List<FlightReservation
}



Flight
{
id;
AircrafT
List<Pilot>
List<Crewmember>
Airport SourceAirport
Airport dstinationAirport
DepartureTime
ArrivalTime
Schedule
List<Seats>
}