//City id, name
//Movie id, name
//Theater id, name , cityId
//Hall id, name, theaterid, List<Seats>
//seat id , type,hallId,price
//Show_Seat seat_id, isBooked,showid
//Show showid, movieid, fromtime, toTime, hallid
//Booking id, status, customerid, seatInfos, showid, totalAmount
//Combo price,

//BookingRequest //bookingInfo // comboInfos
//Payment id, bookinid, account
//IBookingApplicationService ..holdSeats() ...getAvail() ...confirmBooking();
//BookingApplicationSerice ...//business and input validation
//AbstarctBusinessPolicy ...validate() ....validatePolicy(){ validate();throw()} ... throw(){}
//CashDepositbusinePolicy .... validate (){if debit..if succin}
//CashDepositService ...depositCash() { CashDeBusPolicty.validatePolicy();