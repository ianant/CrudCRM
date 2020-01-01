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
	public List<Customer> getCustomers() {
		
		//create a session object
		Session session=sessionFactory.getCurrentSession();
		
		
		//create a hibernate query to fetch customer from database
		Query query=session.createQuery("from Customer order by firstName");
		
		
		//store the result 
		List<Customer> theCustomers=query.getResultList();
		
		
		//return result
		return theCustomers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theID) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		Customer theCustomer=session.get(Customer.class,theID);
		
		return theCustomer;
	}

	@Override
	public void delete(int theID) {
		Session session=sessionFactory.getCurrentSession();
		
		Query newQuery=session.createQuery("delete from Customer where id=:customerID");
		
		newQuery.setParameter("customerID", theID);
		
		newQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String theSearchedName) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query theQuery=null;
		
		if(theSearchedName!=null && theSearchedName.trim().length()>0) {
			theQuery=currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName",Customer.class);
			theQuery.setParameter("theName", "%"+theSearchedName.toLowerCase()+"%");
			
		}
		else {
			theQuery=currentSession.createQuery("from Customer",Customer.class);
			
		}
		List <Customer> theCustomers=theQuery.getResultList();
		
		return theCustomers;
	}

	
		
		
	

}
