package com.myfiles.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myfiles.entity.Product;
import com.myfiles.helper.MyExcelHelper;
import com.myfiles.services.ProductServices;

@RestController
public class ProductController {

	@Autowired
	private ProductServices productServices;
	
	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		if (MyExcelHelper.checkExcelFormat(file)) {
			
			this.productServices.save(file);
			return ResponseEntity.ok(Map.of("message","File uploaded and saved to DB."));
		} 
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file!");
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return this.productServices.getAllProducts();
	}
	
}
