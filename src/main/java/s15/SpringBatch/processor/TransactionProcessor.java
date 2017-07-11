package s15.SpringBatch.processor;

import org.springframework.batch.item.ItemProcessor;

import s15.SpringBatch.model.TransactionData;

public class TransactionProcessor implements ItemProcessor<TransactionData, TransactionData>{

	@Override
	public TransactionData process(TransactionData data) throws Exception {
		// TODO Auto-generated method stub
		if(data.getType().equals("A"))
			return null;
		
		return data;
	}
}
