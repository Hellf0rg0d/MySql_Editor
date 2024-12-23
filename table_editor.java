package sql;

import java.awt.Component;
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
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoDarkFuchsiaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkMediumIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatHighContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMonocaiIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatXcodeDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.ui.FlatButtonBorder;
import com.formdev.flatlaf.ui.FlatRoundBorder;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
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
	JButton qury;
	JButton dlt;
	JButton reauth;
	private int loggerrowcount = 0;
	public JPanel contentPane;
	private String priKeyColumn = "";
	private boolean update_cui = false;
	JButton theme;
	public JFrame frame;
	private int currcomponent = -1;
	JButton logger;
	private JFrame frame2;
	private Font RobotoCondensed;
	private String command = null;
	LocalDateTime now;
    DateTimeFormatter dtf = DateTimeFormatter.ISO_TIME;
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
	logger log = new logger();
	command cui = new command();
	boolean delete = false;
	Object [] logdata = new Object[log.tblmdl.getColumnCount()];
	private JButton ref;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
			FlatLaf.setup(new FlatMacDarkLaf());
			cui.cui_frame.setVisible(false);
			log.frame.setVisible(false);
			authe.authe_frame.setVisible(false);
		frame = new JFrame();
		frame2 = new JFrame();
	    themes();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currcomponent = 6;
			}
		});
		frame.setFont(new Font("RobotoCondensed", Font.BOLD, 20));
		frame.setTitle("TABLE EDITOR");
		try {
			InputStream is = getClass().getResourceAsStream("/textfont/RobotoCondensed-Regular.ttf");
			RobotoCondensed = Font.createFont(Font.TRUETYPE_FONT,is);    
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,is));
			}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			@Override
			public void windowActivated(WindowEvent e) {
				if(cui.isVisible) {
					ref.doClick();
					cui.isVisible = false;
				}
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
		});
		frame.setBounds(100, 100, 1000, 546);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		insert(authe.id,authe.passw,authe.serv,authe.table);
		
	JScrollPane scrollPane = new JScrollPane();
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	scrollPane.addMouseListener(new MouseAdapter() {
		@Override
		
		public void mouseClicked(MouseEvent e) {
			currcomponent = 0;
			if(table.getSelectedColumn() == -1 || table.getSelectedRow() == -1) {
				
			}
			else {
				frame.setTitle("*");
			}
		}
	});
	
	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			currcomponent = 0;
		}
		
	});
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
				
					/*
					 * Sometimes a value at (x,y) might contain null values and might produce exception and to tackle it
					 * An for loop initiates to check a value which is not null and using that value it updates the table 
					 */
					//System.out.println(authe.table);
				if(priKeyColumn.isEmpty() == false) {
					try {
					authe.stmt.executeUpdate("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+priKeyColumn+" = '"+table.getValueAt(initial_row,table.getColumn(priKeyColumn).getModelIndex())+"';");
					now =  LocalDateTime.now();
					logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,"Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+priKeyColumn+" = '"+table.getValueAt(initial_row,table.getColumn(priKeyColumn).getModelIndex())+"';",null);		
					
					}
					catch(Exception exe) {
					exe.printStackTrace();
					
				}
				}
					if(initial_text == null && priKeyColumn.isEmpty()) {	
						try {
					authe.stmt.executeUpdate("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';");
		       //     authe.stmt.executeUpdate("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';");
					now =  LocalDateTime.now();
					logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,"Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';",null);		
					}
						catch(Exception ex) {
							if(ex.getClass().toString().replace("class ", "").equals("java.sql.SQLSyntaxErrorException")) {
								now =  LocalDateTime.now();
								logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,"Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';",ex);
							}
							else {
								ex.printStackTrace();
							}
						}
					
					}
					else {
						if(priKeyColumn.isEmpty()) {
						try {
				//		System.out.println("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(initial_column)+" = '"+initial_text+"';");
				authe.stmt.executeUpdate("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(initial_column)+" = '"+initial_text+"';");
				now =  LocalDateTime.now();
				logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,"Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(initial_column)+" = '"+initial_text+"';",null);
					}
				
				catch(Exception ex) {
					if(ex.getClass().toString().replace("class ", "").equals("java.sql.SQLSyntaxErrorException")) {
						now =  LocalDateTime.now();
						logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,"Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(initial_column)+" = '"+initial_text+"';",ex);
							
					}
					else {
						ex.printStackTrace();
					}
				}}}}
			else {
				try {
				//	System.out.println("Insert into "+authe.table+" ("+table.getColumnName(initial_column)+") values('"+table.getValueAt(initial_row, initial_column)+"');");
				authe.stmt.executeUpdate("Insert into "+authe.table+" ("+table.getColumnName(initial_column)+") values('"+table.getValueAt(initial_row, initial_column)+"');");
				now =  LocalDateTime.now();
				logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,"Insert into "+authe.table+" ("+table.getColumnName(initial_column)+") values('"+table.getValueAt(initial_row, initial_column)+"');",null);
				}
				catch(Exception ex) {
					if(ex.getClass().toString().replace("class ", "").equals("java.sql.SQLSyntaxErrorException")) {
						now =  LocalDateTime.now();
						logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,"Insert into "+authe.table+" ("+table.getColumnName(initial_column)+") values('"+table.getValueAt(initial_row, initial_column)+"');",ex);
						
					}
					else {
						ex.printStackTrace();
					}
				}
			}
		}
	}
		);
	insert(authe.id,authe.passw,authe.serv,authe.table);
	scrollPane.setViewportView(table);
	scrollPane.setViewportView(table);
	SwingUtilities.updateComponentTreeUI(table);
	UIManager.setLookAndFeel(new FlatXcodeDarkIJTheme());
	ref = new JButton("REFRESH");
	ref.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			currcomponent =4;
		}
	});
	ref.setFont(new Font("RobotoCondensed", Font.PLAIN, 15));
	//ref.setBorder(new FlatRoundBorder());
	ref.putClientProperty(FlatClientProperties.STYLE, "arc : 16");
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
			table.setFont(new Font("RobotoCondensed",Font.PLAIN,18));
			table.getTableHeader().setFont(new Font("RobotoCondensed",Font.PLAIN,18));
			
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	});
	dlt = new JButton("DELETE");
	dlt.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			currcomponent = 5;
		}
	});
	dlt.setFont(new Font("RobotoCondensed", Font.PLAIN, 15));
	dlt.putClientProperty(FlatClientProperties.STYLE, "arc : 16");
	dlt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for(int m = 0;m<table.getColumnCount();m++) {
				try {
				if(table.getValueAt(table.getSelectedRow(), m).toString() != null) {
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
				if(priKeyColumn.isEmpty()) {
			authe.stmt.execute("delete from "+authe.table.toString()+" where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';");
			ref.doClick();
			now =  LocalDateTime.now();
			logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,"delete from "+authe.table.toString()+" where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';",null);
			}
				else {
					authe.stmt.execute("delete from "+authe.table.toString()+" where "+priKeyColumn+" = '"+table.getValueAt(table.getSelectedRow(), table.getColumn(priKeyColumn).getModelIndex())+"';");
					ref.doClick();
					now =  LocalDateTime.now();
					logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,"delete from "+authe.table.toString()+" where "+priKeyColumn+" = '"+table.getValueAt(table.getSelectedRow(), table.getColumn(priKeyColumn).getModelIndex())+"';",null);
				}
			}
			catch(Exception ex) {
				if(ex.getClass().toString().replace("class ", "").equals("java.sql.SQLSyntaxErrorException")) {
					now =  LocalDateTime.now();
					logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,"delete from "+authe.table.toString()+" where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';",ex);
					
				}
				else {
					ex.printStackTrace();
				}
			}
		}
	});
	UIManager.setLookAndFeel(new FlatMacDarkLaf());
	qury = new JButton("");
	qury.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			currcomponent = 1;
			System.out.println("qury");
		}
	});
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
		    cui.cui_frame.setVisible(true);		
		}
	});
	qury.setOpaque(true);
	qury.setBorderPainted(false);
	qury.setContentAreaFilled(false);
	qury.setForeground(null);
	qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
	
	reauth = new JButton("");
	reauth.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			currcomponent = 2;
			System.out.println("reauth");
		}
	});
	reauth.setVisible(true);
	reauth.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			authe.authe_frame.setSize(authe.authe_frame.getWidth(), authe.authe_frame.getHeight());
			authe.authe_frame.setVisible(true);
			authe.authe_frame.setTitle("Change-ing Database/Table");
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
	reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
	
	logger = new JButton("");
	logger.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			currcomponent = 3;
		}
	});
	logger.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			log.frame.setVisible(true);
		}
	});
	logger.setOpaque(true);
	logger.setBorderPainted(false);
	logger.setContentAreaFilled(false);
	logger.setForeground(null);
	logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
	
	theme = new JButton("");
	theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));
	theme.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame2.setVisible(true);
			
		}
	});
	theme.setOpaque(true);
	theme.setBorderPainted(false);
	theme.setContentAreaFilled(false);
	theme.setForeground(null);
	GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(10)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
				.addGap(20)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(qury, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addComponent(reauth, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addComponent(logger, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addComponent(theme, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
				.addGap(10))
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(41)
				.addComponent(ref, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				.addGap(39)
				.addComponent(dlt))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(11)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(26)
						.addComponent(qury, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGap(30)
						.addComponent(reauth, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGap(25)
						.addComponent(logger, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGap(35)
						.addComponent(theme, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
				.addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(ref)
					.addComponent(dlt))
				.addGap(11))
	);
	frame.getContentPane().setLayout(groupLayout);
	UIManager.setLookAndFeel(new FlatMacDarkLaf());
	frame.toBack();
	authe.authe_frame.setVisible(true);
	authe.authe_frame.toFront();
	authe.authe_frame.requestFocus();

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
			try {
			priKeyColumn = primaryKey(id,pass, serv, tabe).toUpperCase();
			}
			catch(Exception exe) {
				priKeyColumn = "";
				exe.printStackTrace();
			}
			if(cui.secondary == false) {	
			now =  LocalDateTime.now();
			logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),serv,authe.table,command,null);
			tblmdl.setRowCount(table.getRowCount()+5);
	}
			else {
				now =  LocalDateTime.now();
				logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),serv,authe.table,cui.secondarycmd,cui.secondaryException);
				cui.secondary = false;
				cui.secondaryException = null;
			}
		}
		catch(Exception ex) {
			if(ex.getClass().toString().replace("class ", "").equals("java.sql.SQLSyntaxErrorException")) {
				now =  LocalDateTime.now();
				logging(now.truncatedTo(ChronoUnit.SECONDS).format(dtf),authe.serv,authe.table,command,ex);
				
			}
			else {
				ex.printStackTrace();
			}
			
		}
	}
public static String primaryKey(String id,String pass,String serv,String table) throws Exception{
		String finalprikey;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+serv+"?characterEncoding=latin1",id,pass);
	    java.sql.Statement stmt  = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    java.sql.ResultSet rss = stmt.executeQuery("SHOW INDEX FROM "+table+" where Key_name = 'PRIMARY';");
		rss.next();
	    finalprikey = rss.getString("column_name");
		return finalprikey;	
}
	public void logging(Object time,String server, String table,String command,Exception Exception) {
		if(Exception != null) {
		logdata[0] = time; 
	    logdata[1] = server;
	    logdata[2] = table;
	    logdata[3] = command;
	    logdata[4] = Exception.getClass().toString().replace("class ", "");
		}
		else {
			logdata[0] = time; 
		    logdata[1] = server;
		    logdata[2] = table;
		    logdata[3] = command;
		    logdata[4] = "";
		}
	    for(int run = 0;run<log.table.getColumnCount();run++) {
		    log.tblmdl.setValueAt(logdata[run],loggerrowcount,run);
		    
		    }
	    loggerrowcount++;
	    log.tblmdl.setRowCount(loggerrowcount+1);
	}
	public void themes() {
		frame2.setVisible(false);
		frame2.setResizable(false);
		frame2.setTitle("Pick a Theme!!");
		frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame2.setBounds(100, 100, 504, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame2.setContentPane(contentPane);
			
		JButton flatlafdark = new JButton("Dark");
		flatlafdark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(currcomponent == 0) {
					FlatLaf.setup(new FlatDarkLaf());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatDarkLaf());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatDarkLaf());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatDarkLaf());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatDarkLaf());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatDarkLaf());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));


					FlatLaf.setup(new FlatDarkLaf());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}
						}
		});
		flatlafdark.setBounds(12, 12, 99, 33);
		
		JButton flatlaflight = new JButton("Light");
		flatlaflight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(currcomponent == 0) {
					FlatLaf.setup(new FlatLightLaf());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatLightLaf());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatLightLaf());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatLightLaf());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatLightLaf());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatLightLaf());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-dark-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-dark-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50-dark.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-dark-50.png")));
					
					FlatLaf.setup(new FlatLightLaf());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlaflight.setBounds(12, 56, 99, 33);
		
		JButton flatlafmacosdark = new JButton("MacOS Dark");
		flatlafmacosdark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(currcomponent == 0) {
					FlatLaf.setup(new FlatMacDarkLaf());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatMacDarkLaf());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatMacDarkLaf());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatMacDarkLaf());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatMacDarkLaf());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatMacDarkLaf());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));


					FlatLaf.setup(new FlatMacDarkLaf());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}
}
		});
		flatlafmacosdark.setBounds(12, 100, 99, 33);
		
		JButton flatlafmacoslight = new JButton("MacOSLight");
		flatlafmacoslight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currcomponent == 0) {
					FlatLaf.setup(new FlatMacLightLaf());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatMacLightLaf());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatMacLightLaf());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatMacLightLaf());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatMacLightLaf());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatMacLightLaf());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-dark-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-dark-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50-dark.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-dark-50.png")));
					
					FlatLaf.setup(new FlatMacLightLaf());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafmacoslight.setBounds(12, 144, 99, 33);
		
		JButton flatlafarcorange = new JButton("Arc-Orange");
		flatlafarcorange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(currcomponent == 0) {
					FlatLaf.setup(new FlatArcDarkOrangeIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatArcDarkOrangeIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatArcDarkOrangeIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatArcDarkOrangeIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatArcDarkOrangeIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatArcDarkOrangeIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));

					FlatLaf.setup(new FlatArcDarkOrangeIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafarcorange.setBounds(12, 188, 99, 33);
		
		JButton flatlafdarkpurple = new JButton("Dark Purple");
		flatlafdarkpurple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(currcomponent == 0) {
					FlatLaf.setup(new FlatDarkPurpleIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatDarkPurpleIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatDarkPurpleIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatDarkPurpleIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatDarkPurpleIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatDarkPurpleIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
				qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
				reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
				logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
				theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));
					FlatLaf.setup(new FlatDarkPurpleIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafdarkpurple.setBounds(12, 232, 99, 33);
		
		JButton flatlaffuchisa = new JButton("Fuchsia");
		flatlaffuchisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(currcomponent == 0) {
					FlatLaf.setup(new FlatGradiantoDarkFuchsiaIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatGradiantoDarkFuchsiaIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatGradiantoDarkFuchsiaIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatGradiantoDarkFuchsiaIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatGradiantoDarkFuchsiaIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatGradiantoDarkFuchsiaIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));

					FlatLaf.setup(new FlatGradiantoDarkFuchsiaIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlaffuchisa.setBounds(12, 276, 99, 33);
		
		JButton flatlafocean = new JButton("Ocean");
		flatlafocean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(currcomponent == 0) {
					FlatLaf.setup(new FlatMaterialOceanicIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatMaterialOceanicIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatMaterialOceanicIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatMaterialOceanicIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatMaterialOceanicIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatMaterialOceanicIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));

					FlatLaf.setup(new FlatMaterialOceanicIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafocean.setBounds(132, 12, 118, 33);
		
		JButton flatlafmidnightblue = new JButton("Midnight Blue");
		flatlafmidnightblue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currcomponent == 0) {
					FlatLaf.setup(new FlatGradiantoMidnightBlueIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatGradiantoMidnightBlueIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatGradiantoMidnightBlueIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatGradiantoMidnightBlueIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatGradiantoMidnightBlueIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatGradiantoMidnightBlueIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));


					FlatLaf.setup(new FlatGradiantoMidnightBlueIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafmidnightblue.setBounds(132, 56, 118, 33);
		
		JButton flatlafnaturegreen = new JButton("Nature Green");
		flatlafnaturegreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(currcomponent == 0) {
					FlatLaf.setup(new FlatGradiantoNatureGreenIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatGradiantoNatureGreenIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatGradiantoNatureGreenIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatGradiantoNatureGreenIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatGradiantoNatureGreenIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatGradiantoNatureGreenIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));


					FlatLaf.setup(new FlatGradiantoNatureGreenIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafnaturegreen.setBounds(132, 100, 118, 33);
		
		JButton flatlafgruvbox = new JButton("GruvBox Dark");
		flatlafgruvbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currcomponent == 0) {
					

					
					FlatLaf.setup(new FlatGruvboxDarkMediumIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatGruvboxDarkMediumIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatGruvboxDarkMediumIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatGruvboxDarkMediumIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatGruvboxDarkMediumIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatGruvboxDarkMediumIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));

					FlatLaf.setup(new FlatGruvboxDarkMediumIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafgruvbox.setBounds(132, 144, 118, 33);
		
		JButton flatlafnord = new JButton("Nord");
		flatlafnord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				if(currcomponent == 0) {
					FlatLaf.setup(new FlatNordIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatNordIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatNordIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatNordIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatNordIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatNordIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));


					FlatLaf.setup(new FlatNordIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafnord.setBounds(284, 12, 104, 33);
		
		JButton flatlafsolarizeddark = new JButton("Solarized Dark");
		flatlafsolarizeddark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(currcomponent == 0) {
					FlatLaf.setup(new FlatSolarizedDarkIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatSolarizedDarkIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatSolarizedDarkIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatSolarizedDarkIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatSolarizedDarkIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatSolarizedDarkIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));

					FlatLaf.setup(new FlatSolarizedDarkIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafsolarizeddark.setBounds(284, 56, 118, 33);
		
		JButton flatlafsolarizedlight = new JButton("Solarized Light");
		flatlafsolarizedlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currcomponent == 0) {
					FlatLaf.setup(new FlatSolarizedLightIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatSolarizedLightIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatSolarizedLightIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatSolarizedLightIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatSolarizedLightIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatSolarizedLightIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-dark-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-dark-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50-dark.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-dark-50.png")));
					
					FlatLaf.setup(new FlatSolarizedLightIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}
			}
		});
		flatlafsolarizedlight.setBounds(284, 100, 118, 33);
		
		JButton flatlafmoonlight = new JButton("Moon LIght");
		flatlafmoonlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(currcomponent == 0) {
					FlatLaf.setup(new FlatMoonlightIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatMoonlightIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatMoonlightIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatMoonlightIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatMoonlightIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatMoonlightIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));


					FlatLaf.setup(new FlatMoonlightIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafmoonlight.setBounds(284, 144, 104, 33);
		
		JButton flatlafdeepocean = new JButton("Deep Ocean");
		flatlafdeepocean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currcomponent == 0) {
					FlatLaf.setup(new FlatMaterialDeepOceanIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatMaterialDeepOceanIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatMaterialDeepOceanIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatMaterialDeepOceanIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatMaterialDeepOceanIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatMaterialDeepOceanIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));


					FlatLaf.setup(new FlatMaterialDeepOceanIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafdeepocean.setBounds(284, 232, 104, 33);
		
		JButton flatlafpalenight = new JButton("Pale Night");
		flatlafpalenight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(currcomponent == 0) {
					FlatLaf.setup(new FlatMaterialPalenightIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatMaterialPalenightIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatMaterialPalenightIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatMaterialPalenightIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatMaterialPalenightIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatMaterialPalenightIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));

					FlatLaf.setup(new FlatMaterialPalenightIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafpalenight.setBounds(284, 188, 104, 33);
		
		JButton flatlafmonocaipro = new JButton("MonoKai Pro");
		flatlafmonocaipro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(currcomponent == 0) {
					FlatLaf.setup(new FlatMonokaiProIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatMonokaiProIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatMonokaiProIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatMonokaiProIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatMonokaiProIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatMonokaiProIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));

					FlatLaf.setup(new FlatMonokaiProIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafmonocaipro.setBounds(132, 276, 118, 33);
		
		JButton flatlafmonocai = new JButton("MonoCai");
		flatlafmonocai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(currcomponent == 0) {
					FlatLaf.setup(new FlatMonocaiIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatMonocaiIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatMonocaiIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatMonocaiIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatMonocaiIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatMonocaiIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));
					FlatLaf.setup(new FlatMonocaiIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafmonocai.setBounds(132, 232, 118, 33);
		
		JButton flatlafhighcontrast = new JButton("High Contrast ");
		flatlafhighcontrast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				if(currcomponent == 0) {
					FlatLaf.setup(new FlatHighContrastIJTheme());
					SwingUtilities.updateComponentTreeUI(table);
				}
				else if(currcomponent == 1) {
					FlatLaf.setup(new FlatHighContrastIJTheme());
					SwingUtilities.updateComponentTreeUI(cui.cui_frame);
				}
				else if(currcomponent == 2) {
					FlatLaf.setup(new FlatHighContrastIJTheme());
					SwingUtilities.updateComponentTreeUI(authe.authe_frame);
				}
				else if(currcomponent == 3) {
					FlatLaf.setup(new FlatHighContrastIJTheme());
					SwingUtilities.updateComponentTreeUI(log.frame);
				}
				else if(currcomponent == 4) {
					FlatLaf.setup(new FlatHighContrastIJTheme());
					SwingUtilities.updateComponentTreeUI(ref);
				}
				else if(currcomponent == 5) {
					FlatLaf.setup(new FlatHighContrastIJTheme());
					SwingUtilities.updateComponentTreeUI(dlt);
				}
				else if(currcomponent == 6) {
					qury.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-terminal-50.png")));
					reauth.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-authentication-50.png")));
					logger.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-log-50.png")));
					theme.setIcon(new ImageIcon(table_editor.class.getResource("/icon/icons8-theme-50.png")));

					FlatLaf.setup(new FlatHighContrastIJTheme());
					SwingUtilities.updateComponentTreeUI(frame);
					SwingUtilities.updateComponentTreeUI(frame2);
				}
				else {
					
				}

			}
		});
		flatlafhighcontrast.setBounds(132, 188, 118, 33);
		contentPane.setLayout(null);
		contentPane.add(flatlafdark);
		contentPane.add(flatlaflight);
		contentPane.add(flatlafmacosdark);
		contentPane.add(flatlafmacoslight);
		contentPane.add(flatlafarcorange);
		contentPane.add(flatlafdarkpurple);
		contentPane.add(flatlaffuchisa);
		contentPane.add(flatlafocean);
		contentPane.add(flatlafmidnightblue);
		contentPane.add(flatlafnaturegreen);
		contentPane.add(flatlafgruvbox);
		contentPane.add(flatlafnord);
		contentPane.add(flatlafsolarizeddark);
		contentPane.add(flatlafsolarizedlight);
		contentPane.add(flatlafmoonlight);
		contentPane.add(flatlafdeepocean);
		contentPane.add(flatlafpalenight);
		contentPane.add(flatlafmonocaipro);
		contentPane.add(flatlafmonocai);
		contentPane.add(flatlafhighcontrast);
	
	}
}
