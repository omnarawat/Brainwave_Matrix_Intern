import java.sql.*;
import java.util.*;

public class HospitalManagementSystem {
    static final String url = "jdbc:mysql://localhost:3306/hospital_db";
    static final String user = "root";
    static final String password = "Omiee@123"; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Register Patient\n2. Book Appointment\n3. Add EHR\n4. Generate Bill\n5. Manage Inventory\n6. Add Staff\n0. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt(); sc.nextLine();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, password);
                switch (ch) {
                    case 1 -> {
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                        System.out.print("Gender: "); String gender = sc.nextLine();
                        System.out.print("Contact: "); String contact = sc.nextLine();
                        PreparedStatement ps = con.prepareStatement("INSERT INTO patients(name, age, gender, contact) VALUES (?, ?, ?, ?)");
                        ps.setString(1, name); ps.setInt(2, age); ps.setString(3, gender); ps.setString(4, contact);
                        ps.executeUpdate();
                        System.out.println(" Patient registered.");
                    }
                    case 2 -> {
                        System.out.print("Patient ID: "); int pid = sc.nextInt(); sc.nextLine();
                        System.out.print("Doctor: "); String doc = sc.nextLine();
                        System.out.print("Date (YYYY-MM-DD): "); String date = sc.nextLine();
                        System.out.print("Time (HH:MM): "); String time = sc.nextLine();
                        PreparedStatement ps = con.prepareStatement("INSERT INTO appointments(patient_id, doctor_name, date, time) VALUES (?, ?, ?, ?)");
                        ps.setInt(1, pid); ps.setString(2, doc); ps.setString(3, date); ps.setString(4, time);
                        ps.executeUpdate();
                        System.out.println(" Appointment booked.");
                    }
                    case 3 -> {
                        System.out.print("Patient ID: "); int pid = sc.nextInt(); sc.nextLine();
                        System.out.print("Diagnosis: "); String diag = sc.nextLine();
                        System.out.print("Treatment: "); String treat = sc.nextLine();
                        System.out.print("Doctor: "); String doc = sc.nextLine();
                        PreparedStatement ps = con.prepareStatement("INSERT INTO ehr(patient_id, diagnosis, treatment, doctor_name) VALUES (?, ?, ?, ?)");
                        ps.setInt(1, pid); ps.setString(2, diag); ps.setString(3, treat); ps.setString(4, doc);
                        ps.executeUpdate();
                        System.out.println(" EHR added.");
                    }
                    case 4 -> {
                        System.out.print("Patient ID: "); int pid = sc.nextInt();
                        System.out.print("Amount: "); double amt = sc.nextDouble(); sc.nextLine();
                        System.out.print("Paid? (true/false): "); boolean paid = sc.nextBoolean();
                        PreparedStatement ps = con.prepareStatement("INSERT INTO invoices(patient_id, amount, paid) VALUES (?, ?, ?)");
                        ps.setInt(1, pid); ps.setDouble(2, amt); ps.setBoolean(3, paid);
                        ps.executeUpdate();
                        System.out.println(" Invoice generated.");
                    }
                    case 5 -> {
                        System.out.print("Supply Name: "); String name = sc.nextLine();
                        System.out.print("Quantity: "); int qty = sc.nextInt();
                        System.out.print("Reorder Level: "); int level = sc.nextInt();
                        PreparedStatement ps = con.prepareStatement("INSERT INTO supplies(name, quantity, reorder_level) VALUES (?, ?, ?)");
                        ps.setString(1, name); ps.setInt(2, qty); ps.setInt(3, level);
                        ps.executeUpdate();
                        System.out.println(" Supply added.");
                    }
                    case 6 -> {
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Role: "); String role = sc.nextLine();
                        System.out.print("Contact: "); String contact = sc.nextLine();
                        System.out.print("Shift: "); String shift = sc.nextLine();
                        PreparedStatement ps = con.prepareStatement("INSERT INTO staff(name, role, contact, shift) VALUES (?, ?, ?, ?)");
                        ps.setString(1, name); ps.setString(2, role); ps.setString(3, contact); ps.setString(4, shift);
                        ps.executeUpdate();
                        System.out.println(" Staff added.");
                    }
                    case 0 -> {
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (SQLException e) {
                System.out.println(" DB Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
            }
        }
    }
}
