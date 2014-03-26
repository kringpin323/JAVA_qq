package client.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Menu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.jws.Oneway;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

public class mainServer extends JFrame{
	JPanel j1 = null;
	JPanel j2 = null;
	JPanel j3 = null;
	JPanel j4 = null;
	JScrollPane jsroll0 = null;
	JScrollPane jsroll1 = null;
	JScrollPane jsroll2 = null;
	JScrollPane jsroll3 = null;
	JTextPane textPane0 = null;
	JTextPane textPane1 = null;
	public static JTextPane textPane2 = null;
	JTextField textf_setLimit =null;
	JButton jb_setLimit = null;
	JLabel jlable_setLimit = null;
	JComboBox jcom_setDatabase = null;
	JButton jb_setDatabase = null;
	JLabel jlable_setDatabase = null;
	JTable table = null;
	JLabel jlable1 = null;
	JLabel jlable2 = null;
	JLabel jlable_warning = null;
	
	JButton jb1 = null;
	JButton jb2 = null;
	JButton jb3 = null;
	JButton jb4 = null;
	
	MyTableModel myModel = null;
	
	
	public mainServer()
	{
		createUserInterface();
	}
	
	class refresh extends Thread{}
	
	private void createUserInterface(){
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.lightGray);
		contentPane.setLayout(null);
		
		//ϵͳ��Ϣ
		j1 = new JPanel();
		j1.setLayout(null);
		
		jlable1 = new JLabel("�ѷ��͵�ϵͳ��Ϣ");
		jlable1.setFont(new Font("����",Font.PLAIN,12));
		jlable1.setBounds(0,0,120,15);
		j1.add(jlable1);
		
//		
//		
		textPane0 = new JTextPane();
		textPane0.setEditable(false);
		textPane0.setFont(new Font("����",Font.PLAIN,12));
		textPane0.setDisabledTextColor(Color.red);
		textPane0.setBounds(0,20,600,180);
		j1.add(textPane0);
		jsroll0 = new JScrollPane(textPane0);
		jsroll0.setBounds(0,20,590,180);
		jsroll0.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		j1.add(jsroll0);
		//
		//
		jlable2 = new JLabel("������������ϵͳ��Ϣ����ctrl+enter���ͣ�");
		jlable2.setBounds(0,200,250,15);
		jlable2.setFont(new Font("����", Font.PLAIN,12));
		j1.add(jlable2);
		//
		jb1 = new JButton("����ѷ���");
		jb1.setBounds(470,202,100,15);
		jb1.setFont(new Font("����", Font.PLAIN,12));
		j1.add(jb1);
		jb1.addActionListener(new ActionListener(){
//			@Override
			public void actionPerformed(ActionEvent e){
				
			} 
		});
		
		//
		textPane1 = new JTextPane();
		textPane1.setBounds(0,220,600,80);
		textPane1.setFont(new Font("����",Font.PLAIN,12));
		j1.add(textPane1);
		jsroll3 = new JScrollPane(textPane1);
		jsroll3.setBounds(0,220,590,80);
		jsroll3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		j1.add(jsroll3);
		//
		jb2 = new JButton("����");
		jb2.setBounds(470,302,100,15);
		jb2.setFont(new Font("����", Font.PLAIN,12));
		j1.add(jb2);
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			
			}
		});
		
		//ϵͳ��־
		j2 = new JPanel();
		j2.setLayout(null);
		textPane2 = new JTextPane();
		textPane2.setBounds(0,0,600,300);
		textPane2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		textPane2.setText("ϵͳ��־:\n");
		textPane2.setFont(new Font("����",Font.PLAIN,12));
		textPane2.setEditable(false);
		j2.add(textPane2);
		jsroll1 = new JScrollPane(textPane2);
		jsroll1.setBounds(0,0 ,590, 300);
		jsroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		j2.add(jsroll1);
		jb3 = new JButton("���");
		jb3.setBounds(470, 302, 100, 15);
		jb3.setFont(new Font("����",Font.PLAIN,12));
		j2.add(jb3);
		jb3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		
		//�������
		j3 = new JPanel();
		j3.setLayout(null);
		//���
		myModel = new MyTableModel();
		table = new JTable(myModel);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);//���ÿɷ�ѡ��Ĭ��Ϊfalse
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setGridColor(Color.blue);
		table.setBounds(0, 0, 600, 200);
		jsroll2 = new JScrollPane(table);
		jsroll2.setBounds(0,0,590,300);
		jsroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		j3.add(jsroll2);
		//
		jb4 = new JButton("ˢ��");
		jb4.setBounds(470, 302, 100, 15);
		jb4.setFont(new Font("����",Font.PLAIN,12));
		j3.add(jb4);
		jb4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{}
		});
		//ϵͳ����
		j4 = new JPanel();
		j4.setLayout(null);
		jlable_setLimit = new JLabel("ͬһ��Ipһ�������Ĵ�����");
		jlable_setLimit.setBounds(10,10,200,20);
		textf_setLimit = new JTextField();
		textf_setLimit.setBounds(200,10,90,20);
		jb_setLimit = new JButton("ȷ��");
		jb_setLimit.setBounds(300,10,60,20);
		jb_setLimit.setFont(new Font("����",Font.PLAIN,12));
		j4.add(jlable_setLimit);
		j4.add(jb_setLimit);
		j4.add(textf_setLimit);
		jb_setLimit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		jlable_setDatabase = new JLabel("��ѡ�����ݿ⣬�Բ�����ʵ��û��ѡ��ֻ��MYsql��");
		jlable_setDatabase.setBounds(10,40,200,20);
		String item[] = {"MySql","Oracle"};
		jcom_setDatabase = new JComboBox(item);
		jcom_setDatabase.setBounds(200,40,90,20);
		jlable_warning = new JLabel("(��ʾ������ֻ��mysql����ѡʲô��������mysql��)");
		jlable_warning.setBounds(300,40,300,20);
		jlable_warning.setFont(new Font("����",Font.PLAIN,12));
		j4.add(jlable_setDatabase);
		j4.add(jcom_setDatabase);
		j4.add(jlable_warning);
		jcom_setDatabase.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e)
			{
				
			}
		});
		
		//
		JTabbedPane tab = new JTabbedPane();
		tab.setBounds(0,0,600,400);
		
		tab.addTab("ϵͳ��־", j2);
		tab.addTab("����ϵͳ��Ϣ",j1);
		
		tab.addTab("�������", j3);
		tab.addTab("ϵͳ����", j4);
		tab.setFont(new Font("����",Font.PLAIN,12));
		contentPane.add(tab);
		Menu m = new Menu();
		m.setFont(new Font("����",Font.PLAIN,12));
		this.setJMenuBar(m);
		
		Dimension  screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension framesize = this.getSize();
		int x = (screensize.width - framesize.width)/4;
		int y = (screensize.height - framesize.height)/4;
		this.setLocation(x,y);
		this.show();
		setTitle("KQserver MatherFucker");
		setResizable(false);
		setSize(600,400);
		setVisible(true);
		
		
		}
	
	class MyTableModel extends AbstractTableModel
	{
		int count = 0;
		private String[] columnNames = {"QQ","ip","main_port","sys_port","heartbeat_port","chat_port"};
		private String[][] data = new String[count][0];
		public MyTableModel()
		{
//			Map m =
			
		}
		
		public int getColumnCount()
		{
			return columnNames.length;
		}
		public int getRowCount()
		{
			return data.length;
		}
		
		public String getColumnName(int col)
		{
			return columnNames[col];
		}
		
		public String getValueAt(int row,int col)
		{
			return data[row][col];
		}
		
		public Class geetColumnClass(int c)
		{
			return getValueAt(0,c).getClass();
		}
		
		public boolean isCellEditable(int row, int col)
		{
			return false;
		}
		
		
	}
	class Menu extends JMenuBar
	{
		private JDialog aboutDialog;
		
		/*
		 * �˵���ʼ������
		 * */
		public Menu()
		{
			JMenu fileMenu1 = new JMenu("�ļ�");
			JMenu fileMenu2 = new JMenu("����");
			JMenu fileMenu3 = new JMenu("����");
			JMenuItem aboutMenuItem = new JMenuItem("���ڡ�����");
			JMenuItem exitMenuItem = new JMenuItem("�˳�");
			JMenuItem startMenuItem = new JMenuItem("����������");
			JMenuItem stopMenuItem = new JMenuItem("ֹͣ������");
			fileMenu1.setFont(new Font("����",Font.PLAIN,12));
			fileMenu2.setFont(new Font("����",Font.PLAIN,12));
			fileMenu3.setFont(new Font("����",Font.PLAIN,12));
			aboutMenuItem.setFont(new Font("����", Font.PLAIN,12));
			exitMenuItem.setFont(new Font("����",Font.PLAIN,12));
			startMenuItem.setFont(new Font("����",Font.PLAIN,12));
			stopMenuItem.setFont(new Font("����",Font.PLAIN,12));
			fileMenu1.add(exitMenuItem);
			fileMenu2.add(startMenuItem);
			fileMenu2.add(stopMenuItem);
			fileMenu3.add(aboutMenuItem);
			this.add(fileMenu1);
			this.add(fileMenu2);
			this.add(fileMenu3);
			aboutDialog = new JDialog();
			initAboutDialog();
			
			exitMenuItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
//					String sql_update = "update mainInfo set status "
					dispose();
					System.exit(0);
				}
			});
			
			aboutMenuItem.addActionListener(new ActionListener(){
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e)
				{
					aboutDialog.show();
				}
			});
		}
		
		public JDialog getAboutDialog()
		{
			return aboutDialog;
		}
		
		/*
		 * ����"����"�Ի����һЩ����
		 * */
		public void initAboutDialog()
		{
			aboutDialog.setTitle("motherfucker,�˽֣�����������ؾ�ֻ�");
			Container con = aboutDialog.getContentPane();
			//Swing ��ʹ��html���
			JLabel aboutLabel = new JLabel(
					"<html><b>"
						+"<center><br>QQserver</br><br>verson:1.0</br><br>Copyright 2014 gdufs, All matherfucker reserverd ��Ȩ���� �㶫������ó��ѧ kingpin lin</br></html></b>",
						JLabel.CENTER);
			aboutLabel.setFont(new Font("����",Font.HANGING_BASELINE,15));
			con.add(aboutLabel,BorderLayout.CENTER);
			aboutDialog.setResizable(false);
			aboutDialog.setSize(600,200);
			aboutDialog.setLocation(205,300);
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException,
		SQLException, IOException, InterruptedException
	{
		mainServer server = new mainServer();
	}
	
}
