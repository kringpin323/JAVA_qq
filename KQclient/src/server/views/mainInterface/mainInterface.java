package server.views.mainInterface;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.InterruptedException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.tree.*;
import javax.swing.*;


public class mainInterface extends JFrame implements ActionListener
{
	private static final long serialVersionUID  = 1L;
	static public String ip = "127.0.0.1";
	//	服务器ip地址（猜想）

	HashMap<String, String>   map_qq  = new HashMap<String,String>();
	//定义组件，但是这个组件是指什么？
	String b2 = ".jpg";
	String b1 = "images//main//";
	JLabel imgLabel1  = new JLabel();
	JLabel imgLabel2 = new JLabel();
	JMenuBar jmb1, jmb2;
	JMenu jm1,jm2;
	JMenuItem jm1_online, jm1_hiden,jm1_leave,jm2_sysedit,jm2_editpw,jm2_help,jm2_exit;
	JPanel top, top_1,top_2,bottom,bottom_1,bottom_2,middle1,middle2,middle3;
	JLabel headimg , name ,jl_down;
	JButton add,sysseting, Safe, skin;
	JButton q_zone, blog, email, friend_net, wallet , soso, news ,messagebox, shopping;
	JTabbedPane jtp;
	JScrollPane jsp1 , jsp2, jsp3;
	JComboBox jcb;
	JTree jt;
	JPopupMenu popupMenu;
	JPopupMenu popupMenugp;
	JPopupMenu popupMenuchild;
	JFrame login_jf;
	JPanel login_jp;
	JLabel login_jl;
	JButton login_jb;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode[] Node = new DefaultMutableTreeNode[20];


	static public Container c_temp_main = null;  // 会话信息右下角弹窗
	static public mainInterface main_frame = null;
	static public int status; //当前状态
	static public String text_leave = "2000000您好，我在线不在，matherfucker，再来找我";
	static public String text_busy = "20000 您好， 我很忙，别来烦我";
	static public Date LastExceptionTime = null;   //记录心跳异常
	static public int heartbeatJudge =0;
	static public int heartbeatFrequency = 6; // 心跳频率
	static public int changed =0; // 判断是否接受过mInfo
	String back = "main_background.jpg";
	final static Integer temp = new Integer(1);
	Dimension dm = null;

	public mainInterface()  //public MainInterface(login_message lmessage)
	{
		//		status = lmessage.status;
		main_frame = this;
		c_temp_main = this.getContentPane();
		//		this.lmessage = lmessage;


		//		一系列的线程启动
		//创建组件画图

		login_jf = new JFrame();
		Toolkit tk = this.getToolkit();// 得到窗口工具条
		dm  =  tk.getScreenSize();
		login_jf.setLocation((int)(dm.getWidth()-315), 20);
		login_jp = new JPanel();
		login_jp.setLayout(null);
		login_jp.setOpaque(false);
		login_jb = new JButton("取消");
		login_jb.setFont(new Font("黑体",Font.PLAIN,15));
		login_jb.setActionCommand("取消登录");
		login_jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand() == "取消登录")
				{
					System.exit(0);//停止对服务器的申请，为什么用这种方式，直接mouse_clicked 不行吗？
				}
			}
		});
		login_jl = new JLabel(new ImageIcon("images/logining_Vip.gif"));
		//添加组件
		login_jl.setBounds(0, 100, 295, 150);
		login_jb.setBounds(100, 300, 80, 30);
		//		login_jp.add(login_jl);
		//		login_jp.add(login_jb);
		//		login_jf.add(login_jp);
		//设置背景图片
		final Container c1 = login_jf.getContentPane();
		ImageIcon img1 = new ImageIcon("images/loginingBg.jpg");
		imgLabel2.setIcon(img1);
		imgLabel2.setBounds(0,0,img1.getIconHeight(), img1.getIconHeight());
		((JPanel)login_jf.getContentPane()).setOpaque(false);
		login_jf.getLayeredPane().add(imgLabel2, new Integer(Integer.MIN_VALUE));
		login_jf.getLayeredPane().add(login_jl, new Integer(Integer.MAX_VALUE));
		login_jf.getLayeredPane().add(login_jb, new Integer(Integer.MAX_VALUE));
		// 背景图设置完成
		// 窗体设置
		login_jf.setTitle("KQ2014kingpinMatherFucker");
		Image icon = Toolkit.getDefaultToolkit().getImage("pic\\headpic.jpg");
		login_jf.setIconImage(icon);
		login_jf.setMinimumSize(new Dimension(295,450));
		login_jf.setResizable(false);
		login_jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_jf.setVisible(true);
		//		login.start();

		try
		{
			Thread thread = Thread.currentThread();
			thread.sleep(7000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}

		refresh();



		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){

				//				try{
				//					System.exit(0);
				//				}
				//				catch(InterruptedException e1)
				//				{}
			}
		});


	}

	public void actionPerformed(ActionEvent e)
	{

	}

	public void refresh()
	{
		//创建组件
		//设置背景图片
		ImageIcon img1 = new ImageIcon("main_background.jpg");
		imgLabel1.setIcon(img1);
		imgLabel1.setBounds(0,0, img1.getIconWidth(), img1.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false);
		// getLayeredPane().add(imgLabel1, new Integer(Integer.M
		//		设置背景图片完成
		//		创建面板
		GridLayout gl1 = new GridLayout(2,1);
		top = new JPanel(gl1);
		top.setOpaque(false);
		FlowLayout top_f1 = new FlowLayout(FlowLayout.LEFT);
		top_1 = new JPanel(top_f1);
		top_1.setOpaque(false);
		FlowLayout top_f2 = new FlowLayout(FlowLayout.LEFT);
		top_2 = new JPanel(top_f2);
		top_2.setOpaque(false);
		GridLayout gl2 = new GridLayout(2,1);
		bottom = new JPanel(gl2);
		bottom.setOpaque(false);
		FlowLayout f1 = new FlowLayout(FlowLayout.LEFT);
		f1.setHgap(0);
		bottom_1 = new JPanel(f1);
		bottom_1.setOpaque(false);
		FlowLayout f2  = new FlowLayout(FlowLayout.LEFT);
		f1.setHgap(0);
		bottom_2 = new JPanel(f2);
		bottom_2.setOpaque(false);
		//为每一个好友添加右击弹窗
		JMenuItem popInformation  = new JMenuItem("查看资料",new ImageIcon("images/operation_friend/information.jpg"));
		JMenuItem popChange = new JMenuItem("修改好友备注",new ImageIcon("images/operation_friend/change.jpg"));
		JMenuItem popDelete = new JMenuItem("删除好友",new ImageIcon("images/operation_friend/delete.jpg"));
		JMenuItem popEmail = new JMenuItem("给好友发邮件",new ImageIcon("images/operation_friend/email.jpg"));
		JMenuItem popMove = new JMenuItem("将好友移动到...");
		//		
		//		popInformation.addActionListener(eee);
		//		popChange.addActionListener(eee);
		//		popEmail.addActionListener(eee);
		//		popMove.addActionListener(eee);
		popInformation.setActionCommand("查看好友资料");
		popChange.setActionCommand("修改好友备注");
		popDelete.setActionCommand("删除好友");
		popEmail.setActionCommand("发邮件");
		popMove.setActionCommand("将好友移至各分组");
		popInformation.setFont(new Font("华康少女文字w5(p)", Font.PLAIN, 15));
		popChange.setFont(new Font("华康少女文字w5(p)", Font.PLAIN, 15));
		popDelete.setFont(new Font("华康少女文字w5(p)", Font.PLAIN, 15));
		popEmail.setFont(new Font("华康少女文字w5(p)", Font.PLAIN, 15));
		popMove.setFont(new Font("华康少女文字w5(p)", Font.PLAIN, 15));
		popupMenu = new JPopupMenu();
		popupMenugp  = new JPopupMenu();
		popupMenuchild = new JPopupMenu();
		popupMenu.add(popInformation);
		popupMenu.add(popDelete);
		popupMenu.add(popEmail);
		popupMenu.add(popChange);
		popupMenu.add(popMove);
		//构建对每个分组的弹窗
		JMenuItem pop_addgp = new JMenuItem("添加分组");
		JMenuItem pop_deletegp = new JMenuItem("删除分组");
		JMenuItem pop_updategp = new JMenuItem("修改分组");
		//		pop_addgp.addActionListener(eee);
		//		pop_deletegp.addActionListener(eee);
		//		pop_updategp.addActionListener(eee);
		pop_addgp.setActionCommand("添加分组");
		pop_deletegp.setActionCommand("删除分组");
		pop_updategp.setActionCommand("修改分组");
		popupMenugp.add(pop_addgp);
		popupMenugp.add(pop_deletegp);
		popupMenugp.add(pop_updategp);

		//建立好友树
		root = new DefaultMutableTreeNode();

		// -----------------------------设置窗体------------------------------------
		this.setTitle("QQ2012");
		Image icon = Toolkit.getDefaultToolkit().getImage("pic\\headpic.jpg");
		this.setIconImage(icon);
		this.setSize(295, 589);
		this.setMinimumSize(new Dimension(295, 450));
		this.setLocation(main_frame.getLocation().x, main_frame.getLocation().y);// 显示在屏幕中央
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		login_jf.dispose();



	}


	public static void main(String[] args)throws Exception
	{
		mainInterface news = new mainInterface();
	}

}





