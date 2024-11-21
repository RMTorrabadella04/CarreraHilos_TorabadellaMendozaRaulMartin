/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.carrerahilos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author alumno
 */
public class CarreraVisual extends javax.swing.JFrame {



    /**
     * Creates new form CarreraVisual
     */
    public CarreraVisual(){
        this.velocidades = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        Random random = new Random();
        
            initComponents();
            setFondoPanel();
            setResizable(false);
                        
        // Hilos para cada coche
        // Coche 1
        new Thread(() -> {
            int velocidad = velocidades[random.nextInt(velocidades.length)];
            for (int i = c1y; c1y > 0;) {  // Asegúrate de que el número de iteraciones sea adecuado
                moverCoche(1, velocidad);
                repaint();
                try {
                    Thread.sleep(50);  // Espera entre movimientos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Coche 2
        new Thread(() -> {
            int velocidad = velocidades[random.nextInt(velocidades.length)];
            for (int i = c2y; c2y > 0;) {
                moverCoche(2, velocidad);
                repaint();
                try {
                    Thread.sleep(50);  // Espera entre movimientos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Coche 3
        new Thread(() -> {
            int velocidad = velocidades[random.nextInt(velocidades.length)];
            for (int i = c3y; c3y > 0;) {
                moverCoche(3, velocidad);
                repaint();
                try {
                    Thread.sleep(50);  // Espera entre movimientos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Coche 4
        new Thread(() -> {
            int velocidad = velocidades[random.nextInt(velocidades.length)];
            for (int i = c4y; c4y > 0;) {
                moverCoche(4, velocidad);
                repaint();
                try {
                    Thread.sleep(50);  // Espera entre movimientos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
       
    }
    public int[] velocidades;
    public int c1y=850;
    public int c2y=850;
    public int c3y=850;
    public int c4y=850;
    
      // Panel personalizado para dibujar la imagen de fondo
    class FondoPanel extends JPanel {
        private Image fondo;
        private Image coche1;
        private Image coche2;
        private Image coche3;
        private Image coche4;
        

        // Cargar la imagen en el constructor
       public FondoPanel() {
            
            URL imageURL = getClass().getResource("/carretera1.jpg");
            System.out.println("Image URL: " + imageURL);

            if (imageURL != null) {
                fondo = new ImageIcon(imageURL).getImage();
            } else {
                System.err.println("Image not found!");
                fondo = new ImageIcon().getImage();  
            }
            
            URL coche1Url = getClass().getResource("/Coche1.png"); 
            if (coche1Url != null) {
                coche1 = new ImageIcon(coche1Url).getImage();
            } else {
                coche1 = null;  // Si no se encuentra la imagen, usamos null
            }

            URL coche2Url = getClass().getResource("/Coche2.png");
            if (coche2Url != null) {
                coche2 = new ImageIcon(coche2Url).getImage();
            } else {
                coche2 = null;
            }
            
            URL coche3Url = getClass().getResource("/Coche3.png");
            if (coche3Url != null) {
                coche3 = new ImageIcon(coche3Url).getImage();
            } else {
                coche3 = null;
            }
            
            URL coche4Url = getClass().getResource("/Coche4.png"); 
            if (coche4Url != null) {
                coche4 = new ImageIcon(coche4Url).getImage();
            } else {
                coche4 = null;
            }
            
        }


        // Sobrescribir paintComponent para dibujar la imagen de fondo
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            
            g.drawImage(coche1, 80, c1y, this);
            g.drawImage(coche2, 185, c2y, this);
            g.drawImage(coche3, 310, c3y, this);
            g.drawImage(coche4, 420, c4y, this);
           
            
        }
        
         
       
    }
   
    private void setFondoPanel() {
        FondoPanel fondoPanel = new FondoPanel();

        getContentPane().removeAll();
        getContentPane().add(fondoPanel);

        fondoPanel.setLayout(null);
        fondoPanel.setBounds(0, 0, getWidth(), getHeight());
        fondoPanel.setPreferredSize(new Dimension(getWidth(), getHeight())); // Establecer tamaño

        revalidate();
        repaint();
    }
    
    // Método para mover el coche
    public synchronized void moverCoche(int cocheId, int velocidad) {
        switch (cocheId) {
            case 1:
                this.c1y = Math.max(0, this.c1y - velocidad);
                break;
            case 2:
                this.c2y = Math.max(0, this.c2y - velocidad);
                break;
            case 3:
                this.c3y = Math.max(0, this.c3y - velocidad);
                break;
            case 4:
                this.c4y = Math.max(0, this.c4y - velocidad);
                break;
        }
        repaint();
    }


    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1153, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarreraVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarreraVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarreraVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarreraVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                 new CarreraVisual().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
