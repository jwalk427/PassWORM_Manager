/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.internalframe;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
    private String searchTerm;
    public SearchFrame(mainView mainViews, String search) {
        initComponents();
        accounts = mainViews.getAccounts();
        searchTerm = search;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Search Results");

        JFrame findFrame = new JFrame("Search Results");
        JTextArea findText = new JTextArea();
        for(String s: accounts.getTitles()){
            String l = s;
            if(l.toLowerCase().contains(searchTerm)){
                findText.append("Title: " + s + "  " + accounts.getAccount(s) + "\n");
            }
        }
        findText.setEditable(false);
        findText.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(findText); 
        findFrame.add(scrollPane);
        findFrame.setSize(480, 360);
        findFrame.setVisible(true);

        // javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        // getContentPane().setLayout(layout);
        // layout.setHorizontalGroup(
        //     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //         .addGap(0, 394, Short.MAX_VALUE)
        //         //.addComponent(accounts.getAccount(title), javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
        // );

        // //Figure out a way to create an array of components (account information) and print them within the window in a for loop
        // for (String title : accounts.getTitles()){
        //     layout.setHorizontalGroup(
        //         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //             .addGap(0, 394, Short.MAX_VALUE)
        //             //.addComponent(accounts.getAccount(title), javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
        //     );
        // }

        // layout.setVerticalGroup(
        //     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGap(0, 274, Short.MAX_VALUE)
        // );
        
        /*javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelLogin)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCancelLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        ); */

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AccountMap accounts;
    // End of variables declaration//GEN-END:variables
}