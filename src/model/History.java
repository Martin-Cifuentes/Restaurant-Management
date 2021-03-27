package model;

import java.io.Serializable;

public class History implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String createdBy="";
	private String lastEditedBy="";
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastEditedBy() {
		return lastEditedBy;
	}
	public void setLastEditedBy(String lastEditedBy) {
		this.lastEditedBy = lastEditedBy;
	}
	
	
}
