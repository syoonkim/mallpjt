package menu_member;

import _mall.MenuCommand;
import _mall._Main;
import cart.CartDAO;
import controller.MallController;
import member.MemberDAO;

public class MemberInfo implements MenuCommand {
	private MallController mallController;
	private CartDAO cartDAO;
	
	@Override
	public void init() {
		cartDAO=CartDAO.getInstance();
		mallController=MallController.getInstance();
	}

	@Override
	public boolean update() {
		String id=mallController.getMemberLoginID();
		System.out.println("===[ "+id+" ]===");
		System.out.println("[1]�ֹ� ���� Ȯ��\n[2]��ٱ��� ��� Ȯ��\n[3]�ڷΰ���");
		int sel=_Main.scan.nextInt();
		if(sel==1) MemberDAO.getInstance().checkOrderHistory(id);
		else if(sel==2) mallController.setNextMenu("MemberCart");
		else if(sel==3) mallController.setNextMenu("MemberMain");
		
		return false;
	}

}
