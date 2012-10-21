import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BookMain extends JFrame {
	private JPanel pan = new JPanel();
	private JLabel lbl;
	BorderLayout border = new BorderLayout();
	
	JMenuBar menubar = new JMenuBar();
	
	JMenu menu1 = new JMenu();
	JMenu menu2 = new JMenu();
	JMenu menu3 = new JMenu();
	JMenu menu4 = new JMenu();
	
	JMenuItem menuitem1 = new JMenuItem();
	JMenuItem menuitem2 = new JMenuItem();
	JMenuItem menuitem3 = new JMenuItem();
	JMenuItem menuitem4 = new JMenuItem();
	
	JMenuItem menuitem5 = new JMenuItem();
	JMenuItem menuitem6 = new JMenuItem();
	JMenuItem menuitem7 = new JMenuItem();
	
	JMenuItem menuitem8 = new JMenuItem();
	JMenuItem menuitem9 = new JMenuItem();
	JMenuItem menuitem10 = new JMenuItem();
	JMenuItem menuitem11 = new JMenuItem();
	
	JMenuItem menuitem12 = new JMenuItem();
	
	public void go(){
		this.getContentPane().setLayout(border);
		this.setTitle("图书借阅系统");
		lbl = new JLabel("呼啸山庄图书信息管理系统", SwingConstants.CENTER);
		CardLayout cardlayout = new CardLayout();
		pan.setLayout(cardlayout);
		pan.add(lbl, "图书信息管理系统");
		this.add(pan, BorderLayout.CENTER);
		this.setSize(540, 340);
		//this.setResizable(false);
		
		//set Layout location in the center of the screen
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width/2;
		int screenHeight = screenSize.height/2;
		int height = this.getHeight(); 
		int width = this.getWidth(); 
		setLocation(screenWidth-width/2, screenHeight-height/2);
		
		this.setVisible(true);
		this.setJMenuBar(menubar);
		
		menu1.setText("用户管理");
		menu2.setText("借阅管理");
		menu3.setText("图书管理");
		menu4.setText("退出");
		
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);
		
		menuitem1.setText("添加用户");
		menuitem2.setText("修改用户");
		menuitem3.setText("删除用户");
		menuitem4.setText("查询用户");
		
		menu1.add(menuitem1);
		menu1.add(menuitem2);
		menu1.add(menuitem3);
		menu1.add(menuitem4);
		
		menuitem5.setText("借阅图书");
		menuitem6.setText("归还图书");
		menuitem7.setText("查询图书");
		
		menu2.add(menuitem5);
		menu2.add(menuitem6);
		menu2.add(menuitem7);
		
		menuitem8.setText("添加图书");
		menuitem9.setText("修改图书");
		menuitem10.setText("删除图书");
		menuitem11.setText("查询图书");
		
		menu3.add(menuitem8);
		menu3.add(menuitem9);
		menu3.add(menuitem10);
		menu3.add(menuitem11);
		
		menuitem12.setText("Quit");
		
		menu4.add(menuitem12);
		
		menuitem1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddUser adduser1 = new AddUser();
				pan.add(adduser1,"添加用户信息");
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "添加用户信息");	
			}
		});
		menuitem2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateUser updateuser1 = new UpdateUser();
				pan.add(updateuser1,"修改用户信息");				 
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "修改用户信息");	
				
			}
		});
		menuitem3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DeleteUser deluser1 = new DeleteUser();
				pan.add(deluser1,"删除用户信息");
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "删除用户信息");	
				
			}
		});
		menuitem4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CheckUser checkuser1 = new CheckUser();
				pan.add(checkuser1,"查询用户信息");
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "查询用户信息");
			}
		});
		menuitem5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				LendBook lendbook1 = new LendBook();
				pan.add(lendbook1,"借阅图书信息");
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "借阅图书信息");	
			}
		});
		menuitem6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ReturnBook returnbook1 = new ReturnBook();
				pan.add(returnbook1,"归还图书信息");
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "归还图书信息");	
			}
		});
		menuitem7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CheckLent checklent1 = new CheckLent();
				pan.add(checklent1,"查询借阅信息");
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "查询借阅信息");	
			}
		});
		menuitem8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddBook addbook1 = new AddBook();
				pan.add(addbook1,"添加图书信息");
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "添加图书信息");	
			}
		});
		menuitem9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateBook updatebook1 = new UpdateBook();
				pan.add(updatebook1,"修改图书信息");
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "修改图书信息");	
			}
		});
		menuitem10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DeleteBook delbook1 = new DeleteBook();
				pan.add(delbook1,"删除图书信息");
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "删除图书信息");	
			}
		});
		menuitem11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CheckBook checkbook1 = new CheckBook();
				pan.add(checkbook1,"查询图书信息");
				CardLayout c1 = (CardLayout)pan.getLayout();
				c1.show(pan, "查询图书信息");	
			}
		});
		menuitem12.addActionListener(new java.awt.event.ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookMain bk = new BookMain();
		bk.go();

	}

}
