package de.caltamura.javaee.asynch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;

public class ExampleProcess implements Runnable {

    private AsyncContext asyncContext;
    private int ms;

    public ExampleProcess(AsyncContext asyncContext, int ms) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {
    	try {
    		System.out.println("going to sleep for " + ms + " ms.");
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter out = asyncContext.getResponse().getWriter();
            out.write("Processing done for " + ms + " milliseconds!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        asyncContext.complete();
    }
}
