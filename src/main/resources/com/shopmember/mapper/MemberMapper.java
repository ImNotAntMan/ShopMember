package com.shopmember.mapper;

import java.util.List;

import com.shopmember.myapp.MemberVO;
import com.shopmember.myapp.PageDTO;

public interface MemberMapper {

	public List<MemberVO> getList(PageDTO page);
	
	public void insert(MemberVO member);
	
	public MemberVO read(MemberVO member);
	
	public MemberVO auth(MemberVO member);
	
	public void update(MemberVO member);
	
	public void delete(MemberVO member);
	
	public int getTotalCount();

	public MemberVO read(String m_id);
}
