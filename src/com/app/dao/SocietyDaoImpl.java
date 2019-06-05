package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.ComplainList;
import pojos.HouseList;
import pojos.SocietyList;
import pojos.UserList;


@Repository
public class SocietyDaoImpl implements SocietyDao {
	@Autowired
	private SessionFactory sf;

	/*@Override
	public List<Vendor> listVendors() {
		String jpql = "select v from Vendor v";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).getResultList();
	}

	@Override
	public String deleteVendorDetails(Vendor v) {
		sf.getCurrentSession().delete(v);
		return "Vendor details deleted successfully for ID " +v.getId();
	}
*/
	@Override
	public String addsociety(SocietyList v) {
		sf.getCurrentSession().persist(v);
		return " details added successfully with ID ";
	}

	
	
	
	@Override
	public UserList getUserByUserName(String user) {
		/*User u=sf.getCurrentSession().get(User.class,user);//used when serialized input required
		if(u!=null)
		{
			if(u.getPassword().equals(password))
				return u;
		}
		return null;*/
		String jpql="select u from UserList u where u.userName = :um and u.flag = 'Y'";
		return sf.getCurrentSession().createQuery(jpql, UserList.class).
				setParameter("um", user).
				getSingleResult();
	}

	
	public List<SocietyList> getSociety()
	{
		String jpql="select s from SocietyList s";
		return sf.getCurrentSession().createQuery(jpql, SocietyList.class).getResultList();
	}




	@Override
	public SocietyList getSocietyByName(String name) {
		String jpql="select u from SocietyList u where u.societyName = :nm";
		return sf.getCurrentSession().createQuery(jpql, SocietyList.class).setParameter("nm", name).getSingleResult();
	}

	@Override
	public String addHouse(HouseList c) {
		sf.getCurrentSession().save(c);
		return " House added successfully ";
		}


	@Override
	public List<HouseList> fetchHouses(String societyName) {
		String jpql="select new HouseList(houseId,blockNo,type,societyName,entryDate) from HouseList h where h.societyName = :sn";
		return sf.getCurrentSession().createQuery(jpql, HouseList.class).
				setParameter("sn", societyName).getResultList();
	}


	@Override
	public List<Integer> getHouseNoBySocietyName(String name) {
		System.out.println("before query");
		String jpql="select h.houseId from HouseList h where h.societyName = :sn";
		System.out.println("after query");
		return sf.getCurrentSession().createQuery(jpql, Integer.class).
				setParameter("sn", name).getResultList();
		}




	@Override
	public HouseList fetchHouseById(int houseId) {
		System.out.println("in dao fetch house");
		return sf.getCurrentSession().get(HouseList.class,houseId);
	}




	@Override
	public String addUser(UserList u) {
		sf.getCurrentSession().save(u);
		//u.setImage(u.getFirstName()+".jpg");
		return " User added successfully ";
		}




	@Override
	public List<ComplainList> fetchComplaint() {
		System.out.println("hiiiiiiii");
		String jpql="select c from ComplainList c";
		return sf.getCurrentSession().createQuery(jpql, ComplainList.class).getResultList();
	}




	@Override
	public ComplainList fetchComplaintById(int id) {
		System.out.println("in dao fetch complaint");
		return sf.getCurrentSession().get(ComplainList.class,id);
	}




	@Override
	public String updateComplaint(String reply, int id) {/*
		String jpql="update ComplainList c set c.status='solved', c.reply = :rply where complaintId = :id";
		sf.getCurrentSession().createQuery(jpql, ComplainList.class).
		setParameter("rply", reply).setParameter("id", id).executeUpdate();*/
		ComplainList cs=sf.getCurrentSession().get(ComplainList.class,id);
		cs.setReply(reply);
		cs.setStatus("solved");
		return "complaint successfully solved";
	}
	

	

	/*@Override
	public String updateVendorDetails(Vendor v) {
		//v -- deatched pojo containing updated dtls
		sf.getCurrentSession().update(v);
		return "Vendor detailsupdated successfully with ID " +v.getId();
	}

	@Override
	public Vendor getVendorDetails(int id) {
		
		return sf.getCurrentSession().get(Vendor.class, id);
	}*/

}
