package houseinfoemation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.sql.PreparedStatement;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.sql.ResultSet;
import java.awt.Toolkit;

public class account_info {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static JPanel panel_1;
	public static JPanel panel;
	public JLabel lblNewLabel;
	public JLabel label;
	public JLabel label_1;
	public JLabel label_2;
	public JLabel label_5;
	public JRadioButton radioButton;
	public JRadioButton radioButton_1;
	public JComboBox<String> comboBox;
	public JButton button;
	public JButton button_1;
	public JButton button_2;
	public String id=null;
	private JLabel label_6;
	private JTextField textField_5;
	public String sex =null;
	public String idd = null;
	public String name = null;
	public String email = null;
	public String connection = null;
	public String idcard = null;
	public String pass = null;
	public File arrfiles;
    public static String fileURL="C:/Users/Administrator/eclipse-workspace/house/1111588.jpg";
    private JLabel label_3;
    private JLabel label_4;
    public PreparedStatement st;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					account_info window = new account_info("1");
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
	public account_info(String id) {
		this.id = id;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\9a23661a338d750548d21cd37ed3c9e4.jpg"));
		frame.setTitle("\u7528\u6237\u4FE1\u606F");
		frame.setBounds(100, 100, 597, 341);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		panel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = -2748426784349171958L;

			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(
						"C:\\Users\\Administrator\\eclipse-workspace\\house\\9a23661a338d750548d21cd37ed3c9e4.jpg");
				// 图片随窗体大小而变化
				g.drawImage(icon.getImage(), 0, 0, frame.getSize().width, frame.getSize().height, frame);
			}

		};
		panel.setBounds(0, 0, 591, 313);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A\r\n");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel.setBounds(28, 26, 54, 22);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(80, 27, 97, 21);
		panel.add(textField);
		textField.setColumns(10);

		label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(28, 68, 54, 15);
		panel.add(label);

		textField_1 = new JTextField();
		textField_1.setBounds(79, 65, 98, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		label_1 = new JLabel("\u6027\u522B\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(10, 110, 48, 15);
		panel.add(label_1);

		radioButton = new JRadioButton("\u7537");
		radioButton.setFont(new Font("宋体", Font.PLAIN, 12));
		radioButton.setBounds(64, 106, 54, 23);
		panel.add(radioButton);

		radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
		radioButton_1.setBounds(135, 106, 42, 23);
		panel.add(radioButton_1);

		label_2 = new JLabel("\u7535\u5B50\u90AE\u7BB1\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		label_2.setBounds(10, 151, 78, 15);
		panel.add(label_2);

		textField_2 = new JTextField();
		textField_2.setBounds(90, 148, 106, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 12));
		comboBox.setToolTipText("");
		comboBox.setBounds(206, 148, 106, 21);
		comboBox.addItem("@qq.com");
		comboBox.addItem("@163.com");
		comboBox.addItem("@sina.com");
		panel.add(comboBox);

		textField_3 = new JTextField();
		textField_3.setBounds(278, 27, 156, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(278, 65, 156, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);

		label_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u6B63\u9762\u7167\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 12));
		label_5.setBounds(196, 110, 97, 15);
		panel.add(label_5);

		button = new JButton("\u4FDD\u5B58\u5E76\u9000\u51FA");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(28, 227, 118, 35);
		panel.add(button);

		button_1 = new JButton("\u9000\u51FA");
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.setBounds(200, 227, 97, 35);
		panel.add(button_1);

		label_6 = new JLabel("\u5BC6\u7801\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 12));
		label_6.setBounds(10, 184, 54, 15);
		panel.add(label_6);

		textField_5 = new JTextField();
		textField_5.setBounds(64, 181, 132, 21);
		panel.add(textField_5);
		
		button_2 = new JButton("\u91CD\u65B0\u4E0A\u4F20");
		button_2.setBackground(Color.WHITE);
		button_2.setFont(new Font("宋体", Font.PLAIN, 12));
		button_2.setBounds(322, 269, 93, 23);
		panel.add(button_2);

		label_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		label_3.setBounds(200, 30, 68, 15);
		panel.add(label_3);
		
		label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 12));
		label_4.setBounds(187, 68, 81, 15);
		panel.add(label_4);
		try {
			
			JDBC j = new JDBC();
		if(house_index.radioButton.isSelected()) {
			 st = JDBC.con.prepareStatement("select*from user where id=?");
			st.setString(1, house_index.Did);
			System.out.println(house_index.Did);
		}else {
				st = JDBC.con.prepareStatement("select*from market where id=?");
				st.setString(1, house_index.Did);
				System.out.println(house_index.Did);
		}
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				idd = rs.getString("id");
				System.out.println(idd);
				sex = rs.getString("sex");
				System.out.println(sex);
				name = rs.getString("name");
				email = rs.getString("email");
				connection = rs.getString("connection");
				idcard = rs.getString("idcard");
				pass = rs.getString("password");
				System.out.println(pass);
				fileURL=rs.getString("idcard_image");

			}
			panel_1 = new JPanel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g) {
					ImageIcon icon = new ImageIcon(fileURL);
					// 图片随窗体大小而变化
					g.drawImage(icon.getImage(), 0, 0, panel_1.getWidth(), panel_1.getHeight(), this);

				}

			};
			panel_1.setBounds(322, 110, 244, 152);
			panel.add(panel_1);
			if (sex!=null&&sex.equals("男")) {
				radioButton.setSelected(true);

			} else if (sex!=null&&sex.equals("女")) {
				radioButton_1.setSelected(true);
			}
			textField.setText(idd);
			textField_3.setText(connection);
			textField_4.setText(idcard);
			textField_1.setText(name);
			textField_5.setText(pass);
			String[] e = null ;
			if(email!=null) {
			e= email.split("@");
			textField_2.setText(e[0]);
			
			

			// 后面的邮箱名匹配
			if (e[1].equals("qq.com")) {
				comboBox.setSelectedIndex(0);
			} else if (e[1].equals("sina.com")) {
				comboBox.setSelectedIndex(2);
			} else {
				comboBox.setSelectedIndex(1);
			}
			}
			rs.close();
			st.close();
			JDBC.con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// 保存并退出
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					idd = textField.getText();
					if (radioButton.isSelected()) {
						sex = "男";
					} else {
						sex = "女";
					}

					name = textField_1.getText();
					email = textField_2.getText();
					connection = textField_3.getText();
					idcard = textField_4.getText();
					pass = textField_5.getText();

					JDBC j = new JDBC();
					if(house_index.radioButton.isSelected()) {
					 st = JDBC.con.prepareStatement(
							"replace into user(id,password,name,sex,email,connection,idcard,idcard_image) values(?,?,?,?,?,?,?,?)");}
					else {
						st = JDBC.con.prepareStatement(
								"replace into market(id,password,name,sex,email,connection,idcard,idcard_image) values(?,?,?,?,?,?,?,?)");
						
					}
					st.setString(1, idd);
					st.setString(2, pass);
					st.setString(3, name);
					st.setString(4, sex);
					st.setString(5, email + comboBox.getSelectedItem());
					st.setString(6, connection);
					st.setString(7, idcard);
					st.setString(8, fileURL);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "保存成功！");
					frame.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// 退出
		button_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});

		// 上传身份证图片

		button_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				eventOnImport(button_2);

			}
		});

	}

	public static void eventOnImport(JButton upload) {
		ByteArrayOutputStream baos = null;
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);

		/** 过滤文件类型 * */
		FileNameExtensionFilter filter = new FileNameExtensionFilter("请选择上传图片", "jpg", "png", "jpeg", "bmp");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(upload);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			/** 得到选择的文件* */
			 File arrfiles = chooser.getSelectedFile();
			System.out.println(arrfiles);
			if (arrfiles == null) {
				return;
			}
				fileURL=arrfiles.toString();
				panel.updateUI();
				panel_1.updateUI();
			
		}
	}
}
