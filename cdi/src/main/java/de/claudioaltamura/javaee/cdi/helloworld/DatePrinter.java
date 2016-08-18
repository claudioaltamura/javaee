package de.claudioaltamura.javaee.cdi.helloworld;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePrinter {

	@Override
	public String toString() {
		return new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
	}
	
}
