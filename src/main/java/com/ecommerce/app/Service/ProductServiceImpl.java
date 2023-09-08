package com.ecommerce.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.Entity.Product;
import com.ecommerce.app.Exception.ProductServiceCustomException;
import com.ecommerce.app.Model.ProductRequest;
import com.ecommerce.app.Repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest productRequest) {
		log.info("Adding Product");

		// This is the builder pattren
		Product product = Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity())
				.price(productRequest.getPrice()).build();
		productRepository.save(product);

		log.info("Product created");
		return product.getProductId();
	}

	@Override
	public Product getProductbyId(long id) {
		log.info("Get the product for product Id{}", id);
		return productRepository.findById(id).orElseThrow(
				() -> new ProductServiceCustomException("Product with given ID is not found", "PRODUCT_NOT_FOUND"));
	}

	@Override
	public void reduceQuantity(long productid, long quantity) {
		log.info("Reduce quantity {} for Id: {}", quantity, productid);

		Product product = productRepository.findById(productid)
				.orElseThrow(() -> new ProductServiceCustomException("Product with ID not found", "PRODUCT_NOT_FOUND"));
		if (product.getQuantity() < quantity) {
			throw new ProductServiceCustomException("Product does not have sufficient quantity",
					"Insufficient Quantity");
		}
		product.setQuantity(product.getQuantity() - quantity);
		productRepository.save(product);
		log.info("Product quantity updated sucessfully");
	}

}
