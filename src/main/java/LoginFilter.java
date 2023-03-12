import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/servlet1"})
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html");

        if("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password)){
            chain.doFilter(request,response);
        } else{
            PrintWriter writer = response.getWriter();
            writer.println("<h2>Invalid Credentials</h2>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
            requestDispatcher.include(request, response);
        }
    }

    public void destroy() {
    }
}
