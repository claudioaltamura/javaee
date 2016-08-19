package de.claudioaltamura.javaee.cdi.qualifier;

import static de.claudioaltamura.javaee.cdi.qualifier.TypeEnum.A;
import static de.claudioaltamura.javaee.cdi.qualifier.TypeEnum.B;

import javax.inject.Inject;

public class Client {

	@Inject @Type(A)
	private Service ifA;
	@Inject @Type(B)
	private Service ifB;
	
	public String getServiceA() {
		return ifA.foo();
	}

	public String getServiceB() {
		return ifB.foo();
	}

}
