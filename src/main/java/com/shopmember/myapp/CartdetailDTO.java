package com.shopmember.myapp;

import lombok.Data;

@Data
public class CartdetailDTO {
	private int cs_code;
	private int p_code;
	private String p_name;
	private int p_price;
	private int cs_cnt;
	private int cs_money;	// 단가와 수량의 곱
	private int cm_code;
}