/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nhatbeo
 */
@WebServlet(name = "AddTimeTableController", urlPatterns = {"/add"})
public class AddTimeTableController extends HttpServlet {

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
            out.println("<title>Servlet AddTimeTableController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddTimeTableController at " + request.getContextPath() + "</h1>");
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
        DAO dao = new DAO();
        Date date = Date.valueOf(request.getParameter("date"));
        int slotId = Integer.parseInt(request.getParameter("slot"));
        int classId = Integer.parseInt(request.getParameter("class"));
        int teacherId = Integer.parseInt(request.getParameter("teacher"));
        int roomId = Integer.parseInt(request.getParameter("room"));
        if (dao.checkRoomAvailable(roomId, slotId, date)
                && dao.checkTeacherAvailable(teacherId, slotId, date)
                && dao.checkClassAvailable(slotId, classId, date)) {
            dao.inserTimeTable(date, slotId, classId, teacherId, roomId);
            response.sendRedirect("home");
            return;
        }
        if (!dao.checkClassAvailable(slotId, classId, date)) {
            request.setAttribute("checkclass", "Class already learning this slot at that day");
        }
        if (!dao.checkRoomAvailable(roomId, slotId, date)) {
            request.setAttribute("checkroom", "Room is not available");
        }
        if (!dao.checkTeacherAvailable(teacherId, slotId, date)) {
            request.setAttribute("checkteacher", "Teacher already teaching this slot at that day");
        }
        request.getRequestDispatcher("add.jsp").forward(request, response);
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
