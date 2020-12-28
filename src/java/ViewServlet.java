/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.MemberDAO;
import Pojo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Makwana Divya
 */
@WebServlet(urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            List<Member> list = MemberDAO.getMembers();  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("<title>Members' Details</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<ul><li><h1 id=\"head\">Members' Details</h1><a href=\"index.html\"><button id=\"add\">Add new member</button></a></li></ul>");
            out.println("<table><tr><th>name</th><th>email</th><th>password</th><th>phone</th><th>age</th><th>gender</th><th>city</th><th>Action</th></tr>");
            list.forEach((m) -> {
                out.println("<tr><td>"+m.getFirstname()+" "+m.getLastname()+"</td>"
                        + "<td>"+m.getEmail()+"</td><td>"+m.getPassword()+"</td>"
                        + "<td>"+m.getPhone()+"</td><td>"+m.getAge()+"</td>"
                        + "<td>"+m.getGender()+"</td><td>"+m.getCity()+"</td>"
                        + "<td><a href='EditServlet?id="+m.getId()+"'>Edit</a>"+" | "
                        +"<a href='DeleteServlet?id="+m.getId()+"'> Delete</a></td></tr>");
            });
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
