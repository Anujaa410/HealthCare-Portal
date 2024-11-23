<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, yourpackage.BlogArticleDAO, yourpackage.BlogArticle" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hospital Blog & Articles</title>
</head>
<body>
    <h2>Latest Blog Articles</h2>
    
    <%
        // Initialize BlogArticleDAO and fetch all articles
        BlogArticleDAO dao = new BlogArticleDAO(connection);  // assuming connection is established
        List<BlogArticle> articles = dao.getAllArticles();
    %>

    <div id="blog-articles">
        <%-- Loop through articles and display titles with brief content --%>
        <c:forEach var="article" items="${articles}">
            <div class="article-preview">
                <h3><%= article.getTitle() %></h3>
                <p><%= article.getContent().substring(0, Math.min(150, article.getContent().length())) %>...</p>
                <a href="articleDetails.jsp?id=<%= article.getId() %>">Read More</a>
            </div>
        </c:forEach>
    </div>
</body>
</html>
