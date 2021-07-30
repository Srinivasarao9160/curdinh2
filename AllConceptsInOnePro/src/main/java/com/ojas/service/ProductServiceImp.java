package com.ojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.Product;
import com.ojas.exception.ProductAlreadyExit;
import com.ojas.exception.ProductIdNotFound;
import com.ojas.repository.ProductRepo;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product saveProduct(Product product) throws ProductAlreadyExit {
		if (productRepo.existsById(product.getProductId())) {
			throw new ProductAlreadyExit();
		}
		Product pro = productRepo.save(product);
		return pro;
	}

	@Override
	public List getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(int productId) throws ProductIdNotFound {
		if (productRepo.findById(productId).isEmpty()) {
			throw new ProductIdNotFound();
		}
		Product product = productRepo.findById(productId).get();
		return product;
	}

	@Override
	public String deleteProductById(int productId) throws ProductIdNotFound {
		if (productRepo.findById(productId).isEmpty()) {
			throw new ProductIdNotFound();

		}
		productRepo.deleteById(productId);
		return "deleted" + productId;
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Product orginal = productRepo.findById(productId).orElse(new Product());
		orginal.setProductCost(product.getProductCost());
		orginal.setProductName(product.getProductName());

		return productRepo.save(orginal);
	}

}

//	@Override
//	public Product saveProduct(Product product) {
//		return productRepo.save(product);
//			}
