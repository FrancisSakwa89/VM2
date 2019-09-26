package com.franco.vm.bean;

import com.franco.vm.model.CashDrawer;
import com.franco.vm.model.Denomination;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Stateless
@Local
public class CashDrawerBean extends Bean<CashDrawer> implements CashDrawerBeanI {
    @Inject
    Connection c;
    @Override
    public CashDrawer findByDenomination(Denomination denomination) {
        String sql = "SELECT * FROM cash_drawer WHERE denomination='"+denomination+"'";
        CashDrawer cashDrawer = null;
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                cashDrawer = new CashDrawer();
                cashDrawer.setId(rs.getInt("id"));
                cashDrawer.setDenomination(denomination);
                cashDrawer.setCount(Math.toIntExact(rs.getLong("dn_count")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cashDrawer ;
    }
}
