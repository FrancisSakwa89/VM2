package com.franco.vm.controllers.products;

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
import java.math.BigDecimal;
import java.sql.SQLException;


@WebServlet(name = "add-product", urlPatterns = "/add-product")
public class AddProductServlet extends HttpServlet {

    @EJB
    ProductBeanI productBeanI;

    @EJB
    StockBeanI stockBeanI;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("productName");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double me = Double.parseDouble(req.getParameter("productPrice"));
        BigDecimal price = BigDecimal.valueOf(me);

        try {
                productBeanI.create(new Product(name, price));
                System.out.println("added product successfully...");
//            stockBeanI.

                resp.sendRedirect("index.jsp");


        }catch (Exception e){
            System.out.println("error creating product..");
            e.printStackTrace();
            resp.sendRedirect("add-product");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/products/add-product.jsp").forward(req,resp);


    }
}
