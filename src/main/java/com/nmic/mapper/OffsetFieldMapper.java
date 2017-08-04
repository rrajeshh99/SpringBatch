package com.nmic.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import s15.SpringBatch.model.OffsetAndAdjustmentData;

public class OffsetFieldMapper implements RowMapper<OffsetAndAdjustmentData>{

	//Account_Number , Offset_type , Adj_Type , Amount
	
	@Override
	public OffsetAndAdjustmentData  mapRow(ResultSet rs, int arg1) throws SQLException {
		OffsetAndAdjustmentData data = new OffsetAndAdjustmentData();
		data.setId(rs.getInt(1));
		data.setAdjId(rs.getInt(2));
		data.setAccount_Number(rs.getInt(3));
		data.setOffset_type(rs.getString(4));
		data.setAdj_Type(rs.getString(5));
		data.setAmount(rs.getInt(6));
		return data;
	}
}
