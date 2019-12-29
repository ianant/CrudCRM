package com.anant.mv.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anant.mv.hibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//create a session object
		Session session=sessionFactory.getCurrentSession();
		
		
		//create a hibernate query to fetch customer from database
		Query query=session.createQuery("from Customer");
		
		
		//store the result 
		List<Customer> theCustomers=query.getResultList();
		
		
		//return result
		return theCustomers;
	}

}
