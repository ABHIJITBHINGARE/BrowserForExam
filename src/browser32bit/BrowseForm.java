/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package browser32bit;
import java.io.File;
import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.MessageBox;

/**
 *
 * @author comp
 */
public class BrowseForm extends javax.swing.JFrame {

    /**
     * Creates new form BrowseForm
     */
    
    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imrlogo.png")));
    }
    
    public static String readFileAsString(String fileName)throws Exception 
    {
        String data = ""; 
        
     //   data = new String(Files.readAllBytes(Paths.get(fileName))); 
       File fl=new File(fileName);
        Scanner sc=new Scanner(fl);
        while(sc.hasNext())
        {
            data=sc.nextLine();
        }
        sc.close();
        return data; 
    }
    public BrowseForm() {
           String data = "";
        try {
            data = readFileAsString("config.txt");
        } catch (Exception ex) {
            Logger.getLogger(BrowseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
           this.setAlwaysOnTop(true);
        this.setResizable(false);
        initComponents();
         setIcon();
         Toolkit tk=Toolkit.getDefaultToolkit();
            int xsize=(int) tk.getScreenSize().getWidth();
            int ysize=(int) tk.getScreenSize().getHeight();
            this.setSize(xsize,ysize);
             String url= data; //"erp.imr.ac.in/kceimr";
             final JWebBrowser bro=new JWebBrowser();
        bro.setMenuBarVisible(false);
        bro.setStatusBarVisible(false);
        bro.setBarsVisible(false);
        bro.navigate(url);
        bro.setJavascriptEnabled(true);   
        panel1.add(bro,BorderLayout.CENTER);  
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         UIUtils.setPreferredLookAndFeel();
         NativeInterface.open();
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
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
            java.util.logging.Logger.getLogger(BrowseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrowseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrowseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrowseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BrowseForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
