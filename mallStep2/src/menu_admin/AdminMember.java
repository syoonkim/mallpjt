package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import member.MemberDAO;

public class AdminMember implements MenuCommand{
	private MallController mallController;
	private MemberDAO mamberDAO;
	@Override
	public void init() {
		mallController = MallController.getInstance();	
		mamberDAO = MemberDAO.getInstance();
	}
	@Override
	public boolean update() {
		System.out.println("=== ȸ�� ������ ===");
		mamberDAO.printAllMemberList();
		System.out.println("[1.ȸ�� �˻�] [0.�����ڸ���]");
		int select = _Main.scan.nextInt();
		if(select == 0) {
			mallController.setNextMenu("AdminMain");
		}else if(select == 1) {
			AdminDAO.getInstance().pickOneMember();
		}else {
			return true;
		}
		return false;
	}

}
