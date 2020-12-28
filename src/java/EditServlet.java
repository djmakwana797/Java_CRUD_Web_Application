/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.MemberDAO;
import Pojo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Makwana Divya
 */
@WebServlet(urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

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
            
            int id = Integer.parseInt(request.getParameter("id"));
            Member m = MemberDAO.getMemberById(id);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edit details</title>");   
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"main\">\n" +
"            <h1>Edit member's details</h1>\n" +
"            <form method=\"post\" action=\"EditServlet2\">\n" + 
"                <input type=\"hidden\" name=\"id\" value=\""+m.getId()+"\">\n" +
"                <input type=\"text\" placeholder=\"Enter your first name\" name=\"fname\" value=\""+m.getFirstname()+"\">\n" +
"                <input type=\"text\" placeholder=\"Enter your last name\" name=\"lname\" value=\""+m.getLastname()+"\">\n" +
"                <input type=\"email\" placeholder=\"Enter your email address\" name=\"email\" value=\""+m.getEmail()+"\">\n" +
"                <input type=\"password\" placeholder=\"Enter Password\" name=\"pass\" value=\""+m.getPassword()+"\">\n" +
"                <input type=\"number\" placeholder=\"Enter your phone number\" name=\"phone\" value=\""+m.getPhone()+"\">\n" +
"                <input type=\"number\" placeholder=\"Enter your age\" name=\"age\" value=\""+m.getAge()+"\">\n" +
"                <select id=\"gender\" name=\"gender\">\n" +
"                    <option>Male</option>\n" +
"                    <option>Female</option>\n" +
"                    <option>Other</option>\n" +
"                </select>\n" +
"                <select id=\"city\" name=\"city\">\n" +
"                    <option>Select city</option>\n" +
"                    <option>Amreli</option>\n" +
"                    <option>Ahmedabad</option>\n" +
"                    <option>Bhavnagar</option>\n" +
"                    <option>Jamnagar</option>\n" +
"                    <option>Junagadh</option>\n" +
"                    <option>Morbi</option>\n" +
"                    <option>Porbandar</option>\n" +
"                    <option>Rajkot</option>\n" +
"                    <option>Surat</option>\n" +
"                </select>\n" +
"                <input class=\"button\" type=\"submit\" name=\"register\" value=\"Edit and Save\">\n" +
"                <a href=\"ViewServlet\"><input class=\"button\" id=\"records\" type=\"button\" name=\"records\" value=\"Cancel\"></a>  \n" +
"            </form>\n" +
"        </div>");
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
