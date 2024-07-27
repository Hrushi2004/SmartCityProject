package controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/add-location")
public class AddLocationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/hackathon";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Hem@kumari9";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double latitude = Double.parseDouble(req.getParameter("latitude"));
        double longitude = Double.parseDouble(req.getParameter("longitude"));
        String userId = req.getParameter("username"); // Get from session or authentication

        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "INSERT INTO business_locations (name, latitude, longitude, user_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setDouble(2, latitude);
                stmt.setDouble(3, longitude);
                stmt.setString(4, userId);
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions properly
        }

        resp.sendRedirect("Map.jsp"); // Redirect to the map page
    }
}
