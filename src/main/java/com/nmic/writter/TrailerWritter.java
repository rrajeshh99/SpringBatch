package com.nmic.writter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;

import com.nmic.model.TrailerData;

public class TrailerWritter implements ItemWriter<TrailerData> , ItemStream{

	private FlatFileItemWriter<String> delegate;
	 
	
	@Override
	public void write(List<? extends TrailerData> list) throws Exception {
		List<String> lines = new ArrayList<String>();
		lines.add(list.get(0).getData());
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