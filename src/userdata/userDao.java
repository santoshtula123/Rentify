package userdata;

import model.User_model;
import database.MySQLConnection;
import java.sql.*;

public class userDao {

    MySQLConnection mysql = new MySQLConnection();
<<<<<<< HEAD

    public void signup(User_model user, String fullname) {
        Connection conn = mysql.openConnection();
        String sql = "INSERT INTO users (fullname, username, email, password) VALUES (?,?,?,?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
=======
    
    public void signup(User_model user, String fullname){
        Connection conn = mysql.openConnection();
        String sql = "insert into users (fullname, username, email, password) values(?,?,?,?)";
        try (PreparedStatement pstm = conn.prepareStatement(sql)){
>>>>>>> 818be83 (updates made to product category)
            pstm.setString(1, fullname);
            pstm.setString(2, user.getUsername());
            pstm.setString(3, user.getEmail());
            pstm.setString(4, user.getPassword());
<<<<<<< HEAD

            int rows = pstm.executeUpdate();
            System.out.println("Signup rows inserted = " + rows);
        } catch (Exception ex) {
            System.out.println("Signup error: " + ex);
=======
            int rows = pstm.executeUpdate();
            System.out.println("Signup rows inserted = " + rows);
            
        } catch(Exception ex){
            System.out.println(ex);
>>>>>>> 818be83 (updates made to product category)
        } finally {
            mysql.closeConnection(conn);
        }
    }

    public boolean check(User_model user) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE email = ? OR username = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getUsername());

            ResultSet result = pstm.executeQuery();
            return result.next();
        } catch (Exception ex) {
            System.out.println("Check error: " + ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    public boolean login(User_model user) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());

            ResultSet rs = pstm.executeQuery();
            return rs.next(); // true if login success
        } catch (Exception ex) {
            System.out.println("Login error: " + ex);
            return false;
        } finally {
            mysql.closeConnection(conn);
        }
    }
}