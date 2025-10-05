package hms.jdbcproject;

import java.sql.*;


public class PatientDAO {
    Connection con;

    public PatientDAO() {
        con = DBConnection.getConnection();
    }

    public void addPatient(String name, int age, String gender, String disease) {
        try {
            String query = "INSERT INTO patients(name, age, gender, disease) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, disease);
            ps.executeUpdate();
            System.out.println("Patient added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deletePatient(int id) {
        try {
            String query = "DELETE FROM patients WHERE patient_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Patient record deleted successfully!");
            else
                System.out.println("No patient found with ID: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void viewPatients() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patients");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("patient_id") + 
                                   " | Name: " + rs.getString("name") +
                                   " | Age: " + rs.getInt("age") +
                                   " | Gender: " + rs.getString("gender") +
                                   " | Disease: " + rs.getString("disease"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

