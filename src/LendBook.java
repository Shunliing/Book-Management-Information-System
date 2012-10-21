import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;

public class LendBook extends JPanel{
	private JTextField bnumber,unumber;
	private JLabel jbnumber,junumber;
	private JButton button1,button2;
	PrintStream output;
	DataInputStream input;
	String message = "";
	
	public LendBook(){
		this.setLayout(null);
		jbnumber = new JLabel("图书编号:", SwingConstants.RIGHT);
		bnumber = new JTextField();
		junumber = new JLabel("用户 ID:", SwingConstants.RIGHT);
		unumber = new JTextField();
		button1 = new JButton("借阅");
		button2 = new JButton("取消");
		jbnumber.setBounds(55, 80, 90, 26);
		junumber.setBounds(55, 120, 90, 26);
		bnumber.setBounds(160, 80, 160, 26);
		unumber.setBounds(160, 120, 160, 26);
		button1.setBounds(115, 165, 80, 26);
		button2.setBounds(210, 165, 80, 26);
		this.add(jbnumber);
		this.add(bnumber);
		this.add(junumber);
		this.add(unumber);
		this.add(button1);
		this.add(button2);
		
		//add ActionListener for button1
	    button1.addActionListener(new ActionListener(){
	       	public void actionPerformed(ActionEvent e){
	       		if(bnumber.getText().toString().equals(""))
	        		JOptionPane.showMessageDialog(null, "图书编号不能为空！", "借阅", JOptionPane.WARNING_MESSAGE);
	        	else if(unumber.getText().toString().equals(""))
	            	JOptionPane.showMessageDialog(null, "用户 ID 不能为空！", "借阅", JOptionPane.WARNING_MESSAGE);
	       		}
	       	});
	    
	    //add ActionListener for button1
	    button2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		bnumber.setText("");
	    		unumber.setText("");
	    		}
	    	});
	    setSize(250, 300);
	    this.setVisible(true);
	    }
	
	//connect method
	public static void main(String[] args){
		LendBook app = new LendBook();
	}
}
