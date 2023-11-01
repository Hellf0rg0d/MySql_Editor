package sql;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.Robot;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import net.miginfocom.swing.MigLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.WindowAdapter;

public class table_editor {
	public JLabel errortxt;
	private JPanel contentPane;
	private boolean update_cui = false;
	private JFrame frame;
	private JFrame frame2;
	private String command = null;
	private JTable table;
	private String[] table_from_cmd = new String[1000];
    private DefaultTableModel tblmdl;
    public String surrounding_text;
	String[] data = new String[1000];
	Object[] updt = new Object[100];
	Object iword;
Object etext = null;
int initial_row,initial_column,surrounding_column;
String initial_text;
	char[] netext = new char[100000];
	boolean upd = false,empty=true;
	int rno = 1;
	auth authe = new auth();
	command cui = new command();
	boolean delete = false;
	private JButton ref;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatMacDarkLaf());
					table_editor window = new table_editor();
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
	public table_editor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			cui.setVisible(false);
			authe.setVisible(false);
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setBounds(100, 100, 945, 500);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		insert(authe.id,authe.passw,authe.serv,authe.table);
	
	
		UIManager.setLookAndFeel(new FlatMacLightLaf());
	
	JScrollPane scrollPane = new JScrollPane();
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	scrollPane.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(table.getSelectedColumn() == -1 || table.getSelectedRow() == -1) {
				
			}
			else {
				frame.setTitle("*");
			}
		}
	});
	table = new JTable();
	((DefaultCellEditor)table.getDefaultEditor(String.class)).getComponent().addFocusListener(new  FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			/*
			 * i removed the path to a jdbc connector try replacing it back if it doens't work
			 * try using a diff jdbc.jav file? 
			 */
			empty = true;
			initial_row = table.getSelectedRow();
			initial_column = table.getSelectedColumn();
					for(int m = 0;m<table.getColumnCount();m++) {
				try {
				if(table.getValueAt(initial_row, m).toString() == null || table.getValueAt(initial_row, m) == "") {
						empty = true;
				}
				else {
					empty = false;
					break;
				}
				
			}
			catch(Exception ex) {
			}
			}
			if(empty == false) {
				try {
			initial_text = table.getValueAt(initial_row, initial_column).toString();
				}
				catch(NullPointerException ex) {
					initial_text = null;
					// indicating the text at the selected row and column is null
						for(int m = 0;m<table.getColumnCount();m++) {
							try {
							if(table.getValueAt(initial_row, m).toString() != null) {
								surrounding_text = table.getValueAt(initial_row, m).toString();
								surrounding_column = m;
								break;
							}
							//checking if any column in that row has any data
							
							}
					catch(Exception E) {
						E.printStackTrace();
					}
						}
				}
			}	
		}
		public void focusLost(FocusEvent e) {
			if(empty == false) {
				try {
					/*
					 * Sometimes a value at (x,y) might contain null values and might produce exception and to tackle it
					 * An for loop initiates to check a value which is not null and using that value it updates the table 
					 */
					//System.out.println(authe.table);
					if(initial_text == null) {
					authe.stmt.executeUpdate("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';");
		       //     authe.stmt.executeUpdate("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';");
											
					}
					else {
				//		System.out.println("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(initial_column)+" = '"+initial_text+"';");
				authe.stmt.executeUpdate("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(initial_column)+" = '"+initial_text+"';");
				
					}
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}}
			else {
				try {
					System.out.println("Insert into "+authe.table+" ("+table.getColumnName(initial_column)+") values('"+table.getValueAt(initial_row, initial_column)+"');");
				authe.stmt.executeUpdate("Insert into "+authe.table+" ("+table.getColumnName(initial_column)+") values('"+table.getValueAt(initial_row, initial_column)+"');");

				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
		);
	insert(authe.id,authe.passw,authe.serv,authe.table);
	scrollPane.setViewportView(table);
	scrollPane.setViewportView(table);
	SwingUtilities.updateComponentTreeUI(table);
	ref = new JButton("refresh");
	
	ref.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			cui.db_table = authe.table;
			cui.password = authe.passw;
		

			if(cui.cmd.contains("boom")) {
				command = cui.cmd.replace("boom", authe.table);
			}
			else {
				command = cui.cmd;
			}
			try {
			tblmdl.setRowCount(0);
			tblmdl.setColumnCount(0);
			table.revalidate();
			insert(authe.id,authe.passw,authe.serv,authe.table);
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			centerRenderer.setVerticalAlignment(JLabel.CENTER);
			for(int t= 0;t<table.getColumnCount();t++) {
			table.getColumnModel().getColumn(t).setCellRenderer( centerRenderer );
			//used t because i'm learning integration right now :joy: :joy:
			}
			table.setRowHeight(22);
			table.setFont(new Font("MONOSPACE",Font.PLAIN,18));
			table.getTableHeader().setFont(new Font("ARIAL",Font.PLAIN,18));
			
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	});
	JButton svbtn = new JButton("SAVE");
	svbtn.setVisible(false);
/*	svbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			robo.keyPress(KeyEvent.VK_ENTER);
	         System.out.println("ymuyy");
			try {
				System.out.println(initial_text);
				initial_text = table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString();
			
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		//	robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("myymu");
		//	KeyboardFocusManager.setCurrentKeyboardFocusManager(((DefaultCellEditor)table.getDefaultEditor(String.class)));
			
		//	((DefaultCellEditor)table.getDefaultEditor(String.class)).getComponent().requestFocusInWindow();
		//	KeyboardFocusManager.getCurrentKeyboardFocusManager().clearFocusOwner();
			
		}
	});
	*/
	JButton dlt = new JButton("Delete");
	dlt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for(int m = 0;m<table.getColumnCount();m++) {
				try {
				if(table.getValueAt(table.getSelectedRow(), m).toString() != null) {
				//	System.out.println(table.getValueAt(table.getSelectedRow(),m).toString());
					surrounding_text = table.getValueAt(table.getSelectedRow(), m).toString();
					surrounding_column = m;
					break;
				}
				}
		catch(Exception E) {
			E.printStackTrace();
		}
			}
			try {
			authe.stmt.execute("delete from "+authe.table.toString()+" where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';");
			ref.doClick();
		}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	});
	
	JButton qury = new JButton("");
	qury.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			cui.server = authe.serv;
			cui.user_id = authe.id;
			cui.password = authe.passw;
			if(update_cui == false) {
			cui.refresh(0);
			update_cui = true;
			}
			else {
				
			}
		    cui.setVisible(true);		
		}
	});
	qury.setOpaque(true);
	qury.setBorderPainted(false);
	qury.setContentAreaFilled(false);
	qury.setForeground(null);
	qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
	qury.setSize(50,50);
	
	JButton reauth = new JButton("");
	reauth.setVisible(true);
	reauth.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			authe.setSize(426, 305);
			authe.setVisible(true);
			authe.setTitle("Change-ing Database/Table");
			authe.db_name.setEnabled(false);
			authe.visible.setEnabled(false);
			authe.pass.setEnabled(false);
			authe.icon.setEnabled(false);
		}
	});
	reauth.setOpaque(true);
	reauth.setBorderPainted(false);
	reauth.setContentAreaFilled(false);
	reauth.setForeground(null);
	reauth.setSize(50,50);
	reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
	GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.TRAILING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(53)
				.addComponent(svbtn, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
				.addGap(18)
				.addComponent(ref, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
				.addGap(18)
				.addComponent(dlt, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
				.addGap(550))
			.addGroup(groupLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(qury, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addComponent(reauth, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
				.addContainerGap())
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(7)
						.addComponent(scrollPane)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(svbtn, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addComponent(ref, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addComponent(dlt, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(29)
						.addComponent(qury)
						.addGap(18)
						.addComponent(reauth, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
				.addGap(16))
	);
	frame.getContentPane().setLayout(groupLayout);
	UIManager.setLookAndFeel(new FlatMacDarkLaf());
	frame.toBack();
	authe.setVisible(true);
	authe.toFront();
	authe.requestFocus();

		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	
	}
	public void insert(String id,String pass,String serv,String tabe) {
		try {
			tblmdl= (DefaultTableModel)table.getModel();
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+serv+"?characterEncoding=latin1",id,authe.passw);
		    Statement stmt  = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    ResultSet rss = stmt.executeQuery(command);
			//rss.setFetchDirection(rss.TYPE_SCROLL_INSENSITIVE);
			java.sql.ResultSetMetaData rmd = rss.getMetaData();
			tblmdl.setRowCount(table.getRowCount()+10);
			for(int m = 0;m<rmd.getColumnCount();m++) {
				tblmdl.addColumn(rmd.getColumnName(m+1).toUpperCase());
				rss.beforeFirst();
				while(rss.next()) {
					if(m == 0) {
					tblmdl.setRowCount(rno);
					}
					data[0] = rss.getString(m+1);
					table.setValueAt(data[0], rno-1, m);
					rno++;
				}
				rno = 1;
			}
			tblmdl.setRowCount(table.getRowCount()+10);
	}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
