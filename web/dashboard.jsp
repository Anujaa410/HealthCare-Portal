<select id="languageSelector" onchange="changeLanguage(this.value)">
    <option value="en">English</option>
    <option value="hi">Hindi</option>
    <option value="mr">Marathi</option>
</select>

<script>
    function changeLanguage(language) {
        // Redirect to the same page with the selected language as a parameter
        window.location.href = "/setLanguage?lang=" + language;
    }
</script>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Personalized Health Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .section { margin: 20px 0; }
        .section h3 { margin-bottom: 10px; }
    </style>
</head>
<body>
    <h2>Welcome, [Patient Name]</h2>
    
    <div class="section">
        <h3>Upcoming Appointments</h3>
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
        <h3>Medical Records</h3>
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
        <h3>Current Prescriptions</h3>
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
