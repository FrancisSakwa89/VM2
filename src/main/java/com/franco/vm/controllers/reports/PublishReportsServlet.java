package com.franco.vm.controllers.reports;

import com.franco.vm.bean.SaleBeanI;
import com.franco.vm.model.Sale;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "report", urlPatterns = "/report")
public class PublishReportsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @EJB
    SaleBeanI saleBeanI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Sale> sales = saleBeanI.readAll();
            req.setAttribute("sales",sales);
            req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
            req.getRequestDispatcher("/views/reports/allReports.jsp").include(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
