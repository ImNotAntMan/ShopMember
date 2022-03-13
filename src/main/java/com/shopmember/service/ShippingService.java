package com.shopmember.service;

import java.util.List;

import com.shopmember.myapp.ShippingVO;

public interface ShippingService {

	public List<ShippingVO> getList(ShippingVO shipping); // 사용자의 배송지만 뽑아와야지!!!
	
	public ShippingVO read(ShippingVO shipping); // shipping에 m_id가 있음....
	
	public void insert(ShippingVO shipping);
	
	public void update(ShippingVO shipping);
	
	public void delete(ShippingVO shipping);
	
	public int getTotalCount(ShippingVO shipping);
}
