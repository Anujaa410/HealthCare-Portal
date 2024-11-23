import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class DashboardServlet extends HttpServlet {
    
    // Fetch appointments for a user
    private List<Appointment> getAppointments(int userId) {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments WHERE user_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointment_id"));
                appointment.setDoctorId(rs.getInt("doctor_id"));
                appointment.setAppointmentDate(rs.getTimestamp("appointment_date"));
                appointment.setStatus(rs.getString("status"));
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }
    
    // Fetch medical records for a user
    private List<MedicalRecord> getMedicalRecords(int userId) {
        List<MedicalRecord> medicalRecords = new ArrayList<>();
        String query = "SELECT * FROM medical_records WHERE user_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                MedicalRecord record = new MedicalRecord();
                record.setRecordId(rs.getInt("record_id"));
                record.setRecordType(rs.getString("record_type"));
                record.setDescription(rs.getString("description"));
                record.setResultValue(rs.getString("result_value"));
                record.setTestDate(rs.getDate("test_date"));
                medicalRecords.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalRecords;
    }

    // Fetch prescriptions for a user
    private List<Prescription> getPrescriptions(int userId) {
        List<Prescription> prescriptions = new ArrayList<>();
        String query = "SELECT * FROM prescriptions WHERE user_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Prescription prescription = new Prescription();
                prescription.setPrescriptionId(rs.getInt("prescription_id"));
                prescription.setMedicationName(rs.getString("medication_name"));
                prescription.setDosage(rs.getString("dosage"));
                prescription.setStartDate(rs.getDate("start_date"));
                prescription.setEndDate(rs.getDate("end_date"));
                prescription.setInstructions(rs.getString("instructions"));
                prescriptions.add(prescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptions;
    }

    // Handle HTTP requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId")); // Retrieve user ID from request
        
        // Fetch data
        List<Appointment> appointments = getAppointments(userId);
        List<MedicalRecord> medicalRecords = getMedicalRecords(userId);
        List<Prescription> prescriptions = getPrescriptions(userId);
        
        // Set data in request
        request.setAttribute("appointments", appointments);
        request.setAttribute("medicalRecords", medicalRecords);
        request.setAttribute("prescriptions", prescriptions);
        
        // Forward to JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
