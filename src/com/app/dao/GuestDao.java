package com.app.dao;

import java.util.List;

import pojos.RentHouse;
import pojos.SellHouse;
import pojos.UserList;

public interface GuestDao {

	List<SellHouse> fetchSellHouse();
	List<RentHouse> fetchRentHouse();
	UserList fetchRentHouseByID(int id);

}
