package com.mqtt;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcConnectionPool;

public class H2Store {
	
	public void storeData(String query) throws SQLException{
		
		JdbcConnectionPool cp = JdbcConnectionPool.create(
	            "jdbc:h2:~/hearts", "sa", "sa");
	        for (int i = 0; i < 10; i++) {
	            Connection conn = cp.getConnection();
	            conn.createStatement().execute(query);
	            conn.close();
	        }
	        cp.dispose();
	}

}
