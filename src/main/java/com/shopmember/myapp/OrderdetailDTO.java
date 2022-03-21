package com.shopmember.myapp;

import java.util.Date;

import lombok.Data;

@Data
public class OrderdetailDTO { 
	private int os_code;
	private int p_code; 
	private int om_code;
	private String p_name;
	private int p_price;
	private int os_cnt;
	private int os_money;	// 단가와 수량의 곱
	private int total;
	private Date om_rdate;
}
