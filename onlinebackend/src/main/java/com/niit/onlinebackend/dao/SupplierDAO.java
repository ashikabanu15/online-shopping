package com.niit.onlinebackend.dao;

import java.util.List;

import com.niit.onlinebackend.model.*;

public interface SupplierDAO 
{
	// get all categories -list
	public List<Supplier> list();

	// create category
	public boolean save(Supplier supplier);

	// update category
	public boolean update(Supplier supplier);

	// delete category
	public boolean delete(String id);

	// get category by id
	public Supplier getSupplierByID(String id);

	// get category by name
	public Supplier getSupplierByName(String name);

}
