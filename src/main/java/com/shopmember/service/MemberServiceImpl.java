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
	public Boolean auth(MemberVO member) {
		MemberVO tmp;
		tmp = mapper.read(member);
		if(tmp != null) {	// 아이디가 틀린 경우.
			if(member.getM_passwd().equals(tmp.getM_passwd())) {
				log.info(tmp);
				log.info(member);
				log.info("인증 성공");
				return true;
			} else {	// 아이디는 이치하나 암호가 일치하지 않는 경우
				log.info(tmp);
				log.info(member);
				log.info("아이디는 동일하나 암호가 틀림");
				return false;
			}
		} else {	// 아이디가 존재하는 경우
			log.info(member);
			log.info("아이디가 존재하지 않음.");
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
