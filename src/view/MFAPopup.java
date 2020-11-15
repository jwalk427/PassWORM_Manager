/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import view.MFA;
import view.internalframe.SearchFrame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.time.Instant;



import model.AccountMap;

/**
 *
 * @author jitzu
 */
public class MFAPopup extends javax.swing.JDialog {

    /**
     * Creates new form MFAPopup
     */
    private mainView mainViews;
    private String usertxt = "";
    private long time = 0;
    
    private String code = "";

    public MFAPopup(java.awt.Frame parent, boolean modal, mainView mainViews, String usertxt) {
        super(parent, modal);
        this.mainViews = mainViews;
        initComponents();
        setLocationRelativeTo(null);
        accounts = mainViews.getAccounts();
        this.usertxt = usertxt;
        //time is set to current time plus 3 minutes
        time = Instant.now().getEpochSecond() + 180;
        code = MFA.generateCode();
        MFA.sendEmail(code);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        btnEnter = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MFA Authenticator");

        jLabel1.setText("Please enter the code sent to your email: ");

        /*
         * txtPassword.addKeyListener(new java.awt.event.KeyAdapter() { public void
         * keyPressed(java.awt.event.KeyEvent evt) { txtPasswordKeyPressed(evt); } });
         */

        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 218,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnEnter)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancel).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1).addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEnter).addComponent(btnCancel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        txtTitle.setText("");
        this.dispose();
    }

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {
        authenticate();

    }

    private void authenticate() {
        if (Instant.now().getEpochSecond() < time){
            if (txtTitle.getText().equals(code)){
            mainViews.isLoggin(true);
            mainViews.getUserLabel().setText(usertxt);
            this.dispose();
            } else {
            System.out.print("Incorrect code");
            }
        } else {
            System.out.println("Error: Code timed out");
        }
        //Time limit?
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginPopup.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginPopup.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginPopup.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginPopup.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        // public void run() {
        // loginPopup dialog = new loginPopup(new javax.swing.JFrame(), true);
        // dialog.addWindowListener(new java.awt.event.WindowAdapter() {
        // @Override
        // public void windowClosing(java.awt.event.WindowEvent e) {
        // System.exit(0);
        // }
        // });
        // dialog.setVisible(true);
        // }
        // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEnter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtTitle;
    private AccountMap accounts;
    private JDesktopPane desktop;
    // End of variables declaration//GEN-END:variables
}
