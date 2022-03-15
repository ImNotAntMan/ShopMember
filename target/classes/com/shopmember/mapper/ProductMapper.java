package com.shopmember.mapper;

import java.util.List;

import com.shopmember.myapp.ProductVO;

public interface ProductMapper {
	
	public List<ProductVO> getList();
	
	public void insert(ProductVO product);
	
	public ProductVO read(ProductVO product);
	
	public void update(ProductVO product);
	
	public void delete(ProductVO product);
	
}
