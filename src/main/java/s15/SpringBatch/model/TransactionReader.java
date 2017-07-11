package s15.SpringBatch.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class TransactionReader implements ItemReader<TransactionData>{
	
	private int index =0;
	private List<TransactionData> tranList;
		public TransactionReader() {
			prepareStaticData();
		}
		
		public void prepareStaticData(){
			TransactionData data = new TransactionData();
			tranList = new ArrayList<TransactionData>();
			data.setAmount("100");
			data.setType("C");
			data.setTransaction("1");
			data.setId(1);
			tranList.add(data);
			
			data = new TransactionData();
			data.setAmount("200");
			data.setType("D");
			data.setTransaction("2");
			data.setId(2);
			tranList.add(data);
			data = new TransactionData();
			data.setAmount("300");
			data.setType("D");
			data.setTransaction("3");
			data.setId(3);
			tranList.add(data);
			data = new TransactionData();
			data.setAmount("400");
			data.setType("D");
			data.setTransaction("4");
			data.setId(4);
			tranList.add(data);
		}
	
	@Override
	public TransactionData read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		TransactionData tranData = null;	
		if(index < tranList.size()){
			tranData = tranList.get(index);
			index++;
			}
		return tranData;
	}
}
