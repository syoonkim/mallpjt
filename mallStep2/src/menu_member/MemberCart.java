package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;

public class MemberCart implements MenuCommand{
	private MallController mallController;
	private CartDAO cartDAO;
	@Override
	public void init() {
		cartDAO = CartDAO.getInstance();
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		ArrayList<Cart> oneCartList = 
				cartDAO.getOneCartList(mallController.getMemberLoginID());
		cartDAO.printOneCartList(oneCartList);
		System.out.println("===[��ٱ��ϰ���]===");
		
		System.out.println("[1.����] [2.����] [0.���θ�]");
		int sel = _Main.scan.nextInt();
		if(sel == 0) {
			mallController.setNextMenu("MemberMain");
		}
		else if(sel == 1) {
			cartDAO.purchaseOneCartListItem(oneCartList);
		}else if(sel == 2) {
			cartDAO.removeOneCartListItem();
		}
		return false;
	}

}
