package com.nmic.processor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.nmic.common.HeaderConfig;
import com.nmic.common.NMICConstants;
import com.nmic.model.TrailerData;

public class HeaderProcessor implements ItemProcessor<List<HeaderConfig>,String>{
	
	@Autowired
	private TrailerData trailerData;

	@Override
	public String process(List<HeaderConfig> item) throws Exception {
		// TODO Auto-generated method stub		
		StringBuffer strBuffHeader = new StringBuffer();
		StringBuffer strBuffTrailer = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY");
		String currDate = sdf.format(Calendar.getInstance().getTime());
		for (HeaderConfig headerConfig : item) {
			
			strBuffTrailer = new StringBuffer();
			
			if(headerConfig.getFieldName().equals(NMICConstants.File_Creation_Date) ||
					headerConfig.getFieldName().equals(NMICConstants.File_Creation_Time) ||
						headerConfig.getFieldName().equals(NMICConstants.Expected_Posting_Date) ||
							headerConfig.getFieldName().equals(NMICConstants.File_Effective_Date)){
				strBuffHeader.append(currDate);
				continue;
			}
			if(headerConfig.getFieldvalue() == null || headerConfig.getFieldvalue().isEmpty()){
				int lenght = Integer.parseInt(headerConfig.getFieldLength());									
					for(int i=0;i<lenght;i++){						
						if(headerConfig.getFieldType().equals(NMICConstants.NUMERIC)){
							if(headerConfig.getNmicSegment().equals(NMICConstants.TRAILER_SECTION)){								
								strBuffTrailer.append("0");
							}else{
								strBuffHeader.append("0");
							}
						}else{
							if(headerConfig.getNmicSegment().equals(NMICConstants.TRAILER_SECTION)){
								strBuffTrailer.append(" ");
							}else{
								strBuffHeader.append(" ");
							}
					}					
				}
			}else{
				if(headerConfig.getNmicSegment().equals(NMICConstants.TRAILER_SECTION)){
					strBuffTrailer.append(headerConfig.getFieldvalue());
				}else{
					strBuffHeader.append(headerConfig.getFieldvalue());
				}
			}	
			
			if(headerConfig.getNmicSegment().equals(NMICConstants.TRAILER_SECTION)){
				setTrailerFieldValue(headerConfig.getFieldName(), strBuffTrailer.toString());
			}
		}					
		trailerData.setData(strBuffTrailer.toString());
		return strBuffHeader.toString();
	}
	
	
	public void setTrailerFieldValue(String fieldType, String value){
		if(fieldType.equals(NMICConstants.REC_TYPE)){
			trailerData.setRecType(value);
		}else if(fieldType.equals(NMICConstants.SUB_REC_TYPE)){
			trailerData.setSubRecType(value);
		}else if(fieldType.equals(NMICConstants.FILLER)){
			trailerData.setFiller(value);
		}
	}
	
}
