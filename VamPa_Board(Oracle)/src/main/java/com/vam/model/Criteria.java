package com.vam.model;




public class Criteria {

	/* 현재 페이지 */
    private int pageNum;
    
    /* 한 페이지 당 보여질 게시물 갯수 */
    private int amount;
    
    /* 기본 생성자 -> 기봅 세팅 : pageNum = 1, amount = 10 */
    public Criteria() {

        this(1,10);	// this는 이 클래스로 만들어진 인스턴스 그놈	
        			// this() : 클래스이름에 괄호를 열고 닫고있으니 생성자
        			// 생성자인데 인자가 2개 있으니까 밑의 생성자
        			// 아무 인자를 전달하지 않므면 기본생성자로 객체를 만들고
        			// 1페이지에 10개 보이기
    }
    
    /* 생성자 => 원하는 pageNum, 원하는 amount */
    
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
}
