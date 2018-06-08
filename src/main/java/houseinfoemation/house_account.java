package houseinfoemation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class house_account {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					house_account window = new house_account("1");
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
	public house_account(String id) {
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
		frame.setVisible(true);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(new Color(0, 255, 127));
		panel.setBounds(0, 0, 444, 272);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u4F60\uFF1A");
		label.setBounds(83, 10, 294, 39);
		label.setBackground(Color.BLACK);
		label.setForeground(Color.RED);
		label.setText("\u6B22\u8FCE\u4F60\uFF1A"+house_index.Did);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		panel.add(label);
		
		JButton btnNewButton = new JButton("\u67E5\u770B\u4E2A\u4EBA\u4FE1\u606F");
		btnNewButton.setBounds(24, 75, 112, 100);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u524D\u5F80\u4EA4\u6613\u5927\u5385");
		btnNewButton_1.setBounds(283, 75, 117, 100);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA\u767B\u5F55");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(154, 181, 112, 81);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 12));
		panel.add(btnNewButton_2);
		
		//查看个人信息
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				account_info ho=new account_info(house_index.Did); 
			}
		});
		
		//前往交易大厅
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pay_info PAY_INFO=new pay_info();
				frame.dispose();
			}
		});
			
		//退出登录
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		
	}
}
