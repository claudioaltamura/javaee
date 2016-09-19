package de.claudioaltamura.javaee.cdi.interceptor;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class InterceptorExample {

	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		MilkList list = container.instance().select(MilkList.class, MilkList.class.getAnnotations()).get();
		list.getList();
		container.shutdown();
	}

}
