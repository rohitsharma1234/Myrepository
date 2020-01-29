package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cts.controller.Product;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	
	ProductDao pdao;
	public int AddProduct(Product product) {
		   return pdao.AddProduct(product);
	}
	public Product getById(int Id) {
		
		return pdao.getByID(Id);
	}
	
	
}
