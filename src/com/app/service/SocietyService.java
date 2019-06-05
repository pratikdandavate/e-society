package com.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SocietyDao;

import pojos.ComplainList;
import pojos.HouseList;
import pojos.SocietyList;
import pojos.UserList;

@Service
@Transactional
public class SocietyService {
	@Autowired	
	private SocietyDao dao;
		public String AddSociety(SocietyList c)
		{
			return dao.addsociety(c);
		}
		
		public UserList getUserEntity(String user) {
			return dao.getUserByUserName(user);
		}
		
		public List<SocietyList> getSociety()
		{
			return dao.getSociety();
		}

		
		public SocietyList getSocietyByName(String name)
		{
			return dao.getSocietyByName(name);
		}
		
		public String AddHouse(String sname,HouseList h)
		{
			SocietyList s=dao.getSocietyByName(sname);
			h.setMySociety(s);
			return dao.addHouse(h);
		}

		public List<HouseList> getHouseBySocietyName(String societyName) {
			return dao.fetchHouses(societyName);
			
		}

		public List<Integer> getHouseNoBySocietyName(String name) {
			
			return dao.getHouseNoBySocietyName(name);
		}

		public String AddUser(UserList u, int houseId) {
			HouseList h=dao.fetchHouseById(houseId);
			u.setHouse(h);
			return dao.addUser(u);
			 
			
		}

		public List<ComplainList> fetchComplaints() {
			return dao.fetchComplaint();
			
			
		}

		public ComplainList fetchComplaintById(int id) {
			return dao.fetchComplaintById(id);
		}

		public String updateComplaint(String reply, int id) {
			// TODO Auto-generated method stub
			
			return dao.updateComplaint(reply, id);
		}
		

		
		/*String deleteVendorDetails(int id);
		String addVendorDetails(Vendor v);
		String updateVendorDetails(Vendor v);
		Vendor getVendorDetails(int id);
		*/
	}

