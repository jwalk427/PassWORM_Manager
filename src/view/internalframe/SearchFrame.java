/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.internalframe;

import java.util.Set;

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
public class SearchFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form Master1Frame1
     */
    public SearchFrame(mainView mainViews, JDesktopPane parent, String search) {
        super("Search Results for: " + "\"" + search + "\"", true, true, true, true);
        accounts = mainViews.getAccounts();
        desktop = parent;
        searchTerm = search;
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

        Set<String> temp = null;
        System.out.println(accounts.getTitles());
        if (!accounts.getTitles().isEmpty()){
            temp = accounts.getTitles();
        }
        //Special cases
        if (temp == null){
            JOptionPane.showMessageDialog(null, "There are no stored accounts.");
            return;
        }
        
        String[] columns = {"Title", "Username", "URL", "Password", "Notes"};
        int count = 0;
        for(String title: accounts.getTitles()){
            if(title.toLowerCase().contains(searchTerm)){
                count++;
            }
        }
        String[][] data = new String[count][5];

        int i = 0;
        for(String title: accounts.getTitles()){
            if(title.toLowerCase().contains(searchTerm)){
                String[] accountArray = accounts.getAccountArray(title);
                data[i][0] = title;
                data[i][1] = accountArray[0];
                data[i][2] = accountArray[1];
                data[i][3] = accountArray[2];
                data[i][4] = accountArray[3];
                i++;
            }
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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );

        // this.add(scrollPane);
        // this.setSize(500, 400);
        // this.setVisible(true);
        // desktop.add(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JDesktopPane desktop;
    private AccountMap accounts;
    private JTable acctTable;
    private JScrollPane scrollPane;
    private String searchTerm;
    // End of variables declaration//GEN-END:variables
}
