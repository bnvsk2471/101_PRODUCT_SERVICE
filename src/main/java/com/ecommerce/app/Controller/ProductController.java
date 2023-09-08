package com.ecommerce.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.ecommerce.app.Entity.Product;
import com.ecommerce.app.Model.ProductRequest;
import com.ecommerce.app.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/post")
	public ResponseEntity<Long> addProduct(
			@RequestBody ProductRequest productRequest){
		long productId=productService.addProduct(productRequest);
		return new ResponseEntity<Long>(productId,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductById(
			@PathVariable long id){
		Product getProduct= productService.getProductbyId(id);
		return new ResponseEntity<Product>(getProduct,HttpStatus.OK);
	}
	
	@PutMapping("/reducequantity/{id}")
	public ResponseEntity<Void> reduceQuantity(
			@PathVariable("id") long productid,
			@RequestParam long quantity){
		productService.reduceQuantity(productid,quantity);	
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
