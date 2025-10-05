package hms.jdbcproject;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        while (true) {
            System.out.println("\n Hospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Delete Patient");
            System.out.println("8. Delete Doctor");
            System.out.println("9. Delete Appointment");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter disease: ");
                    String disease = sc.nextLine();
                    patientDAO.addPatient(pname, age, gender, disease);
                    break;

                case 2:
                    patientDAO.viewPatients();
                    break;

                case 3:
                    System.out.print("Enter doctor name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter specialization: ");
                    String spec = sc.nextLine();
                    doctorDAO.addDoctor(dname, spec);
                    break;

                case 4:
                    doctorDAO.viewDoctors();
                    break;

                case 5:
                    System.out.print("Enter patient ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter doctor ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter appointment date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    appointmentDAO.bookAppointment(pid, did, date);
                    break;

                case 6:
                    appointmentDAO.viewAppointments();
                    break;

                case 7:
                    System.out.print("Enter Patient ID to delete: ");
                    int delPid = sc.nextInt();
                    patientDAO.deletePatient(delPid);
                    break;

                case 8:
                    System.out.print("Enter Doctor ID to delete: ");
                    int delDid = sc.nextInt();
                    doctorDAO.deleteDoctor(delDid);
                    break;

                case 9:
                    System.out.print("Enter Appointment ID to delete: ");
                    int delAid = sc.nextInt();
                    appointmentDAO.deleteAppointment(delAid);
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

    }
}
