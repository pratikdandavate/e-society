package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.GuestDao;

import pojos.RentHouse;
import pojos.SellHouse;
import pojos.UserList;


@Service
@Transactional
public class GuestService {
	@Autowired	
	private GuestDao dao;

	public List<SellHouse> fetchSellHouse() {
		return dao.fetchSellHouse();
	}
	
	public List<RentHouse> fetchRentHouse() {
		return dao.fetchRentHouse();
	}

	public UserList fetchRentHouseByID(int id) {
		return dao.fetchRentHouseByID(id);
		// TODO Auto-generated method stub
		
	}	
	
}