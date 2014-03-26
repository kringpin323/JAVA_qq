package server.views.login;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;

public class login extends JFrame implements MouseListener
{
	/*
	 * 
	 * */
	private static final long 	serialVersionUID = 1L; 
	//	这是神马意思？
	private JPanel				jp_login;
	private JTextField 			jt_user;
	private JPasswordField 		jp_password; //原來專門有這樣一個passwordField
	private JButton  			jb_login;
	private JLabel				jl_logo, jl_user, jl_password, jl_apply, jl_rember, jl_status;
	private JComboBox  			jco_status;
	private JCheckBox  			jch_rember,  jch_login;
	private Dimension  			screenSize;

	public login()
	{
		Image image = Toolkit.getDefaultToolkit().getImage("pic//headpic.jpg");
		setIconImage(image);
		//获取当前屏幕大小
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//获取当前窗口大小
		this.setLocation(screenSize.width/3,screenSize.height/3);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		//处理北部
		//logo
		jl_logo = new JLabel();
		jl_logo.setIcon(new ImageIcon("pic/logo.gif"));
		c.add(jl_logo,BorderLayout.NORTH);
		//處理中部
		//center
		jp_login = new JPanel();
		jp_login.setLayout(null);
		//QQ賬號
		jl_user = new JLabel();
		jl_user.setText("qq賬號");
		jl_user.setBounds(10,30,50,20);
		jl_user.setFont(new Font("黑體",Font.ROMAN_BASELINE,12));
		jp_login.add(jl_user);
		//QQ賬號登陸框
		jt_user = new JTextField();
		jt_user.setHorizontalAlignment(JTextField.LEFT);
		jt_user.setBounds(70,30,160,20);
		jp_login.add(jt_user);
		//申請賬號
		jl_apply = new JLabel();
		jl_apply.setText("申請賬號");
		jl_apply.setBounds(250, 30, 80, 20);
		jl_apply.setFont(new Font("宋體",Font.LAYOUT_NO_START_CONTEXT,12));
		jl_apply.setForeground(Color.green);
		jl_apply.addMouseListener(this);
		jp_login.add(jl_apply);

		//QQ密碼
		jl_password = new JLabel();
		jl_password.setText("QQ密碼");
		jl_password.setBounds(10,60,50,20);
		jl_password.setFont(new Font("宋體",Font.CENTER_BASELINE,12));
		jp_login.add(jl_password);

		//QQ密碼登陸框
		jp_password = new JPasswordField();
		jp_password.setBounds(70,60,160,20);
		jp_password.setHorizontalAlignment(JTextField.LEFT);
		jp_login.add(jp_password);
		// 添加鍵盤事件
		jp_password.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e){}
			
			public void keyReleased(KeyEvent e){}
			
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
//					try{}
				}
			}
		});

		//忘記密碼
		jl_rember = new JLabel();
		jl_rember.setText("忘了密碼");
		jl_rember.setFont(new Font("黑體",Font.PLAIN,12));
		jl_rember.setBounds(250, 60, 70, 20);
		jl_rember.setForeground(Color.blue);
		jl_rember.setBackground(Color.red);
		jl_rember.addMouseListener(this);
		jp_login.add(jl_rember);
		//狀態
		jl_status = new JLabel();
		jl_status.setText("狀態：");
		jl_status.setFont(new Font("黑體",Font.PLAIN,12));
		jl_status.setBounds(40,110,40,20);
		jl_status.setForeground(Color.black);
		jp_login.add(jl_status);
		jco_status = new JComboBox();
		jco_status.addItem("在線");
		jco_status.addItem("離開");
		jco_status.addItem("隱身");
		jco_status.addItem("忙碌");
		jco_status.addItem("請勿打擾");
		jco_status.setBounds(80, 110, 60, 20);
		jco_status.setFont(new Font("宋體",Font.PLAIN,13));
		jp_login.add(jco_status);
		
		//記錄密碼
		jch_rember = new JCheckBox();
		jch_rember.setText("記住密碼");
		jch_rember.setBounds(145, 110, 80, 20);
		jch_rember.setFont(new Font("宋體",Font.PLAIN,13));
		jp_login.add(jch_rember);
		
		// 自動登錄
		jch_login = new JCheckBox();
		jch_login.setText("自動登錄");
		jch_login.setFont(new Font("宋體",Font.PLAIN,13));
		jch_login.setBounds(230,110,80,20);
		jp_login.add(jch_login);
		
		//登錄
		jb_login = new JButton();
		jb_login.setIcon(new ImageIcon("pic//login.gif"));
		jb_login.setBounds(240,140,65,20);
		jp_login.add(jb_login);
		c.add(jp_login,BorderLayout.CENTER);
		// 響應
		jb_login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					jb_loginactionPerformed(e);
				}
				catch(Exception e1){}
			}
			
		});
		setResizable(false);
		setSize(348,250);
		setVisible(true);
		setTitle("KQ2014 matherfucker");
		
		
		
		
	}
	
	private void jb_loginactionPerformed(ActionEvent e)throws UnknownHostException, IOException,InterruptedException
	{
		if(jt_user.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,"請輸入賬號后登錄","motherkisser 提示",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(jt_user.getText().length()<6 || jt_user.getText().length() > 20)
		{
			JOptionPane.showMessageDialog(null, "請輸入正確的賬號，賬號可以為數字或者Email地址", "從來沒想過，有這樣的感覺", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else
		{
//			login_message lmessage = new login_message(jt_user.get)
//		這是可以登錄的信息，這裡先不作處理。
		}
			
	}
	
	private void jb_loginactionPerformed(KeyEvent e) throws UnknownHostException, IOException,InterruptedException
	{
		if(jt_user.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "請輸入賬號再登錄","提示",JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if(jt_user.getText().length()<6 || jt_user.getText().length()>20)
		{
			JOptionPane.showMessageDialog(null, "請輸入正確的賬號大於6位小於20位。","提示",JOptionPane.INFORMATION_MESSAGE);
			
		}
		else
		{
//			成功通過檢測以後登錄，登錄模塊就不是現在寫
		}
	}

	public void mouseReleased(MouseEvent e){}

	public void mousePressed(MouseEvent e){}

	public void mouseEntered(MouseEvent e){}

	public void mouseExited(MouseEvent e){}

	public void mouseClicked(MouseEvent e)
	{
		JLabel jl = (JLabel)e.getSource();
		if(jl == jl_rember)
		{
			if(jt_user.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "請先輸入賬號","提示",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{

			}
		}
		else if(jl == jl_apply)
		{
			//			apply a= new apply();
			//此處申請新的QQ賬號
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		login application = new login();
	}
}
