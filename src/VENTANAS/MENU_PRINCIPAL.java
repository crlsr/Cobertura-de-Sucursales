/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VENTANAS;

/**
 *
 * @author marco
 */
public class MENU_PRINCIPAL extends javax.swing.JFrame {

    /**
     * Creates new form MENU_INICIO
     */
    public MENU_PRINCIPAL() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        CAMBIAR_JSON = new javax.swing.JButton();
        CERRAR = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        AGREGAR_SUCURSALES.setText("AGREGAR SUCURSALES");
        AGREGAR_SUCURSALES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_SUCURSALESActionPerformed(evt);
            }
        });
        getContentPane().add(AGREGAR_SUCURSALES, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        CAMBIAR_JSON.setBackground(new java.awt.Color(0, 51, 51));
        CAMBIAR_JSON.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CAMBIAR_JSON.setForeground(new java.awt.Color(255, 255, 255));
        CAMBIAR_JSON.setText("CAMBIAR JSON");
        CAMBIAR_JSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CAMBIAR_JSONActionPerformed(evt);
            }
        });
        getContentPane().add(CAMBIAR_JSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

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
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/FONDO_AZUL.png"))); // NOI18N
        getContentPane().add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -4, 580, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EDITAR_DATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITAR_DATAActionPerformed
        CAMBIAR_JSON MCJ = new CAMBIAR_JSON(); 
        MCJ.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_EDITAR_DATAActionPerformed

    private void CAMBIAR_JSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CAMBIAR_JSONActionPerformed
        EDITOR_DATA MED = new EDITOR_DATA(); 
        MED.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CAMBIAR_JSONActionPerformed

    private void CERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CERRARActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CERRARActionPerformed

    private void AGREGAR_SUCURSALESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_SUCURSALESActionPerformed
        AGREGAR_SUCURSAL MAG = new AGREGAR_SUCURSAL();
        MAG.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AGREGAR_SUCURSALESActionPerformed

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
    private javax.swing.JButton CAMBIAR_JSON;
    private javax.swing.JButton CERRAR;
    private javax.swing.JButton EDITAR_DATA;
    private javax.swing.JLabel FONDO;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
