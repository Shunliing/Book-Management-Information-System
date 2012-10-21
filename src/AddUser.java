import java.awt.CardLayout;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class AddUser extends JPanel {
	private JTextField number, name, college, subject, grade;
	private JLabel jnumber, jname, jpassword, jcollege, jsubject, jgrade;
	private JPasswordField password;
	private JButton button1, button2;
	
	String message = "";
	
	public AddUser(){
		this.setLayout(null);
		jnumber = new JLabel("用户 ID:", SwingConstants.RIGHT);
		number = new JTextField();
		jname = new JLabel("用户名:", SwingConstants.RIGHT);
		name = new JTextField();
		jpassword = new JLabel("密码:", SwingConstants.RIGHT);
		password = new JPasswordField();
		jcollege = new JLabel("学院:", SwingConstants.RIGHT);
		college = new JTextField();
		jsubject = new JLabel("专业:", SwingConstants.RIGHT);
		subject = new JTextField();
		jgrade = new JLabel("年级:", SwingConstants.RIGHT);
		grade = new JTextField();
		button1 = new JButton("添加");
		button2 = new JButton("取消");
		
		//set JLabel's Bounds
		jnumber.setBounds(80, 20, 65, 26);
		jname.setBounds(80, 60, 65, 26);
		jpassword.setBounds(80, 100, 65, 26);
		jcollege.setBounds(80, 140, 65, 26);
		jsubject.setBounds(80, 180, 65, 26);
		jgrade.setBounds(80, 220, 65, 26);
		
		//set JTextField's Bounds
		number.setBounds(160, 20, 160, 26);
		name.setBounds(160, 60, 160, 26);
		password.setBounds(160, 100, 160, 26);
		college.setBounds(160, 140, 160, 26);
		subject.setBounds(160, 180, 160, 26);
		grade.setBounds(160, 220, 160, 26);
		
		//set JButton's Bounds
		button1.setBounds(80, 255, 100, 26);
		button2.setBounds(200, 255, 100, 26);
		
		//add Modules
		this.add(jnumber);
		this.add(jname);
		this.add(jpassword);
		this.add(jcollege);
		this.add(jsubject);
		this.add(jgrade);
		this.add(number);
		this.add(name);
		this.add(password);
		this.add(college);
		this.add(subject);
		this.add(grade);
		this.add(button1);
		this.add(button2);
		
		//add ActionListener for button1
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					JdbcFiles conn = new JdbcFiles();
					String sqlstr = "insert into users(number,name,password,college,subject,grade) values('"
							+ number.getText()
							+ "','"
							+ name.getText()
							+ "','"
							+ password.getText()
							+ "','"
							+ college.getText()
							+"','"
							+ subject.getText()
							+ "','"
							+ grade.getText() + "')";
					int k = -1;
					k = conn.insert(sqlstr);
					if (number.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "用户 ID 不能为空！", "添加", JOptionPane.WARNING_MESSAGE);
					else if (name.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "用户名不能为空！", "添加", JOptionPane.WARNING_MESSAGE);
					else if (password.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "密码不能为空！", "添加", JOptionPane.WARNING_MESSAGE);
					else if (college.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "学院不能为空！", "添加", JOptionPane.WARNING_MESSAGE);
					else if (subject.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "专业不能为空！", "添加", JOptionPane.WARNING_MESSAGE);
					else if (grade.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "年级不能为空！", "添加", JOptionPane.WARNING_MESSAGE);
					else if (k > -1){
						JOptionPane.showMessageDialog(null, "添加成功！", "添加", JOptionPane.WARNING_MESSAGE);
						//conn.close();
					}else
						JOptionPane.showMessageDialog(null, "添加失败！", "添加", JOptionPane.WARNING_MESSAGE);
				}catch (ClassNotFoundException ce){
					System.out.println("SQLException:" + ce.getMessage());
				}catch (SQLException ex){
					System.out.println(ex);
				}catch (Exception s){
					s.printStackTrace();
				}
			}
		});
		
		//add ActionListener for button2
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				number.setText("");
				name.setText("");
				password.setText("");
				college.setText("");
				subject.setText("");
				grade.setText("");
			}
		});
		setSize(250, 400);
		this.setVisible(true);
	}
	public static void main(String[] args){
		AddUser app = new AddUser();
	}

}
