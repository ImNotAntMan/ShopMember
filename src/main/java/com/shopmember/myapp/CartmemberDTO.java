package com.shopmember.myapp;

import lombok.Data;

@Data
public class CartmemberDTO { 
	private int cm_code;
	private String m_id;
	private String m_name;
	private int cm_total;
}
