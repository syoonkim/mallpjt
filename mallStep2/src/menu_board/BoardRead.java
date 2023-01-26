package menu_board;

import _mall.MenuCommand;
import _mall._Main;
import board.BoardDAO;
import controller.MallController;

public class BoardRead implements MenuCommand{
	private MallController mallController;
	private BoardDAO boardDAO;

	@Override
	public void init() {
		mallController=MallController.getInstance();
		boardDAO=BoardDAO.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("[조회할 게시글의 번호를 입력하다.]");
		int num=_Main.scan.nextInt();
		int mod=boardDAO.readStory(num);
		if(mod==0) {
			int sel=_Main.scan.nextInt();
			if(sel==1) {}
			else if(sel==2) {}
			else if(sel==3) mallController.setNextMenu("BoardMain");
		}
		else if(mod==1) {
			int sel=_Main.scan.nextInt();
			if(sel==1) {}
			else if(sel==2) {
				boardDAO.delete(num);
				mallController.setNextMenu("BoardMain");
			}
			else if(sel==3) {}
			else if(sel==4) {}
			else if(sel==5) mallController.setNextMenu("BoardMain");
		}
		
		return false;
	}

}
