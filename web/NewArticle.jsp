<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New Article</title>
</head>
<body>
    <h2>Create New Blog Article</h2>
    
    <form action="createArticle" method="POST">
        <label for="title">Title:</label>
        <input type="text" name="title" id="title" required><br><br>
        
        <label for="content">Content:</label><br>
        <textarea name="content" id="content" rows="10" required></textarea><br><br>
        
        <label for="author">Author:</label>
        <input type="text" name="author" id="author" required><br><br>
        
        <button type="submit">Publish Article</button>
    </form>
</body>
</html>
