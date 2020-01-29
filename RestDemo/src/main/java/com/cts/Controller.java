package com.cts;

import org.springframework.web.bind.annotation.RestController;

//import com.cts.controller.Product;
//import com.cts.controller.Product;
import com.fasterxml.jackson.annotation.JsonFormat.Value;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
public class Controller {
	private static final String Id = null;
	/* Map<Integer,Product> hm=new HashMap();
	List<Product> li=new ArrayList<>();
	
	public Controller() {
		
	hm.put(122,new Product(456,"name",4,4566f));
	hm.put(234,new Product(345,"name1",45,567) );
	li.add(new Product(345,"manish",456,5676));
	li.add(new Product(456,"my",456,675));
	
	}
     @RequestMapping("/aaa")
	public Map str() {
		return hm;
	}
     @RequestMapping("/jsondata")
	public List str1() {
		return li; */
	ProductService pserv;
	@RequestMapping(value="/product", method=RequestMethod.POST,produces="application/json")
	public int AddProduct(@RequestBody Product product) {
		return pserv.AddProduct(product);
	}
	@RequestMapping(value="/getById/{Id}",method=RequestMethod.GET)
	public ResponseEntity<Product> getById(@PathVariable("Id") int Id) {
		Product product = pserv.getById(Id);
		if(product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	}

