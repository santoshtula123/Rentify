/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userdata;

import view.Book;
import database.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDao {


    public void insert(Book b) {
        String sql = "INSERT INTO products " +
                     "(product_name, product_image, product_price, " +
                     " product_synopsis, product_type, product_form) " +
                     "VALUES (?, ?, ?, ?, ?, ?)"; 
                        try (Connection con = new MySQLConnection().openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, b.getName());
            ps.setString(2, b.getImagePath());
            ps.setInt(3, b.getPrice());
            ps.setString(4, b.getSynopsis());
            ps.setBoolean(5, b.isType());
            ps.setBoolean(6, b.isForm());

            ps.executeUpdate();      // INSERT -> executeUpdate
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to insert product", e);
            }
         }
    
            public List<Book> getAll() {
            List<Book> list = new ArrayList<>();
            String sql = "SELECT Product_ID, product_name, product_image, " + "product_price, product_synopsis, product_type, product_form " + "FROM products";

            try (Connection con = new MySQLConnection().openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) { 
             while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("Product_ID"));
                b.setName(rs.getString("product_name"));
                b.setImagePath(rs.getString("product_image"));
                b.setPrice(rs.getInt("product_price"));
                b.setSynopsis(rs.getString("product_synopsis"));
                b.setType(rs.getBoolean("product_type"));
                b.setForm(rs.getBoolean("product_form"));
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
          
    public List<Book> getByCategory(String category) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT Product_ID, product_name, product_image, " +
                     "product_price, product_synopsis, product_type, product_form " +
                     "FROM products WHERE product_form = ?"; // or product_type / other column

        try (Connection con = new MySQLConnection().openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, category);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Book b = new Book();
                    b.setId(rs.getInt("Product_ID"));
                    b.setName(rs.getString("product_name"));
                    b.setImagePath(rs.getString("product_image"));
                    b.setPrice(rs.getInt("product_price"));
                    b.setSynopsis(rs.getString("product_synopsis"));
                    b.setType(rs.getBoolean("product_type"));
                    b.setForm(rs.getBoolean("product_form"));
                    list.add(b);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}