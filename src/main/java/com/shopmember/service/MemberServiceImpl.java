package com.shopmember.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopmember.mapper.MemberMapper;
import com.shopmember.myapp.MemberVO;
import com.shopmember.myapp.PageDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public MemberVO read(MemberVO member) {
		return mapper.read(member);
	}
	
	@Override
	public MemberVO read(String m_id) {
		return mapper.read(m_id);
	}
	
	@Override
	public Boolean auth(MemberVO member) {
		MemberVO tmp;
		tmp = mapper.auth(member);
		log.info(tmp);
		log.info("________________________");
		if(tmp != null) {	// 인증 성공
			log.info(tmp);
			log.info("인증 성공");
			return true;
		} else {	// 일치하지 않는 경우
			log.info(tmp);
			log.info("틀림");
			return false;
		}
	}
	
	@Override
	public void insert(MemberVO member) {
		mapper.insert(member);
	}
	
	@Override
	public List<MemberVO> getList(PageDTO page) {
		return mapper.getList(page);
	}
	
	@Override
	public void update(MemberVO member) {
		mapper.update(member);
	}
	
	@Override
	public void delete(MemberVO member) {
		mapper.delete(member);
	}

	@Override
	public int getTotalCount() {
		return mapper.getTotalCount();
	}
}
