package com.ojas.service;

import java.util.List;

import com.ojas.entity.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	List getAllProduct();
	Product getProductById(int productId);
	String deleteProductById(int productId);
	Product updateProduct(int productId,Product product);

}
