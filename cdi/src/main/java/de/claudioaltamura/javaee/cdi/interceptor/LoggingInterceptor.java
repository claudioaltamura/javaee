package de.claudioaltamura.javaee.cdi.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

@Loggable @Interceptor
public class LoggingInterceptor {

	private static final Logger logger = Logger.getLogger(LoggingInterceptor.class);

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
    	logger.info(ic.getClass().getName() + " - " + ic.getMethod().getName() + " start"); 
        try {
        	Object obj = ic.proceed();
        	logger.info("result is: " + obj.toString());
            return obj;
        } finally {
            logger.info(ic.getClass().getName() + " - " + ic.getMethod().getName() + " end");
        }
    }

}