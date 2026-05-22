package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class Test {
	// Declare it as "static" once here so all methods share the exact same service reference
	static ProductService service = new ProductServiceImpl();

	public static void main(String[] args) {
		add();
		getAll();
		delete();

	}

	// add
	static void add() {
		/*
		 * As ProductService is static at the very top this main class, we don't require
		 * the below declaration
		 */
		// ProductService service = new ProductServiceImpl();
		Scanner scn = new Scanner(System.in);

		char flag = 'y';
		do {
			Product pd = new Product();
			System.out.println("Enter Product ID :");
			pd.setId(Integer.parseInt(scn.nextLine()));

			System.out.println("Enter Product Name :");
			pd.setName(scn.nextLine());

			System.out.println("Enter Product Company :");
			pd.setCompany(scn.nextLine());

			System.out.println("Enter Product Price :");
			pd.setPrice(Integer.parseInt(scn.nextLine()));

			service.addProduct(pd);
			System.out.println("Do you want to continue? [y/n]");
			flag = scn.nextLine().charAt(0);
		} while (flag == 'y');
		scn.close();
	}

	// get all
	static void getAll() {
		/*
		 * As ProductService is static at the very top this main class, we don't require
		 * the below declaration
		 */
		// ProductService service = new ProductServiceImpl();
		List<Product> plist = service.getAllProducts();
		System.out.println(plist);
	}

	// delete
	static void delete() {
		/*
		 * As ProductService is static at the very top this main class, we don't require
		 * the below declaration
		 */
		// ProductService service = new ProductServiceImpl();
		service.deleteProduct(0); // index = 0
		// get all products after deleted
		getAll();
	}
}
