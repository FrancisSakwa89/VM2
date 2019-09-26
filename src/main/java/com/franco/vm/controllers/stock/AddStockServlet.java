package com.franco.vm.controllers.stock;

import com.franco.vm.bean.ProductBeanI;
import com.franco.vm.bean.StockBeanI;
import com.franco.vm.model.Product;
import com.franco.vm.model.Stock;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "add-stock", urlPatterns = "/add-stock")
public class AddStockServlet extends HttpServlet {

    @EJB
    StockBeanI stockBeanI;

    @EJB
    ProductBeanI productBeanI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        try{
            Product product = new Product();
            product.setId(productId);
            Product product1 = productBeanI.read(product);
            stockBeanI.create(new Stock(product1,quantity));
        }catch (Exception e){
            System.out.println("Error adding stock...");
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
        req.getRequestDispatcher("/views/stock/AddStock.jsp").include(req,resp);
    }
}
