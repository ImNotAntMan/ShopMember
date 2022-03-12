package com.shopmember.myapp;

import lombok.Data;

@Data
public class PageViewDTO {
	private int startPage;
	private int endPage;
	private int realend;
	private boolean prev;
	private boolean next;
	
	private int total;
	PageDTO page;	// 입력된 page로 나머지 변수를 계산
	
	public PageViewDTO(PageDTO page, int total) {
		this.page = page;
		this.total = total;
		
		this.endPage = (int)Math.ceil(this.page.getPageNum() / 10.0) * 10;
		this.startPage = this.endPage - 10 + 1;
		this.realend = (int)Math.ceil(total / (double)page.getPageAmount());	// 살제 마지막 페이지 번호
		if(this.realend < this.endPage) {
			this.endPage = this.realend;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realend; 
	}
}
