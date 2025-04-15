import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    // Dummy credentials for demonstration
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        // Set response type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple authentication check
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            out.println("<html><body><h2>Welcome, " + username + "!</h2></body></html>");
        } else {
            out.println("<html><body><h2>Invalid credentials. Please try again.</h2></body></html>");
        }

        out.close();
    }
}
