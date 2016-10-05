package de.claudioaltamura.javaee.cdi.interceptor;

import java.io.PrintStream;
import java.io.StringWriter;

import javax.inject.Inject;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.claudioaltamura.javaee.cdi.util.WeldJUnit4Runner;

@RunWith(WeldJUnit4Runner.class)
public class InterceptorExampleTest {

	protected StringWriter stdout;
	protected StringWriter stderr;
	private PrintStream oldStdout;
	private PrintStream oldStderr;
	
	@Before
	public void setUp() {
		stdout = new StringWriter();
		oldStdout = System.out;
		System.setOut(new PrintStream(new WriterOutputStream(stdout, "UTF-8"), true));

		oldStderr = System.err;
		stderr = new StringWriter();
		System.setErr(new PrintStream(new WriterOutputStream(stderr, "UTF-8"), true));
	}

	@After
	public void tearDown()
	{
		System.setOut(oldStdout);
		System.setOut(oldStderr);
	}
	
	@Inject 
	private MilkList milkList;
	
	@Test
	public void test() {
		milkList.getList();
		assertOutputContains(stdout, "Milk");
	}

	protected void assertOutputContains(StringWriter outputWriter, String lookForThis)
	{ 
		String output = outputWriter.toString();
		if (!output.contains(lookForThis))
			throw new AssertionError("String " + lookForThis + " not found in output:\n" + output + "\n");
	}
	
}
