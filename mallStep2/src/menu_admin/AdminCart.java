package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import cart.CartDAO;
import controller.MallController;

public class AdminCart implements MenuCommand {

	private CartDAO cartDAO;
	private MallController mallController;

	@Override
	public void init() {
		cartDAO = CartDAO.getInstance();
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("=== ��ٱ��� ������ ===");
		cartDAO.printAllCartList();
		System.out.println("[1.�˻�] [0.�����ڸ���]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("AdminMain");
		}else if(select == 1){
			AdminDAO.getInstance().pickOneCart();
		}else {
			return true;
		}
		return false;
	}

}
