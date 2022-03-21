package com.shopmember.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shopmember.myapp.PageDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ShippingMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private ShippingMapper mapper;
	
	//@Test
	public void testGetList() {
		PageDTO page = new PageDTO();
		page.setPageAmount(10);
		page.setPageNum(1);
		int pageNum = 1;
		int pageAmount = 10;
		String m_id = "lion";
	
		mapper.getList(pageNum, pageAmount, m_id).forEach(board -> log.info(board));
	}	
}
