/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import userdata.userDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.User_model;
import view.registration;

public class userController implements ActionListener {

    private final userDao dao;
    private final registration userView;

    public userController(registration userView) {
        this.userView = userView;
        this.dao = new userDao();
        this.userView.addUserListener(this);   // controller listens to the Register button
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }
<<<<<<< HEAD

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String fullname = userView.getFullNameField().getText().trim();
            String username = userView.getUsernameField().getText().trim();
            String email    = userView.getEmailField().getText().trim();
            char[] passwordChars = userView.getPasswordField().getPassword();
            String password = new String(passwordChars).trim();

            // 1. empty + placeholder checks
            if (fullname.isEmpty() || fullname.equals("Full Name")) {
                JOptionPane.showMessageDialog(userView,
                        "Please enter your full name.",
                        "Validation error",
                        JOptionPane.ERROR_MESSAGE);
                return;
=======
    
    
    class SignUpListener implements ActionListener {
@Override
            public void actionPerformed(ActionEvent e){
                try{
                    String fullname = userView.getFullNameField().getText();
                    String username = userView.getUsernameField().getText();
                    String email    = userView.getEmailField().getText();
                    char[] passwordChars = userView.getPasswordField().getPassword();
                    String password = new String(passwordChars);
                    
                    User_model usermodel = new User_model( username, email, password);
                    boolean check = userdao.check(usermodel);
                    if(check){
                        JOptionPane.showMessageDialog(userView, "Already exist");
                    }else{
                        userdao.signup(usermodel,fullname);
                        JOptionPane.showMessageDialog(userView, "Successfull");
                    }
                }catch(Exception ext){
                    System.out.println(ext);
                }   
>>>>>>> 818be83 (updates made to product category)
            }

            if (username.isEmpty() || username.equals("Username")) {
                JOptionPane.showMessageDialog(userView,
                        "Please enter a username.",
                        "Validation error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (email.isEmpty() || email.equals("Email")) {
                JOptionPane.showMessageDialog(userView,
                        "Please enter your email.",
                        "Validation error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(userView,
                        "Please enter a password.",
                        "Validation error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. email format
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (!email.matches(emailRegex)) {
                JOptionPane.showMessageDialog(userView,
                        "Please enter a valid email address (e.g. user@example.com).",
                        "Invalid email",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 3. password length
            if (password.length() < 6) {
                JOptionPane.showMessageDialog(userView,
                        "Password must be at least 6 characters long.",
                        "Invalid password",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 4. model
            User_model usermodel = new User_model(username, email, password);

            // 5. check duplicates
            boolean exists = dao.check(usermodel);
            if (exists) {
                JOptionPane.showMessageDialog(userView,
                        "Email or username already exists.",
                        "Registration error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 6. save user
            dao.signup(usermodel, fullname);
            JOptionPane.showMessageDialog(userView,
                    "Registration successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ext) {
            System.out.println(ext);
            JOptionPane.showMessageDialog(userView,
                    "Unexpected error: " + ext.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}