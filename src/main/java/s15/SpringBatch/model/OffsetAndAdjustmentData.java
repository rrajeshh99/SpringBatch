package s15.SpringBatch.model;

public class OffsetAndAdjustmentData {

	private int id;
	private int adjId;
	private int Account_Number;
	private int Adj_Amount;
	private String Amount_Type ;
	private String Status;
	private String Offset_type;
	private String Adj_Type;
	private int Amount;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdjId() {
		return adjId;
	}
	public void setAdjId(int adjId) {
		this.adjId = adjId;
	}
	public int getAccount_Number() {
		return Account_Number;
	}
	public void setAccount_Number(int account_Number) {
		Account_Number = account_Number;
	}
	public int getAdj_Amount() {
		return Adj_Amount;
	}
	public void setAdj_Amount(int adj_Amount) {
		Adj_Amount = adj_Amount;
	}
	public String getAmount_Type() {
		return Amount_Type;
	}
	public void setAmount_Type(String amount_Type) {
		Amount_Type = amount_Type;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getOffset_type() {
		return Offset_type;
	}
	public void setOffset_type(String offset_type) {
		Offset_type = offset_type;
	}
	public String getAdj_Type() {
		return Adj_Type;
	}
	public void setAdj_Type(String adj_Type) {
		Adj_Type = adj_Type;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Account_Number+","+Adj_Amount+","+Adj_Type+","+Amount+","+Amount_Type+","+Offset_type+","+Status;
	}
}
