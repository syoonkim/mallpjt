package member;

import java.util.ArrayList;

import item.Item;

public class Member {
	private int memberNumber;
	private String memberID;
	private String memberPW;
	private String memberName;
	private ArrayList<Item> orderItemList;
	
	public Member() {}
	
	public Member(int memberNumber, String memberID, String memberPW, String memberName, ArrayList<Item> orderItemList) {
		this.memberNumber = memberNumber;
		this.memberID = memberID;
		this.memberPW = memberPW;
		this.memberName = memberName;
		this.orderItemList=orderItemList;
	}
	public ArrayList<Item> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(ArrayList<Item> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPW() {
		return memberPW;
	}
	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String toString() {
		String print = String.format("[%-6d] [%10s] [%10s] [%10s]", 
				memberNumber , memberID , memberPW , memberName);
		return print;
	}
}
