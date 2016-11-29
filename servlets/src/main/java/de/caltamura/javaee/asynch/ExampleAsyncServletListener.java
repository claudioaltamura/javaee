package de.caltamura.javaee.asynch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebListener;

@WebListener
public class ExampleAsyncServletListener implements AsyncListener {

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        ServletResponse response = asyncEvent.getAsyncContext().getResponse();
        PrintWriter out = response.getWriter();
        out.write("TimeOut Error in Processing");
        System.out.println("onTimeout");
    }

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("onComplete");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
        System.out.println("onError");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("onStartAsync");
    }

}
