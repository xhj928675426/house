package houseinfoemation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;

public class house_sell {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					house_sell window = new house_sell("1");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public house_sell(String id) {
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("     \u8BF7\u586B\u5199\u5982\u4E0B\u4FE1\u606F");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(108, 10, 178, 40);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(21, 57, 19, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(21, 86, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5E73\u65B9\u7C73");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(118, 60, 54, 15);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 86, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4EF7\u683C");
		label_2.setBounds(215, 60, 54, 15);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(215, 86, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6240\u5C5E\u4EBA");
		label_3.setBounds(21, 142, 54, 15);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(21, 167, 66, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8D26\u6237");
		label_4.setBounds(108, 142, 54, 15);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(106, 167, 66, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(200, 153, 127, 76);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDBC j=new JDBC();
				String str1=textField.getText();
				if(isexit(str1)==true) {
				String str2=textField_1.getText();
				String str3=textField_2.getText();
				String str4=textField_3.getText();
				String str5=textField_4.getText();
				try {
					PreparedStatement st=(PreparedStatement) j.con.prepareStatement("insert into house_pay(id,status,squer,money,whoes,accountnumber) values(?,'闲置',?,?,?,?)");
					st.setString(1,str1);
					st.setString(2,str2);
					st.setString(3,str3);
					st.setString(4,str4);
					st.setString(5,str5);
					st.execute();
					JOptionPane.showMessageDialog(null, "上传信息成功!");
					st.close();	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}else {
					
					JOptionPane.showMessageDialog(null,"该ID已存在！");
					textField.setText(null);
					panel.updateUI();
				}
			}
		});
		
		
		
	}
	
public Boolean isexit(String str){
	JDBC j=new JDBC();
	try {
		Statement st=j.con.createStatement();
		ResultSet rs=st.executeQuery("select id from house_pay");
		while(rs.next()) {
			String strr=rs.getString("id");
			if(str.equals(strr)) {
				return false;
			}	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	return true;
}
	
}
