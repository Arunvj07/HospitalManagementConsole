package hms.jdbcproject;

import java.sql.*;

public class AppointmentDAO {
    Connection con;

    public AppointmentDAO() {
        con = DBConnection.getConnection();
    }

    public void bookAppointment(int patientId, int doctorId, String date) {
        try {
            String query = "INSERT INTO appointments(patient_id, doctor_id, appointment_date) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setString(3, date);
            ps.executeUpdate();
            System.out.println("✅ Appointment booked successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteAppointment(int id) {
        try {
            String query = "DELETE FROM appointments WHERE appointment_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Appointment deleted successfully!");
            else
                System.out.println("No appointment found with ID: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAppointments() {
        try {
            String query = "SELECT a.appointment_id, p.name AS patient, d.name AS doctor, a.appointment_date " +
                           "FROM appointments a " +
                           "JOIN patients p ON a.patient_id=p.patient_id " +
                           "JOIN doctors d ON a.doctor_id=d.doctor_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("Appointment ID: " + rs.getInt("appointment_id") +
                                   " | Patient: " + rs.getString("patient") +
                                   " | Doctor: " + rs.getString("doctor") +
                                   " | Date: " + rs.getString("appointment_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
