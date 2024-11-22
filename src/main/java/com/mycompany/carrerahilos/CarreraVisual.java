/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.carrerahilos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author alumno
 */
public class CarreraVisual extends javax.swing.JFrame {
    /**
     * Creates new form CarreraVisual
     */
    
    private JTextField distanciaEntrada;
    private int distanciaMeta;
    
    public CarreraVisual(){    
            initComponents();
            setFondoPanel();
            cambiarEstiloBoton();
            setResizable(false);
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
    
    private void cambiarEstiloBoton() {
      
        BotonEmpezar.setFont(new java.awt.Font("Consolas", 3, 18));  
        BotonEmpezar.setBackground(new Color(100, 76, 72));
        BotonEmpezar.setForeground(new Color(180, 158, 154));
        BotonEmpezar.setText("¡EMPEZAR CARRERA!");  // Texto más claro
        BotonEmpezar.setBorder(BorderFactory.createLineBorder(new Color(100, 76, 72), 3));
        BotonEmpezar.setFocusPainted(false);
        BotonEmpezar.setPreferredSize(new Dimension(250, 60));

        // Efecto hover
        BotonEmpezar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonEmpezar.setBackground(new Color(123, 95, 90));
                BotonEmpezar.setForeground(new Color(100, 76, 72));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonEmpezar.setBackground(new Color(100, 76, 72));  
            }
        });
    }

    private void setFondoPanel() {
        
        FondoPanel fondoPanel = new FondoPanel();
        fondoPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        getContentPane().removeAll();  // Limpiar el contenedor anterior

        // Usamos un layout adecuado para organizar el contenido
        getContentPane().setLayout(new BorderLayout());

        // Agregamos el fondo al centro
        getContentPane().add(fondoPanel, BorderLayout.CENTER); 
        
        // Agregamos el botón a la parte inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(180, 158, 154));
        panelInferior.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        panelInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelInferior.add(BotonEmpezar);
       
        panelInferior.add(Box.createHorizontalStrut(50));
        
        JLabel distanciaTexto = new JLabel("DISTANCIA:");
        distanciaTexto.setFont(new java.awt.Font("Consolas", 1, 18)); // Establecer fuente
        panelInferior.add(distanciaTexto);

        // Campo de texto para la distancia
        distanciaEntrada = new JTextField(10); // Ancho de 10 columnas
        distanciaEntrada.setFont(new java.awt.Font("Consolas", 0, 18)); // Establecer fuente
        distanciaEntrada.setPreferredSize(new Dimension(120, 30)); // Ajustar tamaño si lo deseas
        panelInferior.add(distanciaEntrada);
        

        getContentPane().add(panelInferior, BorderLayout.SOUTH);

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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonEmpezar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1125, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonEmpezar.setBackground(new java.awt.Color(221, 207, 205));
        BotonEmpezar.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        BotonEmpezar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonEmpezar.setLabel("EMPEZAR");
        BotonEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEmpezarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BotonEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1095, Short.MAX_VALUE)
                .addComponent(BotonEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEmpezarActionPerformed
                                        
    // Obtener el valor ingresado en el campo de texto
    String distanciaTexto = distanciaEntrada.getText();
    
    try {
        // Convertir el valor a un número entero
        int distancia = Integer.parseInt(distanciaTexto);
        
        if (distanciaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una distancia.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            // Convertir la distancia a entero
            distanciaMeta = Integer.parseInt(distanciaTexto);
            
            // Verificamos que la distancia sea mayor que 0
            if (distanciaMeta < 500 || distanciaMeta > 1500) {
                JOptionPane.showMessageDialog(this, "La distancia debe estar entre 500 y 1500 .", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Usar la distancia obtenida, por ejemplo, como límite para los coches
            System.out.println("La distancia ingresada es: " + distanciaMeta);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para la distancia.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Asignar la distancia máxima a cada coche
        int distanciaMaxima = distancia;  // Distancia que el coche debe recorrer

        this.velocidades = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        Random random = new Random();

        // Hilos para cada coche
        // Coche 1
        new Thread(() -> {
            int velocidad = velocidades[random.nextInt(velocidades.length)];
            while (c1y > (getHeight() - distanciaMaxima)) {  // Asegúrate de que el coche no sobrepase la distancia
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
            while (c2y > (getHeight() - distanciaMaxima)) {
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
            while (c3y > (getHeight() - distanciaMaxima)) {
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
            while (c4y > (getHeight() - distanciaMaxima)) {
                moverCoche(4, velocidad);
                repaint();
                try {
                    Thread.sleep(50);  // Espera entre movimientos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
    } catch (NumberFormatException e) {
        // Si ocurre un error en la conversión (por ejemplo, si el usuario ingresa texto no numérico)
        System.err.println("Por favor, ingresa un número válido para la distancia.");
    }
   

    }//GEN-LAST:event_BotonEmpezarActionPerformed

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
    private javax.swing.JButton BotonEmpezar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
