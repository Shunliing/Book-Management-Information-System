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

public class CheckLent extends JPanel implements ActionListener{

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
	
	public CheckLent(){
		searchlabel = new JLabel("查询借阅书目:");
		searchfield = new JTextField("请输入查询条件");
		searchcbo = new JComboBox();
		button1 = new JButton("查询");
		searchcbo.addItem("按图书编号查询");
		searchcbo.addItem("按用户 ID 查询");
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
		vector2.add("书名");
		vector2.add("用户名");
		vector2.add("借出时间");
		vector2.add("应还时间");
		vector2.add("还书时间");
		vector2.add("是否退还");
		button1.addActionListener(this);
		this.setSize(500, 500);
	}

	 public void actionPerformed(ActionEvent e)
	 {
		 String numorname, searchf;
		 numorname = searchcbo.getSelectedItem().toString();
		 searchf = searchfield.getText().trim();
		 {
			 if(searchf.equals(""))
				 JOptionPane.showMessageDialog(null, "查询条件不能为空！", "查询", JOptionPane.WARNING_MESSAGE);
			 else
				 if(numorname.equals(""))
					 JOptionPane.showMessageDialog(null, "查询条件不能为空！", "查询", JOptionPane.WARNING_MESSAGE);
				 else
					 connect("searchbook" + "/" + searchf + "/" + numorname);
		 }
	 }
	 public void connect(String s){
		 Socket socket;
		 try{
			 socket = new Socket(InetAddress.getByName(""),4321);
			 output = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
			 input = new BufferedReader(new InputStreamReader(socket.getInputStream()));			 
			 output.println(s);
			 output.flush();
			 try{
				 while(!(message = input.readLine()).equals("end")){
					 String booklendinfor[];
					 booklendinfor = message.split("/");
					 Vector vector3 = new Vector();
					 vector3.add(booklendinfor[1]);
					 vector3.add(booklendinfor[2]);
					 vector3.add(booklendinfor[3]);
					 vector3.add(booklendinfor[4]);
					 vector3.add(booklendinfor[5]);
					 vector3.add(booklendinfor[6]);
					 
					 vector1.add(vector3);
					 }
				 table = new JTable(vector1, vector2);
				 jspane = new JScrollPane(table);
				 this.add(jspane,BorderLayout.CENTER);
				 }catch(IOException e){
					 System.out.println("无法获取图书信息");
					 }
			 output.close();
			 input.close();
			 socket.close();
			 }catch(EOFException eof){
				 System.out.println("服务器中断");
				 }catch(IOException e){
					 e.printStackTrace();
					 }
		 }
	 public static void main(String[] args){
		 CheckLent app1 = new CheckLent();
		}
}

