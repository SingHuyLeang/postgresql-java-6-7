package service;

import data.Account;
import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseAccount extends DataBaseService {
    
    public int currentUserId = -1;
    
    public boolean signUp(Account account) {
        String query = "INSERT INTO tbl_user (email,password) VALUES (?,MD5(?))";
        int i = -1;
        try {
            String validationEmail = "SELECT id FROM tbl_user WHERE email = ?";
            ps = connection().prepareStatement(validationEmail);
            ps.setString(1, account.getEmail());
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Can not sign up your account!\nBecause this email has using by some one else.", "", JOptionPane.ERROR_MESSAGE);
            } else {
                ps = connection().prepareStatement(query);
                ps.setString(1, account.getEmail());
                ps.setString(2, account.getPassword());
                i = ps.executeUpdate();
                currentUserId = getCurrentUserId(account);
            }
        } catch (SQLException e) {
            System.out.println("SQLException sign up method : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Can not sign up your account.", "", JOptionPane.ERROR_MESSAGE);
        }
        return i > 0;
    }

    public boolean signIn(Account account) {
        String query = "SELECT id FROM tbl_user WHERE email = ? AND password = MD5(?)";
        String queryEmail = "SELECT id FROM tbl_user WHERE email = ?";
        boolean signInSuccess = false;
        try {
            ps = connection().prepareStatement(queryEmail);
            ps.setString(1, account.getEmail());
            rs = ps.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Invalid email.", "", JOptionPane.ERROR_MESSAGE);
            } else {
                ps = connection().prepareStatement(query);
                ps.setString(1, account.getEmail());
                ps.setString(2, account.getPassword());
                rs = ps.executeQuery();
                if (rs.next()) {
                    signInSuccess = true;
                    currentUserId = getCurrentUserId(account);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Password.", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException sign in method : " + e.getMessage());
        }
        return signInSuccess;
    }

    public boolean verifyEmail(String email) {
        String query = "SELECT id FROM tbl_user WHERE email = ?";
        try {
            ps = connection().prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("SQLException on verify email by " + e.getMessage());
        }
        return false;
    }

    public boolean resetPassword(String oldEmail, String newPassword) {
        int i = -1;
        String query = "SELECT id FROM tbl_user WHERE email = ?";
        String updateQuery = "UPDATE tbl_user SET password = MD5(?) WHERE id = ? AND email = ?";
        try {
            ps = connection().prepareStatement(query);
            ps.setString(1, oldEmail);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                if (id > 0) {
                    ps = connection().prepareStatement(updateQuery);
                    ps.setString(1, newPassword);
                    ps.setInt(2, id);
                    ps.setString(3, oldEmail);
                    i = ps.executeUpdate();
                } else {
                    JOptionPane.showMessageDialog(null, "Can not update new password.", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException on verify email by " + e.getMessage());
        }
        return i > 0;
    }
    
    public int getCurrentUserId(Account account) {
        String query = "SELECT id FROM tbl_user WHERE email = ? AND password = MD5(?)";
        try {
            ps = connection().prepareStatement(query);
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("SQLException on get current user id by " + e.getMessage());
        }
        return -1;
    }
    
}
