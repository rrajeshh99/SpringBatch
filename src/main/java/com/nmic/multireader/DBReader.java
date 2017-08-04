package com.nmic.multireader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBReader {

	@Autowired
	private DataSource dataSource;
	
	public String getDBValue() throws SQLException{
		String value =null;
		if(dataSource != null){
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select name from organization where id = 2");
			while(rs.next()){
				value = rs.getString(1);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}
		
		return value;
	}
}
