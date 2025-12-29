/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dao.Book;
import dao.BookDao;


import java.awt.GridLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BooksPanel extends javax.swing.JPanel {
     
        private final BookDao bookDao = new BookDao();
        
        private final JPanel booksPanel = new JPanel();


        public BooksPanel() {
            setLayout (new GridLayout (1, 1));
        
            booksPanel.setBackground(java.awt.Color.WHITE);
            booksPanel.setLayout(new GridLayout(0, 1));
        
            add(booksPanel);
        
            loadProductsFromDatabase();
        }
    
        private void loadProductsFromDatabase(){
            
            List<Book> books = bookDao.getByCategory("Book");
    
            booksPanel.removeAll();
            booksPanel.setLayout(new GridLayout(0, 1));
    
            for (Book b : books){
                JPanel p = new JPanel();
                p.setBackground(java.awt.Color.WHITE);
                p.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK));
    
                JLabel imgLabel = new JLabel();
                if (b.imagePath != null && !b.imagePath.isEmpty()){
                    imgLabel.setIcon(new ImageIcon(b.imagePath));
                }
                JLabel nameLabel = new JLabel(b.name);
                JLabel typeLabel = new JLabel("Type" + b.type);
    
                p.add(imgLabel);
                p.add(nameLabel);
                p.add(typeLabel);
    
                booksPanel.add(p);
            }
            booksPanel.revalidate();
            booksPanel.repaint();
        }
}
