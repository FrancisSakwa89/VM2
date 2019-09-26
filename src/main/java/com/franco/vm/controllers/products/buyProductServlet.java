package com.franco.vm.controllers.products;

import com.franco.vm.bean.ProductBeanI;
import com.franco.vm.bean.StockBeanI;
import com.franco.vm.bean.VendingMachineI;
import com.franco.vm.model.Denomination;
import com.franco.vm.model.Product;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "saleProduct", urlPatterns = "/saleProduct")
public class buyProductServlet extends HttpServlet {
    @EJB
    ProductBeanI productBeanI;
    @EJB
    StockBeanI stockBeanI;

    @EJB
    VendingMachineI vendingMachineI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = new Product();
        product.setId(id);
        product=productBeanI.read(product);

        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int thousandcount= Integer.parseInt(req.getParameter("1000"));
        int fivehundredcount= Integer.parseInt(req.getParameter("500"));
        int twohundredcount = Integer.parseInt(req.getParameter("200"));
        int onehundredcount = Integer.parseInt(req.getParameter("100"));
        int fiftycount = Integer.parseInt(req.getParameter("50"));
        int twentycount = Integer.parseInt(req.getParameter("20"));
        int tencount = Integer.parseInt(req.getParameter("10"));
        int fivecount = Integer.parseInt(req.getParameter("5"));
        int onecount = Integer.parseInt(req.getParameter("1"));

        Map<Denomination, Integer> map = new HashMap<>();
          map.put(Denomination.THOUSAND_NOTE, thousandcount);
          map.put(Denomination.FIVE_HUNDRED_NOTE, fivehundredcount);
          map.put(Denomination.TWO_HUNDRED_NOTE, twohundredcount);
          map.put(Denomination.ONE_HUNDRED_NOTE, onehundredcount);
          map.put(Denomination.FIFTY_NOTE, fiftycount);
          map.put(Denomination.TWENTY_COIN, twentycount);
          map.put(Denomination.TEN_COIN, tencount);
          map.put(Denomination.FIVE_COIN, fivecount);
          map.put(Denomination.ONE_COIN, onecount);
        try {
            vendingMachineI.makeSale(product, quantity,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/products/buy-product.jsp").forward(req,resp);

    }
}
