package houseinfoemation;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;

import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import java.awt.Color;
public class house_index {

	public JFrame frame;
	public JTextField textField;
	public JPasswordField passwordField;
	public JPanel panel;
	public static JRadioButton radioButton;
	public static JRadioButton radioButton_1;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	public static String Did;
	private JLabel label_2;
	private JLabel lblatm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					house_index window = new house_index();
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
	public house_index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\6fb0bdf030439bbe57d38edd1cde0124.jpg"));
		frame.setTitle("\u4E8C\u624B\u623F\u4EA4\u6613\u7CFB\u7EDF");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		panel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = -2748426784349171958L;

			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(
						"C:\\Users\\Administrator\\eclipse-workspace\\house\\6fb0bdf030439bbe57d38edd1cde0124.jpg");
				// 图片随窗体大小而变化
				g.drawImage(icon.getImage(), 0, 0, frame.getSize().width, frame.getSize().height, frame);
			}

		};
		panel.setBounds(0, 0, 444, 272);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 12));
		label.setBounds(48, 65, 54, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 12));
		label_1.setBounds(48, 126, 54, 15);
		panel.add(label_1);

		textField = new JTextField();
		textField.setBounds(112, 62, 164, 21);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(112, 123, 164, 21);
		panel.add(passwordField);

		radioButton = new JRadioButton("\u6211\u662F\u4E70\u5BB6");
		radioButton.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 12));
		radioButton.setBounds(38, 191, 121, 23);
		panel.add(radioButton);

		radioButton_1 = new JRadioButton("\u6211\u662F\u5356\u5BB6");
		radioButton_1.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 12));
		radioButton_1.setBounds(226, 191, 121, 23);
		panel.add(radioButton_1);

		button = new JButton("\u767B\u9646");
		button.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 12));
		button.setBounds(48, 162, 93, 23);
		panel.add(button);

		button_1 = new JButton("\u6E05\u9664");
		button_1.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 12));
		button_1.setBounds(313, 162, 93, 23);
		panel.add(button_1);

		button_2 = new JButton("\u6CE8\u518C\u65B0\u7528\u6237");
		button_2.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 12));
		button_2.setBounds(162, 162, 141, 23);
		panel.add(button_2);
		
		label_2 = new JLabel("        欢迎使用二手房交易系统");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(25, 10, 399, 31);
		panel.add(label_2);
		
		lblatm = new JLabel("本系统采用自编ATM交易系统1.0");
		lblatm.setForeground(Color.RED);
		lblatm.setFont(new Font("宋体", Font.PLAIN, 12));
		lblatm.setBounds(215, 247, 191, 15);
		panel.add(lblatm);

		// 锟斤拷陆锟铰硷拷
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// 锟斤拷锟斤拷锟斤拷锟揭碉拷陆
				if (radioButton.isSelected() && !radioButton_1.isSelected()) {
					JDBC j = new JDBC();
					String id = textField.getText();
					String password = new String(passwordField.getPassword());
					String sql = "select *from user";
					Statement st;
					try {
						if (!JDBC.con.isClosed()) {
							st = (Statement) JDBC.con.createStatement();
							ResultSet re = st.executeQuery(sql);
							while (re.next()) {
								String ID = re.getString("id");
								String PASS = re.getString("password");
								if (ID.equals(id) && password.equals(PASS)) {
									// 锟斤拷锟诫当前锟矫伙拷锟斤拷
									
									System.out.println("当前用户：" + ID + "  " + password);
									Did = ID;
									re.close();
									JDBC.con.close();
									frame.dispose();
									JOptionPane.showMessageDialog(null, "登录成功!");
									house_account HOUSE_ACCOUNT=new house_account(Did);
									break;
								}

							}
							if (!JDBC.con.isClosed()) {
								JOptionPane.showMessageDialog(null, "用户名或者密码错误！");
								textField.setText(null);
								passwordField.setText(null);

							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// 锟斤拷锟揭碉拷陆
				} else if (radioButton_1.isSelected() && !radioButton.isSelected()) {
					JDBC j = new JDBC();
					String id = textField.getText();
					String password = new String(passwordField.getPassword());
					String sql = "select *from market";
					Statement st;
					try {
						if (!JDBC.con.isClosed()) {
							st = (Statement) JDBC.con.createStatement();
							ResultSet re = st.executeQuery(sql);
							while (re.next()) {
								String ID = re.getString("id");
								String PASS = re.getString("password");
								if (ID.equals(id) && password.equals(PASS)) {
									// 锟斤拷锟诫当前锟矫伙拷锟斤拷
									System.out.println("当前用户：" + ID + "  " + password);
									Did = ID;
									re.close();
									JDBC.con.close();
									JOptionPane.showMessageDialog(null, "登录成功!");
									house_account h=new house_account(Did);
									frame.dispose();
								}

							}
							if (!JDBC.con.isClosed()) {
								JOptionPane.showMessageDialog(null, "ID或者密码错误！");
								textField.setText(null);
								passwordField.setText(null);

							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (!radioButton.isSelected() && !radioButton_1.isSelected()
						|| radioButton.isSelected() && radioButton_1.isSelected()) {
					JOptionPane.showMessageDialog(null, "你必须选择一个买家/卖家登陆!");
					
					panel.updateUI();
				}

			}
		});

		// 注锟斤拷锟铰硷拷
		button_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
           newaccount nn=new newaccount();
           frame.dispose();
			}
		});

		// 锟斤拷锟斤拷录锟�
		button_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setText(null);
				passwordField.setText(null);
				panel.updateUI();
			}
		});

	}

}
