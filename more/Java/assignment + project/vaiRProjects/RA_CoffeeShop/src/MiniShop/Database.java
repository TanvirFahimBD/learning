package MiniShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Database {
	private static Connection con;
	int Number=0;
	public static String name;
	

	public boolean query(FormPane form) throws SQLException{
		String sql=form.getSql();
		java.sql.Statement selectStatement= con.createStatement();
		ResultSet res=selectStatement.executeQuery(sql);
		while(res.next()){
			Number++;
			name=res.getString(3);
			
			}
			if (Number==0){
		       return false;
		     } 
			else
		     {
				Number=0;
		    	return true;
		     }
		}	
	

	   void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/POS_RA_COFFEE_SHOP1";
		con= (Connection) DriverManager.getConnection(url, "root", "");
	}
	
	   void disconnect() throws SQLException{
		   
		   con.close();
	   }

}
