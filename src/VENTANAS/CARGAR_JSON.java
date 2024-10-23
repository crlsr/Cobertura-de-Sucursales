/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VENTANAS;

import EDD.Grafo;
import JSON.LecturaJSON;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author marco
 */
public class CARGAR_JSON extends javax.swing.JFrame {
    static Grafo grafo;
    static LecturaJSON json;
    /**
     * Creates new form CAMBIAR_JSON
     */
    public CARGAR_JSON(Grafo grafo,LecturaJSON json) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.grafo=grafo;
        this.json=json;        
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/ICONO.png"));
        return retValue;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CARGAR_JSON = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        INPUT_T = new javax.swing.JTextField();
        REGRESAR = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabeljson = new javax.swing.JLabel();
        CERRAR = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ESTABLECER_T = new javax.swing.JButton();
        INSTRUCCIONES = new javax.swing.JButton();
        FONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CARGAR JSON");
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CARGAR_JSON.setBackground(new java.awt.Color(0, 51, 51));
        CARGAR_JSON.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CARGAR_JSON.setForeground(new java.awt.Color(255, 255, 255));
        CARGAR_JSON.setText("CARGAR JSON");
        CARGAR_JSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CARGAR_JSONActionPerformed(evt);
            }
        });
        getContentPane().add(CARGAR_JSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ESTABLECER RADIO DE COBERTURA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 250, -1));

        INPUT_T.setBackground(new java.awt.Color(0, 0, 51));
        INPUT_T.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INPUT_T.setForeground(new java.awt.Color(255, 255, 255));
        INPUT_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INPUT_TActionPerformed(evt);
            }
        });
        getContentPane().add(INPUT_T, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 250, -1));

        REGRESAR.setBackground(new java.awt.Color(0, 51, 51));
        REGRESAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        REGRESAR.setText("REGRESAR");
        REGRESAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGRESARActionPerformed(evt);
            }
        });
        getContentPane().add(REGRESAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CARGAR JSON");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 210, -1));

        jLabeljson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/IMAGEN_JSON.png"))); // NOI18N
        getContentPane().add(jLabeljson, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 200, -1, -1));

        CERRAR.setBackground(new java.awt.Color(255, 0, 0));
        CERRAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CERRAR.setForeground(new java.awt.Color(255, 255, 255));
        CERRAR.setText("X");
        CERRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CERRARActionPerformed(evt);
            }
        });
        getContentPane().add(CERRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ICONO_RADIO.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        ESTABLECER_T.setBackground(new java.awt.Color(0, 51, 51));
        ESTABLECER_T.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ESTABLECER_T.setForeground(new java.awt.Color(255, 255, 255));
        ESTABLECER_T.setText("ESTABLECER");
        ESTABLECER_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ESTABLECER_TActionPerformed(evt);
            }
        });
        getContentPane().add(ESTABLECER_T, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        INSTRUCCIONES.setBackground(new java.awt.Color(0, 51, 51));
        INSTRUCCIONES.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INSTRUCCIONES.setForeground(new java.awt.Color(255, 255, 255));
        INSTRUCCIONES.setText("INSTRUCCIONES");
        INSTRUCCIONES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSTRUCCIONESActionPerformed(evt);
            }
        });
        getContentPane().add(INSTRUCCIONES, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/FONDO_AZUL.png"))); // NOI18N
        getContentPane().add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void INPUT_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INPUT_TActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_INPUT_TActionPerformed

    private void CERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CERRARActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CERRARActionPerformed

    private void CARGAR_JSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CARGAR_JSONActionPerformed
        try {
        JFileChooser finder = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos JSON", "json");
        finder.setFileFilter(filter);
        int response = finder.showOpenDialog(null);
        if(response == JFileChooser.APPROVE_OPTION){
            File selected = finder.getSelectedFile(); 
            if (json ==null){
            json=new LecturaJSON(selected);
            json.dataConstructor(grafo);
            }else{
            this.json.changeJSON(selected, this.grafo);
            }
            if(json != null){
                JOptionPane.showMessageDialog(this, "El JSON se ha cargado correctamente");
            }
        }
        
        }    
        catch (Exception e){
           JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");
       }
    }//GEN-LAST:event_CARGAR_JSONActionPerformed

    private void ESTABLECER_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ESTABLECER_TActionPerformed
        try {
            if (json != null){
            int t = Integer.parseInt(INPUT_T.getText());                              
            INPUT_T.setText("");
            if(t<grafo.getNumVertices()){
                if (t>0){
                this.grafo.setT(t);
                JOptionPane.showMessageDialog(this, "Radio de cobertura establecido de forma correcta ✅");
                }
                else{
                JOptionPane.showMessageDialog(this, "No se permiten radios negativos");
                }
            }
            else{
            JOptionPane.showMessageDialog(this, "El radio de cobertura no puede ser mayor que el numero de estaciones");
            }
        }
            else{
            JOptionPane.showMessageDialog(this, "Debes cargar primero el JSON");
            }
        }    
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ingresa los datos correctamente ❌");
        }
    }//GEN-LAST:event_ESTABLECER_TActionPerformed

    private void REGRESARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGRESARActionPerformed
        if(json!=null && grafo.getT()>0){
            MENU_PRINCIPAL MP = new MENU_PRINCIPAL(grafo, json);
            MP.setVisible(true);
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(this, "Agregue un JSON y establesca el radio de cobertura primero");
        }
    }//GEN-LAST:event_REGRESARActionPerformed

    private void INSTRUCCIONESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSTRUCCIONESActionPerformed
        JOptionPane.showMessageDialog(this, "Carga un archivo json e ingresa un radio de cobertura para poder acceder a las demas funciones");
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
            java.util.logging.Logger.getLogger(CARGAR_JSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CARGAR_JSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CARGAR_JSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CARGAR_JSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CARGAR_JSON(grafo,json).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CARGAR_JSON;
    private javax.swing.JButton CERRAR;
    private javax.swing.JButton ESTABLECER_T;
    private javax.swing.JLabel FONDO;
    private javax.swing.JTextField INPUT_T;
    private javax.swing.JButton INSTRUCCIONES;
    private javax.swing.JButton REGRESAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabeljson;
    // End of variables declaration//GEN-END:variables
}