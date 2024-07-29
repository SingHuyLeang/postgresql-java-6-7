package ui;

import data.Account;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.Device;
import main.UICallBack;
import service.DatabaseAccount;

public class AuthenticationScreen extends javax.swing.JPanel {

    private final UICallBack callBack;
    private final DatabaseAccount db = new DatabaseAccount();
    private final Device device = new Device();

    public AuthenticationScreen(UICallBack callBack) {
        this.callBack = callBack;
        initComponents();
    }

    private void showForm(JPanel form) {
        removeAll();
        add(form);
        revalidate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SignInForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSignInEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSignInPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        showFormSignUp = new javax.swing.JLabel();
        btnForgotPassword = new javax.swing.JLabel();
        SignUpForm = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSignUpEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSignUpPassword = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        showFormSignIn = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtSignUpConfirmPassword = new javax.swing.JPasswordField();

        setLayout(new java.awt.CardLayout());

        SignInForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        SignInForm.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 170));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Do you have an account ?");
        SignInForm.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 190, 20));

        jLabel3.setFont(new java.awt.Font("Barlow", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sign In");
        SignInForm.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1000, 40));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Please enter your email and password.");
        SignInForm.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 1000, 40));

        txtSignInEmail.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        SignInForm.add(txtSignInEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 300, 35));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Email");
        SignInForm.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 60, 20));
        SignInForm.add(txtSignInPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 300, 35));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Password");
        SignInForm.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 80, 20));

        btnSignIn.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnSignIn.setText("Sign In");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        SignInForm.add(btnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, -1));

        showFormSignUp.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        showFormSignUp.setForeground(new java.awt.Color(51, 0, 255));
        showFormSignUp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        showFormSignUp.setText("Sign Up");
        showFormSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showFormSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showFormSignUpMouseClicked(evt);
            }
        });
        SignInForm.add(showFormSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, -1, 20));

        btnForgotPassword.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnForgotPassword.setForeground(new java.awt.Color(51, 0, 255));
        btnForgotPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnForgotPassword.setText("Forgot password ?");
        btnForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnForgotPasswordMouseClicked(evt);
            }
        });
        SignInForm.add(btnForgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 140, 20));

        add(SignInForm, "card2");

        SignUpForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        SignUpForm.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 170));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Do you have an account ?");
        SignUpForm.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 190, 20));

        jLabel11.setFont(new java.awt.Font("Barlow", 1, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sign Up");
        SignUpForm.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1000, 40));

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Create your account with email and password.");
        SignUpForm.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 1000, 40));

        txtSignUpEmail.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        SignUpForm.add(txtSignUpEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 300, 35));

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Email");
        SignUpForm.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 60, 20));
        SignUpForm.add(txtSignUpPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 300, 35));

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Password");
        SignUpForm.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 80, 20));

        btnSignUp.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        SignUpForm.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, -1));

        showFormSignIn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        showFormSignIn.setForeground(new java.awt.Color(51, 0, 255));
        showFormSignIn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        showFormSignIn.setText("Sign In");
        showFormSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showFormSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showFormSignInMouseClicked(evt);
            }
        });
        SignUpForm.add(showFormSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, -1, 20));

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Confirm password");
        SignUpForm.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 140, 20));
        SignUpForm.add(txtSignUpConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 300, 35));

        add(SignUpForm, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void showFormSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFormSignInMouseClicked
        showForm(SignInForm);
    }//GEN-LAST:event_showFormSignInMouseClicked

    private void showFormSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFormSignUpMouseClicked
        showForm(SignUpForm);
    }//GEN-LAST:event_showFormSignUpMouseClicked

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        if (txtSignInEmail.getText().isEmpty() || txtSignInPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields.", "", JOptionPane.ERROR_MESSAGE);
        } else {
            if (db.signIn(new Account(txtSignInEmail.getText(), txtSignInPassword.getText()))) {
                device.signIn(Device.getDeviceName(),String.valueOf(db.currentUserId));
                callBack.callBack();
            }
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        if (txtSignUpEmail.getText().isEmpty() || txtSignUpPassword.getText().isEmpty() || txtSignUpConfirmPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields.", "", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!txtSignUpPassword.getText().equals(txtSignUpConfirmPassword.getText())) {
                JOptionPane.showMessageDialog(this, "Your confirm password is not equals.", "", JOptionPane.ERROR_MESSAGE);
            } else {
                if (db.signUp(new Account(txtSignUpEmail.getText(), txtSignUpPassword.getText()))) {
                    device.signIn(Device.getDeviceName(),String.valueOf(db.currentUserId));
                    callBack.callBack();
                }
            }
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnForgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForgotPasswordMouseClicked
        try {
            String email = JOptionPane.showInputDialog(null, "Please enter your email.", "Reset Password", JOptionPane.PLAIN_MESSAGE);
            if (!email.isEmpty()) {
                if (db.verifyEmail(email)){
                    String newPassword = JOptionPane.showInputDialog(null, "Please enter new password.", "Reset Password", JOptionPane.PLAIN_MESSAGE);
                    if (db.resetPassword(email, newPassword)){
                        JOptionPane.showMessageDialog(null, "Successfuly.", "", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update new password.", "", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid your email.", "Verify email", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.err.println("User clicked cancel");
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException on forgot password by " + e.getMessage());
        } finally {
            txtSignInEmail.setText("");
            txtSignInPassword.setText("");
        }
    }//GEN-LAST:event_btnForgotPasswordMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SignInForm;
    private javax.swing.JPanel SignUpForm;
    private javax.swing.JLabel btnForgotPassword;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel showFormSignIn;
    private javax.swing.JLabel showFormSignUp;
    private javax.swing.JTextField txtSignInEmail;
    private javax.swing.JPasswordField txtSignInPassword;
    private javax.swing.JPasswordField txtSignUpConfirmPassword;
    private javax.swing.JTextField txtSignUpEmail;
    private javax.swing.JPasswordField txtSignUpPassword;
    // End of variables declaration//GEN-END:variables
}
