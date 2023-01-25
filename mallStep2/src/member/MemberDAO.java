package member;

import java.util.ArrayList;


public class MemberDAO {
	private MemberDAO() {}
	static private MemberDAO instance=  new MemberDAO();
	static public MemberDAO getInstance() {
		return instance;
	}
	
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
				new Member(getNextNumber(), "admin", "admin", "°ü¸®ÀÚ");
		addMember(member);		
		member = new Member(getNextNumber(), "a", "a", "±èÃ¶¹Î");
		addMember(member);
		member = new Member(getNextNumber(), "b", "b", "ÀÌ¹Î¿µ");
		addMember(member);
	}
}
