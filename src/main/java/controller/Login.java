package controller;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

// Import your model and entity classes
import model.UserRemote;
import entity.Details;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB(lookup = "java:global/Hackathon/UserModel!model.UserRemote")
    private UserRemote userRemote;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            password = hashPassword(password);
            // Validate input
            if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
                pw.print("Username and Password are required.");
                return;
            }

            // Fetch user details based on username (assuming getUserByUsername is implemented)
            Details user = userRemote.getUserByUsername(username);

            if (user == null) {
                pw.print("Invalid username.");
                pw.print(user);
                return;
            }

            // Verify password (assuming verifyPassword is implemented in UserRemote)
            if (!userRemote.verifyPassword(password, user.getPassword())) {
                pw.print("Invalid password.");
                return;
            }

            // Create a session for the user
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Redirect to a success page or dashboard
            response.sendRedirect("AddLocation.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            pw.print("An error occurred: " + e.getMessage());
        }
    }
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
