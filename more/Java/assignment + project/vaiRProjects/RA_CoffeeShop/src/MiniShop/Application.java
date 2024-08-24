package MiniShop;



import MiniShop.MainFrame;
import java.awt.EventQueue;

public class Application {
	public static MainFrame mf=new  MainFrame();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				mf.setVisible(true);		
			}
		});
	}
}
