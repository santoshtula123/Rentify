/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import userdata.WishlistDao;
import model.ProductModel;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author ASUS
 */
public class wishlist extends javax.swing.JPanel {

    private int currentUserId;
    private JPanel itemsContainer;
    private WishlistDao wishlistDao = new WishlistDao();

    public wishlist(int userId) {
        this.currentUserId = userId;
        initComponents();

        ContentPanel.setLayout(new java.awt.CardLayout());
        ContentPanel.add(ProfilePanel, "Profile");
        ContentPanel.add(OrderPanel, "Orders");
        ContentPanel.add(HistoryPanel, "History");
        ContentPanel.add(WishlistPanel, "Wishlist");

        setupWishlistPanel();
        loadWishlistFromDatabase();
    }

    private void setupWishlistPanel() {
        WishlistPanel.setLayout(null);

        itemsContainer = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        itemsContainer.setOpaque(false);
        itemsContainer.setBounds(40, 120, 880, 400);

        WishlistPanel.add(itemsContainer);
    }

    private void loadWishlistFromDatabase() {
        try {
            List<ProductModel> items = wishlistDao.getWishlist(currentUserId);
        showItemsInCards(items);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(
            this,
            "Failed to load wishlist.",
            "Error",
            JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void showItemsInCards(java.util.List<ProductModel> items) {
        itemsContainer.removeAll();
        for (ProductModel p : items) {
            JPanel card = createCard(p);
            itemsContainer.add(card);
        }
        itemsContainer.revalidate();
        itemsContainer.repaint();
    }

    
    private JPanel createCard(ProductModel p) {
    JPanel card = new JPanel();
    card.setPreferredSize(new Dimension(180, 220));
    card.setBackground(Color.WHITE);
    card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    card.setLayout(new BorderLayout());
    
    JLabel imgLbl = new JLabel();
imgLbl.setHorizontalAlignment(SwingConstants.CENTER);

String imgPath = p.getProductImage();   // e.g. "src/pictures/Johnwickposter.jpg"
System.out.println("Image path from model: " + imgPath);

if (imgPath != null && !imgPath.isEmpty()) {
    // strip "src/pictures/" if present
    String prefix = "src/pictures/";
    String fileName = imgPath.startsWith(prefix)
            ? imgPath.substring(prefix.length())
            : imgPath;   // e.g. "Johnwickposter.jpg"

    java.net.URL url = wishlist.class.getResource("/pictures/" + fileName);
    System.out.println("Resolved URL: " + url);

    if (url != null) {
        ImageIcon icon = new ImageIcon(url);
        Image scaled = icon.getImage().getScaledInstance(140, 120, Image.SCALE_SMOOTH);
        imgLbl.setIcon(new ImageIcon(scaled));
    } else {
        System.out.println("Image not found on classpath: /pictures/" + fileName);
    }
}
    JLabel nameLbl = new JLabel(p.getProductName(), SwingConstants.CENTER);
    nameLbl.setFont(new Font("Segoe UI", Font.PLAIN, 16));

    JLabel priceLbl = new JLabel("Rs. " + p.getProductPrice(), SwingConstants.CENTER);
    priceLbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    priceLbl.setForeground(new Color(220, 38, 38));

    JButton removeBtn = new JButton("Remove");
removeBtn.addActionListener(e -> {
    System.out.println("Remove clicked: user=" + currentUserId
                       + ", product=" + p.getProductID());
    try {
        boolean ok = wishlistDao.removeFromWishlist(currentUserId, p.getProductID());
        System.out.println("removeFromWishlist returned = " + ok);
        if (ok) {
            loadWishlistFromDatabase();   // refresh cards
        } else {
            JOptionPane.showMessageDialog(this, "Failed to remove.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error removing from wishlist.");
    }
});

    JPanel center = new JPanel();
    center.setOpaque(false);
    center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
    center.add(Box.createVerticalStrut(10));
    center.add(nameLbl);
    center.add(Box.createVerticalStrut(5));
    center.add(priceLbl);
    center.add(Box.createVerticalStrut(10));
    center.add(removeBtn);
    
    card.add(imgLbl, BorderLayout.NORTH);
    card.add(center, BorderLayout.CENTER);
    return card;
}
     public static void main(String args[]) {
         javax.swing.SwingUtilities.invokeLater(() -> {
        javax.swing.JFrame f = new javax.swing.JFrame("Wishlist test");
        f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new wishlist(1)); // use a real user_id that exists
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    });
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        libraryBTN = new javax.swing.JButton();
        bookbtn = new javax.swing.JButton();
        Moviesbtn = new javax.swing.JButton();
        newestbtn = new javax.swing.JButton();
        supportbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        buttonpanel = new javax.swing.JPanel();
        Profile = new javax.swing.JButton();
        Orders = new javax.swing.JButton();
        History = new javax.swing.JButton();
        Wishlist = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        ProfilePanel = new javax.swing.JPanel();
        OrderPanel = new javax.swing.JPanel();
        HistoryPanel = new javax.swing.JPanel();
        WishlistPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(249, 250, 251));
        setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rentify-200.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(20, 10, 200, 70);

        libraryBTN.setBackground(new java.awt.Color(232, 241, 253));
        libraryBTN.setText("Library");
        libraryBTN.setPreferredSize(new java.awt.Dimension(156, 36));
        libraryBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libraryBTNActionPerformed(evt);
            }
        });
        add(libraryBTN);
        libraryBTN.setBounds(310, 30, 156, 36);

        bookbtn.setBackground(new java.awt.Color(232, 241, 253));
        bookbtn.setText("Books");
        bookbtn.setPreferredSize(new java.awt.Dimension(136, 136));
        bookbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookbtnActionPerformed(evt);
            }
        });
        add(bookbtn);
        bookbtn.setBounds(490, 30, 156, 36);

        Moviesbtn.setBackground(new java.awt.Color(232, 241, 253));
        Moviesbtn.setText("Movies");
        Moviesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoviesbtnActionPerformed(evt);
            }
        });
        add(Moviesbtn);
        Moviesbtn.setBounds(670, 30, 156, 36);

        newestbtn.setBackground(new java.awt.Color(232, 241, 253));
        newestbtn.setText("Newest");
        newestbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newestbtnActionPerformed(evt);
            }
        });
        add(newestbtn);
        newestbtn.setBounds(850, 30, 156, 36);

        supportbtn.setBackground(new java.awt.Color(232, 241, 253));
        supportbtn.setText("Support");
        supportbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supportbtnActionPerformed(evt);
            }
        });
        add(supportbtn);
        supportbtn.setBounds(1030, 30, 156, 36);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(1210, 10, 62, 62);

        buttonpanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Profile.setText("Profile");
        Profile.setPreferredSize(new java.awt.Dimension(179, 36));
        Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileActionPerformed(evt);
            }
        });

        Orders.setText("Orders");
        Orders.setPreferredSize(new java.awt.Dimension(179, 36));
        Orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdersActionPerformed(evt);
            }
        });

        History.setText("History");
        History.setPreferredSize(new java.awt.Dimension(179, 36));
        History.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryActionPerformed(evt);
            }
        });

        Wishlist.setText("Wishlist");
        Wishlist.setPreferredSize(new java.awt.Dimension(179, 36));
        Wishlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WishlistActionPerformed(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(38, 166, 154));
        Logout.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Log out");

        javax.swing.GroupLayout buttonpanelLayout = new javax.swing.GroupLayout(buttonpanel);
        buttonpanel.setLayout(buttonpanelLayout);
        buttonpanelLayout.setHorizontalGroup(
            buttonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonpanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(buttonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(History, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Wishlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        buttonpanelLayout.setVerticalGroup(
            buttonpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonpanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(Profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(History, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Wishlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        add(buttonpanel);
        buttonpanel.setBounds(30, 120, 250, 565);

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ContentPanel.setLayout(new java.awt.CardLayout());

        ProfilePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ProfilePanelLayout = new javax.swing.GroupLayout(ProfilePanel);
        ProfilePanel.setLayout(ProfilePanelLayout);
        ProfilePanelLayout.setHorizontalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 968, Short.MAX_VALUE)
        );
        ProfilePanelLayout.setVerticalGroup(
            ProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        ContentPanel.add(ProfilePanel, "card2");

        OrderPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout OrderPanelLayout = new javax.swing.GroupLayout(OrderPanel);
        OrderPanel.setLayout(OrderPanelLayout);
        OrderPanelLayout.setHorizontalGroup(
            OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 968, Short.MAX_VALUE)
        );
        OrderPanelLayout.setVerticalGroup(
            OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        ContentPanel.add(OrderPanel, "card2");

        HistoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout HistoryPanelLayout = new javax.swing.GroupLayout(HistoryPanel);
        HistoryPanel.setLayout(HistoryPanelLayout);
        HistoryPanelLayout.setHorizontalGroup(
            HistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 968, Short.MAX_VALUE)
        );
        HistoryPanelLayout.setVerticalGroup(
            HistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        ContentPanel.add(HistoryPanel, "card2");

        WishlistPanel.setBackground(new java.awt.Color(255, 255, 255));
        WishlistPanel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel2.setText("Wishlist");
        WishlistPanel.add(jLabel2);
        jLabel2.setBounds(60, 30, 160, 54);

        ContentPanel.add(WishlistPanel, "card2");

        add(ContentPanel);
        ContentPanel.setBounds(280, 120, 970, 565);
    }// </editor-fold>//GEN-END:initComponents

    private void libraryBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libraryBTNActionPerformed
        javax.swing.JFrame f = new javax.swing.JFrame("Library");

        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.getContentPane().add(new LibraryPanel());
        f.pack();
        f.setLocationRelativeTo(this);
        f.setVisible(true);
    }//GEN-LAST:event_libraryBTNActionPerformed

    private void bookbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookbtnActionPerformed
    System.out.println("Books button clicked");   // debug

        System.out.println("Books button clicked");
        javax.swing.JFrame f = new javax.swing.JFrame("Books");
        f.setSize(1280, 780);                   // test size
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.getContentPane().add(new JPanel());   // TEMP: empty panel
        f.setLocationRelativeTo(this);
        f.setVisible(true);
    }//GEN-LAST:event_bookbtnActionPerformed

    private void MoviesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoviesbtnActionPerformed
        javax.swing.JFrame f = new javax.swing.JFrame("Movies");

        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.getContentPane().add(new MoviesPanel());
        f.pack();
        f.setLocationRelativeTo(this);
        f.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_MoviesbtnActionPerformed

    private void newestbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newestbtnActionPerformed
        javax.swing.JFrame f = new javax.swing.JFrame("Newest");

        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.getContentPane().add(new NewestPanel());
        f.pack();
        f.setLocationRelativeTo(this);
        f.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_newestbtnActionPerformed

    private void supportbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supportbtnActionPerformed
        javax.swing.JFrame f = new javax.swing.JFrame("Support");

        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.getContentPane().add(new SupportPanel());
        f.pack();
        f.setLocationRelativeTo(this);
        f.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_supportbtnActionPerformed

    private void HistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryActionPerformed
        CardLayout card = (CardLayout) ContentPanel.getLayout();
        card.show(ContentPanel, "Orders");

        // TODO add your handling code here:
    }//GEN-LAST:event_HistoryActionPerformed

    private void ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileActionPerformed
        CardLayout card = (CardLayout) ContentPanel.getLayout();
        card.show(ContentPanel, "Profile");
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfileActionPerformed

    private void OrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdersActionPerformed
        CardLayout card = (CardLayout) ContentPanel.getLayout();
        card.show(ContentPanel, "Orders");

        // TODO add your handling code here:
    }//GEN-LAST:event_OrdersActionPerformed

    private void WishlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WishlistActionPerformed
           CardLayout card = (CardLayout) ContentPanel.getLayout();
    card.show(ContentPanel, "Wishlist");
        // TODO add your handling code here:
    }//GEN-LAST:event_WishlistActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JButton History;
    private javax.swing.JPanel HistoryPanel;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Moviesbtn;
    private javax.swing.JPanel OrderPanel;
    private javax.swing.JButton Orders;
    private javax.swing.JButton Profile;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JButton Wishlist;
    private javax.swing.JPanel WishlistPanel;
    private javax.swing.JButton bookbtn;
    private javax.swing.JPanel buttonpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton libraryBTN;
    private javax.swing.JButton newestbtn;
    private javax.swing.JButton supportbtn;
    // End of variables declaration//GEN-END:variables
   


}