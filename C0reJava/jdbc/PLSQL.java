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
			CallableStatement stmt = con.prepareCall("{call p1(?,?)}");
			System.out.println("My statement is "+stmt);
			stmt.setInt(1,Integer.parseInt(args[0]));
			stmt.registerOutParameter(2,java.sql.Types.INTEGER);
			stmt.executeUpdate();
			System.out.println("The sal is "+stmt.getInt(2));
		}
		catch(SQLException e){
			System.out.println(e);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}