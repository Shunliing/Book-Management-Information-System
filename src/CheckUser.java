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

public class CheckUser extends JPanel implements ActionListener{
	private JTextField checkfield;
	private JLabel checklabel;
	private JComboBox checkcbo;
	private JButton button1;

	Vector vector1 = new Vector();
	Vector vector2 = new Vector();

	JScrollPane jspane;
	private JPanel jp = new JPanel();

	JTable table;

	PrintWriter output;
	BufferedReader input;

	String message = "";

	public CheckUser(){
		checklabel = new JLabel("查询用户信息:");
		checkfield = new JTextField("请输入查询条件");
		checkcbo = new JComboBox();
		button1 = new JButton("查询");
		checkcbo.addItem("用户 ID 查询");
		checkcbo.addItem("按用户名查询");
		
		//set JPanel Layout
		//jp.setLayout(new FlowLayout());

		//jp.add(checklabel);
		//jp.add(checkfield);
		//jp.add(checkcbo);
		//jp.add(button1);
		checklabel.setBounds(100, 50, 200, 26);
		checkfield.setBounds(100, 90, 200, 26);
		checkcbo.setBounds(100, 130, 200, 26);
		button1.setBounds(200, 170, 100, 26);
		
		this.add(checklabel);
		this.add(checkfield);
		this.add(checkcbo);
		this.add(button1);

		this.setLayout(new BorderLayout());
		this.add(jp, BorderLayout.NORTH);

		vector2.add("用户 ID");
		vector2.add("用户名");
		vector2.add("密码");
		vector2.add("学院");
		vector2.add("专业");
		vector2.add("年级");
		
		//add ActionListener for button1
		button1.addActionListener(this);
		this.setSize(500, 500);		
	}
	
	//add ActionEvent
	public void actionPerformed(ActionEvent e){
		String numorname, searchf, sql;
		numorname = checkcbo.getSelectedItem().toString();
		searchf = checkfield.getText().trim();
		{
			if(searchf.equals(""))
				JOptionPane.showMessageDialog(null, "查询条件不能为空！", "查询", JOptionPane.WARNING_MESSAGE);
			else if(numorname.equals(""))
				JOptionPane.showMessageDialog(null, "查询条件不能为空！", "查询", JOptionPane.WARNING_MESSAGE);
			else
				connect("checkuser" + "/" + searchf + "/" + numorname);
		}		
	}
	
	//connect method
	public void connect(String s){
		Socket socket;
		try{
			//create a Socket class object, specify the port number 3306
			socket = new Socket(InetAddress.getByName("210.30.108.66"), 3306);
			//create data input and output streams object
			output = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//output data stream
			output.println(s);
			output.flush();
			try{
				//read data stream
				while(!(message=input.readLine()).equals("end")){
					String userinfor[];
					//transmission the string into arrays
					userinfor = message.split("/");
					Vector vector3 = new Vector();
					vector3.add(userinfor[1]);
					vector3.add(userinfor[2]);
					vector3.add(userinfor[3]);
					vector3.add(userinfor[4]);
					vector3.add(userinfor[5]);
					vector3.add(userinfor[6]);
					
					vector1.add(vector3);						
				}
				table = new JTable(vector1, vector2);
				jspane = new JScrollPane(table);
				this.add(jspane, BorderLayout.CENTER);
			}catch(IOException e){
				System.out.println("无法获取用户信息");					
				}
			//close data stream and Socket object
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
		CheckUser app1 = new CheckUser();			
	}
}

