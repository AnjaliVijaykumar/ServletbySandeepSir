import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "filter1", urlPatterns = {"/servlet1","/servlet2"})
public class Filter1 implements Filter {
    public Filter1() {
        System.out.println("Filter constructor");
    }

    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("filter init method");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       //logic for filteration
        System.out.println("doFilter method");

        //forward the request
        chain.doFilter(request, response);

        //post-processing
        System.out.println("Postprocessing");
    }

    public void destroy() {
        System.out.println("Filter destroy method");
    }
}
