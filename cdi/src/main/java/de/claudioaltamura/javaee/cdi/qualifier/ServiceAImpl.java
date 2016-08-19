package de.claudioaltamura.javaee.cdi.qualifier;

@Type(TypeEnum.A)
public class ServiceAImpl implements Service {

	@Override
	public String foo() {
		return "A";
	}

}
