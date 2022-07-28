//rental cab service

//vehicle ( id , model , year, mileage, vtype, ownerid, vehicle_category_id)

//rental ( id , custoemr_id vehicleId, pickulocation pickup time , droppLoc, DroppTime
           rental_inssurance_id)
location // id,street_address,city,satate,country,zip

customer id name , driving_liscene number

rental 1....*rental_insurance
//rental_insurance( id , insurenace id , rental_id)
//customer
//Owner

//vehicleCategory ( id , type, rental value); ( will b needed at reservation time)

//reservation ( id , vehicle_category_id, pickUp_time,pickupLocation,drop_offTime,
DroppLocation,customer)

1 reservation can have many additional equimnt
//reservation_equipment (id , reservationid,equipmentcategory_id)

//equipmentCategoryId ( id , category_name)
 1 category can have mulitple equiments
//equipments
( id, category_id,equipment name, rental value ,curr_location)


we can integrate rental value in equipment ctegory & car/vehcile category

rental_invoice
id, rentalid,car_rent,equipment_rent_total,insurance_total,service_tax,VAT,totalAmountpayable,discount,netAmount


to cater fuel option 
we will integrate it with rental table with fuel_opption_id

fuel ( id, desc)






