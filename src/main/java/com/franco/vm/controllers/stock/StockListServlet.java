package com.franco.vm.controllers.stock;

import com.franco.vm.bean.StockBeanI;
import com.franco.vm.model.Stock;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "all-stock", urlPatterns = "/all-stock")
public class StockListServlet extends HttpServlet {
    @EJB
    StockBeanI stockBeanI;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Stock> stock = stockBeanI.readAll();
            req.setAttribute("stock",stock);
            req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
            req.getRequestDispatcher("/views/stock/stock.jsp").include(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
