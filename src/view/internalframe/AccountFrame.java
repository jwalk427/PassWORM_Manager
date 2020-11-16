package view.internalframe;

import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.AccountMap;
import view.editEntryPopup;
import view.mainView;

/**
 *
 * @author jitzu
 */
public class AccountFrame extends javax.swing.JInternalFrame {

    private mainView mainViews;
    /**
     * Creates new form Master1Frame1
     */
    public AccountFrame(mainView mainViews, JDesktopPane parent) {
        super("User Accounts", true, true, true, true);
        this.mainViews = mainViews;
        accounts = mainViews.getAccounts();
        desktop = parent;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);

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

        acctTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClickActionPerformed(evt);
            }
        });

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

        pack();
    }

    private void tableClickActionPerformed(java.awt.event.MouseEvent evt){
        int column = 0;
        int row = acctTable.getSelectedRow();
        String title = acctTable.getModel().getValueAt(row, column).toString();
        if(title != null){
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt){
        int column = 0;
        int row = acctTable.getSelectedRow();
        String title = acctTable.getModel().getValueAt(row, column).toString();
        if(title != null){
            editEntryPopup editEntryPopups = new editEntryPopup(null, true, mainViews, title);
            editEntryPopups.setVisible(true);
        }
        this.dispose();
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt){
        int column = 0;
        int row = acctTable.getSelectedRow();
        String title = acctTable.getModel().getValueAt(row, column).toString();
        if(title != null){
            int answer = JOptionPane.showOptionDialog(null, "Are you sure you want to delete this entry?", "Deletion Confirmation", 2, 3, null, null, null);
            if (answer == JOptionPane.YES_OPTION) {
                delete(title);
            }
        }
    }

    private void delete(String title){
        accounts.removeAccount(title);
        JOptionPane.showMessageDialog(null, title + " successfully deleted.");
        this.dispose();
    }


    // Variables declaration - do not modify
    private JDesktopPane desktop;
    private AccountMap accounts;
    private JTable acctTable;
    private JScrollPane scrollPane;
    private JButton btnEdit;
    private JButton btnDelete;
    // End of variables declaration
}
