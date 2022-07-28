

Entitites for hotel & room


//Hotel ( id , location, name , zipCode)
//Room ( id, hotelId,roomType, price, available,isreserved, smoke)
//roomType( is , description,max_capacity)
//housekeepLogs ( id , room_id,logsType,description, housekeeper_id)
//RoomKey( id , room_id, isMasterKey)
//Room_Amentities( id , room_id,amenti_id)
//ameniities ( id , name , type)
//amnetitiestype

//reservation( id , customer_id, checkINDate, checkoutDate,payment_id, total_amunt,discount,service_charge)
//Room reservation ( id , reservation_id, room_id)
//AdditonalServices( id , service_id,reservation_id)
//services( id , type, unit , price)
//payment( id ,payment_type, amount, reservation id)

//invoiceitem ( id, item/service_id, reservationId,amount, roomcharge_id,transactionid)

BillTransaction( id , amount , txnType,txnInfo)
extends creditCardTxn CachTxn



