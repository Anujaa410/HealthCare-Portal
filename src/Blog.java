import java.sql.*;
import java.util.*;

public class BlogArticleDAO {
    private Connection connection;

    public BlogArticleDAO(Connection connection) {
        this.connection = connection;
    }

    // Fetch all published blog articles
    public List<BlogArticle> getAllArticles() throws SQLException {
        List<BlogArticle> articles = new ArrayList<>();
        String query = "SELECT * FROM blog_articles WHERE status = 'published' ORDER BY publish_date DESC";
        
        try (Statement stmt = connection.createStatement(); 
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                BlogArticle article = new BlogArticle();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setAuthor(rs.getString("author"));
                article.setPublishDate(rs.getTimestamp("publish_date"));
                articles.add(article);
            }
        }
        return articles;
    }
    
    // Create a new blog/article
    public void createArticle(BlogArticle article) throws SQLException {
        String query = "INSERT INTO blog_articles (title, content, author, publish_date, status) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, article.getTitle());
            stmt.setString(2, article.getContent());
            stmt.setString(3, article.getAuthor());
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmt.setString(5, article.getStatus());
            stmt.executeUpdate();
        }
    }
}
