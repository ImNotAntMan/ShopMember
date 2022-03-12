package com.shopmember.myapp;

import lombok.Data;

@Data
public class PageDTO {
	private int pageNum;
	private int pageAmount;
	
	public PageDTO() {
		this(1, 10);
	}
	
	public PageDTO(int pageNum, int pageAmount) {
		this.pageNum = pageNum;
		this.pageAmount =  pageAmount;
	}
}
