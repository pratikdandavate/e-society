package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.HouseList;
import pojos.RentHouse;
import pojos.SellHouse;
import pojos.UserList;

@Repository
public class GuestDaoImpl implements GuestDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<SellHouse> fetchSellHouse() {
		String jpql="select new SellHouse(sellId,houseId,societyName,sellPrice,entryDate) from SellHouse s";
		System.out.println("in dao SellHouse");
		return sf.getCurrentSession().createQuery(jpql, SellHouse.class).getResultList();
	}

	@Override
	public List<RentHouse> fetchRentHouse() {
		String jpql="select new RentHouse(rentId,houseId,societyName,rentPrice,entryDate) from RentHouse s";
		System.out.println("in dao rentHouse");
		return sf.getCurrentSession().createQuery(jpql, RentHouse.class).getResultList();
	}

	@Override
	public UserList fetchRentHouseByID(int id) {
		String jpql="select new UserList(userId,firstName,lastName,email,mobileNo,societyName)  from UserList u  where u.userId = :id";
		System.out.println("in dao fetch house");
		return sf.getCurrentSession().createQuery(jpql, UserList.class).
				setParameter("id", id).getSingleResult();

		/*System.out.println("in dao fetch house by id");
		return sf.getCurrentSession().get(UserList.class,id);*/
	}
}










