import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM portal WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                response.getWriter().println(
                        "<h1>Welcome "
                                + rs.getString("name")
                                + "</h1>"
                );

                response.getWriter().println(
                        "<h3>Email : "
                                + rs.getString("email")
                                + "</h3>"
                );

                response.getWriter().println(
                        "<h3>Address : "
                                + rs.getString("address")
                                + "</h3>"
                );

            }

            else {

                response.getWriter().println(
                        "<h2>Invalid Email or Password!</h2>"
                );

            }

            con.close();

        }

        catch(Exception e) {

            e.printStackTrace();

        }

    }

}