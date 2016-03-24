package de.claudioaltamura.jsf.booklibray.data;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import de.claudioaltamura.jsf.booklibray.model.LabelValue;

@SessionScoped
@Named
public class AuthorListProducer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public LabelValue[] getList() {
		return new LabelValue[]{new LabelValue("Sam Newman", "Sam Newman")
				, new LabelValue("Karl Matthias", "Karl Matthias")};
	}

}
