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

import model.AccountMap;

/**
 *
 * @author jitzu
 */
public class findEntryPopup extends javax.swing.JFrame {

    /**
     * Creates new form findEntryPopup
     */
    private mainView mainViews;

    public findEntryPopup(JDesktopPane parent, boolean modal, mainView mainViews) {
        //super(parent, modal);
        super();
        this.mainViews = mainViews;
        initComponents();
        setLocationRelativeTo(null);
        accounts = mainViews.getAccounts();
        desktop = parent;
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
        btnFind = new javax.swing.JButton();
        btnCancelFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Entries");

        jLabel1.setText("Find by keywords in account title:");

        /*
         * txtPassword.addKeyListener(new java.awt.event.KeyAdapter() { public void
         * keyPressed(java.awt.event.KeyEvent evt) { txtPasswordKeyPressed(evt); } });
         */

        btnFind.setText("Go");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnCancelFind.setText("Cancel");
        btnCancelFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelFindActionPerformed(evt);
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
                                                .addComponent(btnFind)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancelFind).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1).addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnFind).addComponent(btnCancelFind))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }

    private void btnCancelFindActionPerformed(java.awt.event.ActionEvent evt) {
        txtTitle.setText("");
        this.dispose();
    }

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {
        searchEntries();

    }

    private void searchEntries() {
        boolean found = false;
        String titletxt = txtTitle.getText();
        Set<String> temp = null;
        if (!accounts.getTitles().isEmpty()){
            temp = accounts.getTitles();
        }
        //Special cases
        if (temp == null){
            JOptionPane.showMessageDialog(null, "There are no stored accounts.");
            return;
        }

        //Search
        for (String s : temp) {
            String l = s;
            if (l.toLowerCase().contains(titletxt)) {
                accounts.getAccount(titletxt);
                found = true;
            }
        }
        //Not found
        if (!found) {
            JOptionPane.showMessageDialog(null, "Could not find the account " + titletxt);
        }
        
        //Found - print all accounts whose titles contain the search term
        else{
            //JInternalFrame findFrame = new JInternalFrame("Search Results for: " + "\"" + titletxt + "\"", true, true, true, true);
            SearchFrame searchFrame = new SearchFrame(mainViews, desktop, titletxt);
            desktop.add(searchFrame);
            searchFrame.setVisible(true);
            // searchFrame.setVisible(true);
            // JTextArea findText = new JTextArea();
            // for(String s: temp){
            //     String l = s;
            //     if(l.toLowerCase().contains(titletxt)){
            //         findText.append("Title: " + s + "  " + accounts.getAccount(s) + "\n");
            //     }
            // }
            // findText.setEditable(false);
            // findText.setVisible(true);
            // JScrollPane scrollPane = new JScrollPane(findText);
            // findFrame.add(scrollPane);
            // findFrame.setSize(480, 360);
            // findFrame.setVisible(true);
            // desktop.add(findFrame);

            this.dispose();
        }
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
    private javax.swing.JButton btnCancelFind;
    private javax.swing.JButton btnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtTitle;
    private AccountMap accounts;
    private JDesktopPane desktop;
    // End of variables declaration//GEN-END:variables
}
