package menu_admin;

import java.util.ArrayList;

import _mall._Main;
import cart.Cart;
import cart.CartDAO;
import member.Member;
import member.MemberDAO;

public class AdminDAO {
	private AdminDAO() {}
	static private AdminDAO instance=new AdminDAO();
	static public AdminDAO getInstance() {
		return instance;
	}
	
	public void pickOneMember() {
		System.out.println("[찾고자 하는 회원번호를 입력하다.]");
		int sel=_Main.scan.nextInt();
		Member m=MemberDAO.getInstance().findMember(sel);
		System.out.println("[아이디 : "+m.getMemberID()+"]");
		System.out.println("[비밀번호 : "+m.getMemberPW()+"]");
		System.out.println("[이름 : "+m.getMemberName()+"]");
		System.out.println("[주문 내역 : "+m.getOrderItemList()+"]");
	}
	
	public void pickOneCart() {
		System.out.println("[찾고자 하는 회원번호를 입력하다.]");
		int sel=_Main.scan.nextInt();
		String id=MemberDAO.getInstance().findMember2(sel);
		ArrayList<Cart> oneCartList=CartDAO.getInstance().getOneCartList(id);
		CartDAO.getInstance().printOneCartList(oneCartList);
	}

}
