package com.franco.vm.bean;

import com.franco.vm.model.Sale;
import com.franco.vm.model.Stock;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.ArrayList;

@Local
public interface SaleBeanI {
    boolean makeSale(Sale sale);
    public ArrayList<Sale> readAll() throws SQLException;

}
