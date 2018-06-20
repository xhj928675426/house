package houseinfoemation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;


import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Color;

public class newaccount {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel panel;
	public JLabel label;
	public JLabel label_1;
	public JRadioButton radioButton;
	public JRadioButton radioButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newaccount window = new newaccount();
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
	public newaccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\64bee3f7a2907d17b15fa5abae4180fe.jpg"));
		frame.setTitle("\u6CE8\u518C\r\n");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
						"C:\\Users\\Administrator\\eclipse-workspace\\house\\64bee3f7a2907d17b15fa5abae4180fe.jpg");
				// 图片随窗体大小而变化
				g.drawImage(icon.getImage(), 0, 0, frame.getSize().width, frame.getSize().height, frame);
			}

		};
		panel.setBounds(0, 0, 444, 272);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(42, 68, 54, 15);
		panel.add(label);

		label_1 = new JLabel("      \u6CE8\u518C\u9875\u9762");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(106, 28, 218, 27);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setBounds(42, 122, 54, 15);
		panel.add(label_2);

		textField = new JTextField();
		textField.setBounds(106, 65, 121, 21);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(106, 119, 120, 21);
		panel.add(passwordField);

		radioButton = new JRadioButton("\u6CE8\u518C\u4E00\u4E2A\u4E70\u5BB6\u8D26\u53F7");
		radioButton.setFont(new Font("宋体", Font.PLAIN, 12));
		radioButton.setBounds(261, 64, 153, 23);
		panel.add(radioButton);

		radioButton_1 = new JRadioButton("\u6CE8\u518C\u4E00\u4E2A\u5356\u5BB6\u8D26\u53F7");
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
		radioButton_1.setBounds(261, 118, 153, 23);
		panel.add(radioButton_1);

		JButton button = new JButton("\u786E\u8BA4\u6CE8\u518C");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(63, 187, 93, 23);
		panel.add(button);

		JButton button_1 = new JButton("\u6E05\u9664\u91CD\u7F6E");
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.setBounds(245, 187, 93, 23);
		panel.add(button_1);

		// 确认注册按钮
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//注册一个买家账号
				if (radioButton.isSelected()&&!radioButton_1.isSelected()) {
					String idd = textField.getText();
					if (isexit(idd)) {
						JOptionPane.showMessageDialog(null, "该用户已经存在，请重新输入！");
						textField.setText(null);
						passwordField.setText(null);
					} else {
						JDBC j = new JDBC();
						String sql = "insert into user(id,password) values(?,?)";
						try {
							PreparedStatement st = (PreparedStatement) JDBC.con.prepareStatement(sql);
							st.setString(1, textField.getText());
							st.setString(2, new String(passwordField.getPassword()));
							st.executeUpdate();
							JOptionPane.showMessageDialog(null, "新建用户成功！");
							frame.dispose();
							house_index h=new house_index();
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

					
				} 
				//注册一个卖家账号
				else if (radioButton_1.isSelected()&&!radioButton.isSelected()) {
					String idd = textField.getText();
					if (isexit_1(idd)) {
						JOptionPane.showMessageDialog(null, "该用户已经存在，请重新输入！");
						textField.setText(null);
						passwordField.setText(null);
					} else {
						JDBC j = new JDBC();
						String sql = "insert into market(id,password) values(?,?)";
						try {
							PreparedStatement st = (PreparedStatement) JDBC.con.prepareStatement(sql);
							st.setString(1, textField.getText());
							st.setString(2, new String(passwordField.getPassword()));
							st.executeUpdate();
							JOptionPane.showMessageDialog(null, "新建用户成功！");
							frame.dispose();
							house_index h=new house_index();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					
					
					
				} else if (!radioButton.isSelected() && !radioButton_1.isSelected()||radioButton.isSelected() && radioButton_1.isSelected()) {
					JOptionPane.showMessageDialog(null, "你必须选择一个选项进行注册！");
					textField.setText(null);
					passwordField.setText(null);
					panel.updateUI();

				}

			}
		});

		// 清除重置按钮

		button_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setText(null);
				passwordField.setText(null);
				panel.updateUI();
			}
		});

	}

	public boolean isexit(String i) {
		Boolean is = false;
		JDBC j = new JDBC();
		try {
			if (!JDBC.con.isClosed()) {
				Statement statement = (Statement) JDBC.con.createStatement();
				String sql = "select*from user";
				ResultSet rs = statement.executeQuery(sql);
				String id = textField.getText();
				String ID = null;
				while (rs.next()) {
					ID = rs.getString("ID");
					if (id.equals(ID)) {
						is = true;
					}
				}
			}
		} catch (SQLException e2) {
			// TODO 自动生成的 catch 块
			e2.printStackTrace();
		}

		return is;
	}
	public boolean isexit_1(String i) {
		Boolean is = false;
		JDBC j = new JDBC();
		try {
			if (!JDBC.con.isClosed()) {
				Statement statement = (Statement) JDBC.con.createStatement();
				String sql = "select*from market";
				ResultSet rs = statement.executeQuery(sql);
				String id = textField.getText();
				String ID = null;
				while (rs.next()) {
					ID = rs.getString("ID");
					if (id.equals(ID)) {
						is = true;
					}
				}
			}
		} catch (SQLException e2) {
			// TODO 自动生成的 catch 块
			e2.printStackTrace();
		}

		return is;
	}
}
