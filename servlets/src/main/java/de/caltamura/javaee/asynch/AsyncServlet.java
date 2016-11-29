package de.caltamura.javaee.asynch;

import java.util.concurrent.ThreadPoolExecutor;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/asyncservlet" }, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final long TIMEOUT_MS = 100;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		long startTime = System.currentTimeMillis();
		System.out.println("Async Servlet Start Name="
				+ Thread.currentThread().getName() + " ID="
				+ Thread.currentThread().getId());

		int ms = Integer.valueOf(request.getParameter("ms"));

		final AsyncContext acontext = request.startAsync();
		acontext.addListener(new ExampleAsyncServletListener());
		acontext.setTimeout(TIMEOUT_MS);

		ThreadPoolExecutor executor = (ThreadPoolExecutor) request
				.getServletContext().getAttribute("executor");

		//TODO: ms is 0!?
		executor.execute(new ExampleProcess(acontext, ms));

		long endTime = System.currentTimeMillis();
		System.out.println("Async Servlet End Name="
				+ Thread.currentThread().getName() + " ID="
				+ Thread.currentThread().getId() + " Time ="
				+ (endTime - startTime) + " ms.");
	}
}