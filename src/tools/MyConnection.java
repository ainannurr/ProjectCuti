/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Simbok_pc
 */
public class MyConnection {
    private Connection connect;
    public Connection getConnection(){
     try {
            OracleDataSource ods = new OracleDataSource();
            ods.setDriverType("thin");
            ods.setServerName("localhost");
            ods.setPortNumber(1521);
            ods.setServiceName("XE");
            ods.setUser("DINA");
            ods.setPassword("DINA");
            connect = ods.getConnection();
            connect.createStatement()
                    .execute("alter session set "
                            + "current_schema=CUTI");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }
}

