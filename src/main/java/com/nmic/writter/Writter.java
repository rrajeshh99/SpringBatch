package com.nmic.writter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;

public class Writter  implements ItemWriter<List <List<String>>> , ItemStream{

	private FlatFileItemWriter<String> delegate;
	 
		
	@Override
	public void write(List<? extends List<List<String>>> list) throws Exception {
		List<String> lines = new ArrayList<String>();
		Iterator<? extends List<List<String>>> itr1 = list.iterator();
		while(itr1.hasNext()){
			 List<List<String>> listInside = itr1.next();	
			 Iterator<List<String>> itr2 = listInside.iterator();
			 while(itr2.hasNext()){
				 List<String> list3 = itr2.next();
				 this.delegate.write(list3);
			 }
		}
		/*Iterator<? extends OffsetAndAdjustmentData> itr = 	list.iterator();
		while (itr.hasNext()) {
			Map<Integer, List<OffsetAndAdjustmentData>> map =  (Map<Integer, List<OffsetAndAdjustmentData>>) itr.next();	
			Set<Integer> set = map.keySet();
			for (Integer adj : set) {
				List<OffsetAndAdjustmentData> adjOffsetList = map.get(adj);
				for (OffsetAndAdjustmentData data : adjOffsetList) {
					lines.add(data.toString());		
				}
			}
							
		}*/
		this.delegate.write(lines);
	}

	public void setDelegate(FlatFileItemWriter<String> delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public void close() throws ItemStreamException {
		this.delegate.close();
		
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		this.delegate.open(executionContext);
		
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		this.delegate.update(executionContext);
		
	}
	
}
