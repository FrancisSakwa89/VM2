package com.franco.vm.bean;

import com.franco.vm.exception.InsufficeintProductQuantityException;
import com.franco.vm.exception.InsufficientAmountException;
import com.franco.vm.model.*;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

@Singleton
@Local
@Startup
public class VendingMachine implements VendingMachineI {
    @EJB
    StockBeanI stockBeanI;
    @EJB
    SaleBeanI saleBeanI;
    @EJB
    CashDrawerBeanI cashDrawerBeanI;
    @EJB
    private MoneyConverterBeanI moneyConverterBeanI;

    @PostConstruct
    public void initialize() {
        // check if money is there or initialize

        for (Denomination denomination : Denomination.values()) {
            CashDrawer cashDrawer = cashDrawerBeanI.findByDenomination(denomination);
            if (cashDrawer == null) {
                cashDrawer = new CashDrawer();
                cashDrawer.setCount(10);
                cashDrawer.setDenomination(denomination);
                cashDrawerBeanI.create(cashDrawer);

            }
        }
    }

    @Override
    public BigDecimal calculateRequiredAmount(Product product, int quantity) {
        return product.getUnitPrice().multiply(new BigDecimal(quantity));
    }

    @Override
    public boolean makeSale(Product product, int quantity, Map<Denomination, Integer> denominations) throws Exception {
        for (Map.Entry m : denominations.entrySet()) {
            Denomination denomination = Denomination.valueOf(m.getKey().toString());
            CashDrawer cashDrawer = cashDrawerBeanI.findByDenomination(denomination);
            cashDrawer.setCount(cashDrawer.getCount() + (Integer) m.getValue());
            //update the denomination in the VM's cashdrawer
            cashDrawerBeanI.update(cashDrawer);
        }
        //convert money denominations to value
        BigDecimal userAmount = moneyConverterBeanI.getMoneyValueFromDenominations(denominations);
        BigDecimal requiredAmount = this.calculateRequiredAmount(product, quantity);
        BigDecimal balance = userAmount.subtract(requiredAmount);

        if (userAmount.compareTo(requiredAmount) < 0) {
            dispenseMoney(denominations);
            throw new InsufficientAmountException();
        }
        //check if the quantity required is available in stock
        if (stockBeanI.getStockBalance(product) < quantity) {
            dispenseMoney(denominations);
            throw new InsufficeintProductQuantityException();
        }

        //add denominations supplied to the VM cash drawer
        Sale sale = new Sale();
        sale.setDate(new Date());
        sale.setAmount(requiredAmount);
        sale.setProduct(product);
        sale.setQuantity(quantity);

        if (userAmount.compareTo(requiredAmount) > 0 && !giveChange(balance).isEmpty()) {

            dispenseMoney(giveChange(balance));
        }
        // record the sale transaction to db
        saleBeanI.makeSale(sale);

        Stock stock = stockBeanI.getStockForProduct(product);
        stock.setQuantity(stock.getQuantity() - quantity);
        stockBeanI.update(stock);
        return true;
    }

    private void dispenseMoney(Map<Denomination, Integer> denominations) {
        for (Map.Entry m : denominations.entrySet()) {
            Denomination denomination = Denomination.valueOf(m.getKey().toString());
            CashDrawer cashDrawer = cashDrawerBeanI.findByDenomination(denomination);
            cashDrawer.setCount(cashDrawer.getCount() - (Integer) m.getValue());
            //update the denomination in the VM's cashdrawer
            cashDrawerBeanI.update(cashDrawer);

        }
    }
//        persist sale to db

//    boolean status = saleBeanI.makeSale();
//    //check if the customer is to be given change
//        if (amount.compareTo(this.calculateRequiredAmount(product, quantity)) > 0) {
//        status = status && !giveChange(amount.subtract(this.calculateRequiredAmount(product, quantity))).isEmpty();
//    }
//        if (!status) {
//        this.refundCustomerMoney(denominations);
//    }
//        return status;
//
//
//
//    private void refundCustomerMoney(Map<Denomination, Integer> denominations) {        //dispense
//        System.out.println(denominations);
//    }

    private Map<Denomination, Integer> giveChange(BigDecimal amount) {
        Map<Denomination, Integer> map = moneyConverterBeanI.getDenominationsForMoney(amount);
        return moneyConverterBeanI.getMoneyValueFromDenominations(map).equals(amount) ? map : new HashMap<Denomination, Integer>();
    }

//    private void addStock(){
//
//    }


}




