/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ASUS
 */
public class Product {
    public int productid;
    public String productname;
    public String producttype;
    public String productimagePath;
    public String productcategory;
    
    
    public Product(){}
    
    public Product(int productid, String name, String type, String imagepath, String category){
        this.productid = productid;
        this.productname = name;
        this.producttype = type;
        this.productimagePath = imagepath;
        this.productcategory = category;
    }
    
}



