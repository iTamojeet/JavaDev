import java.sql.*;
class PLSQL{
    /* {
        System.out.println("Instance block: I am " + this);
    } */

	public static void main(String ...args){
		System.out.println("JDBC with PLSQL starts here...");
		//new PLSQL();
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##scott","tiger")){
			System.out.println("My con is "+con);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}