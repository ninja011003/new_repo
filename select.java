package framedemo;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class select extends JFrame {
	DBconnector dbc = new DBconnector();
	private JPanel contentPane;
	private JTextField select_id;
	private final JLabel header = DefaultComponentFactory.getInstance().createTitle("SELECT");

	/**
	 * Launch the application.
	 */
	/* 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					select frame = new select();
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
	public select() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(header);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel enter_userid = new JLabel("Enter userID:");
		enter_userid.setFont(new Font("Tahoma", Font.PLAIN, 25));
		enter_userid.setBounds(29, 63, 226, 43);
		contentPane.add(enter_userid);
		
		select_id = new JTextField();
		select_id.setFont(new Font("Tahoma", Font.PLAIN, 23));
		select_id.setBounds(236, 67, 249, 37);
		contentPane.add(select_id);
		select_id.setColumns(10);
		final JTextArea lblNewLabel = new JTextArea("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 173, 517, 284);
		contentPane.add(lblNewLabel);
		
		JButton retrieve = new JButton("Retrieve");
		retrieve.setFont(new Font("Tahoma", Font.PLAIN, 20));
		retrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sid= Integer.parseInt(select_id.getText());
				lblNewLabel.setText(dbc.select(sid));
			}
		});
		retrieve.setBounds(145, 126, 173, 37);
		contentPane.add(retrieve);
		JButton return_menu_button = new JButton("MENU");
		return_menu_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		return_menu_button.setBounds(25, 467, 105, 36);
		contentPane.add(return_menu_button);
		
		JButton exit_button = new JButton("EXIT");
		exit_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		exit_button.setBounds(380, 467, 105, 36);
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
				menu.disposer();
			}
			
		};
		return_menu_button.addActionListener(menu_act);
	}
}
