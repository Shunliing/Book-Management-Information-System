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
		this.setTitle("Library Loan System");
		lbl = new JLabel("Book Management Information System of City Institue, DLUT");
		CardLayout cardlayout = new CardLayout();
		pan.setLayout(cardlayout);
		pan.add(lbl, "Book Management Information System");
		this.add(pan, BorderLayout.CENTER);
		this.setSize(500, 250);
		this.setVisible(true);
		this.setJMenuBar(menubar);
		
		menu1.setText("User Management");
		menu2.setText("Lending Management");
		menu3.setText("Book Management");
		menu4.setText("Quit");
		
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);
		
		menuitem1.setText("Add User");
		menuitem2.setText("Edit User");
		menuitem3.setText("Delete User");
		menuitem4.setText("Search a User");
		
		menu1.add(menuitem1);
		menu1.add(menuitem2);
		menu1.add(menuitem3);
		menu1.add(menuitem4);
		
		menuitem5.setText("Borrow Books");
		menuitem6.setText("Return Books");
		menuitem7.setText("Search a Book");
		
		menu2.add(menuitem5);
		menu2.add(menuitem6);
		menu2.add(menuitem7);
		
		menuitem8.setText("Add Books");
		menuitem9.setText("Edit Books");
		menuitem10.setText("Delete Books");
		menuitem11.setText("Search a Book");
		
		menu3.add(menuitem8);
		menu3.add(menuitem9);
		menu3.add(menuitem10);
		menu3.add(menuitem11);
		
		menuitem12.setText("Quit");
		
		menu4.add(menuitem12);
		
		menuitem1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddUsers addusers1 = new AddUsers();
				pan.add(addusers1,"Add User Information");
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Add User Information");	
			}
		});
		menuitem2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateUsers updateusers1=new UpdateUsers();
				pan.add(updateusers1,"Edit User Information");				 
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Edit User Information");	
				
			}
		});
		menuitem3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DelUsers delusers1=new DelUsers();
				pan.add(delusers1,"Delete User Information");
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Delete User Information");	
				
			}
		});
		menuitem4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SearchUser searchuser1=new SearchUser();
				pan.add(searchuser1,"Check User Information");
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Check User Information");
			}
		});
		menuitem5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				LendBook lendbook1=new LendBook();
				pan.add(lendbook1,"Borrowed Book Information");
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Borrowed Book Information");	
			}
		});
		menuitem6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ReturnBook returnbook1=new ReturnBook();
				pan.add(returnbook1,"Returned Book Information");
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Returned Book Information");	
			}
		});
		menuitem7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SearchLend searchlend1=new SearchLend();
				pan.add(searchlend1,"Search Borrowed Information");
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Search Borrowed Information");	
			}
		});
		menuitem8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddBook addbook1=new AddBook();
				pan.add(addbook1,"Add Book Information");
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Add Book Information");	
			}
		});
		menuitem9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateBook updatebook1=new UpdateBook();
				pan.add(updatebook1,"Edit Book Information");
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Edit Book Information");	
			}
		});
		menuitem10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DelBook delbook1=new DelBook();
				pan.add(delbook1,"Delete Book Information");
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Delete Book Information");	
			}
		});
		menuitem11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SearchBook searchbook1=new SearchBook();
				pan.add(searchbook1,"Search Book Information");
				CardLayout c1=(CardLayout)pan.getLayout();
				c1.show(pan, "Search Book Information");	
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
