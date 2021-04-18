package model;

public class Word {
	private String code;
	private String value;
	
	public Word(String c, String v) {
		this.code = c;
		this.value = v;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		code = this.code;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		value = this.value;
	}
	
	
}
