package view;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyVetoException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.internalframe.AccountFrame;
import model.Account;
import model.AccountMap;
import model.User;

/**
 *
 * @author WORM with template from jitzu
 */
public final class mainView extends javax.swing.JFrame {

    private final ImageIcon worm = new ImageIcon(this.getClass().getResource("/images/worm.png"));
    /**
     * Creates new form mainView
     */
    public mainView() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        //set to true if an account exists
        isSignup(false);
    }

    public ImageIcon getWorm() {
        return worm;
    }

    //Do not show signup if user has an account
    public void isSignup(boolean b){
        menuSignup.setEnabled(!b);
        menuLogin.setEnabled(b);
        menuLogout.setEnabled(false);
        menuChangePassword.setEnabled(b);
        menuAddEntry.setEnabled(false);
        menuEditEntry.setEnabled(false);
        menuDeleteEntry.setEnabled(false);
        menuViewEntries.setEnabled(false);
        menuFindEntry.setEnabled(false);
        menuPasswordGen.setEnabled(false);
        menuMaster2.setEnabled(b);

        if (!b) {
            txtLoginAs.setText("you must sign up first.");
            userLabel.setText("");
        } 
        else{
            txtLoginAs.setText("you must login first.");
            userLabel.setText("");
        }
    }

    public void isLoggin(boolean b) {
        menuSignup.setEnabled(false);
        menuLogin.setEnabled(!b);
        menuLogout.setEnabled(b);
        menuChangePassword.setEnabled(true);
        menuAddEntry.setEnabled(b);
        // Enabled for testing purposes only (only allowed if an entry exists)
        menuEditEntry.setEnabled(b);
        menuDeleteEntry.setEnabled(b);
        menuViewEntries.setEnabled(b);
        menuFindEntry.setEnabled(b);
        menuPasswordGen.setEnabled(b);
        menuMaster2.setEnabled(b);

        if (b) {
            txtLoginAs.setText("logged in as : ");
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
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/nontransparent.png"));
        Image image = icon.getImage();
        JLabel label = new JLabel(icon);
        label.setIcon(icon);
        desktopPane = new javax.swing.JDesktopPane() {
            public void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D)g;
                g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel1 = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        txtLoginAs = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuSignup = new javax.swing.JMenuItem();
        menuLogin = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();
        menuChangePassword = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuAddEntry = new javax.swing.JMenuItem();
        menuEditEntry = new javax.swing.JMenuItem();
        menuDeleteEntry = new javax.swing.JMenuItem();
        menuFindEntry = new javax.swing.JMenuItem();
        menuViewEntries = new javax.swing.JMenuItem();
        menuPasswordGen = new javax.swing.JMenuItem();
        menuMaster2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PassWORM Manager");

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

        txtLoginAs.setText("logged in as :");

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

        menuSignup.setText("Sign Up");
        menuSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSignupActionPerformed(evt);
            }
        });
        menuFile.add(menuSignup);

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

        menuChangePassword.setText("Change Password");
        menuChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChangePasswordPerformed(evt);
            }
        });
        menuFile.add(menuChangePassword);

        jMenuBar1.add(menuFile);

        menuEdit.setText("Edit");
        menuAddEntry.setText("Add Entry");
        menuAddEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAccounts(User.getInstance().getAccounts());
                menuAddEntryActionPerformed(evt);
            }
        });
        menuEdit.add(menuAddEntry);
        menuEditEntry.setText("Edit Entry");
        menuEditEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //Is there a better place to put ths instead of before every call?
                setAccounts(User.getInstance().getAccounts());
                menuEditEntryActionPerformed(evt);
            }
        });
        menuEdit.add(menuEditEntry);
        menuDeleteEntry.setText("Delete Entry");
        menuDeleteEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAccounts(User.getInstance().getAccounts());
                menuDeleteEntryActionPerformed(evt);
            }
        });
        menuEdit.add(menuDeleteEntry);
        menuFindEntry.setText("Find Entry");
        menuFindEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAccounts(User.getInstance().getAccounts());
                menuFindEntryActionPerformed(evt);
            }
        });
        menuEdit.add(menuFindEntry);
        menuViewEntries.setText("View Entries");
        menuViewEntries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAccounts(User.getInstance().getAccounts());
                menuViewEntriesActionPerformed(evt);
            }
        });
        menuEdit.add(menuViewEntries);

        menuPasswordGen.setText("Password Generator");
        menuPasswordGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAccounts(User.getInstance().getAccounts());
                menuPasswordGenActionPerformed(evt);
            }
        });
        menuEdit.add(menuPasswordGen);

        jMenuBar1.add(menuEdit);

        setJMenuBar(jMenuBar1);

        pack();
    }

    private void menuSignupActionPerformed(java.awt.event.ActionEvent evt) {
        signupPopup signupPopups = new signupPopup(null, true, this);
        signupPopups.setVisible(true);
    }

    private void menuAddEntryActionPerformed(java.awt.event.ActionEvent evt) {
        addEntryPopup addEntryPopups = new addEntryPopup(null, true, this);
        addEntryPopups.setVisible(true);
    }

    private void menuEditEntryActionPerformed(java.awt.event.ActionEvent evt) {
        findEntryPopup findEntryPopups = new findEntryPopup(desktopPane, true, this);
        findEntryPopups.setVisible(true);
    }

    private void menuDeleteEntryActionPerformed(java.awt.event.ActionEvent evt) {
        findEntryPopup findEntryPopups = new findEntryPopup(desktopPane, true, this);
        findEntryPopups.setVisible(true);
    }

    private void menuFindEntryActionPerformed(java.awt.event.ActionEvent evt) {
        findEntryPopup findEntryPopups = new findEntryPopup(desktopPane, true, this);
        findEntryPopups.setVisible(true);

    }

    private void menuViewEntriesActionPerformed(java.awt.event.ActionEvent evt) {
        AccountFrame accountFrame = new AccountFrame(this, desktopPane);
        desktopPane.add(accountFrame);
        accountFrame.setVisible(true);

    }

    private void menuPasswordGenActionPerformed(java.awt.event.ActionEvent evt) {
        PasswordGenPopup passwordGen = new PasswordGenPopup(this, desktopPane);
        desktopPane.add(passwordGen);
        passwordGen.setVisible(true);

    }

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        isLoggin(false);
    }

    private void menuLoginActionPerformed(java.awt.event.ActionEvent evt) {
        loginPopup loginPopups = new loginPopup(null, true, this);
        loginPopups.setVisible(true);
    }

    private void menuChangePasswordPerformed(java.awt.event.ActionEvent evt) {
        changePasswordPopup changePasswordPopups = new changePasswordPopup(null, true, this);
        changePasswordPopups.setVisible(true);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

    public AccountMap getAccounts() {
        return accounts;
    }

    public void setAccounts(AccountMap accounts) {
        this.accounts = accounts;
    }

    // Variables declaration
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuSignup;
    private javax.swing.JMenuItem menuLogin;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuChangePassword;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenuItem menuAddEntry;
    private javax.swing.JMenuItem menuEditEntry;
    private javax.swing.JMenuItem menuDeleteEntry;
    private javax.swing.JMenuItem menuFindEntry;
    private javax.swing.JMenuItem menuViewEntries;
    private javax.swing.JMenuItem menuPasswordGen;
    private javax.swing.JMenuItem menuMaster2;
    private javax.swing.JLabel txtLoginAs;
    private javax.swing.JLabel userLabel;
    private AccountMap accounts;

    // End of variables declaration
}
