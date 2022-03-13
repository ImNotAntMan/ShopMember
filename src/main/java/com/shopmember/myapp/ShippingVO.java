package com.shopmember.myapp;

import java.util.Date;

import lombok.Data;

@Data
public class ShippingVO {
	private int s_num;
	private String m_id;
	private String s_zipcode;
	private String s_address01;
	private String s_address02;
	private Date s_rdate;
	private Date s_udate;
}
