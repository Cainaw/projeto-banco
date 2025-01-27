package util;

public class Data {
	private Integer DD;
	private Integer MM;
	private Integer AA;
	
	public Data(Integer DD, Integer MM, Integer AA) {
		this.DD = DD;
		this.MM = MM;
		this.AA = AA;
	}
	
	public String getData() {
		return DD.toString() + "/" + MM.toString() + "/" + AA.toString();
	}
}
