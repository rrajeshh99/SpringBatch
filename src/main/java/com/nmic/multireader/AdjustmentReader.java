package com.nmic.multireader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


public class AdjustmentReader <OffsetAndAdjustmentData> implements ItemReader<List<OffsetAndAdjustmentData>>{

	private ItemReader<OffsetAndAdjustmentData> itemReader;
	
	@Override
	public List<OffsetAndAdjustmentData> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		ResultHolder holder = new ResultHolder();
		
		while(process(itemReader.read(), holder)){
		continue;	
		}
		if(holder.isExhausted()){
			holder.setExhausted(false);
			if(holder.getRecords().isEmpty()){
				return null;
			}
			return holder.getRecords();
		}else{			
			return null;
		}
		
	}
	
	public void setItemReader(ItemReader<OffsetAndAdjustmentData> itemReader) { 
		 		this.itemReader = itemReader; 
		 	} 

	private boolean process(OffsetAndAdjustmentData value, ResultHolder holder) {
		
		if(value != null){
			holder.addRecord(value);
			return true;
		}
		else{
		holder.setExhausted(true);
		return false;
		}
	}
	
	
	private class ResultHolder { 
		 		private List<OffsetAndAdjustmentData> records = new ArrayList<OffsetAndAdjustmentData>(); 
		 		private boolean exhausted = false; 
		 
		 
		 		public List<OffsetAndAdjustmentData> getRecords() { 
		 			return records; 
		 		} 
		 
		 
		 		public boolean isExhausted() { 
		 			return exhausted; 
		 		} 
		 
		 
		 		public void addRecord(OffsetAndAdjustmentData record) { 
		 			records.add(record); 
		 		} 
		 
		 
		 		public void setExhausted(boolean exhausted) { 
		 			this.exhausted = exhausted; 
		 		} 
		 	} 

}
