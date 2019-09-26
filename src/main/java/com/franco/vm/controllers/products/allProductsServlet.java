package com.franco.vm.controllers.products;

import com.franco.vm.bean.ProductBeanI;
import com.franco.vm.model.Product;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "all-products", urlPatterns = "/all-products")
public class allProductsServlet extends HttpServlet {

    @EJB
    ProductBeanI productBeanI;
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
                ArrayList<Product> products = productBeanI.readAll();
                req.setAttribute("products",products);
                req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
                req.getRequestDispatcher("/views/products/allProducts.jsp").include(req,resp);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
}
