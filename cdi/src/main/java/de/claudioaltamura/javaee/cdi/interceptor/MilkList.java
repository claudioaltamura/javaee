package de.claudioaltamura.javaee.cdi.interceptor;

import java.util.ArrayList;
import java.util.List;

public class MilkList {

	@Loggable
	public List<String> getList() {
		List<String> list = new ArrayList<>();
		list.add("Milk");
		list.add("Butter");
		list.add("Bread");
		
		return list;
	}
}
