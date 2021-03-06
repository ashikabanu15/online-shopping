package com.niit.onlinebackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.onlinebackend.dao.SupplierDAO;
import com.niit.onlinebackend.model.*;

@Repository("supplierDAO")
@Transactional

public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<Supplier> list() 
	{
		return sessionFactory.getCurrentSession().createQuery("from category").list();
	}
	public boolean save(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(supplier);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	
	}
	public boolean update(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean delete(String id) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(getSupplierByID(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Supplier getSupplierByID(String id) 
	{
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}
	@SuppressWarnings("deprecation")
	public Supplier getSupplierByName(String name) 
	{
		return  (Supplier) sessionFactory.getCurrentSession().createQuery("from supplier where name=?").setString(0,name).uniqueResult();
		
	}
}
