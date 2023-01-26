package menu_board;

import _mall.MenuCommand;
import _mall._Main;
import board.BoardDAO;
import controller.MallController;

public class BoardMain implements MenuCommand {
	private MallController mallController;
	private BoardDAO boardDAO;
	
	@Override
	public void init() {
		mallController=MallController.getInstance();
		boardDAO = BoardDAO.getInstance();
		boardDAO.init();
	}

	@Override
	public boolean update() {
		
		System.out.println("================== [ 게시판 ] ==================");
		System.out.println("N)  게시글 제목                             작성자 ");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		boardDAO.printAllBoard();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("[1]다음페이지 [2]이전페이지 [3]글쓰기 [4]글조회 [5]뒤로가기");
		System.out.println("----------------------------------------------");
		int sel=_Main.scan.nextInt();
		
		if(sel==1) {}
		else if(sel==2) {}
		else if(sel==3) boardDAO.write();
		else if(sel==4) mallController.setNextMenu("BoardRead");
		else if(sel==5) mallController.setNextMenu("MemberMain");
		
		return false;
	}

}
