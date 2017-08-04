package com.nmic.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import s15.SpringBatch.model.OffsetAndAdjustmentData;

public class AdjustmentFieldMapper implements RowMapper<OffsetAndAdjustmentData>{

//	 Account_Number, Adj_Amount , Amount_Type  , Status
	
	@Override
	public OffsetAndAdjustmentData  mapRow(ResultSet rs, int arg1) throws SQLException {
		OffsetAndAdjustmentData data = new OffsetAndAdjustmentData();
		data.setId(rs.getInt(1));
		data.setAccount_Number(rs.getInt(2));
		data.setAdj_Amount(rs.getInt(3));
		data.setAmount_Type(rs.getString(4));
		data.setStatus(rs.getString(5));		
		return data;
	}
}
