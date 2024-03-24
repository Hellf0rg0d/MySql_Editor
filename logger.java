package sql;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoDarkFuchsiaIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class logger {

	public JFrame frame;
	public JTable table;
	public DefaultTableModel tblmdl;
	private Font RobotoCondensed;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logger window = new logger();
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
	public logger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
		//	FlatLaf.setup(new FlatMonokaiProIJTheme());
		frame = new JFrame();
		frame.setFont(new Font("RobotoCondensed", Font.BOLD, 20));
		frame.setTitle("Logger");
		frame.setBounds(100, 100, 678, 370);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		try {
			InputStream is = getClass().getResourceAsStream("/textfont/RobotoCondensed-Regular.ttf");
			RobotoCondensed = Font.createFont(Font.TRUETYPE_FONT,is);    
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,is));
			}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	//	UIManager.setLookAndFeel(new FlatMonokaiProIJTheme());
		JScrollPane scrollPane = new JScrollPane();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setDefaultEditor(Object.class, null);
		table.setFont(new Font("Monospaced", Font.PLAIN, 14));
		table.getTableHeader().setFont(new Font("RobotoCondensed",Font.PLAIN,16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "TIME", "SERVER", "TABLE", "COMMAND","ERROR"
			}
		));
		tblmdl = (DefaultTableModel)table.getModel();
		tblmdl.setRowCount(tblmdl.getRowCount()+1);
		System.out.println(tblmdl.getRowCount());
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		centerRenderer.setVerticalAlignment(JLabel.CENTER);
		for(int t= 0;t<table.getColumnCount();t++) {
			table.getColumnModel().getColumn(t).setCellRenderer( centerRenderer );
			}
		table.setRowHeight(22);
		table.setFont(new Font("RobotoCondensed",Font.PLAIN,18));
		table.getTableHeader().setFont(new Font("RobotoCondensed",Font.PLAIN,18));
		scrollPane.setViewportView(table);
		
		JButton cpy = new JButton("COPY");
		cpy.putClientProperty(FlatClientProperties.STYLE, "arc : 15");
		cpy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedColumn() == -1 || table.getSelectedRow() == -1) {
					
				}
				else {
					String cpyString = "{ ";
					for(int m = 0; m<table.getColumnCount();m++) {
						cpyString = cpyString+table.getValueAt(table.getSelectedRow(), m).toString();
						cpyString = cpyString+" , ";
					}
					cpyString = cpyString+" }";
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(cpyString),null);
				}
			}
		});
		cpy.setFont(new Font("RobotoCondensed", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(cpy, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(cpy, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		frame.getContentPane().setLayout(groupLayout);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
