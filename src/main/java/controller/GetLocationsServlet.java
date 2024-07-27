package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson; // Add Gson library for JSON serialization

import entity.BusinessLocation;

@WebServlet("/get-locations")
public class GetLocationsServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/hackathon";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Hem@kumari9";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BusinessLocation> locations = new ArrayList<>();

        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        	String sql = "SELECT id, name, latitude, longitude FROM business_locations";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    BusinessLocation location = new BusinessLocation();
                    location.setId(rs.getLong("id"));
                    location.setName(rs.getString("name"));
                    location.setLatitude(rs.getDouble("latitude"));
                    location.setLongitude(rs.getDouble("longitude"));
                    locations.add(location);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions properly
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Convert the list of locations to JSON
        Gson gson = new Gson();
        String json = gson.toJson(locations);

        // Write the JSON to the response
        try (PrintWriter out = resp.getWriter()) {
            out.print(json);
        }
    }
}
