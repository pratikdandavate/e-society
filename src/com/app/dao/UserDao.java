package com.app.dao;

import java.util.List;

import pojos.ComplainList;
import pojos.HouseList;
import pojos.RentHouse;
import pojos.SellHouse;
import pojos.SocietyList;
import pojos.UserList;


public interface UserDao {
  
   UserList getUserEntityByUser(String user);

   UserList getHouseById(int rentId);

   String addRentHouse(RentHouse hs);
   String addSellHouse(SellHouse hs);

   String makeComplaint(ComplainList c);

   List<ComplainList> fetchComplaint(int id);
   
	
}
