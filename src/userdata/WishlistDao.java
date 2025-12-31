/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userdata;

import database.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ProductModel;
import model.User_model;
import userdata.WishlistDao;

/**
 *
 * @author ASUS
 */
public class WishlistDao {

    
    MySQLConnection mysql = new MySQLConnection();
    public boolean addToWishlist (int userId, int productId) throws SQLException {
        String sql = "INSERT INTO wishlist(user_id, product_id) VALUES(?, ?)";
        try(Connection con = mysql.openConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, userId);
            pst.setInt(2, productId);
            return pst.executeUpdate() == 1;
        }
    }
    
    public boolean removeFromWishlist(int userId, int productId) throws SQLException {
        String sql = "DELETE FROM wishlist WHERE user_id = ? AND product_id = ?";
        try (Connection con = mysql.openConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, userId);
            pst.setInt(2, productId);
            return pst.executeUpdate() == 1;
        }
    }
    public  List<ProductModel> getWishlist(int userId) throws SQLException {
        List<ProductModel> list = new ArrayList<>();
        String sql = """
                     SELECT p.id,
                                    p.productName,
                                    p.productImage,
                                    p.productPrice,
                                    p.productSynopsis,
                                    p.productType,
                                    p.productForm,
                                    p.productQuantity
                             FROM wishlist w
                             JOIN products p ON w.product_id = p.id
                             WHERE w.user_id = ?
                         """;
        try (Connection con = mysql.openConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, userId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()){
                    ProductModel p = new ProductModel(
                        rs.getInt("id"),
                        rs.getString("productName"),
                        rs.getString("productImage"),
                        rs.getInt("productPrice"),
                        rs.getString("productSynopsis"),
                        rs.getString("productType"),
                        rs.getString("productForm"),
                        rs.getInt("productQuantity")
                    );       
                    list.add(p);
                }
            }
        }
        return list;
    } 
}
