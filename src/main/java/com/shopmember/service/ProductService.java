package com.shopmember.service;

import java.util.List;

import com.it.domain.ProductVO;

public interface ProductService {

	public List<ProductVO> getList();
	
	public void insert(ProductVO product);
	
	public ProductVO read(ProductVO product);
	
	public void update(ProductVO product);
	
	public void delete(ProductVO product);

}
