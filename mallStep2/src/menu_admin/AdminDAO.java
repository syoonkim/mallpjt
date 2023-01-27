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
		System.out.println("[ã���� �ϴ� ȸ����ȣ�� �Է��ϴ�.]");
		int sel=_Main.scan.nextInt();
		Member m=MemberDAO.getInstance().findMember(sel);
		System.out.println("[���̵� : "+m.getMemberID()+"]");
		System.out.println("[��й�ȣ : "+m.getMemberPW()+"]");
		System.out.println("[�̸� : "+m.getMemberName()+"]");
		System.out.println("[�ֹ� ���� : "+m.getOrderItemList()+"]");
	}
	
	public void pickOneCart() {
		System.out.println("[ã���� �ϴ� ȸ����ȣ�� �Է��ϴ�.]");
		int sel=_Main.scan.nextInt();
		String id=MemberDAO.getInstance().findMember2(sel);
		ArrayList<Cart> oneCartList=CartDAO.getInstance().getOneCartList(id);
		CartDAO.getInstance().printOneCartList(oneCartList);
	}

}
