package framedemo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class overview extends JFrame {
	
	
	
	private JPanel contentPane;
	private JTextField table;
	public void ovr_output(String str){
		table.setText(str);
	}
	/**
	 * Launch the application.
	 */
	/* 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					overview frame = new overview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public overview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 10, 144, 41);
		contentPane.add(lblNewLabel);
		
		table = new JTextField("");
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(10, 67, 416, 125);
		contentPane.add(table);
		
		
		JButton return_menu_button = new JButton("MENU");
		return_menu_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		return_menu_button.setBounds(10, 217, 105, 36);
		contentPane.add(return_menu_button);
		
		JButton exit_button = new JButton("EXIT");
		exit_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		exit_button.setBounds(321, 217, 105, 36);
		contentPane.add(exit_button);
		
		ActionListener exit_act = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		};
		exit_button.addActionListener(exit_act);
		ActionListener menu_act = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				main_control.caller();
				insert.closer();
			}
			
		};
		return_menu_button.addActionListener(menu_act);
	}
}
