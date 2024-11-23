@WebServlet("/createArticle")
public class CreateArticleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = request.getParameter("author");
        
        BlogArticle article = new BlogArticle();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);
        article.setStatus("published");  // Assuming it is published by default
        
        try {
            BlogArticleDAO dao = new BlogArticleDAO(connection);  // Assuming connection is established
            dao.createArticle(article);
            response.sendRedirect("adminDashboard.jsp");  // Redirect to dashboard or success page
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error creating article.");
        }
    }
}

