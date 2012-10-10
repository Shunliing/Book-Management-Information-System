import java.sql.*;

public class PreparedSQL {
	Connection conn;
	PreparedStatement stm;
	
	public PreparedSQL() throws Exception{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://210.30.108.66:3306/booksystem";
			   
			//get a connection to the database for a user named booksystem
			conn = DriverManager.getConnection(url, "booksystem", "booksystem");
			
			stm=conn.prepareStatement("insert into Admin(null,password) value(?,?)");
		    String [][] admin={{"a","aa"},{"b","bb"},{"c","cc"},{"d","dd"}};
		    for(int i=0;i<4;i++){
		    	stm.setString(1,admin[i][0].toString());
	    		stm.setString(2,admin[i][1].toString());
	    		stm.execute();
		    }
		}catch(ClassNotFoundException e){
		       throw new Exception("Database Driver Not Found" + e.getMessage());
		}catch(SQLException e){
		       throw new Exception("Database Not Connected" + e.getMessage());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PreparedSQL pl=new PreparedSQL();
		}catch(ClassNotFoundException ce){
			System.out.println("SQLException:"+ce.getMessage());
		}catch(SQLException ex){
			System.out.println(ex);
		}catch(Exception s){
			s.printStackTrace();
		}
	}

}
