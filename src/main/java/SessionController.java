import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        if("admin".equalsIgnoreCase(username)&&"admin".equalsIgnoreCase(password)){
            //true : create a new session object
            //false : get a already existing session object
            HttpSession httpSession = req.getSession(true);

            httpSession.setAttribute("username",username);
            httpSession.setAttribute("password",password);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("welcome");
            requestDispatcher.forward(req,resp);
        } else{
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("Invalid credentials");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("session.html");
            requestDispatcher.include(req,resp);
        }

    }
}
