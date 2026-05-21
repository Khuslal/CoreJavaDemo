package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class Test {
	public static void main(String[] args) {
		add();
		getAll();
		delete();

	}

	// add
	static void add() {
		ProductService service = new ProductServiceImpl();
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
		ProductService service = new ProductServiceImpl();
		List<Product> plist = service.getAllProducts();
		System.out.println(plist);
	}

	// delete
	static void delete() {
		ProductService service = new ProductServiceImpl();
		service.deleteProduct(0); // index = 0
		// get all products after deleted
		getAll();
	}
}
