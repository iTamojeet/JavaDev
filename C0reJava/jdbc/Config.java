import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Config {
    
    public static void main(String[] args) {
        // IO.println("HI ALL");

        try(Connection oracleConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##scott","tiger")){
            IO.println(oracleConn);
        }
        catch(SQLException s){
            IO.println("Oracle failed "+s);
        }

        try(Connection mysqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airportdb","root","garden")){
            IO.println(mysqlConn);
        }
        catch(SQLException s){
            IO.println("MySql failed "+s);
        }
    }

    /*
    static {
        try {
            IO.println(Class.forName("com.mysql.cj.jdbc.Driver"));
            IO.println(Class.forName("oracle.jdbc.OracleDriver"));
        }
        catch(ClassNotFoundException c){
            IO.println("not found "+c);
        }
    }
    */
}
