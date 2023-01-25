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
		System.out.println("===[ 회원가입 ]===");
		System.out.println("[회원가입] 아이디 입력 : ");
		String id = _Main.scan.next();
		boolean check = memberDAO.checkMember(id);
		if(check == true) {
			System.out.println("[중복아이디]");		
		}
		else {
			System.out.println("[회원가입] 비밀번호 입력 : ");
			String pw = _Main.scan.next();
			System.out.println("[회원가입] 이름 입력 : ");
			String name = _Main.scan.next();		
			int memberNumber = memberDAO.getNextNumber();
			Member member = 
					new Member(memberNumber , id , pw , name);		
			memberDAO.addMember(member);
			System.out.println("[회원가입 성공]");
		}
		mallController.setNextMenu("MallMain");
		return false;
	}

}
