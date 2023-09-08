package com.ecommerce.app.Service;

import com.ecommerce.app.Entity.Product;
import com.ecommerce.app.Model.ProductRequest;

public interface ProductService {

	public long addProduct(ProductRequest productRequest);
	public Product getProductbyId(long id);
	public void reduceQuantity(long productid, long quantity);
	

}
