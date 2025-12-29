/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.ProductModel;
import database.MySQLConnection;
import java.sql.*;
import java.util.*;


public class ProductDao {
     
    public void insert(ProductModel p) {
           String sql = "INSERT INTO Products(product_name, product_type, product_image, product_form, product_price) VALUES(?, ?, ?, ?, ?)";
                    try (Connection con = new MySQLConnection().openConnection();
               PreparedStatement ps = con.prepareStatement(sql)){
              ps.setString(1, p.getProductName());
              ps.setBoolean(2, p.getProductType());
              ps.setString(3, p.getProductImage());
              ps.setBoolean(4, p.getProductForm());
              ps.setInt(5, p.getProductPrice());
              ps.executeUpdate();   
              
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public List<ProductModel> getAll(){
            List<ProductModel> list = new ArrayList<>();
            String sql = "SELECT product_ID, product_name, product_type, product_image, product_price," + "product_synopsis, product_type, product_form FROM products";
    
            try(Connection con = new MySQLConnection().openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
        
             while (rs.next()){
                ProductModel p = new ProductModel(
                rs.getInt("Product_ID"),
                rs.getString("product_name"),
                rs.getString("Product_image"),
                rs.getInt("product_price"),
                rs.getString("product_synopsis"),
                rs.getBoolean("product_type"),
                rs.getBoolean("product_form")
                );
                list.add(p);
            }
        } catch (SQLException e){
             e.printStackTrace();
             
        }
        return list;
    }
}
    

