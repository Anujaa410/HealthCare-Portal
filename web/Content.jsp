<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, yourpackage.LanguageHelper" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Personalized Health Dashboard</title>
</head>
<body>
    <%
        // Retrieve language preference from session
        String userLang = (String) session.getAttribute("language");
        if (userLang == null) {
            userLang = "en"; // Default to English if no language is set
        }
        
        // Load language messages using ResourceBundle
        ResourceBundle messages = LanguageHelper.getMessages(userLang);
    %>

    <h2><%= messages.getString("welcome_message") %></h2>
    
    <div class="section">
        <h3><%= messages.getString("appointments") %></h3>
        <ul id="appointments-list">
            <%-- Loop through appointments and display them --%>
            <c:forEach var="appointment" items="${appointments}">
                <li>
                    ${appointment.appointmentDate} - Doctor: ${appointment.doctorName} (Status: ${appointment.status})
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="section">
        <h3><%= messages.getString("medical_records") %></h3>
        <ul id="medical-records-list">
            <%-- Loop through medical records and display them --%>
            <c:forEach var="record" items="${medicalRecords}">
                <li>
                    ${record.recordType} - Result: ${record.resultValue} (Test Date: ${record.testDate})
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="section">
        <h3><%= messages.getString("prescriptions") %></h3>
        <ul id="prescriptions-list">
            <%-- Loop through prescriptions and display them --%>
            <c:forEach var="prescription" items="${prescriptions}">
                <li>
                    ${prescription.medicationName} - Dosage: ${prescription.dosage} (From ${prescription.startDate} to ${prescription.endDate})
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
