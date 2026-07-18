import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        String address = request.getParameter("address");

        try (Connection con = DBConnection.getConnection();){

            String sql =
                    "INSERT INTO portal VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, address);

            int row = ps.executeUpdate();

            if(row > 0) {

                response.getWriter().println(
                        "<h2>Registration Successful!</h2>"
                );

            }

            else {

                response.getWriter().println(
                        "<h2>Registration Failed!</h2>"
                );

            }

            con.close();

        }

        catch(Exception e) {

            e.printStackTrace();

        }

    }

}