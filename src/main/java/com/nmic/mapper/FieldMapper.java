package com.nmic.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import s15.SpringBatch.model.OffsetAndAdjustmentData;

public class FieldMapper implements RowMapper<OffsetAndAdjustmentData>{

	@Override
	public OffsetAndAdjustmentData  mapRow(ResultSet rs, int arg1) throws SQLException {
		OffsetAndAdjustmentData data = new OffsetAndAdjustmentData();
		data.setAccount_Number(rs.getInt(1));
		data.setAdj_Amount(rs.getInt(2));
		data.setAmount_Type(rs.getString(3));
		data.setStatus(rs.getString(4));
		data.setOffset_type(rs.getString(5));
		data.setAdj_Type(rs.getString(6));
		data.setAmount(rs.getInt(7));
		return data;
	}
}
