/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.MemberDAO;
import Pojo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Makwana Divya
 */
@WebServlet(urlPatterns = {"/EditServlet2"})
public class EditServlet2 extends HttpServlet {

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
           String fname = request.getParameter("fname");
           String lname = request.getParameter("lname");
           String email = request.getParameter("email");
           String pass = request.getParameter("pass");
           String phone = request.getParameter("phone");
           int age = Integer.parseInt(request.getParameter("age"));
           String gender = request.getParameter("gender");
           String city = request.getParameter("city");
           //out.println(fname+lname+email+pass+phone+age+gender+city);  
           Member md = new Member();
           md.setId(id);
           md.setFirstname(fname);
           md.setLastname(lname);
           md.setEmail(email);
           md.setPassword(pass);
           md.setPhone(phone);
           md.setAge(age);
           md.setGender(gender);
           md.setCity(city);
           System.out.println(md.getFirstname());
           int row = MemberDAO.update(md);
           if(row>0){
               //out.println("Data updated succesfully");
               request.getRequestDispatcher("ViewServlet").include(request, response);
           }
           else{
               out.println("Error Occured while updating data");
           }
           out.close();
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
