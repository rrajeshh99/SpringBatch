package com.nmic.multireader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.nmic.common.HeaderConfig;

import s15.SpringBatch.model.OffsetAndAdjustmentData;

public class MultiTableReader implements ItemReader<Map<Integer, List<OffsetAndAdjustmentData>>>{

	
	private AdjustmentReader<OffsetAndAdjustmentData> itemReader1;
	private OffsetReader<OffsetAndAdjustmentData> itemReader2;
	
	@Override
	public Map<Integer, List<OffsetAndAdjustmentData>> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		ResultHolder holder = new ResultHolder();
		
		List<OffsetAndAdjustmentData> adjustmentList = itemReader1.read();		
		List<OffsetAndAdjustmentData> offsetList = itemReader2.read();
		
		if(adjustmentList == null || adjustmentList.isEmpty())
				return null;
		if(offsetList == null || offsetList.isEmpty())
			return null;
		
				
		Map<Integer, List<OffsetAndAdjustmentData>> dataMap = new HashMap<Integer,List<OffsetAndAdjustmentData>>();
		for (OffsetAndAdjustmentData adjustmentData : adjustmentList) {
			List<OffsetAndAdjustmentData> adjOffsetList = new ArrayList<OffsetAndAdjustmentData>();
			if(!dataMap.containsKey(adjustmentData.getId())){
				adjOffsetList.add(adjustmentData);
				dataMap.put(adjustmentData.getId(), adjOffsetList);
					
				for (OffsetAndAdjustmentData offsetData : offsetList) {
					if(offsetData.getAdjId() == adjustmentData.getId()){
						dataMap.get(adjustmentData.getId()).add(offsetData);	
					}				
				}
			}
		}
		
				return dataMap;
		
		
	}
	
	public void setItemReader1(AdjustmentReader<OffsetAndAdjustmentData> itemReader) { 
		 		this.itemReader1 = itemReader; 
		 	} 
	

	public void setItemReader2(OffsetReader<OffsetAndAdjustmentData> itemReader) { 
		 		this.itemReader2 = itemReader; 
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
