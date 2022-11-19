package framedemo;

import java.awt.EventQueue;

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
import javax.swing.JTable;
import javax.swing.JTextArea;

public class delete extends JFrame {
	DBconnector dbc = new DBconnector();
	overview ovr = new overview();
	private JPanel contentPane;
	private JTextField select_id;
	private final JLabel header = DefaultComponentFactory.getInstance().createTitle("DELETE");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete frame = new delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 257);
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
		
		JButton delete = new JButton("Delete");
		delete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sid= Integer.parseInt(select_id.getText());
				ovr.setVisible(true);
				ovr.ovr_output(dbc.delete(sid));
				menu.disposer();
				ovr.ovr_output(dbc.delete(sid));
			}
		});
		delete.setBounds(172, 126, 105, 29);
		contentPane.add(delete);
		
		JLabel deleted_message_block = new JLabel("");
		deleted_message_block.setFont(new Font("Tahoma", Font.PLAIN, 22));
		deleted_message_block.setBounds(118, 165, 240, 31);
		contentPane.add(deleted_message_block);
	}
}
