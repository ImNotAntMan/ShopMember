package com.shopmember.myapp;

import lombok.Data;

@Data
public class OrderdetailDTO {
	private int os_code;
	private int p_code;
	private String p_name;
	private int p_price;
	private int os_cnt;
	private int os_money;	// 단가와 수량의 곱
}
