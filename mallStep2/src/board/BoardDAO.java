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
		bList.add(new Board("ù ��° �Խñ�","�ȳ��ϼ���, �ݰ����ϴ�. �� ���������� �ؿ�.","yoon",""));
		bList.add(new Board("�� ��° �Խñ�","My Name is Yoon from Bundang^^","yoon",""));
		bList.add(new Board("�� ��° �Խñ�","�� ����ģ���� �̸��� ����, �ڿ����Դϴ�.","yoon",""));
		bList.add(new Board("�� ��° �Խñ�","�� ����ģ���� �����ϰ� Ű�� ���� Ů�ϴ�.","yoon",""));
		bList.add(new Board("�� ��° �Խñ�","���� 173cm�Դϴ�. ��������.","yoon",""));
		ct++;
	}
	
	public void write() {
		_Main.scan.nextLine();
		System.out.println("[������ �ۼ��ϴ�.] : ");
		String title=_Main.scan.nextLine();
		System.out.println("[������ �ۼ��ϴ�.] : ");
		String story=_Main.scan.nextLine();
		
		bList.add(new Board(title,story,curId,""));
		System.out.println("[�Խñ� �ۼ� �Ϸ�.]");
	}
	
	public int readStory(int num) {
		int mod=-1;
		System.out.println("=============== [ "+bList.get(num).title+" ] ===============");
		System.out.println("�ۼ��� : "+bList.get(num).writer);
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		System.out.println(bList.get(num).story);
		System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		if(bList.get(num).writer.equals(curId)) {
			System.out.println("[1]�Խñۼ��� [2]�Խñۻ��� [3]��۾��� [4]��ۻ��� [5]�ڷΰ���");
			mod=1;
		}
		else {
			System.out.println("[1]��۾��� [2]��ۻ��� [3]�ڷΰ���");
			mod=0;
		}
		System.out.println("----------------------------------------------");
		return mod;
	}
	
	public void delete(int num) {
		bList.remove(num);
		System.out.println("["+num+"��° �Խñ� ���� �Ϸ�.]");
	}
}
