package com.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SocietyDao;
import com.app.dao.UserDao;

import pojos.ComplainList;
import pojos.HouseList;
import pojos.RentHouse;
import pojos.SellHouse;
import pojos.UserList;

@Service
@Transactional
public class UserService {
	@Autowired	
	private UserDao dao;
	
	public UserList getUserEntity(String user) {
		return dao.getUserEntityByUser(user);
	}

	public String getHouseById(int rentId,int rentPrice) {
		UserList h=dao.getHouseById(rentId);
		RentHouse hs=new RentHouse(h.getUserId(), h.getSocietyName(), rentPrice, new Date());
		hs.setUser(h);
		return dao.addRentHouse(hs);
	}

	public String sellHouse(int rentId,int rentPrice) {
		UserList h=dao.getHouseById(rentId);
		SellHouse hs=new SellHouse(h.getUserId(), h.getSocietyName(), rentPrice, new Date());
		hs.setUser(h);
		return dao.addSellHouse(hs);
	}

	public String makeComplaint(ComplainList c, int userid) {
		UserList h=dao.getHouseById(userid);
		c.setUser1(h);
		return dao.makeComplaint(c);
		// TODO Auto-generated method stub
		
	}

	public List<ComplainList> getComplaintById(int id) {
		return dao.fetchComplaint(id);
	}

}
