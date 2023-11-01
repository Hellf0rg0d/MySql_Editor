package sql;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mysql.cj.x.protobuf.MysqlxSession.AuthenticateContinue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class command extends JFrame {
//if any prob with gui try replacing auth with JFrame
	private JPanel contentPane;
	private String command;
	private JTextArea textArea;
	public auth authe = new auth();
	public String password;
	public String db_table;
	public String server,user_id;
	public String cmd = "select*from boom";
	private String[] line_breaker = new String[5000];
	private String help;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UIManager.setLookAndFeel(new FlatMacDarkLaf());
					command frame = new command();
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
	public command() {
		authe.setVisible(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//addWindowListener(null);
		setBounds(100, 100, 880, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		Font f = new Font("MONOSPACED", 1, 18);
		
		textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
				//10 = enter 
				// 8 = backspace
				if(e.getKeyCode() == 10) {
					refresh(1);
					e.consume();
				}
				else if (e.getKeyCode() == 8) {
					
				}
			}
		});
		textArea.setLineWrap(true);
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea.setText("Data Base Connected!! \n"+server+"->");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(jsp, GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(jsp, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	
	}
	public void refresh(int jfk){
		/*
		 * variable jfk helps the function to know if it is called from tableEditor or from command 
		 * the function is caleld from texteditor to update the server variable 
		 * as the server variable retrives data from authe.serv
		 * and authe.serv retrives data from the local file(if it exists) 
		 * if the user setups a new connection 
		 * inorder to update variables it is called from tableEditor
		 */
		if(jfk == 0) {
		textArea.setText(textArea.getText().toString().trim()+"\n"+server+"->");
		}
		else {
			commands();
			textArea.setText(textArea.getText().toString().trim()+"\n"+server+"->");
		}
	}
	public void commands(){
		try {
			 authe.con= DriverManager.getConnection(  
			    		"jdbc:mysql://localhost:3306/"+server+"?characterEncoding=latin1",user_id,password);  
			  authe.stmt=authe.con.createStatement(); 
		line_breaker = textArea.getText().split("\n");
		command = line_breaker[line_breaker.length-1].replace(server+"->","");
		if(command.equals("help")) {
			help =  "\nVersion number \t--\t 1.0\nConnected database \t--\t "+server+"\nCreator \t--\t Hellf0rg0d\ncheck out my github for more information \t--\t https://github.com/hellf0rg0d";
			textArea.setText(textArea.getText().toString().trim()+help);
		}
		else {
		if(authe.stmt.execute(command.toString()) == true){
			cmd = command;	
		}
		else {
			authe.stmt.execute(command);
		}
		}
		}
		catch(Exception ex) {
			textArea.setText(textArea.getText().toString().trim()+"\n"+ex.getMessage());
		}
	}
}
