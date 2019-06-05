package com.app.dao;

import java.util.List;

import pojos.ComplainList;
import pojos.HouseList;
import pojos.SocietyList;
import pojos.UserList;


public interface SocietyDao {
   String addsociety(SocietyList c);
   UserList getUserByUserName(String user);
   List<SocietyList> getSociety();
   SocietyList getSocietyByName(String name);
   String addHouse(HouseList h);
   List<Integer> getHouseNoBySocietyName(String name);
	/*String deleteVendorDetails(Vendor v);
	String addVendorDetails(Vendor v);
	String updateVendorDetails(Vendor v);
	Vendor getVendorDetails(int id);*/
   	List<HouseList> fetchHouses(String societyName);
	HouseList fetchHouseById(int houseId);
	String addUser(UserList u);
	List<ComplainList> fetchComplaint();
	ComplainList fetchComplaintById(int id);
	String updateComplaint(String reply, int id);
	
}
