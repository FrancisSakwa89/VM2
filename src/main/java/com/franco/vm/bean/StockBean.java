package com.franco.vm.bean;

import com.franco.vm.model.Product;
import com.franco.vm.model.Stock;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Stateless
@Local
public class StockBean extends Bean<Stock> implements StockBeanI {
    @Inject
    Connection c;
    @EJB
    private ProductBeanI productBeanI;

    @Override
    public long getStockBalance(Product product) {
        String sql = "SELECT * FROM stock WHERE product=" + product.getId();
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                return rs.getLong("quantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Stock getStockForProduct(Product product) {
        String sql = "SELECT * FROM stock WHERE product=" + product.getId();
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                Stock stock = new Stock();
                stock.setId(rs.getInt("id"));
                stock.setProduct(product);
                stock.setQuantity(rs.getInt("quantity"));
                return stock;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Stock();

    }

    public ArrayList<Stock> readAll() throws SQLException {
        String sql = "SELECT * FROM stock";
        ResultSet rs =c.createStatement().executeQuery(sql);
        ArrayList<Stock> stockArrayList = new ArrayList<>();
        while(rs.next()){
            Product product = new Product();
            int productId=rs.getInt("product");
            product.setId(productId);
            product=productBeanI.read(product);

            Stock stock = new Stock();
            stock.setProduct(product);

            stock.setQuantity(rs.getInt("quantity"));

            stockArrayList.add(stock);

        }

        return stockArrayList;

    }

}