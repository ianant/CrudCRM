package com.anant.mv.hibernate.dbtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DbTest
 */
@WebServlet("/DbTest")
public class DbTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DbTest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user="CRM";
		String Pass="CRM";
		String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			
			
			PrintWriter pw=response.getWriter();
			
			pw.println("\ninitiating connection::\n");
			
			Class.forName(driver);
			
			Connection conn=DriverManager.getConnection(url,user,Pass);
			
			pw.println("\nconnection estabalized with db"+url);
			
			conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			//throw new ServletException();
		}
	}

}
