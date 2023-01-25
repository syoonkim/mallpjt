package menu_member;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class MemberMain implements MenuCommand{
	private MallController mallController;
	@Override
	public void init() {
		mallController = MallController.getInstance();
	}
	@Override
	public boolean update() {
		System.out.println("===[ ���θ� ]===");
		System.out.println("[1.����] [2.��ٱ���] "
				+ "[3.�Խ���] [4.�ڱ�����] [0.����ȭ��] ");
		int select = _Main.scan.nextInt();
		if(select == 0) {		
			mallController.setNextMenu("MemberMain");
		}else if(select == 1) {
			mallController.setNextMenu("MemberShop");
		}else if(select == 2) {
			
		}else if(select == 3) {	
			System.out.println("[�����ϱ�]");
		}else if(select == 4) {
			System.out.println("[�����ϱ�]");
		}		else {
			return true;
		}
		return false;
	}

}