package com.ojas.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.entity.Product;
import com.ojas.service.ProductServiceImp;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImp productServiceImp;
	
    Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping("/saveproduct")
	@ApiOperation("Insert product details")
	public ResponseEntity saveProduct(@RequestBody Product product) {
		
		logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		
		
		
		Product saveproduct = productServiceImp.saveProduct(product);
		return new ResponseEntity<>(saveproduct,HttpStatus.CREATED);
		
	}
	@GetMapping("/getproducts")
	@ApiOperation("Get all products")
     public ResponseEntity<List> getproducts(){
		return new ResponseEntity<List>(productServiceImp.getAllProduct(),HttpStatus.OK);
		
	}
	@GetMapping("product/{productId}")
	@ApiOperation("Based on id get product")

	public ResponseEntity getProductById(@PathVariable int productId) {
		return new ResponseEntity(productServiceImp.getProductById(productId), HttpStatus.OK);
	
	}
	@DeleteMapping("productdelete/{productId}")
	@ApiOperation("Based on product id delete")

    public ResponseEntity deleteProduct(@PathVariable int productId) {
    	 return new ResponseEntity(productServiceImp.deleteProductById(productId),HttpStatus.OK);
    }

	@PutMapping("/update/{productId}")
	@ApiOperation("Based on id update product ")

    public ResponseEntity updatePro(@PathVariable Integer productId, @RequestBody Product product) {
        return  new ResponseEntity(productServiceImp.updateProduct(productId, product),HttpStatus.OK);
}
}
