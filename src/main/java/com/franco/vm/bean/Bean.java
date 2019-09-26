package com.franco.vm.bean;

import com.franco.vm.model.*;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Local
@Stateless
public class Bean<T> implements BeanI<T> {
    @Inject
     Connection c;
    @EJB
     ProductBeanI productBeanI;

    @Override
    public T create(T t) {
        String sql = null;
        Statement stmt;
        if (t instanceof CashDrawer) {
            CashDrawer cashDrawer = (CashDrawer) t;
            sql = "INSERT INTO cash_drawer(denomination,dn_count)VALUES('" + cashDrawer.getDenomination() + "'," + cashDrawer.getCount() + ");";


        } else if (t instanceof Product) {
            Product product = (Product) t;
            sql = "INSERT INTO product(name,unitPrice)VALUES('" + product.getName() + "'," + product.getUnitPrice() + ");";

        } else if (t instanceof Sale) {
            Sale sale = (Sale) t;

            sql = "INSERT INTO sale(date,product,quantity,amount)VALUES(NOW()," + sale.getProduct().getId() + "," + sale.getQuantity() + "," + sale.getAmount() + "  );";

        } else if (t instanceof Stock) {
            Stock stock = (Stock) t;
            Product product = productBeanI.read(stock.getProduct());
            if (product.equals(stock.getProduct())) {
                sql = "INSERT INTO stock(product,quantity)VALUES(" + product.getId() + "," + stock.getQuantity() + ")";

            }

        }
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public T read(T t) {
        String sql = null;
        try {
            if (t instanceof CashDrawer) {
                CashDrawer cashDrawer = (CashDrawer) t;
                sql = "SELECT * FROM cash_drawer WHERE id=" + cashDrawer.getId();
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {

                    cashDrawer.setId(rs.getInt("id"));
                    cashDrawer.setDenomination(Denomination.valueOf(rs.getString("denomination")));
                    cashDrawer.setCount(rs.getInt("dn_count"));
                    return (T) cashDrawer;
                }


            } else if (t instanceof Product) {
                Product product = (Product) t;
                sql = "SELECT * FROM product WHERE id=" + product.getId();
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {

                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setUnitPrice(rs.getBigDecimal("unitPrice"));
                    return (T) product;
                }
            } else if (t instanceof Sale) {
                Sale sale = (Sale) t;
                sql = "SELECT * FROM sale WHERE id=" + sale.getId();
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    sale.setDate(rs.getDate("date"));
                    Product product = new Product();
                    product.setId(rs.getInt("product"));
                    sale.setProduct(productBeanI.read(product));
                    sale.setQuantity(rs.getInt("quantity"));
                    sale.setAmount(rs.getBigDecimal("amount"));
                    return (T) sale;
                }
            } else if (t instanceof Stock) {
                Stock stock = (Stock) t;
                sql = "SELECT * FROM stock where id=" + stock.getId();
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    stock.setId(rs.getInt("id"));
                    Product product = new Product();
                    product.setId(rs.getInt("product"));
                    stock.setProduct(productBeanI.read(product));
                    stock.setQuantity(rs.getInt("quantity"));

                    return (T) stock;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return t;
    }

    @Override
    public T update(T t) {
        Statement stmt = null;
        String sql = null;

        if (t instanceof CashDrawer) {
            CashDrawer cashDrawer = (CashDrawer) t;
            sql = "UPDATE  cash_drawer SET denomination='" + cashDrawer.getDenomination() + "',count=" + cashDrawer.getCount() + ");";

        } else if (t instanceof Product) {
            Product product = (Product) t;
            sql = "UPDATE  product SET name='" + product.getName() + "',unitPrice=" + product.getUnitPrice() + ");";

        } else if (t instanceof Sale) {
            Sale sale = (Sale) t;
            sql = "UPDATE sale SET  date='" + sale.getDate() + "',product=" + sale.getProduct().getId() + ",quantity=" + sale.getQuantity() + ",amount=" + sale.getAmount() + "  );";

        } else if (t instanceof Stock) {
            Stock stock = (Stock) t;
            sql = "UPDATE  stock SET product=" + stock.getProduct().getId() + ",quantity=" + stock.getQuantity() + ")";

        }
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public boolean delete(T t) {
        String sql = null;

        if (t instanceof CashDrawer) {
            CashDrawer cashDrawer = (CashDrawer) t;
            sql = "DELETE FROM cash_drawer WHERE id=" + cashDrawer.getId();

        } else if (t instanceof Product) {
            Product product = (Product) t;
            sql = "DELETE  FROM product WHERE id=" + product.getId();

        } else if (t instanceof Sale) {
            Sale sale = (Sale) t;
            sql = "DELETE  FROM sale WHERE id=" + sale.getId();

        } else if (t instanceof Stock) {
            Stock stock = (Stock) t;
            sql = "DELETE  FROM stock where id=" + stock.getId();

        }
        try {
            Statement stmt = c.createStatement();
            return stmt.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}