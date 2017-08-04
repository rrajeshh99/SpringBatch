package com.nmic.multireader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.nmic.model.TrailerData;

public class TrailerReader implements ItemReader<TrailerData>{

	@Autowired
	TrailerData trailerData;
	
	@Override
	public TrailerData read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		if(trailerData.isFinished())
			return null;
		trailerData.setFinished(Boolean.TRUE);
		return trailerData;
	}
}
