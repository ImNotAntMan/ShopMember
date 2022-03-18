package com.shopmember.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopmember.myapp.ShippingVO;

public interface ShippingMapper {

	public List<ShippingVO> getList(@Param("pageNum") int pageNum, @Param("pageAmount") int pageAmount, @Param("m_id") String m_id);
	
	public ShippingVO read(ShippingVO shipping);
	
	public void insert(ShippingVO shipping);
	
	public void update(ShippingVO shipping);
	
	public void delete(ShippingVO shipping);
	
	public int getTotalCount(ShippingVO shipping);
	
	public ShippingVO readnum(ShippingVO shipping);
}

