package com.nmic.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TrailerData {

private boolean finished = false;	
public boolean isFinished() {
	return finished;
}
public void setFinished(boolean finished) {
	this.finished = finished;
}
private String data;
private String subRecType;
private String recType;
private String totalCount;
private String totalAmount;
private String creditCount;
private String creditAmount;
private String debitCount;
private String debitAmount;
private String miscCount;
private String filler ;
public String getSubRecType() {
	return subRecType;
}
public void setSubRecType(String subRecType) {
	this.subRecType = subRecType;
}
public String getRecType() {
	return recType;
}
public void setRecType(String recType) {
	this.recType = recType;
}
public String getTotalCount() {
	return totalCount;
}
public void setTotalCount(String totalCount) {
	this.totalCount = totalCount;
}
public String getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(String totalAmount) {
	this.totalAmount = totalAmount;
}
public String getCreditCount() {
	return creditCount;
}
public void setCreditCount(String creditCount) {
	this.creditCount = creditCount;
}
public String getCreditAmount() {
	return creditAmount;
}
public void setCreditAmount(String creditAmount) {
	this.creditAmount = creditAmount;
}
public String getDebitCount() {
	return debitCount;
}
public void setDebitCount(String debitCount) {
	this.debitCount = debitCount;
}
public String getDebitAmount() {
	return debitAmount;
}
public void setDebitAmount(String debitAmount) {
	this.debitAmount = debitAmount;
}
public String getMiscCount() {
	return miscCount;
}
public void setMiscCount(String miscCount) {
	this.miscCount = miscCount;
}
public String getFiller() {
	return filler;
}
public void setFiller(String filler) {
	this.filler = filler;
}
public String getData() {
	return subRecType+recType+totalCount+totalAmount+creditCount+creditAmount+debitCount+debitAmount+miscCount+filler;
}
public void setData(String data) {
	this.data = data;
}



}
