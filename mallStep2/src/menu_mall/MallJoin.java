package menu_mall;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import member.Member;
import member.MemberDAO;

public class MallJoin implements MenuCommand{
	private MallController mallController;
	private MemberDAO memberDAO;
	@Override
	public void init() {
		mallController = MallController.getInstance();
		memberDAO = MemberDAO.getInstance();	
	}
	@Override
	public boolean update() {
		System.out.println("===[ ȸ������ ]===");
		System.out.println("[ȸ������] ���̵� �Է� : ");
		String id = _Main.scan.next();
		boolean check = memberDAO.checkMember(id);
		if(check == true) {
			System.out.println("[�ߺ����̵�]");		
		}
		else {
			System.out.println("[ȸ������] ��й�ȣ �Է� : ");
			String pw = _Main.scan.next();
			System.out.println("[ȸ������] �̸� �Է� : ");
			String name = _Main.scan.next();		
			int memberNumber = memberDAO.getNextNumber();
			Member member = 
					new Member(memberNumber , id , pw , name,null);		
			memberDAO.addMember(member);
			System.out.println("[ȸ������ ����]");
		}
		mallController.setNextMenu("MallMain");
		return false;
	}

}
