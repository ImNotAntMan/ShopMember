package com.shopmember.myapp;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String m_id;
	private String m_name;
	private String m_passwd;
	private Date m_rdate;
	private Date m_udate;
}
