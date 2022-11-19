package framedemo;
//import framedemo.main_control.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
public class menu extends JFrame {
	static select sel_obj = new select();
	static insert ins_obj = new insert();
	static delete del_obj = new delete();
	static overview ovr_obj= new overview();
	static DBconnector dbc = new DBconnector();
	public static void disposer(){
		sel_obj.dispose();
		ins_obj.dispose();
		del_obj.dispose();
		ovr_obj.dispose();
	}
	private JPanel contentPane;
	private int flag=0;
	private final JLabel header = DefaultComponentFactory.getInstance().createTitle("MENU");
	private ActionListener select_button = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			flag=1;
			
		}
	};
	private ActionListener insert_button = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			flag=2;
		}
	};
	private ActionListener delete_button = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			flag=3;
		}
	};
	private ActionListener overview_button = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			flag=4;
		}
	};
	private ActionListener proceed_button = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			switch (flag) {
				case 1:
					sel_obj.setVisible(true);
					main_control.disposer();
					break;
				case 2:
					ins_obj.setVisible(true);
					main_control.disposer();
					break;
				case 3:
					del_obj.setVisible(true);
					main_control.disposer();
					break;
				case 4:
					ovr_obj.setVisible(true);
					ovr_obj.ovr_output(dbc.overview_statement());
					main_control.disposer();
					break;
				default:
					break;
			}
			
		}
	};
	/* 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Launch the application.
	 */
/* 
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	public menu() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(header);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel menu_title = new JLabel(" Menu");
		menu_title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		menu_title.setBounds(21, 24, 208, 50);
		contentPane.add(menu_title);
		
		JRadioButton select = new JRadioButton("Select");
		select.setFont(new Font("Tahoma", Font.PLAIN, 25));
		select.setBounds(21, 92, 118, 21);
		select.setSelected(false);
		contentPane.add(select);
		select.addActionListener(select_button);
		
		JRadioButton insert = new JRadioButton("Insert");
		insert.setFont(new Font("Tahoma", Font.PLAIN, 25));
		insert.setBounds(21, 126, 103, 21);
		insert.setSelected(false);
		contentPane.add(insert);
		insert.addActionListener(insert_button);
		
		JRadioButton delete = new JRadioButton("Delete");
		delete.setFont(new Font("Tahoma", Font.PLAIN, 25));
		delete.setBounds(21, 158, 103, 21);
		delete.setSelected(false);
		contentPane.add(delete);
		delete.addActionListener(delete_button);
		JRadioButton overview = new JRadioButton("Overview");
		overview.setFont(new Font("Tahoma", Font.PLAIN, 25));
		overview.setBounds(21, 191, 134, 21);
		overview.setSelected(false);
		contentPane.add(overview);
		overview.addActionListener(overview_button);
		JButton proceed = new JButton("Proceed");
		proceed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		proceed.setBounds(263, 222, 118, 31);
		contentPane.add(proceed);
		proceed.addActionListener(proceed_button);
	}
}
