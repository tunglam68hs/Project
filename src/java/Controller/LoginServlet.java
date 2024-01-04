/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DAO;
import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author tungl
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("View/LoginPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty() ) {
            User c = DAO.INSTANCE.checkLogin(username, password);
            if (c != null) {
                HttpSession session = request.getSession();
                session.setAttribute("roll", c.getRoll());
                session.setAttribute("cus", c);
                    request.getRequestDispatcher("View/abc.jsp").forward(request, response);  
            } else {
                String mes = "Wrong Username or Password.";
                request.setAttribute("mes", mes);
            }
        } else {
            String mes = "Username or Password can not be blank, please input.";
            request.setAttribute("mes", mes);
        }
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
