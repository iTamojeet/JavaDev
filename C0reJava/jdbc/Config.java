import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Config {

    static Connection getOracleConn(String url, String user, String password){
        try(Connection oracleConn = DriverManager.getConnection(url,user,password)){
            return oracleConn;
        }
        catch(SQLException s){
            IO.println("Oracle failed "+s);
            return null;
        }
    }

    static Connection getMysqlConn(String url, String user, String password){
        try(Connection mysqlConn = DriverManager.getConnection(url,user,password)){
            return mysqlConn;
        }
        catch(SQLException s){
            IO.println("MySql failed "+s);
            return null;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        IO.println("Please enter 1 for Oracle DB connection and 2 for MySQL DB connection - ");
        
        int choice = Integer.parseInt(br.readLine());
        String user, password, database;

        Connection conn = switch (choice) {
            case 1 -> {
                IO.println("Enter your oracle user: ");
                user = br.readLine();
                IO.println("Enter your oracle password: ");
                password = br.readLine();
                yield getOracleConn("jdbc:oracle:thin:@localhost:1521:XE",user,password);
            }
            case 2 -> {
                IO.println("Enter your mysql user: ");
                user = br.readLine();
                IO.println("Enter your mysql password: ");
                password = br.readLine();
                IO.println("Enter your mysql database that you want to use: ");
                database = br.readLine();
                yield getMysqlConn("jdbc:mysql://localhost:3306/"+database,user,password);
            }
            default -> null;
        };
        
        IO.println(conn);
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
