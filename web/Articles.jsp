<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, yourpackage.BlogArticleDAO, yourpackage.BlogArticle" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Article Details</title>
</head>
<body>
    <%
        // Get article ID from request parameters
        int articleId = Integer.parseInt(request.getParameter("id"));
        
        // Fetch the article from database
        BlogArticleDAO dao = new BlogArticleDAO(connection);  // assuming connection is established
        BlogArticle article = dao.getArticleById(articleId);
    %>

    <div class="article-details">
        <h1><%= article.getTitle() %></h1>
        <p>By <%= article.getAuthor() %> | <%= article.getPublishDate() %></p>
        <div class="content">
            <%= article.getContent() %>
        </div>
    </div>
</body>
</html>
