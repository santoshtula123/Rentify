/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDao {


    public void insert(Book b) {
           String sql = "INSERT INTO products(name, type, image_path, category) VALUES(?, ?, ?, ?)";
                    try (Connection con = new MySQLConnection().openConnection();
               PreparedStatement ps = con.prepareStatement(sql)){
              ps.setString(1, b.name);
              ps.setString(2, b.type);
              ps.setString(3, b.imagePath);
              ps.setString(4, b.category);
              ps.executeUpdate();   
              
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to insert product", e);
            }
        }
    
        public List<Book> getAll(){
            List<Book> list = new ArrayList<>();
            String sql = "SELECT id, name, type, image_path, category FROM products";
    
            try(Connection con = new MySQLConnection().openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
        
             while (rs.next()){
                Book b = new Book();
                b.id = rs.getInt("id");
                b.name = rs.getString("name");
                b.type = rs.getString("type");
                b.imagePath = rs.getString("image_path");
                b.category = rs.getString("category");
                list.add(b);
            }
        } catch (SQLException e){
             e.printStackTrace();
             
        }
        return list;
    }
        public List<Book> getByCategory(String category){
            List<Book> list = new ArrayList<>();
            String sql = "SELECT id, name, type, image_path, category FROM products WHERE category = ?";
            
            try (Connection con = new MySQLConnection().openConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                
                ps.setString(1, category);
                                
                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    Book b = new Book();
                    b.id = rs.getInt("id");
                    b.name = rs.getString("name");
                    b.type = rs.getString("type");
                    b.imagePath = rs.getString("image_path");
                    b.category = rs.getString("category");
                    list.add(b);
                }
            } catch (SQLException e){
                    e.printStackTrace();
            }
            return list;

        }
}        