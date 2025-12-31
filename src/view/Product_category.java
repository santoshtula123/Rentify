/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import userdata.ProductDao;
import model.ProductModel;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class Product_category extends javax.swing.JFrame {
    
      private List<ProductModel> allProducts;
      private String currentMode = "NONE";
      private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Product_category.class.getName());
      
      
       public Product_category() {
        initComponents();
        setupProductsPanel();
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16); 
        loadProductsFromDatabase();
    }
 
    
                           
      private void setupProductsPanel() {
          booksjPanel2.removeAll();
          booksjPanel2.setLayout(new javax.swing.BoxLayout(booksjPanel2, javax.swing.BoxLayout.Y_AXIS));

          javax.swing.JScrollPane productScroll = new javax.swing.JScrollPane(booksjPanel2, javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    productScroll.setBorder(null);
                    productScroll.getVerticalScrollBar().setUnitIncrement(16); // smooth scroll
                    productScroll.getViewport().setBackground(java.awt.Color.WHITE);
                    productScroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 12));

                    jScrollPane1.setViewportView(booksjPanel2);
                }

        private javax.swing.JPanel createProductCard(ProductModel p) {
            javax.swing.JPanel card = new javax.swing.JPanel();
            card.setPreferredSize(new java.awt.Dimension(1000, 160));
            card.setBackground(java.awt.Color.WHITE);
            card.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.LIGHT_GRAY));
            card.setLayout(new java.awt.BorderLayout());

            javax.swing.JLabel nameLbl = new javax.swing.JLabel(p.getProductName());
            nameLbl.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));

            javax.swing.JLabel typeLbl = new javax.swing.JLabel("Type: " + p.getProductType());
            javax.swing.JLabel priceLbl = new javax.swing.JLabel("Rs. " + p.getProductPrice());
            priceLbl.setForeground(new java.awt.Color(220, 38, 38));

            javax.swing.JPanel center = new javax.swing.JPanel();
            center.setOpaque(false);
            center.setLayout(new javax.swing.BoxLayout(center, javax.swing.BoxLayout.Y_AXIS));
            center.add(nameLbl);
            center.add(typeLbl);
            center.add(priceLbl);

            card.add(center, java.awt.BorderLayout.CENTER);
            return card;
        }

           private void showProducts(String typeFilter) {
            booksjPanel2.removeAll();

            if (allProducts == null) {
                booksjPanel2.revalidate();
                booksjPanel2.repaint();
                return;
            }

            for (ProductModel p : allProducts) {
                String t = p.getProductType();  // "Book" or "Movie"
                if ("Book".equalsIgnoreCase(typeFilter) && !"Book".equalsIgnoreCase(t)) { continue; }
                if ("Movie".equalsIgnoreCase(typeFilter) && !"Movie".equalsIgnoreCase(t)) { continue; }           
                booksjPanel2.add(createProductCard(p));
            }

            booksjPanel2.revalidate();
            booksjPanel2.repaint();
        }

         private void refreshListFromCheckboxes() {
            if (!"BOOKS_PAGE".equals(currentMode) && !"MOVIES_PAGE".equals(currentMode)) {
            return;
        }

            booksjPanel2.removeAll();

            boolean booksChecked  = checkbox1.getState();
            boolean moviesChecked = checkbox2.getState();

            for (ProductModel p : allProducts) {
                String t = p.getProductType();
                boolean isBook  = "Book".equalsIgnoreCase(t);
                boolean isMovie = "Movie".equalsIgnoreCase(t);

                if ("BOOKS_PAGE".equals(currentMode) && !isBook)  continue;
                if ("MOVIES_PAGE".equals(currentMode) && !isMovie) continue;

                if (!booksChecked  && isBook)  continue;
                if (!moviesChecked && isMovie) continue;

                booksjPanel2.add(createProductCard(p));
            }

            if (!booksChecked && !moviesChecked) {
                booksjPanel2.removeAll();
                for (ProductModel p : allProducts) {
                    String t = p.getProductType();
                    boolean isBook  = "Book".equalsIgnoreCase(t);
                    boolean isMovie = "Movie".equalsIgnoreCase(t);

                    if ("BOOKS_PAGE".equals(currentMode) && !isBook)  continue;
                    if ("MOVIES_PAGE".equals(currentMode) && !isMovie) continue;

                    booksjPanel2.add(createProductCard(p));
                }
            }

            booksjPanel2.revalidate();
            booksjPanel2.repaint();
        }


        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        checkbox1 = new java.awt.Checkbox();
        checkbox2 = new java.awt.Checkbox();
        jScrollPane1 = new javax.swing.JScrollPane();
        booksjPanel2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        libraryBTN = new javax.swing.JButton();
        Bookbtn = new javax.swing.JButton();
        Moviesbtn = new javax.swing.JButton();
        Supportbtn = new javax.swing.JButton();
        Newestbtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rentify-200.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 200, 70);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1210, 10, 60, 60);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel4.setText("  Products");
        jLabel4.setPreferredSize(new java.awt.Dimension(152, 39));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 120, 152, 39);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Category:");
        jLabel5.setPreferredSize(new java.awt.Dimension(117, 24));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 160, 90, 30);

        jButton7.setBackground(new java.awt.Color(229, 231, 235));
        jButton7.setText("Digital");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(170, 170, 75, 23);

        jButton8.setBackground(new java.awt.Color(229, 231, 235));
        jButton8.setText("Physical");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(260, 170, 72, 23);

        checkbox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        checkbox1.setLabel("  Books\n");
        checkbox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkbox1ItemStateChanged(evt);
            }
        });
        checkbox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                checkbox1PropertyChange(evt);
            }
        });
        jPanel1.add(checkbox1);
        checkbox1.setBounds(70, 200, 100, 20);

        checkbox2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        checkbox2.setLabel(" Movies");
        checkbox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkbox2ItemStateChanged(evt);
            }
        });
        jPanel1.add(checkbox2);
        checkbox2.setBounds(170, 200, 75, 21);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1192, 436));

        booksjPanel2.setBackground(new java.awt.Color(255, 255, 255));
        booksjPanel2.setPreferredSize(new java.awt.Dimension(1192, 1192));
        booksjPanel2.setLayout(new java.awt.GridLayout(10, 2));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setText("Harry Potter");
        jLabel12.setPreferredSize(new java.awt.Dimension(98, 20));

        jLabel13.setText("Type: Digital");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Harry_Potter.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1238, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        booksjPanel2.add(jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1208, 235));

        jLabel14.setText("Type: Paperback");

        jLabel15.setText("The Secret Library");
        jLabel15.setPreferredSize(new java.awt.Dimension(98, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/The secret library (1) (2).png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(1210, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)))
                .addGap(58, 58, 58))
        );

        booksjPanel2.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(1208, 235));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hamlet.png"))); // NOI18N

        jLabel16.setText("Hamlet");
        jLabel16.setPreferredSize(new java.awt.Dimension(98, 20));

        jLabel17.setText("Type: Ebook");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(1227, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        booksjPanel2.add(jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Exit west.png"))); // NOI18N

        jLabel20.setText("Exit West");

        jLabel21.setText("Type: Physical");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addContainerGap(1243, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        booksjPanel2.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Devil.png"))); // NOI18N

        jLabel23.setText("The Devils Deadline");

        jLabel24.setText("Type: Movie");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addContainerGap(1213, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(62, 62, 62))
        );

        booksjPanel2.add(jPanel8);

        jScrollPane1.setViewportView(booksjPanel2);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 240, 1220, 450);

        libraryBTN.setBackground(new java.awt.Color(232, 241, 253));
        libraryBTN.setText("Library");
        libraryBTN.setPreferredSize(new java.awt.Dimension(156, 36));
        libraryBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libraryBTNActionPerformed(evt);
            }
        });
        jPanel1.add(libraryBTN);
        libraryBTN.setBounds(310, 30, 156, 36);

        Bookbtn.setBackground(new java.awt.Color(232, 241, 253));
        Bookbtn.setText("Books");
        Bookbtn.setPreferredSize(new java.awt.Dimension(136, 136));
        Bookbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookbtnMouseClicked(evt);
            }
        });
        Bookbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Bookbtn);
        Bookbtn.setBounds(490, 30, 156, 36);

        Moviesbtn.setBackground(new java.awt.Color(232, 241, 253));
        Moviesbtn.setText("Movies");
        Moviesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoviesbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Moviesbtn);
        Moviesbtn.setBounds(670, 30, 156, 36);

        Supportbtn.setBackground(new java.awt.Color(232, 241, 253));
        Supportbtn.setText("Support");
        Supportbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupportbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Supportbtn);
        Supportbtn.setBounds(1030, 30, 156, 36);

        Newestbtn.setBackground(new java.awt.Color(232, 241, 253));
        Newestbtn.setText("Newest");
        Newestbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewestbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Newestbtn);
        Newestbtn.setBounds(850, 30, 156, 36);

        jTextField1.setBackground(new java.awt.Color(184, 179, 179));
        jTextField1.setText("Search");
        jTextField1.setPreferredSize(new java.awt.Dimension(400, 33));
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(790, 120, 400, 33);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 720);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NewestbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewestbtnActionPerformed
   javax.swing.JFrame f = new javax.swing.JFrame("Newest");
      
      f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      f.getContentPane().add(new NewestPanel());
      f.pack();
      f.setLocationRelativeTo(this);
      f.setVisible(true);              
      
            // TODO add your handling code here:
    }//GEN-LAST:event_NewestbtnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void SupportbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupportbtnActionPerformed
   javax.swing.JFrame f = new javax.swing.JFrame("Support");
      
      f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      f.getContentPane().add(new SupportPanel());
      f.pack();
      f.setLocationRelativeTo(this);
      f.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_SupportbtnActionPerformed

    private void MoviesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoviesbtnActionPerformed
           javax.swing.JFrame f = new javax.swing.JFrame("Movies");
      
      f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      f.getContentPane().add(new MoviesPanel());
      f.pack();
      f.setLocationRelativeTo(this);
      f.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_MoviesbtnActionPerformed

    private void BookbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookbtnActionPerformed
         javax.swing.JFrame f = new javax.swing.JFrame("Books");
      
      f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      f.getContentPane().add(new BooksPanel());
      f.pack();
      f.setLocationRelativeTo(this);
      f.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_BookbtnActionPerformed

    private void BookbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BookbtnMouseClicked

    private void libraryBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libraryBTNActionPerformed
      javax.swing.JFrame f = new javax.swing.JFrame("Library");
      
      f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      f.getContentPane().add(new LibraryPanel());
      f.pack();
      f.setLocationRelativeTo(this);
      f.setVisible(true);
    }//GEN-LAST:event_libraryBTNActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void checkbox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_checkbox1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox1PropertyChange

    private void checkbox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkbox1ItemStateChanged
        refreshListFromCheckboxes();
          // TODO add your handling code here:
    }//GEN-LAST:event_checkbox1ItemStateChanged

    private void checkbox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkbox2ItemStateChanged
       refreshListFromCheckboxes();
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbox2ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Product_category().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bookbtn;
    private javax.swing.JButton Moviesbtn;
    private javax.swing.JButton Newestbtn;
    private javax.swing.JButton Supportbtn;
    private javax.swing.JPanel booksjPanel2;
    private java.awt.Checkbox checkbox1;
    private java.awt.Checkbox checkbox2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton libraryBTN;
    // End of variables declaration//GEN-END:variables
    
    private void loadProductsFromDatabase() {
        try {
           ProductDao dao = new ProductDao();
           allProducts = dao.getAllProducts();   // or your real DAO method name
           showProducts("ALL");
       } catch (Exception ex) {
           ex.printStackTrace();
           javax.swing.JOptionPane.showMessageDialog(
                   this,
                   "Failed to load products.",
                   "Error",
                   javax.swing.JOptionPane.ERROR_MESSAGE
           );
       }
    }
}