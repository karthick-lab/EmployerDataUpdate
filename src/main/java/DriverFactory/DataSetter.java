package DriverFactory;

public class DataSetter {
	
	private String Employercode;
	private String Month;
	private String Year;
	private String District;
	
	public DataSetter(String Employercode,String Month, String Year, String District)
	{
		this.Employercode=Employercode;
		this.Month=Month;
		this.Year=Year;
		this.District=District;
	}
	
	public  String getEmployercode() {
		return Employercode;
	}
	public void setEmployercode(String employercode) {
		Employercode = employercode;
	}
	public  String getMonth() {
		return Month;
	}
	public  void setMonth(String month) {
		Month = month;
	}
	public  String getYear() {
		return Year;
	}
	public  void setYear(String year) {
		Year = year;
	}
	public  String getDistrict() {
		return District;
	}
	public  void setDistrict(String district) {
		District = district;
	}


}
