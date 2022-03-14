package com.shopmember.myapp;

import java.util.Date;

import lombok.Data;

@Data
public class CartmainVO {
	private int cm_code;
	private String m_id;
	private Date cm_rdate;
	private Date cm_udate;
}
