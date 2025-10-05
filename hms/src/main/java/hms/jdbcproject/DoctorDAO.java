package hms.jdbcproject;

import java.sql.*;

public class DoctorDAO {
    Connection con;

    public DoctorDAO() {
        con = DBConnection.getConnection();
    }

    public void addDoctor(String name, String specialization) {
        try {
            String query = "INSERT INTO doctors(name, specialization) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, specialization);
            ps.executeUpdate();
            System.out.println("Doctor added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteDoctor(int id) {
        try {
            String query = "DELETE FROM doctors WHERE doctor_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Doctor record deleted successfully!");
            else
                System.out.println("No doctor found with ID: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewDoctors() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM doctors");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("doctor_id") +
                                   " | Name: " + rs.getString("name") +
                                   " | Specialization: " + rs.getString("specialization"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

