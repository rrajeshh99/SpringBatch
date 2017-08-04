package com.nmic.multireader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.nmic.common.HeaderConfig;

public class HeaderReader implements ItemReader<List<HeaderConfig>>{

	private ItemReader<HeaderConfig> itemReader;
	
	@Autowired
	private DBReader dbReader;
	
	@Override
	public List<HeaderConfig> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		ResultHolder holder = new ResultHolder();
		String v = dbReader.getDBValue();
		System.out.println(" *********************  "+v);
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
	
	public void setItemReader(ItemReader<HeaderConfig> itemReader) { 
		 		this.itemReader = itemReader; 
		 	} 

	private boolean process(HeaderConfig value, ResultHolder holder) {
		
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
		 		private List<HeaderConfig> records = new ArrayList<HeaderConfig>(); 
		 		private boolean exhausted = false; 
		 
		 
		 		public List<HeaderConfig> getRecords() { 
		 			return records; 
		 		} 
		 
		 
		 		public boolean isExhausted() { 
		 			return exhausted; 
		 		} 
		 
		 
		 		public void addRecord(HeaderConfig record) { 
		 			records.add(record); 
		 		} 
		 
		 
		 		public void setExhausted(boolean exhausted) { 
		 			this.exhausted = exhausted; 
		 		} 
		 	} 

}
