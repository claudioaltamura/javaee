package de.claudioaltamura.javaee.cdi.qualifier;

import static de.claudioaltamura.javaee.cdi.qualifier.TypeEnum.A;
import static de.claudioaltamura.javaee.cdi.qualifier.TypeEnum.B;
import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.claudioaltamura.javaee.cdi.util.WeldJUnit4Runner;

@RunWith(WeldJUnit4Runner.class)
public class QualifierTest {

   @Inject @Type(A)
   private Service ifA;
   
   @Inject @Type(B)
   private Service ifB;
   
	@Test
	public void testA() {
		assertEquals("A", ifA.foo());
	}

	@Test
	public void testB() {
		assertEquals("B", ifB.foo());
	}
	
}
