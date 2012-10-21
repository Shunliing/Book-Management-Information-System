import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

	public class UpdateUser extends JPanel{
		private JTextField number, name, college, subject, grade;
		private JLabel jnumber, jname, jpassword, jcollege, jsubject, jgrade;
		private JPasswordField password;
		private JButton button1, button2;
		PrintStream output;
		DataInputStream input;
		String message = "";
		String bookinfor[];

		public UpdateUser()
		{
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
			button1 = new JButton("查询");
			button2 = new JButton("修改");
			
			//set Controller's Bounds
			jnumber.setBounds(80, 20, 65, 26);
			jname.setBounds(80, 100, 65, 26);
			jpassword.setBounds(80, 130, 65, 26);
			jcollege.setBounds(80, 160, 65, 26);
			jsubject.setBounds(80, 190, 65, 26);
			jgrade.setBounds(80, 220, 65, 26);
			number.setBounds(160, 20, 160, 26);
			name.setBounds(160, 100, 160, 26);
			password.setBounds(160, 130, 160, 26);
			college.setBounds(160, 160, 160, 26);
			subject.setBounds(160, 190, 160, 26);
			grade.setBounds(160, 220, 160, 26);
			button1.setBounds(150, 55, 100, 26);
			button2.setBounds(150, 255, 100, 26);
			
			//set JTextField Not Editable
			name.setEnabled(false);
			password.setEnabled(false);
			college.setEnabled(false);
			subject.setEnabled(false);
			grade.setEnabled(false);
			
			//add Modules
			this.add(jnumber);
			this.add(number);
			this.add(jname);
			this.add(name);
			this.add(jpassword);
			this.add(password);
			this.add(jcollege);
			this.add(college);
			this.add(jsubject);
			this.add(subject);
			this.add(jgrade);
			this.add(grade);
			this.add(button1);
			this.add(button2);
			
			//add ActionListener for button1
			button1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						if(number.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "用户 ID 不能为空！","修改",JOptionPane.WARNING_MESSAGE);
						String sqlstr1;
						JdbcFiles conn=new JdbcFiles();
						sqlstr1="select number,name,password,college,subject,grade from users where number='"+number.getText()+"'";
						ResultSet result=conn.executeQuery(sqlstr1);							
						if(result.next()){
							{
								name.setText(result.getString("name"));
							    password.setText(result.getString("password"));
							    college.setText(result.getString("college"));
							    subject.setText(result.getString("subject"));
							    grade.setText(result.getString("grade"));
							    name.setEnabled(true);
							    password.setEnabled(true);
							    college.setEnabled(true);
							    subject.setEnabled(true);
							    grade.setEnabled(true);
							    }
							}else
								JOptionPane.showMessageDialog(null, "用户信息未找到！","修改",JOptionPane.WARNING_MESSAGE);
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
					try{
						String sqlstr2 = "update users set name='"+name.getText()+"',password='"+password.getText()+"',college='"+college.getText()+"',subject='"+subject.getText()+"',grade='"+grade.getText()+"' where number='"+number.getText()+"'";
						int k = -1;
						JdbcFiles conn1=new JdbcFiles();
						k = conn1.insert(sqlstr2);
						if(number.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "用户 ID 不能为空！","修改",JOptionPane.WARNING_MESSAGE);	
						else if(name.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "用户名不能为空！","修改",JOptionPane.WARNING_MESSAGE);	
						else if(password.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "密码不能为空！","修改",JOptionPane.WARNING_MESSAGE);	
						else if(college.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "学院不能为空！","修改",JOptionPane.WARNING_MESSAGE);	
						else if(subject.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "专业不能为空！","修改",JOptionPane.WARNING_MESSAGE);	
						else if(grade.getText().toString().equals(""))
							JOptionPane.showMessageDialog(null, "年级不能为空！","修改",JOptionPane.WARNING_MESSAGE);	
						else if (k > -1){
							JOptionPane.showMessageDialog(null, "修改成功！", "修改",JOptionPane.WARNING_MESSAGE);
							//conn1.close();
							}else
								JOptionPane.showMessageDialog(null, "修改失败！", "修改",JOptionPane.WARNING_MESSAGE);
						}catch(ClassNotFoundException ce){
							System.out.println("SQLException:" + ce.getMessage());
						}catch(SQLException ex){
							System.out.println(ex);	
						}catch(Exception s){
							s.printStackTrace();
							}
					}
				});
			setSize(250,400);
			this.setVisible(true);
			}
		
		public static void main(String[] args){
			UpdateUser app1 = new UpdateUser();
			}
}




