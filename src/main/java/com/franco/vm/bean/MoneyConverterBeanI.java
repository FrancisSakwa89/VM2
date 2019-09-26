package com.franco.vm.bean;

import com.franco.vm.model.Denomination;

import javax.ejb.Local;
import java.math.BigDecimal;
import java.util.Map;

@Local
public interface MoneyConverterBeanI {
    BigDecimal getMoneyValueFromDenominations(Map<Denomination, Integer> money);
    Map<Denomination, Integer> getDenominationsForMoney(BigDecimal amount);

}
