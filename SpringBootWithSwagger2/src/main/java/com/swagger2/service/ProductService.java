package com.swagger2.service;

import java.util.List;
import java.util.Optional;

import com.swagger2.entity.Product;

public interface ProductService {

	public void loadProduct(Product product);

	public List<Product> getListOfProduct();

	Optional<Product> findByproductId(Integer id);

	public void deleteByProductId(Integer id);

	public void updateproduct(Product product);

}
