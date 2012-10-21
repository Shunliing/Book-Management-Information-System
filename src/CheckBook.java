import java.awt.*;
import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.*;
import java.util.*;

public class CheckBook extends JPanel implements ActionListener{
	private JTextField searchfield;
	private JLabel searchlabel;
	private JComboBox searchcbo;
	private JButton button1;
	
	Vector vector1 = new Vector();
	Vector vector2 = new Vector();
	
	JScrollPane jspane;
	private JPanel jp = new JPanel();
	JTable table;	 
	PrintWriter output;
	BufferedReader input;
	String message = "";
	
	public CheckBook(){
		searchlabel = new JLabel("查询图书信息:");
		searchfield = new JTextField("请输入查询条件");
		searchcbo = new JComboBox();
		button1 = new JButton("查询");
		searchcbo.addItem("按图书编号查询");
		searchcbo.addItem("按图书名查询");

		//jp.setLayout(new FlowLayout());

		//jp.add(searchlabel);
		//jp.add(searchfield);
		//jp.add(button1);
		//jp.add(searchcbo);
		//jp.add(button1);
		
		searchlabel.setBounds(100, 50, 200, 26);
		searchfield.setBounds(100, 90, 200, 26);
		searchcbo.setBounds(100, 130, 200, 26);
		button1.setBounds(200, 170, 100, 26);
		this.add(searchlabel);
		this.add(searchfield);
		this.add(searchcbo);
		this.add(button1);
		
		this.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.NORTH);
		 
		vector2.add("图书编号");
		vector2.add("图书名");
		vector2.add("作者");
		vector2.add("出版社");
		vector2.add("ISBN");
		vector2.add("价格");
		vector2.add("是否借出");
		 
		button1.addActionListener(this);
		this.setSize(500, 500);		
	}
	
	public void actionPerformed(ActionEvent e){
		String numorname, searchf, sql;
		numorname = searchcbo.getSelectedItem().toString();
		searchf = searchfield.getText().trim();{
			if(searchf.equals(""))
				JOptionPane.showMessageDialog(null, "查询条件不能为空！", "查询", JOptionPane.WARNING_MESSAGE);
			else if(numorname.equals(""))
				JOptionPane.showMessageDialog(null, "查询条件不能为空！", "查询", JOptionPane.WARNING_MESSAGE);
			}
		}
	public static void main(String[] args){
		CheckBook app1 = new CheckBook();
		}
}

			 
			 
			 
		