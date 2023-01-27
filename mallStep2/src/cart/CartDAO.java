package cart;

import java.util.ArrayList;

import _mall._Main;
import controller.MallController;
import item.Item;
import item.ItemDAO;
import member.MemberDAO;


public class CartDAO {
	
	private CartDAO() {}
	static private CartDAO instance=  new CartDAO();
	static public CartDAO getInstance() {
		return instance;
	}

	private ArrayList<Cart> cartList;
	private int cartNumber;

	public void init() {
		cartList = new ArrayList<Cart>();
		cartNumber = 1000;
	}

	public int getCartNumber() {
		cartNumber += 1;
		return cartNumber;
	}

	public void insertCart(Cart cart) {
		cartList.add(cart);
	}

	public ArrayList<Cart> getOneCartList(String memberLoginID) {
		ArrayList<Cart> oneCartList = new ArrayList<Cart>();
		for (int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getMemberID().equals(memberLoginID)) {
				oneCartList.add(cartList.get(i));
			}
		}
		return oneCartList;
	}
	
	public void printOneCartList(ArrayList<Cart> oneCartList) {
		for (int i = 0; i < oneCartList.size(); i++) {
			System.out.println(i + 1 + ")" + oneCartList.get(i));
		}
	}
	
	public void printAllCartList() {
		for (int i = 0; i < cartList.size(); i++) {
			System.out.println(i + 1 + ")" + cartList.get(i));
		}
	}
	
	public void purchaseOneCartListItem(ArrayList<Cart> oneCartList) {
		
		if(oneCartList.size()==0) {
			System.out.println("[��ٱ��ϰ� �����.]");return;
		}
		
		
		int cnt=0;
		for(Cart c:oneCartList) {
			cnt+=c.getItemPrice();
		}		
		System.out.println("["+oneCartList.size()+"�� ǰ�� ��"+cnt+"�� ���� �Ϸ�.]");
		
		MemberDAO.getInstance().initOrderList(MallController.getInstance().getMemberLoginID());
		for(Cart c : oneCartList) {
			 Item i = ItemDAO.getInstance().getItem(c.getItemName());
			 MemberDAO.getInstance().addOrderList(i, MallController.getInstance().getMemberLoginID());
		}
		
		for(int i=0;i<oneCartList.size();i++) {
			for(int j=0;j<cartList.size();j++) {
				if(oneCartList.get(i).getNumber()==cartList.get(j).getNumber()) cartList.remove(j);
			}
		}
	}
	
	public void removeOneCartListItem() {
		System.out.println("[��ٱ��Ͽ��� ������ ��ǰ�� ��ȣ�� �Է��ϴ�.]");
		int del=_Main.scan.nextInt();
		int idx=-1;
		for(int i=0;i<cartList.size();i++) {
			if(cartList.get(i).getNumber()==del) idx=i;
		}
		if(idx==-1) {
			System.out.println("[�������� �ʴ� ��ȣ.]");
			return;
		}
		else {
			cartList.remove(idx);
			System.out.println("["+del+"�� ��ٱ��Ͽ��� ��ǰ ���� �Ϸ�.]");
		}
	}
	
	
	
}
