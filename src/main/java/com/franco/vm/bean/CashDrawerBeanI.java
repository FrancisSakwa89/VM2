package com.franco.vm.bean;

import com.franco.vm.model.CashDrawer;
import com.franco.vm.model.Denomination;

import javax.ejb.Local;

@Local
public interface CashDrawerBeanI extends BeanI<CashDrawer> {
    CashDrawer findByDenomination(Denomination denomination);
}