package com.franco.vm.bean;

import com.franco.vm.model.Denomination;
import com.franco.vm.model.Product;

import javax.ejb.Local;
import java.math.BigDecimal;
import java.util.Map;

@Local
public interface VendingMachineI {

    BigDecimal calculateRequiredAmount(Product product, int quantity) ;
    boolean makeSale(Product product, int quantity, Map<Denomination,Integer> denominations) throws Exception;


}
