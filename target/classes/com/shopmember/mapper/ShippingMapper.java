package com.shopmember.mapper;

import java.util.List;

import com.shopmember.myapp.ShippingVO;

public interface ShippingMapper {

	public List<ShippingVO> getList(ShippingVO shipping);
	
	public ShippingVO read(ShippingVO shipping);
	
	public void insert(ShippingVO shipping);
	
	public void update(ShippingVO shipping);
	
	public void delete(ShippingVO shipping);
	
	public int getTotalCount(ShippingVO shipping);
}
