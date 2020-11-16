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
 * @author WORM
 */
public class findEntryPopup extends javax.swing.JFrame {

    /**
     * Creates new form findEntryPopup
     */
    private mainView mainViews;

    public findEntryPopup(JDesktopPane parent, boolean modal, mainView mainViews) {
        super();
        this.mainViews = mainViews;
        initComponents();
        setLocationRelativeTo(null);
        accounts = mainViews.getAccounts();
        desktop = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnCancelFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Entries");
        setIconImage(mainViews.getWorm().getImage());

        jLabel1.setText("Find by keywords in account title:");

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
            SearchFrame searchFrame = new SearchFrame(mainViews, desktop, titletxt);
            desktop.add(searchFrame);
            searchFrame.setVisible(true);
            this.dispose();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
    }

    // Variables declaration
    private javax.swing.JButton btnCancelFind;
    private javax.swing.JButton btnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtTitle;
    private AccountMap accounts;
    private JDesktopPane desktop;
    // End of variables declaration
}
