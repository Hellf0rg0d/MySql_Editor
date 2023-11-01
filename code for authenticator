package sql;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.ResultSet;
//import com.mysql.jdbc.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class auth extends JFrame {
	public JLabel errortxt ;
	private JPanel contentPane;
	JButton connect_btn;
	public boolean icon_clk , fie =false,full = false,edit = false;
	private 	String loc = System.getProperty("user.home");
	private File file1 = new File(loc+"\\cykablyat.txt");
	private File file2 = new File(loc+"\\data.pablo");
	public 	JTextField us ;
	public String id,passw,serv,table;
	public 	JTextField visible;
	public  java.sql.Statement stmt;
	public java.sql.Connection con;
	public java.sql.ResultSet rs;
	public JPasswordField pass;
	public JButton icon;
	public 	JButton neW;
	public JTextField db_name;
	public  JTextField id_tb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatMacDarkLaf());
					auth frame = new auth();
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
	public auth() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	try {
		try {
		if(file2.exists()) {
			file2.renameTo(file1);
			Scanner sc = new Scanner(file1);
			serv = sc.nextLine();
			id = sc.nextLine();
			table = sc.next();
			sc.close();
			file1.renameTo(file2);
			fie = true;
		}else {
			
		}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		setVisible(true);
		setBounds(100, 100, 426, 305);
		getContentPane().setLayout(null);
		JLabel lblNewLabel_6 = new JLabel("Password:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(70, 190, 75, 15);
		getContentPane().add(lblNewLabel_6);
		setTitle("Log-in");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(auth.class.getResource("/icon/icons8-database-50 white.png")));
	
//		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/bill/icons/mysql.png")));
		lblNewLabel.setBounds(10, 142, 50, 50);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME BACK !!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 4, 390, 53);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("DB name :");
		lblNewLabel_3.setFont(new Font("Arialq", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(70, 68, 75, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("User:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(89, 149, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		db_name = new JTextField(serv);
		db_name.setFont(new Font("Arial", Font.PLAIN, 13));
		db_name.setHorizontalAlignment(SwingConstants.CENTER);
		db_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					int m = e.getKeyChar();
					if(m == KeyEvent.VK_ENTER) {
						id_tb.requestFocusInWindow();
					}
				
			}
		});
		db_name.setBounds(157, 61, 187, 30);
		getContentPane().add(db_name);
		db_name.setColumns(10);
		pass = new JPasswordField();
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int m = e.getKeyChar();
				if(m == KeyEvent.VK_ENTER) {
					connect_btn.doClick();
				}
			}
		});
		pass.setEchoChar('*');
		pass.setFont(new Font("Arial", Font.PLAIN, 13));
		pass.setBounds(157, 184, 187, 30);
		getContentPane().add(pass);
		us = new JTextField(id);
		us.setFont(new Font("Arial", Font.PLAIN, 13));
		us.setHorizontalAlignment(SwingConstants.CENTER);
		us.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int m = e.getKeyChar();
				if(m == KeyEvent.VK_ENTER) {
					pass.requestFocusInWindow();
				}
			}
		});
		us.setBounds(157, 143, 187, 30);
		getContentPane().add(us);
	visible = new JTextField();
	visible.setFont(new Font("Arial", Font.PLAIN, 13));
	visible.setHorizontalAlignment(SwingConstants.CENTER);
	visible.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			int m = e.getKeyChar();
			if(m == KeyEvent.VK_ENTER) {
				connect_btn.doClick();
			}
		}
	});
		 connect_btn = new JButton("Connect");
		connect_btn.setBounds(109, 225, 100, 30);
		connect_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			//	id = null;serv = null;table = null;
				id = us.getText().toString();
				serv = db_name.getText().toString();
				if(id_tb.getText().toString().equals("(optional)")) {
					table = "";
				}
				else {
				table = id_tb.getText().toString();
				}
				try {
					if(icon_clk == true) {
						passw = visible.getText().toString();
					}
					else {
						passw = pass.getText().toString();
					}
					if(fie == false) {
						FileWriter wri = new FileWriter(file1,true);
					wri.write(db_name.getText());
					wri.write("\n"+us.getText());
					wri.write("\n"+id_tb.getText());
					wri.close();
					file1.renameTo(file2);
					fie = true;
					}
					if(edit == true) {
						file2.renameTo(file1);
						FileWriter wri = new FileWriter(file1,true);
						 PrintWriter pwOb = new PrintWriter(file1);
					      pwOb.flush();
					      pwOb.close();
						wri.write(db_name.getText());
						wri.write("\n"+us.getText());
						wri.write("\n"+id_tb.getText());
						wri.close();
						file1.renameTo(file2);
						fie = true;
					}
				Class.forName("com.mysql.jdbc.Driver");  
			    con= DriverManager.getConnection(  
			    		"jdbc:mysql://localhost:3306/"+db_name.getText().toString()+"?characterEncoding=latin1",id,passw);  
			  stmt=con.createStatement();
			int exit = JOptionPane.showOptionDialog(null, "Connected Succesfully", "info", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			if(exit == JOptionPane.OK_OPTION) {
				dispose();
			}
				}
				catch(Exception ex) {
			int recap = JOptionPane.showOptionDialog(null, ex.getMessage(), "Authentication Error!!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
							if(recap == JOptionPane.OK_OPTION) {
								id_tb.setText(null);
								pass.setText(null);
								visible.setText(null);
								id_tb.requestFocusInWindow();
						}
							else {
								dispose();
							}
					}
			}
		});
		getContentPane().add(connect_btn);
		visible.setBounds(157, 184, 187, 30);
		getContentPane().add(visible);
		icon = new JButton("");
		icon.setIcon(new ImageIcon(auth.class.getResource("/icon/icons8-eye-24.png")));
		icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(icon_clk == false) {
					icon_clk = true;
				}
				else{
					icon_clk = false;
				}
				if(icon_clk == true) {
					pass.setEnabled(false);
					visible.setEnabled(true);
					visible.setVisible(true);
					pass.setVisible(false);
					visible.setText(pass.getText());
					getContentPane().add(pass);
				//	passw = visible.getText().toString();
				}
				else {
					pass.setEnabled(true);
					visible.setEnabled(false);
					visible.setVisible(false);
					pass.setVisible(true);
					pass.setText(visible.getText());
					getContentPane().add(pass);
					getContentPane().add(visible);
				//s	passw = pass.getText().toString();
				}
			}
		});
		icon.setBounds(366, 186, 28, 28);
		getContentPane().add(icon);
		
	neW = new JButton("New connection");
		neW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(icon.isEnabled() == false || pass.isEnabled() == false || visible.isEnabled() == false || db_name.isEnabled() == false) {
					icon.enable();
					pass.enable();
					visible.enable();
					db_name.enable();
				}
				visible.setText(null);
				pass.setText(null);
				db_name.setText(null);
				id_tb.setText(null);
				us.setText(null);
			edit = true;		
			db_name.requestFocusInWindow();
			}
		});
		neW.setBounds(236, 225, 128, 30);
		getContentPane().add(neW);
		
		JLabel lblNewLabel_4 = new JLabel("Table Name :");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(53, 100, 92, 30);
		getContentPane().add(lblNewLabel_4);
		
		id_tb = new JTextField();
		id_tb.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		id_tb.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(id_tb.getText().toString().equals("(optional)")) {
					id_tb.setText("");
				}
		
			}
			public void focusLost(FocusEvent e) {
				if(id_tb.getText().equals("")) {
					id_tb.setText("(optional)");
				}
			}
			
		});
		id_tb.setHorizontalAlignment(SwingConstants.CENTER);
		id_tb.setText("(optional)");
		id_tb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int m = e.getKeyChar();
				if(m == KeyEvent.VK_ENTER) {
					us.requestFocusInWindow();
				}
			}
		});
		id_tb.setBounds(157, 102, 187, 30);
		getContentPane().add(id_tb);
		id_tb.setColumns(10);
		requestFocusInWindow();
	}
	
	catch(Exception ex) {
		ex.printStackTrace();
	}

}
	public void tty(String err) {
		
		setResizable(true);
		setTitle("Authentication");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 600, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auth frame = new auth();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(400, 65, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.requestFocusInWindow();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setBounds(300, 65, 100, 23);
		contentPane.add(btnNewButton_1);
		errortxt= new JLabel(err);
		errortxt.setFont(new Font("Arial",Font.PLAIN,15));
		errortxt.setHorizontalAlignment(SwingConstants.LEFT);
		errortxt.setBounds(5, 5, 1000, 50);
		contentPane.add(errortxt);
		
		JLabel icon = new JLabel("");
		icon.setBounds(10, 11, 48, 48);
		contentPane.add(icon);
		SwingUtilities.updateComponentTreeUI(this);
		
	}
}
