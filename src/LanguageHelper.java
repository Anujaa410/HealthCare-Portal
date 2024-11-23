import java.util.*;

public class LanguageHelper {
    
    // Method to get language bundle based on the user's language preference
    public static ResourceBundle getMessages(String language) {
        Locale locale = new Locale(language);  // Create Locale based on the selected language
        return ResourceBundle.getBundle("messages", locale);  // Load the corresponding properties file
    }
}
