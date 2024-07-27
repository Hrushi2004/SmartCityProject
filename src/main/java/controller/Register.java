package controller;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserRemote;
import java.io.IOException;
import java.io.PrintWriter;
import entity.Details;

@WebServlet("/Register")
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@EJB(lookup = "java:global/Hackathon/UserModel!model.UserRemote")
	UserRemote r;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
    	try {
    		Details d = new Details();
    	String fullName = request.getParameter("fullName");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        d.setFullName(fullName);
        d.setDob(dob);
        d.setGender(gender);
        d.setEmail(email);
        d.setPhone(phone);
        d.setUsername(username);
        d.setPassword(password);
        
        String ack = r.InsertData(d);
		pw.print(ack);
    	}catch(Exception e){
    		pw.print(e.getMessage());
    	}
    }
}
