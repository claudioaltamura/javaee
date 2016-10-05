package de.claudioaltamura.javaee.cdi.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logged @Interceptor
public class LoggingInterceptor {

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
    	System.out.println(ic.getClass().getName() + " - " + ic.getMethod().getName() + " start"); 
        try {
        	Object obj = ic.proceed();
        	System.out.println("result is: " + obj.toString());
            return obj;
        } finally {
        	System.out.println(ic.getClass().getName() + " - " + ic.getMethod().getName() + " end");
        }
    }

}