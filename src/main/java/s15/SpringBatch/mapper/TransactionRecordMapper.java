package s15.SpringBatch.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import s15.SpringBatch.model.TransactionData;

public class TransactionRecordMapper implements FieldSetMapper<TransactionData>{

	@Override
	public TransactionData mapFieldSet(FieldSet fs) throws BindException {
		// TODO Auto-generated method stub
		TransactionData tx = new TransactionData();
		tx.setId(fs.readInt(0));
		tx.setTransaction(fs.readString(1));
		tx.setAmount(fs.readString(2));
		tx.setType(fs.readString(3));
		return tx;
	}
}
