package com.franco.vm.bean;

import com.franco.vm.model.Product;
import com.franco.vm.model.Stock;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.ArrayList;

@Local
public interface StockBeanI extends BeanI<Stock>{
    long getStockBalance(Product product);
    Stock getStockForProduct(Product product);
    public ArrayList<Stock> readAll() throws SQLException;
}
