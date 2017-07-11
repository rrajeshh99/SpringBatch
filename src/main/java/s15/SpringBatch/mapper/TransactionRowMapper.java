package s15.SpringBatch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import s15.SpringBatch.model.TransactionData;

public class TransactionRowMapper implements RowMapper<TransactionData>{

	@Override
	public TransactionData mapRow(ResultSet rs, int arg1) throws SQLException {
		TransactionData data = new TransactionData();
		data.setId(rs.getInt(1));
		data.setTransaction(rs.getString(2));
		data.setType(rs.getString(3));
		data.setAmount(rs.getString(4));
		return data;
	}
}
