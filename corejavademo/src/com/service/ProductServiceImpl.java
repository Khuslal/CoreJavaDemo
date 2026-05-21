package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductServiceImpl implements ProductService {

	static List<Product> plist = new ArrayList<>();

	@Override
	public void addProduct(Product pd) {
		plist.add(pd);
		System.out.println("Product added successfully. List Size ="+plist.size());
	}

	@Override
	public void deleteProduct(int index) {
		plist.remove(index);
		System.out.println("Product at index "+index+" is deleted successfully");
	}

	@Override
	public List<Product> getAllProducts(){
		return plist;
	}
}
