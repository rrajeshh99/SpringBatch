package com.nmic.processor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.nmic.model.TrailerData;

import s15.SpringBatch.model.OffsetAndAdjustmentData;

public class TransactionProcessor implements ItemProcessor<Map<Integer, List<OffsetAndAdjustmentData>> ,List <List<String>> >{

	@Autowired
	TrailerData trailerData;
	
	List<OffsetAndAdjustmentData> listData = new ArrayList<OffsetAndAdjustmentData>(); 
	
	@Override
	public List <List<String>> process(Map<Integer, List<OffsetAndAdjustmentData>> mapData) throws Exception {
		// TODO Auto-generated method stub
//		if(data.getType().equals("A"))
//			return null;
		
		List <List<String>> linesOS = new ArrayList <List<String>>();
		List<String> lines = null;
//		Iterator<? extends OffsetAndAdjustmentData> itr = 	mapData.iterator();
//		while (itr.hasNext()) {
//			Map<Integer, List<OffsetAndAdjustmentData>> map =  (Map<Integer, List<OffsetAndAdjustmentData>>) itr.next();	
			Set<Integer> set = mapData.keySet();
			for (Integer adj : set) {
				List<OffsetAndAdjustmentData> adjOffsetList = mapData.get(adj);
				for (OffsetAndAdjustmentData data : adjOffsetList) {
					lines = new ArrayList<String>();
					lines.add(data.toString());		
				}
				linesOS.add(lines);
			}
							
//		}
		
		trailerData.setDebitAmount("debitAmount");
		trailerData.setDebitCount("debitCount");
		trailerData.setTotalCount("totalCount");
		trailerData.setTotalAmount("totalAmount");
		trailerData.setMiscCount("miscCount");
		trailerData.setCreditCount("CreditCount");
		trailerData.setCreditAmount("creditAmount");
		
		return linesOS;
	}
}
