/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entities.User;

/**
 *
 * @author IC MOTS
 */
public class verifyDetailsServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet verifyDetailsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet verifyDetailsServlet at " + request.getContextPath() + "</h1>");
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
        String studentNumber = request.getParameter("studentNumber").trim();
        String name = request.getParameter("name");
        String predMark = request.getParameter("predMark");
         int predMarkInt = 0;
         
        try{
        int studNum = Integer.parseInt(studentNumber);
            predMarkInt = Integer.parseInt(predMark);
            
        }catch(NumberFormatException e){
           request.setAttribute("errorMessage", "Please enter valid numeric values for student number or predicate mark"); 
           request.getRequestDispatcher("errorPage.jsp").forward(request, response);
           return;
        }catch(Exception e){
            request.setAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            return;
        }
        if (studentNumber.length() != 9){
           request.setAttribute("errorMessage","Student number is not 9 digits long"); 
           request.getRequestDispatcher("errorPage.jsp").forward(request, response);
           return;
        }
        
        if (predMarkInt < 0 || predMarkInt > 100 ){
              request.setAttribute("errorMessage", "Predicate Mark in out of range/invalid"); 
              request.getRequestDispatcher("errorPage.jsp").forward(request, response);
              return;
        }
        String result = "";
        int countTotal = (int) request.getSession().getAttribute("countTotal");
        int countFail = (int) request.getSession().getAttribute("countFail");
        int countPass = (int) request.getSession().getAttribute("countPass");
        int countSupplement = (int) request.getSession().getAttribute("countSupplement");
        
        if (predMarkInt >= 40 && predMarkInt <= 49){
            countFail ++;
            countTotal++;
            result = "Fail";
        }else 
         if (predMarkInt >= 50 && predMarkInt <= 59){
            countSupplement ++;
            countTotal++;
            result = "Supplement";
        }else
        if (predMarkInt >= 60 ){
            countPass ++;
            countTotal++;
            result = "Pass";
        }else{
           if (predMarkInt < 40 ){ 
               result = "DID NOT QUALIFY TO WRITE EXAM";
           }
        }
        
        User user = new User(studentNumber, name,predMark );
        
        List<User> listOfUsers = (List<User>) request.getSession().getAttribute("listOfUsers");
        if (listOfUsers == null){
            listOfUsers = new ArrayList<>();
        }
        listOfUsers.add(user);
        
        request.getSession().setAttribute("listOfUsers", listOfUsers);
        
        request.setAttribute("result", result);
        request.getSession().setAttribute("countTotal", countTotal);
        request.getSession().setAttribute("countFail", countFail);
        request.getSession().setAttribute("countPass", countPass);
        request.getSession().setAttribute("countSupplement", countSupplement);
        
        request.getRequestDispatcher("verifyDetails_output.jsp").forward(request, response);
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
