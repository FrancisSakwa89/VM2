package com.franco.vm.bean;

import com.franco.vm.model.Product;
import com.franco.vm.model.Sale;
import com.franco.vm.model.Stock;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Stateless
@Local
public class SaleBean extends Bean<Sale> implements SaleBeanI {
    @Override
    public boolean makeSale(Sale sale) {
//        if(create(sale).getId()!=0){
//            return true;
//        }
        return false;
    }

    public ArrayList<Sale> readAll() throws SQLException {
        String sql = "SELECT * FROM sale";
        ResultSet rs =c.createStatement().executeQuery(sql);
        ArrayList<Sale> sales = new ArrayList<>();
        while(rs.next()){
            Product product = new Product();
            int productId=rs.getInt("product");
            product.setId(productId);
            product=productBeanI.read(product);

            Sale sale = new Sale();
            sale.setProduct(product);

            sale.setQuantity(rs.getInt("quantity"));
            sale.setId(rs.getInt("id"));
            sale.setDate(rs.getDate("date"));
            sale.setAmount(rs.getBigDecimal("amount"));
            sale.setProduct((Product) rs.getObject("Product"));

        }

        return sales;
}
}
