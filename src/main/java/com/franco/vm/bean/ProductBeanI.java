package com.franco.vm.bean;

import com.franco.vm.model.Product;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.ArrayList;


@Local

@SuppressWarnings("ALL")
public interface ProductBeanI extends BeanI<Product> {

    public  ArrayList<Product> readAll() throws SQLException ;


}