package com.shopmember.myapp;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shopmember.mapper.ShippingMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ShippingMapperTest {

	@Setter(onMethod_ = @Autowired)
	private ShippingMapper mapper;
	
	//@Test
	public void testGetList() { // shipping.m_id, page.PageAmount, page.PageNum 넘겨서 리스트를 받아오는 테스트
		ShippingVO shipping = new ShippingVO();
		PageDTO page = new PageDTO();
		page.setPageAmount(10);
		page.setPageNum(1);
		shipping.setM_id("lion");
//		log.info(shipping);
//		shipping = mapper.read(shipping);
//		mapper.getList(shipping);
		log.info(mapper.getList(shipping));
	}
}
