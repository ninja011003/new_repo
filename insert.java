package framedemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class insert extends JFrame {
	static overview ovr = new overview();
	public static void closer(){
		ovr.dispose();
	}
	DBconnector dbc= new DBconnector();
	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField contact_no;
	private JTextField dept;
	private JTextField dob;
	private JTextField batch;
	private ActionListener insert_act = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			ovr.setVisible(true);
			menu.disposer();
			ovr.ovr_output(dbc.insert(dbc.generateSid(),name.getText(),address.getText(),dob.getText(),contact_no.getText(),dept.getText(),batch.getText()));

		}

	};

	/**
	 * Launch the application.
	 */
	/* 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert frame = new insert();
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
	public insert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel insert_title = new JLabel("Enter Details");
		insert_title.setHorizontalAlignment(SwingConstants.CENTER);
		insert_title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		insert_title.setBounds(10, 10, 551, 50);
		contentPane.add(insert_title);
		
		JLabel sid_label = new JLabel("S.id:");
		sid_label.setHorizontalAlignment(SwingConstants.LEFT);
		sid_label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sid_label.setBounds(10, 97, 129, 35);
		contentPane.add(sid_label);
		
		JLabel sid = new JLabel();
		
		sid.setHorizontalAlignment(SwingConstants.CENTER);
		sid.setFont(new Font("Tahoma", Font.ITALIC, 15));
		sid.setText("auto-genrated");
		sid.setBounds(212, 97, 233, 33);
		contentPane.add(sid);
		
		JLabel name_label = new JLabel("Name:");
		name_label.setHorizontalAlignment(SwingConstants.LEFT);
		name_label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		name_label.setBounds(10, 150, 129, 35);
		contentPane.add(name_label);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 195, 129, 35);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setBounds(212, 150, 233, 33);
		contentPane.add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setBounds(212, 209, 233, 105);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contact No:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(10, 381, 145, 33);
		contentPane.add(lblNewLabel_2);
		
		contact_no = new JTextField();
		contact_no.setBounds(212, 381, 233, 32);
		contentPane.add(contact_no);
		contact_no.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Department:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(10, 424, 162, 35);
		contentPane.add(lblNewLabel_3);
		
		dept = new JTextField();
		dept.setBounds(212, 423, 233, 33);
		contentPane.add(dept);
		dept.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DOB:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(10, 336, 129, 35);
		contentPane.add(lblNewLabel_4);
		
		dob = new JFormattedTextField();
		dob.setBounds(212, 336, 233, 35);
		dob.setHorizontalAlignment(SwingConstants.CENTER);
		dob.setText("yyyy-mm-dd");
		dob.setFont(new Font("Tahoma", Font.ITALIC, 15));
		contentPane.add(dob);
		dob.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Batch:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(10, 469, 129, 35);
		contentPane.add(lblNewLabel_5);
		
		batch = new JTextField();
		batch.setBounds(212, 466, 233, 36);
		contentPane.add(batch);
		batch.setColumns(10);
		
		JButton insert_button = new JButton("Insert");
		insert_button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		insert_button.setBounds(217, 534, 122, 40);
		contentPane.add(insert_button);
		insert_button.addActionListener(insert_act);
	}
}
