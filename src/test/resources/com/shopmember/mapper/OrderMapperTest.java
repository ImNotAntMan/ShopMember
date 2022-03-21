package com.shopmember.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shopmember.myapp.OrdermainVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OrderMapperTest { 
	
	@Setter(onMethod_ = @Autowired)
	private OrderMapper mapper;
	
	//@Test
	public void testGetListOrder() {
		OrdermainVO ordermain = new OrdermainVO();
		ordermain.setM_id("tiger");
		mapper.getListOrder(ordermain).forEach(board -> log.info(board));
	}
}
