package s15.SpringBatch.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;

public class TransactionWriter implements ItemWriter<TransactionData> , ItemStream{

	private FlatFileItemWriter<String> delegate;
	private List<TransactionData> listTD = new ArrayList<TransactionData>(); 
	
	@Override
	public void write(List<? extends TransactionData> list) throws Exception {
		// TODO Auto-generated method stub
		List<String> lines = new ArrayList<String>();
		
		System.out.println(" Transaction data -- > "+list.size());
		int index =1;
		for (TransactionData data : list) {		
			
			lines.add(data.toString());
			if(index == list.size()){
				lines.add("Tail");
			}
			index++;
		}
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
