package de.claudioaltamura.javaee.cdi.qualifier;

@Type(TypeEnum.B)
public class ServiceBImpl implements Service {

	@Override
	public String foo() {
		return "B";
	}

}
