import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie")
public class CookieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Cookie cookieUsername = new Cookie("username",username);
        Cookie cookiePassword = new Cookie("password",password);

        resp.addCookie(cookieUsername);
        resp.addCookie(cookiePassword);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Cookies has been set in the browser");
    }
}
