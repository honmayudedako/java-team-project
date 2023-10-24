package model.entity;

public class CustomerBean {
	
	private int id;
	private String name;
	private String nameKana;
	private String postCode;
	private String areaCode;
	private String gender;
	private String birthday;
	private String phoneNumber;
	private String insertDateTime;
	private String updateDateTime; 
			
	public CustomerBean(){}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNameKana() {
		return this.nameKana;
	}
	public void setNameKana(String nameKana) {
		this.nameKana = nameKana;
	}
	
	public String getPostCode() {
		return this.postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public String getAreaCode() {
		return this.areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getInsertDateTime() {
		return this.insertDateTime;
	}
	public void setInsertDateTime(String InsertDateTime) {
		this.insertDateTime = InsertDateTime;
	}

	public String getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(String UpdatedateTime) {
		this.updateDateTime = UpdatedateTime;
	}
}
