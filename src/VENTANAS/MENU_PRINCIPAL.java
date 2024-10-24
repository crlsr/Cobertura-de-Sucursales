/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VENTANAS;

import EDD.Grafo;
import JSON.LecturaJSON;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class MENU_PRINCIPAL extends javax.swing.JFrame {
    static Grafo grafo;
    static LecturaJSON json;
    static boolean jsoncargado;
    /**
     * Creates new form MENU_INICIO
     */
    public MENU_PRINCIPAL() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.grafo =new Grafo();
        this.jsoncargado = false;
    }
    public MENU_PRINCIPAL(Grafo grafo,LecturaJSON json) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.grafo =grafo;
        this.json =json;
        this.jsoncargado = true;
    }
    
    /**
     * @return icono 
     * Se carga una imagen desde el package de imagenes, usando la libreria toolkit 
     * se obtiene una una representacion de dicha imagen.
     * Retorna una variable de tipo imagen igualada a la instacia antes mencionada.
     * @author Marco Betancourt
     */
    public Image getIconImage() {
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/ICONO.png"));
        return icono;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EDITAR_DATA = new javax.swing.JButton();
        AGREGAR_SUCURSALES = new javax.swing.JButton();
        CARGAR_JSON = new javax.swing.JButton();
        CERRAR = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        INSTRUCCIONES = new javax.swing.JButton();
        FONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU PRINCIPAL");
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EDITAR_DATA.setBackground(new java.awt.Color(0, 51, 51));
        EDITAR_DATA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EDITAR_DATA.setForeground(new java.awt.Color(255, 255, 255));
        EDITAR_DATA.setText("EDITAR DATA");
        EDITAR_DATA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITAR_DATAActionPerformed(evt);
            }
        });
        getContentPane().add(EDITAR_DATA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        AGREGAR_SUCURSALES.setBackground(new java.awt.Color(0, 51, 51));
        AGREGAR_SUCURSALES.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AGREGAR_SUCURSALES.setForeground(new java.awt.Color(255, 255, 255));
        AGREGAR_SUCURSALES.setText("MANEJO SUCURSALES");
        AGREGAR_SUCURSALES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_SUCURSALESActionPerformed(evt);
            }
        });
        getContentPane().add(AGREGAR_SUCURSALES, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        CARGAR_JSON.setBackground(new java.awt.Color(0, 51, 51));
        CARGAR_JSON.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CARGAR_JSON.setForeground(new java.awt.Color(255, 255, 255));
        CARGAR_JSON.setText("CARGAR JSON");
        CARGAR_JSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CARGAR_JSONActionPerformed(evt);
            }
        });
        getContentPane().add(CARGAR_JSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        CERRAR.setBackground(new java.awt.Color(255, 0, 0));
        CERRAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CERRAR.setForeground(new java.awt.Color(255, 255, 255));
        CERRAR.setText("X");
        CERRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CERRARActionPerformed(evt);
            }
        });
        getContentPane().add(CERRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MENU PRINCIPAL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ICONO_MENU.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, 200));

        INSTRUCCIONES.setBackground(new java.awt.Color(0, 51, 51));
        INSTRUCCIONES.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INSTRUCCIONES.setForeground(new java.awt.Color(255, 255, 255));
        INSTRUCCIONES.setText("INSTRUCCIONES");
        INSTRUCCIONES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSTRUCCIONESActionPerformed(evt);
            }
        });
        getContentPane().add(INSTRUCCIONES, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, -1));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/FONDO_AZUL.png"))); // NOI18N
        getContentPane().add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -4, 580, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * @param evt 
     * Verifica si el json esta cargado
     * Si se cumple la condición abre la ventana "EDITOR_DATA" y cierra esta ventana.
     * Si no pasa un mensaje de error.
     * @author Marco Betancourt
     */
    private void EDITAR_DATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITAR_DATAActionPerformed
        if(jsoncargado){
        EDITOR_DATA MED = new EDITOR_DATA(grafo, json); 
        MED.setVisible(true);
        this.setVisible(false);        
        }else{
            JOptionPane.showMessageDialog(this, "Debe cargar primero un archivo JSON");
        }
    }//GEN-LAST:event_EDITAR_DATAActionPerformed

    
    /**
     * @param evt
     * Abre la ventana "EDITOR_DATA" y cierra esta ventana.
     * @author Marco Betancourt
     */
    private void CARGAR_JSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CARGAR_JSONActionPerformed
        CARGAR_JSON MCJ = new CARGAR_JSON(grafo, json); 
        MCJ.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CARGAR_JSONActionPerformed

    
    /**
     * @param evt 
     * Termina con la ejecución al oprimir el botón.
     * Cierra la interfaz.
     * no retorna.
     * @author Marco Betancourt
     */
    private void CERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CERRARActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CERRARActionPerformed

    
    /**
     * @param evt 
     * Verifica si el json esta cargado
     * Si se cumple la condición abre la ventana "AGREGAR_SUCURSAL" y cierra esta ventana.
     * Si no pasa un mensaje de error.
     * @author Marco Betancourt
     */
    private void AGREGAR_SUCURSALESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_SUCURSALESActionPerformed
        if(jsoncargado){
        AGREGAR_SUCURSAL MAG = new AGREGAR_SUCURSAL(grafo, json);
        MAG.setVisible(true);
        this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Debe cargar primero un archivo JSON");
        }
    }//GEN-LAST:event_AGREGAR_SUCURSALESActionPerformed


    /**
     * @param evt
     * Crea un JOptionPane el cual devuelve un mensaje con las instrucciones que se encuentran en esa ventana.
     * @author Marco Betancourt
     */
    private void INSTRUCCIONESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSTRUCCIONESActionPerformed
        JOptionPane.showMessageDialog(this, "Instrucciones Menu Principal\n"
                                          + "Haga click en el botón CARGAR JSON para subir un archivo .JSON y establecer un radio de cobertura\n"
                                          + "Haga click en el botón MANEJO SUCURSALES para explorar el control de sucursales en las estaciones\n"
                                          + "Haga click en el botón EDITAR DATA para agregar nuevas lineas a las redes de transporte\n"
                                          + "Nota: Inicialmente, se debe cargar un archivo .JSON y establecer un radio de cobertura");
    }//GEN-LAST:event_INSTRUCCIONESActionPerformed

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
            java.util.logging.Logger.getLogger(MENU_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MENU_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MENU_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MENU_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MENU_PRINCIPAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AGREGAR_SUCURSALES;
    private javax.swing.JButton CARGAR_JSON;
    private javax.swing.JButton CERRAR;
    private javax.swing.JButton EDITAR_DATA;
    private javax.swing.JLabel FONDO;
    private javax.swing.JButton INSTRUCCIONES;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
