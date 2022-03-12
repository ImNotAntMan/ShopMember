package com.shopmember.service;

import java.util.List;

import com.shopmember.myapp.MemberVO;
import com.shopmember.myapp.PageDTO;

public interface MemberService {
	public MemberVO read(MemberVO member);	// 단일 레코드 조회
	
	public MemberVO read(String m_id);
	
	public Boolean auth(MemberVO member);	// 아이디와 암호를 전달하여 인증 처리 T or F
	
	public void insert(MemberVO member);	// 레코드 입력
	
	public List<MemberVO> getList(PageDTO page);	// 레코드 리스트
	
	public void update(MemberVO member);	// 수정
	
	public void delete(MemberVO member);	// 삭제

	public int getTotalCount();
}
