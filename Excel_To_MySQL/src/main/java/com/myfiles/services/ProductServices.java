package com.myfiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myfiles.dao.ProductRepository;
import com.myfiles.entity.Product;
import com.myfiles.helper.MyExcelHelper;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;

	public void save(MultipartFile file) {
		try {

			List<Product> products = MyExcelHelper.convertExcelToListOfProduct(file.getInputStream());
			this.productRepository.saveAll(products);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

}
