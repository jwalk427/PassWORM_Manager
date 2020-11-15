/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.internalframe;

import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.AccountMap;
import view.mainView;

/**
 *
 * @author jitzu
 */
public class AccountFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form Master1Frame1
     */
    public AccountFrame(mainView mainViews, JDesktopPane parent) {
        super("User Accounts", true, true, true, true);
        accounts = mainViews.getAccounts();
        desktop = parent;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        //TODO: Find a way to allow user to go to URL when an element is clicked? Or add another button to do so ("Visit")?
        /*import java.awt.Desktop;
        import java.net.URI;

        // ...

        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("http://www.example.com"));
        }*/

        //TODO: Create Edit(Similar to an add account form) and Delete(Dialog with Yes/No choice) popups.
        //Figure out how to use Edit/Delete buttons for a selected table element
        //Add the JButtons for "Edit" and "Delete" that opens Edit/Delete popups. Reflect to data model.

        Set<String> temp = null;
        if (!accounts.getTitles().isEmpty()){
            temp = accounts.getTitles();
        }
        //Special cases
        if (temp == null){
            JOptionPane.showMessageDialog(null, "There are no stored accounts.");
            return;
        }
        
        String[] columns = {"Title", "Username", "URL", "Password", "Notes"};
        String[][] data = new String[accounts.getTitles().size()][5];

        int i = 0;
        for(String title: accounts.getTitles()){
            String[] accountArray = accounts.getAccountArray(title);
            data[i][0] = title;
            data[i][1] = accountArray[0];
            data[i][2] = accountArray[1];
            data[i][3] = accountArray[2];
            data[i][4] = accountArray[3];
            i++;
        }

        acctTable = new JTable(data, columns);
        acctTable.setModel(new DefaultTableModel(data, columns) {

            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        });
        acctTable.setBounds(0, 0, 500, 300);

        scrollPane = new JScrollPane(acctTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete).addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnEdit).addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        // this.add(scrollPane);
        // this.setSize(500, 400);
        // this.setVisible(true);
        // desktop.add(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnEditActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt){
        JOptionPane.showOptionDialog(null, "Are you sure you want to delete this entry?", "Deletion Confirmation", 2, 3, null, null, null);
        delete();
    }

    private void delete(){
        int column = 0;
        int row = acctTable.getSelectedRow();
        String value = acctTable.getModel().getValueAt(row, column).toString();
        System.out.println(value);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JDesktopPane desktop;
    private AccountMap accounts;
    private JTable acctTable;
    private JScrollPane scrollPane;
    private JButton btnEdit;
    private JButton btnDelete;
    // End of variables declaration//GEN-END:variables
}
