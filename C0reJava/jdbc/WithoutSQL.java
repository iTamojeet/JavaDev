import java.sql.*;

class WithoutSQL{
    public static void main(String []args) throws Exception{
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##scott","tiger");
		System.out.println("My con is "+con);

        Statement st = con.createStatement(
            ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE
        );

        // int r = st.executeUpdate("CREATE TABLE myself (id NUMBER, name VARCHAR2(50))");
        // System.out.println("Table created " + r);

        ResultSet rs = st.executeQuery("select id, name from myself");
        System.out.println(rs.getConcurrency());
        rs.last();
        rs.moveToInsertRow();
        rs.updateInt("id",1);
        rs.updateString("name","Tamo");
        rs.insertRow();
    }

    // static{
    //     try{
    //         Class.forName("oracle.jdbc.OracleDriver");
    //     }
    //     catch(ClassNotFoundException c){
    //         System.out.println("not found "+c);
    //     }
    // }
}