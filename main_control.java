package framedemo;

import java.awt.EventQueue;

public class main_control {
	
	static menu frame = new menu();
	public static void disposer(){
		frame.setVisible(false);
	}
	public static void caller(){
		frame.setVisible(true);
	}
 
    public static void main(String[] args) {
		//DBconnector dbc = new DBconnector();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//System.out.println(dbc.delete(-1));
	}
}
