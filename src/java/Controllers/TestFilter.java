package Controllers;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestFilter implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;

    public TestFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
//            HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        HttpSession session = req.getSession();
//        System.out.println("a intrat in filtru de test dar cu body de loginfilter");
//
//        if (session.getAttribute("username") != null) {
//            chain.doFilter(req, res);
//        } else {
//            res.sendRedirect("index.html");
//        }
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {

    }

}
