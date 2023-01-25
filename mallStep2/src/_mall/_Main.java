package _mall;
import java.util.Scanner;
import controller.MallController;
public class _Main {
	static public  Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);		
		MallController.getInstance().init();		
		scan.close();
	}
}