import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LanguageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter("lang");  // Get the language parameter
        if (language != null) {
            // Set the language preference in the session
            HttpSession session = request.getSession();
            session.setAttribute("language", language);
        }
        
        // Redirect back to the previous page (or a specific page after language selection)
        response.sendRedirect(request.getHeader("Referer"));
    }
}
ResourceBundle messages = ResourceBundle.getBundle("messages", locale, new Control() {
    @Override
    public Locale getFallbackLocale(String baseName, Locale locale) {
        return Locale.ENGLISH;  // Fallback to English if translation is missing
    }
});
