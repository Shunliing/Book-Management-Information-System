import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteBook extends JPanel{
	private JTextField number, bookname, publish, author, isbn, price;
	private JLabel jnumber, jbookname, jpublish, jauthor, jisbn, jprice;
	private JButton button1, button2;
	PrintStream output;
	DataInputStream input;
	String message = "";
	String bookinfor[];

	public DeleteBook(){
		this.setLayout(null);
		jnumber = new JLabel("图书编号:", SwingConstants.RIGHT);
        number = new JTextField();
        jbookname = new JLabel("图书名:", SwingConstants.RIGHT);
        bookname = new JTextField();
        jpublish = new JLabel("出版社:", SwingConstants.RIGHT);
        publish = new JTextField();
        jauthor = new JLabel("作者:", SwingConstants.RIGHT);
        author = new JTextField();
        jisbn = new JLabel("ISBN:", SwingConstants.RIGHT);
        isbn = new JTextField();
        jprice = new JLabel("价格:", SwingConstants.RIGHT);
        price = new JTextField();
        button1 = new JButton("查看");
        button2 = new JButton("删除");

        jnumber.setBounds(55, 20, 90, 26);
        jbookname.setBounds(55, 100, 90, 26);
        jpublish.setBounds(30, 130, 115, 26);
        jauthor.setBounds(55, 160, 90, 26);
        jisbn.setBounds(55, 190, 90, 26);
        jprice.setBounds(55, 220, 90, 26);
        number.setBounds(160, 20, 160, 26);
        bookname.setBounds(160, 100, 160, 26);
        publish.setBounds(160, 130, 160, 26);
        author.setBounds(160, 160, 160, 26);
        isbn.setBounds(160, 190, 160, 26);
        price.setBounds(160, 220, 160, 26);
        button1.setBounds(150, 55, 100, 26);
        button2.setBounds(150, 255, 100, 26);

        bookname.setEnabled(false);
        publish.setEnabled(false);
        author.setEnabled(false);
        isbn.setEnabled(false);
        price.setEnabled(false);

        this.add(jnumber);
        this.add(number);
        this.add(button1);
        this.add(jbookname);
        this.add(bookname);
        this.add(jpublish);
        this.add(publish);
        this.add(jauthor);
        this.add(author);
        this.add(jisbn);
        this.add(isbn);
        this.add(jprice);
        this.add(price);       
        this.add(button2);

        button1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try{
        			if(number.getText().toString().equals(""))
        				JOptionPane.showMessageDialog(null, "图书编号不能为空！","修改",JOptionPane.WARNING_MESSAGE);
        			String sqlstr1;
					JdbcFiles conn = new JdbcFiles();
					sqlstr1 = "select number,bookname,publish,author,isbn,price from books where number='"+number.getText()+"'";
					ResultSet result = conn.executeQuery(sqlstr1);							
					   if(result.next()){
						   {
							   bookname.setText(result.getString("bookname"));
							   publish.setText(result.getString("publish"));
							   author.setText(result.getString("author"));
							   isbn.setText(result.getString("isbn"));
							   price.setText(result.getString("price"));
						   }
					}else
						JOptionPane.showMessageDialog(null, "图书信息未找到！", "删除",JOptionPane.WARNING_MESSAGE);
					   }catch (ClassNotFoundException ce) {
						   System.out.println("SQLException:" + ce.getMessage());
						   }catch (SQLException ex) {
							   System.out.println(ex);
							   } catch (Exception s) {
								   s.printStackTrace();
							   }
        		}
        	});

		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					String sqlstr2 = "delete from books where number='"+number.getText()+"'";
					int k = -1;
					JdbcFiles conn1 = new JdbcFiles();
					k=conn1.insert(sqlstr2);
					if(number.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "图书编号不能为空！", "修改", JOptionPane.WARNING_MESSAGE);
					else if(bookname.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "图书名不能为空！", "修改", JOptionPane.WARNING_MESSAGE);
					else if(publish.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "出版社不能为空！", "修改", JOptionPane.WARNING_MESSAGE);
					else if(author.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "作者不能为空！", "修改", JOptionPane.WARNING_MESSAGE);
					else if(isbn.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "ISBN 不能为空！", "修改", JOptionPane.WARNING_MESSAGE);
					else if(price.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "价格不能为空！", "修改", JOptionPane.WARNING_MESSAGE);
					else if (k > -1){
						JOptionPane.showMessageDialog(null, "删除成功！", "删除",JOptionPane.WARNING_MESSAGE);
						//conn1.close();
						} else
							JOptionPane.showMessageDialog(null, "删除失败！", "删除",JOptionPane.WARNING_MESSAGE);									
					}catch(ClassNotFoundException ce){
						System.out.println("SQLException:"+ce.getMessage());
						
					}catch(SQLException ex){
						System.out.println(ex);
						
					}catch(Exception s){
						s.printStackTrace();
						}
				}
			});
		setSize(250, 380);
		this.setVisible(true);
		}
	public static void main(String[] args){
		DeleteBook app1 = new DeleteBook();
		}		
}

		
		
		
	
