package com.franco.vm.bean;

import com.franco.vm.model.Product;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Stateless
@Local
public class ProductBean extends Bean<Product> implements ProductBeanI {

    @Inject
    Connection c;

    @Override
    public ArrayList<Product> readAll() throws SQLException {
        String sql = "SELECT * FROM product";
        ResultSet rs = c.createStatement().executeQuery(sql);
        ArrayList<Product> products = new ArrayList<>();

        while (rs.next()) {
            Product product = new Product();

            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setUnitPrice(BigDecimal.valueOf(rs.getDouble("unitPrice")));
            products.add(product);
        }
        return products;
    }
}
