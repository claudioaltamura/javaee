package de.claudioaltamura.jsf.booklibray.model;

import java.io.Serializable;

public class LabelValue implements Serializable {

	private static final long serialVersionUID = 1L;

	private String label;
	private String value;
	
	public LabelValue(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}
	public String getValue() {
		return value;
	}
	
	
}
