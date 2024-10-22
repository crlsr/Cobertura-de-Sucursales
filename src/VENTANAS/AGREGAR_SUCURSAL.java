/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VENTANAS;

import EDD.Grafo;
import javax.swing.JOptionPane;
import EXTRAS.Funciones;
import EXTRAS.Estacion;
import JSON.LecturaJSON;


/**
 *
 * @author marco
 */
public class AGREGAR_SUCURSAL extends javax.swing.JFrame {
    static Grafo grafo;
    static Funciones funciones;
    static LecturaJSON json;

    /**
     * Creates new form MENU_SUCURSAL
     */
    public AGREGAR_SUCURSAL(Grafo grafo, LecturaJSON json) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.grafo=grafo;
        this.json=json;   
        funciones = new Funciones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        INPUT_AGREGAR_SUCURSAL = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        AGREGAR_SUCURSAL = new javax.swing.JButton();
        VER_COBERTURA_DFS = new javax.swing.JButton();
        VER_COBERTUTA_TOTAL = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        INPUT_ESTACIONES_CUBIERTAS = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        INPUT_ESTACIONAR_SUCURSAL = new javax.swing.JTextArea();
        CERRAR = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ELIMINAR_SUCURSAL = new javax.swing.JButton();
        VER_COBERTURA_BFS = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        REGRESAR = new javax.swing.JButton();
        FONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SUCURSALES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        INPUT_AGREGAR_SUCURSAL.setBackground(new java.awt.Color(0, 0, 51));
        INPUT_AGREGAR_SUCURSAL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INPUT_AGREGAR_SUCURSAL.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(INPUT_AGREGAR_SUCURSAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 230, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INGRESA UNA SUCURSAL:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 180, -1));

        AGREGAR_SUCURSAL.setBackground(new java.awt.Color(0, 51, 51));
        AGREGAR_SUCURSAL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AGREGAR_SUCURSAL.setForeground(new java.awt.Color(255, 255, 255));
        AGREGAR_SUCURSAL.setText("AGREGAR SUCURSAL");
        AGREGAR_SUCURSAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_SUCURSALActionPerformed(evt);
            }
        });
        getContentPane().add(AGREGAR_SUCURSAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        VER_COBERTURA_DFS.setBackground(new java.awt.Color(0, 51, 51));
        VER_COBERTURA_DFS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VER_COBERTURA_DFS.setForeground(new java.awt.Color(255, 255, 255));
        VER_COBERTURA_DFS.setText("VER COBERTURA DFS");
        VER_COBERTURA_DFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VER_COBERTURA_DFSActionPerformed(evt);
            }
        });
        getContentPane().add(VER_COBERTURA_DFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        VER_COBERTUTA_TOTAL.setBackground(new java.awt.Color(0, 51, 51));
        VER_COBERTUTA_TOTAL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VER_COBERTUTA_TOTAL.setForeground(new java.awt.Color(255, 255, 255));
        VER_COBERTUTA_TOTAL.setText("VER COBERTURA TOTAL");
        VER_COBERTUTA_TOTAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VER_COBERTUTA_TOTALActionPerformed(evt);
            }
        });
        getContentPane().add(VER_COBERTUTA_TOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, -1));

        INPUT_ESTACIONES_CUBIERTAS.setEditable(false);
        INPUT_ESTACIONES_CUBIERTAS.setBackground(new java.awt.Color(0, 0, 51));
        INPUT_ESTACIONES_CUBIERTAS.setColumns(20);
        INPUT_ESTACIONES_CUBIERTAS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INPUT_ESTACIONES_CUBIERTAS.setForeground(new java.awt.Color(255, 255, 255));
        INPUT_ESTACIONES_CUBIERTAS.setRows(5);
        INPUT_ESTACIONES_CUBIERTAS.setFocusable(false);
        jScrollPane2.setViewportView(INPUT_ESTACIONES_CUBIERTAS);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 180, 250));

        INPUT_ESTACIONAR_SUCURSAL.setEditable(false);
        INPUT_ESTACIONAR_SUCURSAL.setBackground(new java.awt.Color(0, 0, 51));
        INPUT_ESTACIONAR_SUCURSAL.setColumns(20);
        INPUT_ESTACIONAR_SUCURSAL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INPUT_ESTACIONAR_SUCURSAL.setForeground(new java.awt.Color(255, 255, 255));
        INPUT_ESTACIONAR_SUCURSAL.setRows(5);
        INPUT_ESTACIONAR_SUCURSAL.setFocusable(false);
        jScrollPane1.setViewportView(INPUT_ESTACIONAR_SUCURSAL);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 180, 250));

        CERRAR.setBackground(new java.awt.Color(255, 0, 0));
        CERRAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CERRAR.setForeground(new java.awt.Color(255, 255, 255));
        CERRAR.setText("X");
        CERRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CERRARActionPerformed(evt);
            }
        });
        getContentPane().add(CERRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ESTACIONES CUBIERTAS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ESTACIONES SIN CUBRIR");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 170, -1));

        ELIMINAR_SUCURSAL.setBackground(new java.awt.Color(0, 51, 51));
        ELIMINAR_SUCURSAL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ELIMINAR_SUCURSAL.setForeground(new java.awt.Color(255, 255, 255));
        ELIMINAR_SUCURSAL.setText("ELIMINAR SUCURSAL");
        ELIMINAR_SUCURSAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINAR_SUCURSALActionPerformed(evt);
            }
        });
        getContentPane().add(ELIMINAR_SUCURSAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        VER_COBERTURA_BFS.setBackground(new java.awt.Color(0, 51, 51));
        VER_COBERTURA_BFS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VER_COBERTURA_BFS.setForeground(new java.awt.Color(255, 255, 255));
        VER_COBERTURA_BFS.setText("VER COBERTURA BFS");
        VER_COBERTURA_BFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VER_COBERTURA_BFSActionPerformed(evt);
            }
        });
        getContentPane().add(VER_COBERTURA_BFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ICONO_ESTACIONES.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, -1, -1));

        REGRESAR.setBackground(new java.awt.Color(0, 51, 51));
        REGRESAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        REGRESAR.setText("REGRESAR");
        REGRESAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGRESARActionPerformed(evt);
            }
        });
        getContentPane().add(REGRESAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/FONDO_AZUL.png"))); // NOI18N
        getContentPane().add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CERRARActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CERRARActionPerformed

    private void AGREGAR_SUCURSALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_SUCURSALActionPerformed
        try{
            String nombreEstacion = INPUT_AGREGAR_SUCURSAL.getText();
            if (!nombreEstacion.isBlank()){
                INPUT_ESTACIONAR_SUCURSAL.setText("");
                INPUT_ESTACIONES_CUBIERTAS.setText("");
                Estacion estacion = new Estacion(nombreEstacion," ");
                funciones.colocarSucursal(grafo,estacion, "");
                INPUT_AGREGAR_SUCURSAL.setText("");}                            
            else {
            JOptionPane.showMessageDialog(this, "Error, debes escribir el nombre de una estación 🏪🏬");}
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");}
    }//GEN-LAST:event_AGREGAR_SUCURSALActionPerformed

    private void VER_COBERTURA_DFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VER_COBERTURA_DFSActionPerformed
        try{
            String nombreEstacion = INPUT_AGREGAR_SUCURSAL.getText();
            if (!nombreEstacion.isBlank()){
                Estacion estacion = new Estacion(nombreEstacion, " ");
                funciones.eliminarCobertura(grafo);
                String estaciones_cubiertas = funciones.busquedaDFS(estacion, grafo.getT(), grafo);
                if (!estaciones_cubiertas.isBlank()) {
                    grafo.mostrarGrafo();
                    INPUT_ESTACIONES_CUBIERTAS.setText(estaciones_cubiertas);
                    funciones.coberturaTotal(grafo.getT(), grafo);
                    String estaciones_no_cubiertas = funciones.verNoCubiertos(grafo);
                    INPUT_ESTACIONAR_SUCURSAL.setText(estaciones_no_cubiertas);}}
            else {
                JOptionPane.showMessageDialog(this, "Debe ingresar las estaciones 🚄️");}
            INPUT_AGREGAR_SUCURSAL.setText("");}
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");}
    }//GEN-LAST:event_VER_COBERTURA_DFSActionPerformed

    private void ELIMINAR_SUCURSALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELIMINAR_SUCURSALActionPerformed
        try{
            String nombreEstacion = INPUT_AGREGAR_SUCURSAL.getText();
            if (!nombreEstacion.isBlank()){
                INPUT_ESTACIONAR_SUCURSAL.setText("");
                INPUT_ESTACIONES_CUBIERTAS.setText("");
                Estacion estacion = new Estacion(nombreEstacion," ");
                funciones.eliminarSucursal(grafo, estacion);}
                else {
                JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de una estación 🚄️");}
            INPUT_AGREGAR_SUCURSAL.setText("");}
     catch(Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");}
    }//GEN-LAST:event_ELIMINAR_SUCURSALActionPerformed

    private void VER_COBERTUTA_TOTALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VER_COBERTUTA_TOTALActionPerformed
        try{
            funciones.eliminarCobertura(grafo);
            funciones.coberturaTotal(grafo.getT(), grafo);
            grafo.mostrarGrafo();
            String stringCubiertos=funciones.verCubiertos(grafo);
            String stringNoCubiertos =funciones.verNoCubiertos(grafo);
            INPUT_ESTACIONES_CUBIERTAS.setText(stringCubiertos);
            INPUT_ESTACIONAR_SUCURSAL.setText(stringNoCubiertos);}
     catch(Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");}
    }//GEN-LAST:event_VER_COBERTUTA_TOTALActionPerformed

    private void VER_COBERTURA_BFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VER_COBERTURA_BFSActionPerformed
        try{
            String nombreEstacion = INPUT_AGREGAR_SUCURSAL.getText();
            if (!nombreEstacion.isBlank()) {
                Estacion estacion = new Estacion(nombreEstacion, " ");
                funciones.eliminarCobertura(grafo);
                String estaciones_cubiertas = funciones.busquedaBFS(estacion, grafo.getT(), grafo);
                if (!estaciones_cubiertas.isBlank()) {
                    grafo.mostrarGrafo();
                    INPUT_ESTACIONES_CUBIERTAS.setText(estaciones_cubiertas);
                    funciones.coberturaTotal(grafo.getT(), grafo);
                    String estaciones_no_cubiertas = funciones.verNoCubiertos(grafo);
                    INPUT_ESTACIONAR_SUCURSAL.setText(estaciones_no_cubiertas);}}
            else {
                JOptionPane.showMessageDialog(this, "Debe ingresar las estaciones 🚄️");}
            INPUT_AGREGAR_SUCURSAL.setText("");}
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");}
    }//GEN-LAST:event_VER_COBERTURA_BFSActionPerformed

    private void REGRESARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGRESARActionPerformed
            MENU_PRINCIPAL MP = new MENU_PRINCIPAL(grafo, json);
            MP.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_REGRESARActionPerformed

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
            java.util.logging.Logger.getLogger(AGREGAR_SUCURSAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AGREGAR_SUCURSAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AGREGAR_SUCURSAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AGREGAR_SUCURSAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AGREGAR_SUCURSAL(grafo, json).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AGREGAR_SUCURSAL;
    private javax.swing.JButton CERRAR;
    private javax.swing.JButton ELIMINAR_SUCURSAL;
    private javax.swing.JLabel FONDO;
    private javax.swing.JTextField INPUT_AGREGAR_SUCURSAL;
    private javax.swing.JTextArea INPUT_ESTACIONAR_SUCURSAL;
    private javax.swing.JTextArea INPUT_ESTACIONES_CUBIERTAS;
    private javax.swing.JButton REGRESAR;
    private javax.swing.JButton VER_COBERTURA_BFS;
    private javax.swing.JButton VER_COBERTURA_DFS;
    private javax.swing.JButton VER_COBERTUTA_TOTAL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
