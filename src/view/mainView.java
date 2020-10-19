/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.internalframe.Master1Frame;
import view.internalframe.Master2Frame;

/**
 *
 * @author jitzu
 */
public final class mainView extends javax.swing.JFrame {

    /**
     * Creates new form mainView
     */
    public mainView() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        isLoggin(false);
    }

    public void isLoggin(boolean b) {
        menuLogin.setEnabled(!b);
        menuLogout.setEnabled(b);
        menuMaster1.setEnabled(b);
        menuMaster2.setEnabled(b);

        if (b) {
            txtLoginAs.setText("login as : ");
        } else {
            txtLoginAs.setText("you must login first.");
            userLabel.setText("");
        }
    }

    private Boolean frameExist(String frameTitle) {
        JInternalFrame[] jifList = desktopPane.getAllFrames();
        for (JInternalFrame jf : jifList) {
            if (jf.getTitle().equalsIgnoreCase(frameTitle)) {
                System.out.println("frameTitle "+frameTitle+" exist");
                return true;
            }
        }
        System.out.println("frameTitle "+frameTitle+" not exist");
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        txtLoginAs = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuLogin = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();
        menuMaster = new javax.swing.JMenu();
        menuMaster1 = new javax.swing.JMenuItem();
        menuMaster2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Application Template by Mazipan - mazipanneh@gmail.com - mazipanneh.wordpress.com");

        desktopPane.setAutoscrolls(true);
        desktopPane.setName(""); // NOI18N
        desktopPane.setPreferredSize(new java.awt.Dimension(1366, 649));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        jPanel1.setAutoscrolls(true);

        userLabel.setText("user");

        txtLoginAs.setText("login as :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLoginAs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLabel)
                .addContainerGap(320, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(txtLoginAs))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        menuFile.setText("File");

        menuLogin.setText("Login");
        menuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoginActionPerformed(evt);
            }
        });
        menuFile.add(menuLogin);

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuFile.add(menuLogout);

        jMenuBar1.add(menuFile);

        menuMaster.setText("Edit");
/*
        menuMaster1.setText("");
        menuMaster1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMaster1ActionPerformed(evt);
            }
        });
        menuMaster.add(menuMaster1);
 
        menuMaster2.setText("Master Simple 2");
        menuMaster2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMaster2ActionPerformed(evt);
            }
        });
        menuMaster.add(menuMaster2);
*/
        jMenuBar1.add(menuMaster);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        // TODO add your handling code here:
        isLoggin(false);
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoginActionPerformed
        // TODO add your handling code here:
        loginPopup loginPopups = new loginPopup(null, true, this);
        loginPopups.setVisible(true);
    }//GEN-LAST:event_menuLoginActionPerformed

    Master1Frame master1Frame;
    private void menuMaster1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMaster1ActionPerformed

        // TODO add your handling code here:
        try {
            if ((master1Frame) == null) {
                master1Frame = new Master1Frame();
                desktopPane.add(master1Frame);
            } else {
                if (frameExist(master1Frame.getTitle())) {
                    master1Frame.toFront();
                } else {
                    desktopPane.add(master1Frame);
                }
            }
                        
            master1Frame.setVisible(true);
            master1Frame.setSelected(true);
            
            master1Frame.setMaximum(false);
            master1Frame.setMaximum(true);
            
        } catch (PropertyVetoException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_menuMaster1ActionPerformed

    Master2Frame master2Frame;
    private void menuMaster2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMaster2ActionPerformed
        // TODO add your handling code here:
        try {
            if ((master2Frame) == null) {
                master2Frame = new Master2Frame();
                desktopPane.add(master2Frame);
            } else {
                if (frameExist(master2Frame.getTitle())) {
                    master2Frame.toFront();
                } else {
                    desktopPane.add(master2Frame);
                }
            }

            master2Frame.setVisible(true);
            master2Frame.setSelected(true);
            
            master2Frame.setMaximum(false);
            master2Frame.setMaximum(true);

        } catch (PropertyVetoException ex) {
            System.out.println(ex);
        }


    }//GEN-LAST:event_menuMaster2ActionPerformed

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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainView().setVisible(true);
            }
        });
    }

    public JLabel getTxtLoginAs() {
        return txtLoginAs;
    }

    public void setTxtLoginAs(JLabel txtLoginAs) {
        this.txtLoginAs = txtLoginAs;
    }

    public JLabel getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(JLabel userLabel) {
        this.userLabel = userLabel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuLogin;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuMaster;
    private javax.swing.JMenuItem menuMaster1;
    private javax.swing.JMenuItem menuMaster2;
    private javax.swing.JLabel txtLoginAs;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
