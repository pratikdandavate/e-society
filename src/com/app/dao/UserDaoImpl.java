package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.ComplainList;
import pojos.RentHouse;
import pojos.SellHouse;
import pojos.UserList;



@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sf;

	
	
	@Override
	public UserList getUserEntityByUser(String user) {
		/*User u=sf.getCurrentSession().get(User.class,user);//used when serialized input required
		if(u!=null)
		{
			if(u.getPassword().equals(password))
				return u;
		}
		return null;*/
//		CriteriaBuilder criteriaBuilder = sf.getCriteriaBuilder();
//		CriteriaQuery<UserList> criteriaQuery = criteriaBuilder.createQuery(UserList.class);
//		Root<UserList> userEntity = criteriaQuery.from(UserList.class);
//
//		criteriaQuery.select(userEntity).where(criteriaBuilder.equal(userEntity.get("email"),user));
		String jpql="select u from UserList u where u.userName = :um and u.flag = 'N'";
		return sf.getCurrentSession().createQuery(jpql, UserList.class).
				setParameter("um", user).getSingleResult();
	}



	@Override
	public UserList getHouseById(int rentId) {
		System.out.println("in dao fetch house");
		return sf.getCurrentSession().get(UserList.class,rentId);
	}



	@Override
	public String addRentHouse(RentHouse hs) {
		sf.getCurrentSession().save(hs);
		return " Rent house added successfully ";
	}



	@Override
	public String addSellHouse(SellHouse hs) {
		sf.getCurrentSession().save(hs);
		return " Sell house added successfully ";
	}



	@Override
	public String makeComplaint(ComplainList c) {
		sf.getCurrentSession().save(c);
		return " Complaint added successfully ";
	}

	@Override
	public List<ComplainList> fetchComplaint(int id) {
		System.out.println("in fetch complaint");
		String jpql="select c from ComplainList c where c.userId = :uid";
		return sf.getCurrentSession().createQuery(jpql, ComplainList.class).
				setParameter("uid", id).getResultList();
	}


	
	





}
