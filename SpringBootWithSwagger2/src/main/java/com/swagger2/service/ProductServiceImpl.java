package com.swagger2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagger2.entity.Product;
import com.swagger2.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public void loadProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public List<Product> getListOfProduct() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findByproductId(Integer id) {
		return productRepository.findById(id);
	}

	@Override
	public void deleteByProductId(Integer id) {
		productRepository.deleteById(id);

	}

	@Override
	public void updateproduct(Product product) {
		productRepository.save(product);
	}

}
