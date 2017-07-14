package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory 
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//create query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		
		// execute query and get result list
		List<Customer> customers= theQuery.getResultList();
		// return the results
		return customers;
	}
	@Override
	public void saveCustomer(Customer customer){
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(customer);
	}
	@Override
	public Customer getCustomer(int theID) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, theID) ;
		//use theID to read/retrive the record
		
		return theCustomer;
	} 

}
