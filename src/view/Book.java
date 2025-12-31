/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


/**
 *
 * @author ASUS
 */
public class Book {
    public int id;
    public String name;
    public String type;
    public String imagePath;
    public String category;
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getImagePath() { return imagePath; }
    public String getCategory() { return category; }
    
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
    public void setCategory(String category) { this.category = category; }
    
    private int price;
    private String synopsis;
    private boolean productType;
    private boolean productForm;

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getSynopsis() { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public boolean isType() { return productType; }
    public void setType(boolean productType) { this.productType = productType; }

    public boolean isForm() { return productForm; }
    public void setForm(boolean productForm) { this.productForm = productForm; }
    
}
