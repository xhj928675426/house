package houseinfoemation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Toolkit;

public class select_houseinfo {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					select_houseinfo window = new select_houseinfo();
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
	public select_houseinfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\3f86ce856b723a14f281d2888283267e.jpg"));
		frame.setBounds(100, 100, 544, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = -2748426784349171958L;

			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(
						"C:\\Users\\Administrator\\eclipse-workspace\\house\\3f86ce856b723a14f281d2888283267e.jpg");
				// 图片随窗体大小而变化
				g.drawImage(icon.getImage(), 0, 0, frame.getSize().width, frame.getSize().height, frame);
			}

		};
		panel.setBounds(0, 0, 528, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u6309\u5927\u5C0F\u67E5\u8BE2\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(28, 42, 85, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("\u6309\u4EF7\u683C\u67E5\u8BE2\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(24, 102, 72, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u6309\u6240\u5C5E\u4EBA\u67E5\u8BE2\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setBounds(24, 167, 85, 15);
		panel.add(label_2);

		textField = new JTextField();
		textField.setBounds(105, 39, 37, 21);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(94, 99, 37, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(105, 164, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton button = new JButton("\u67E5\u8BE2");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(415, 38, 93, 23);
		panel.add(button);

		JButton button_1 = new JButton("\u67E5\u8BE2");
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.setBounds(415, 98, 93, 23);
		panel.add(button_1);

		JButton button_2 = new JButton("\u67E5\u8BE2");
		button_2.setFont(new Font("宋体", Font.PLAIN, 12));
		button_2.setBounds(192, 163, 93, 23);
		panel.add(button_2);

		JLabel label_3 = new JLabel("\uFF08\u8BF7\u8F93\u5165\u5927\u5C0F\u8303\u56F4\uFF09");
		label_3.setForeground(Color.GREEN);
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		label_3.setBounds(276, 42, 129, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("\uFF08\u8BF7\u8F93\u5165\u4EF7\u683C\u8303\u56F4\uFF09");
		label_4.setForeground(Color.GREEN);
		label_4.setFont(new Font("宋体", Font.PLAIN, 12));
		label_4.setBounds(276, 102, 129, 15);
		panel.add(label_4);

		JLabel label_5 = new JLabel("\u2014\u2014");
		label_5.setBounds(146, 42, 44, 15);
		panel.add(label_5);

		textField_3 = new JTextField();
		textField_3.setBounds(200, 39, 66, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_6 = new JLabel("\u2014\u2014");
		label_6.setBounds(138, 102, 52, 15);
		panel.add(label_6);

		textField_4 = new JTextField();
		textField_4.setBounds(200, 99, 66, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);

		// 按大小查询：
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFrame frame = new JFrame();
				frame.setBounds(100, 100, 450, 300);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);

				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 434, 262);
				frame.getContentPane().add(panel);
				panel.setLayout(null);

				TextArea textArea = new TextArea();
				textArea.setBounds(0, 56, 440, 206);
				panel.add(textArea);

				Label label = new Label("\u4EE5\u4E0B\u4E3A\u67E5\u8BE2\u4FE1\u606F");
				label.setForeground(Color.RED);
				label.setFont(new Font("宋体", Font.PLAIN, 12));
				label.setBounds(151, 10, 98, 23);
				panel.add(label);

				JDBC j = new JDBC();
				try {
					PreparedStatement st = (PreparedStatement) j.con
							.prepareStatement("select *from house_pay where squer between ? and ?");
				st.setString(1, textField.getText());	
				st.setString(2, textField_3.getText());
			java.sql.ResultSet rs=st.executeQuery();
			String text="";	
			while(rs.next()) {
					text+="占用人ID：";
					text += rs.getString("people");
					text += "\t" + "id: " + rs.getString("id");
					text += "\t" + "状态： " + rs.getString("status");
					text += "\t" + "平方米： " + rs.getString("squer");
					text += "\t" + "价格： " + rs.getString("money");
					text += "\t" + "所属人： " + rs.getString("whoes");
					text += "\t" + "所属人账户：" + rs.getString("accountnumber");
					text += "\n";
				}
			textArea.setText(text);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		
		
		//按价格查询
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame();
				frame.setBounds(100, 100, 450, 300);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);

				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 434, 262);
				frame.getContentPane().add(panel);
				panel.setLayout(null);

				TextArea textArea = new TextArea();
				textArea.setBounds(0, 56, 440, 206);
				panel.add(textArea);

				Label label = new Label("\u4EE5\u4E0B\u4E3A\u67E5\u8BE2\u4FE1\u606F");
				label.setForeground(Color.RED);
				label.setFont(new Font("宋体", Font.PLAIN, 12));
				label.setBounds(151, 10, 98, 23);
				panel.add(label);

				JDBC j = new JDBC();
				try {
					PreparedStatement st = (PreparedStatement) j.con
							.prepareStatement("select *from house_pay where money between ? and ?");
				st.setString(1, textField_1.getText());	
				st.setString(2, textField_4.getText());
			java.sql.ResultSet rs=st.executeQuery();
			String text="";	
			while(rs.next()) {
					text+="占用人ID：";
					text += rs.getString("people");
					text += "\t" + "id: " + rs.getString("id");
					text += "\t" + "状态： " + rs.getString("status");
					text += "\t" + "平方米： " + rs.getString("squer");
					text += "\t" + "价格： " + rs.getString("money");
					text += "\t" + "所属人： " + rs.getString("whoes");
					text += "\t" + "所属人账户：" + rs.getString("accountnumber");
					text += "\n";
				}
			textArea.setText(text);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		//按所属人查询
		button_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame();
				frame.setBounds(100, 100, 450, 300);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);

				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 434, 262);
				frame.getContentPane().add(panel);
				panel.setLayout(null);

				TextArea textArea = new TextArea();
				textArea.setBounds(0, 56, 440, 206);
				panel.add(textArea);

				Label label = new Label("\u4EE5\u4E0B\u4E3A\u67E5\u8BE2\u4FE1\u606F");
				label.setForeground(Color.RED);
				label.setFont(new Font("宋体", Font.PLAIN, 12));
				label.setBounds(151, 10, 98, 23);
				panel.add(label);

				JDBC j = new JDBC();
				try {
					PreparedStatement st = (PreparedStatement) j.con
							.prepareStatement("select *from house_pay where whoes=?");
				st.setString(1, textField_2.getText());	
			java.sql.ResultSet rs=st.executeQuery();
			String text="";	
			while(rs.next()) {
					text+="占用人ID：";
					text += rs.getString("people");
					text += "\t" + "id: " + rs.getString("id");
					text += "\t" + "状态： " + rs.getString("status");
					text += "\t" + "平方米： " + rs.getString("squer");
					text += "\t" + "价格： " + rs.getString("money");
					text += "\t" + "所属人： " + rs.getString("whoes");
					text += "\t" + "所属人账户：" + rs.getString("accountnumber");
					text += "\n";
				}
			textArea.setText(text);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
