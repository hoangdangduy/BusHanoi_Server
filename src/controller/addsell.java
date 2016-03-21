package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class addsell
 */
public class addsell extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addsell() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");    
        PrintWriter ut = response.getWriter();   
		java.sql.Connection conn = null;
		
		String name = request.getParameter("ten");
		float kinhdo = Float.parseFloat(request.getParameter("kinhdo"));
		float vido = Float.parseFloat(request.getParameter("vido"));
		String batdau = request.getParameter("batdau");
		String giodong = request.getParameter("giodong");
		
		String sql = "INSERT INTO tblDiembanve(ten, kinhdo, vido, gioMoCua,gioDongCua) VALUES(?,?,?,?,?)";
	    try{
	    	ConnectSQL connectSQL = new ConnectSQL();
			conn = connectSQL.getConnecttion();
	        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
	        ps.setString(1, name);
	        ps.setFloat(2,kinhdo);
	        ps.setFloat(3, vido);
	        ps.setString(4, batdau);
	        ps.setString(5,giodong);  
	        ps.executeUpdate();
	        ut.print("sai à");
	        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.include(request,response);    
	        conn.close();
	    }catch(Exception e){
	        e.printStackTrace();
	    }      
	}

}
