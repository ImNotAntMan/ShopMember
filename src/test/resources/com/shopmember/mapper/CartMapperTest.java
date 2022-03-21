package com.shopmember.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shopmember.myapp.CartmainVO;
import com.shopmember.myapp.CartmemberDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CartMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private CartMapper mapper;
	
	@Test
	public void testCartTotal() {
		CartmemberDTO cartmember = new CartmemberDTO();
		cartmember.setM_id("tiger");
		CartmainVO cartmain = new CartmainVO();
		cartmain.setM_id("tiger");
		cartmember.setCm_total(mapper.getCartTotal(cartmain));
		log.info(cartmember);
	
		
//		mapper.getList(pageNum, pageAmount, m_id).forEach(board -> log.info(board));
	}
	//@Test
	public void testDeleteSub() {
		CartmainVO cartmain = new CartmainVO();
		cartmain.setCm_code(1014);
		mapper.deleteSub(cartmain);
		mapper.deleteMain(cartmain);
	}
}
