package com.nmic.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.nmic.common.HeaderConfig;
import com.nmic.common.NMICConstants;

public class HeaderMapper implements FieldSetMapper<HeaderConfig>{

	@Override
	public HeaderConfig mapFieldSet(FieldSet fieldSet) throws BindException {
		
		String arr[] = null;
		
		HeaderConfig config = new HeaderConfig();
		
		arr = (fieldSet.readString(0)).split("=");
		if(arr.length == 2 && arr[1] != null){
		config.setNmicSegment(arr[1].trim());
		}
		
		arr = (fieldSet.readString(1)).split("=");
		if(arr.length == 2 && arr[1] != null){
		config.setFieldName(arr[1].trim());
		}
		arr = (fieldSet.readString(2)).split("=");
		if(arr.length == 2 && arr[1] != null){
		config.setFieldType(arr[1].trim());
		}
		arr = (fieldSet.readString(3)).split("=");
		if(arr.length == 2 && arr[1] != null){
		config.setFieldLength(arr[1].trim());
		}
		arr = (fieldSet.readString(4)).split("=");
		if(arr.length == 2 && arr[1] != null){
		config.setFieldvalue(arr[1].trim());
		}
		
//		config.setFieldName(fieldSet.readString(1));
//		config.setFieldType(fieldSet.readString(2));
//		config.setFieldLength(fieldSet.readString(3));
//		config.setFieldvalue(fieldSet.readString(4));

		return config;
	}
}
