package member;

import java.util.ArrayList;

import controller.MallController;
import item.Item;

public class MemberDAO {
	private MemberDAO() {}
	static private MemberDAO instance=  new MemberDAO();
	static public MemberDAO getInstance() {
		return instance;
	}
	
	ArrayList<Item> orderItemList=new ArrayList<Item>();
	private ArrayList<Member> memberList;
	private int memberNumber;
	
	public void init() {
		memberNumber = 1000;
		memberList = new ArrayList<>();
		setSampleData();
	}

	public void addMember(Member member) {
		memberList.add(member);
	}
	
	public int getNextNumber() {
		memberNumber += 1;
		return memberNumber;
	}
	
	public boolean checkMember(String id) {
		for (int i = 0; i < memberList.size(); i++) {
			if (id.equals(memberList.get(i).getMemberID())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkMemberLogin(String id, String pw) {
		for (int i = 0; i < memberList.size(); i++) {
			if (id.equals(memberList.get(i).getMemberID()) && 
					pw.equals(memberList.get(i).getMemberPW())) {
				return true;
			}
		}
		return false;
	}
	
	public void printAllMemberList() {
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println(i + 1 + ") " + memberList.get(i));
		}
	}

	
	public void setSampleData() {
		Member member = 
				new Member(getNextNumber(), "admin", "admin", "관리자",null);
		addMember(member);		
		member = new Member(getNextNumber(), "a", "a", "김철민",null);
		addMember(member);
		member = new Member(getNextNumber(), "b", "b", "이민영",null);
		addMember(member);
	}
	
	public void initOrderList(String id) {
		int idx=-1;
		for(int i=0;i<memberList.size();i++) {
			if(memberList.get(i).getMemberID().equals(id)) idx=i;
		}
		memberList.get(idx).setOrderItemList(new ArrayList<Item>());
	}
	
	public void addOrderList(Item it, String id) {
		int idx=-1;
		for(int i=0;i<memberList.size();i++) {
			if(memberList.get(i).getMemberID().equals(id)) idx=i;
		}
		memberList.get(idx).getOrderItemList().add(it);
	}
	
	
	public void printOrderList() {
		int idx=-1;
		String curId=MallController.getInstance().getMemberLoginID();
		System.out.println("===[주문내역]===");
		for(int i=0;i<memberList.size();i++) {
			if(memberList.get(i).getMemberID().equals(curId)) idx=i;
		}
		System.out.println(memberList.get(idx).getOrderItemList());
	}
	
	public void checkOrderHistory(String curId) {
		int idx=-1;
		for(int i=0;i<memberList.size();i++) {
			if(memberList.get(i).getMemberID().equals(curId)) idx=i;
		}
		int size=memberList.get(idx).getOrderItemList().size();
		if(size==0) {
			System.out.println("주문 내역이 존재하지 않는다.");
			return;
		}
		printOrderList();
	}
	
	public Member findMember(int num) {
		Member m=null;
		for (int i = 0; i < memberList.size(); i++) {
			if (num==memberList.get(i).getMemberNumber()) {
				m=memberList.get(i);
			}
		}
		return m;
	}
	
	public String findMember2(int num) {
		String id=null;
		for (int i = 0; i < memberList.size(); i++) {
			if (num==memberList.get(i).getMemberNumber()) {
				id=memberList.get(i).getMemberID();
			}
		}
		return id;
	}
}
