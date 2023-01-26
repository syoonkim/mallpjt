package board;

import java.util.ArrayList;

import _mall._Main;
import controller.MallController;

public class BoardDAO {
	
	int ct=0;
	String curId="";
	private MallController mallController;
	private static BoardDAO instance=new BoardDAO();
	private ArrayList<Board> bList=new ArrayList<Board>();
	
	public void init() {
		mallController=MallController.getInstance();
		curId=mallController.getMemberLoginID();
		
		if(ct==0) putSampleDataToBList();
	}

	public ArrayList<Board> getbList() {
		return bList;
	}

    public void printAllBoard() {
    	int length=bList.size();
    	if(length!=0) {
			for(int i=0;i<length;i++) {
				System.out.print(i+") "+bList.get(i).title);
				System.out.printf("%32s\n",bList.get(i).writer);
			}
		}
    	
    }
	public void setbList(ArrayList<Board> bList) {
		this.bList = bList;
	}


	public static BoardDAO getInstance() {
		return instance;
	}
	
	private void putSampleDataToBList() {
		bList.add(new Board("첫 번째 게시글","안녕하세요, 반갑습니다. 잘 지내보도록 해요.","yoon",""));
		bList.add(new Board("두 번째 게시글","My Name is Yoon from Bundang^^","yoon",""));
		bList.add(new Board("세 번째 게시글","제 여자친구의 이름은 원경, 박원경입니다.","yoon",""));
		bList.add(new Board("네 번째 게시글","제 여자친구는 날씬하고 키가 아주 큽니다.","yoon",""));
		bList.add(new Board("오 번째 게시글","무려 173cm입니다. 여신이죠.","yoon",""));
		ct++;
	}
	
	public void write() {
		_Main.scan.nextLine();
		System.out.println("[제목을 작성하다.] : ");
		String title=_Main.scan.nextLine();
		System.out.println("[내용을 작성하다.] : ");
		String story=_Main.scan.nextLine();
		
		bList.add(new Board(title,story,curId,""));
		System.out.println("[게시글 작성 완료.]");
	}
	
	public int readStory(int num) {
		int mod=-1;
		System.out.println("=============== [ "+bList.get(num).title+" ] ===============");
		System.out.println("작성자 : "+bList.get(num).writer);
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		System.out.println(bList.get(num).story);
		System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		if(bList.get(num).writer.equals(curId)) {
			System.out.println("[1]게시글수정 [2]게시글삭제 [3]댓글쓰기 [4]댓글삭제 [5]뒤로가기");
			mod=1;
		}
		else {
			System.out.println("[1]댓글쓰기 [2]댓글삭제 [3]뒤로가기");
			mod=0;
		}
		System.out.println("----------------------------------------------");
		return mod;
	}
	
	public void delete(int num) {
		bList.remove(num);
		System.out.println("["+num+"번째 게시글 삭제 완료.]");
	}
}
