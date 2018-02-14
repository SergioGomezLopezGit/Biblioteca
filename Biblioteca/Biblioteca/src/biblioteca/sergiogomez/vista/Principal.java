/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.sergiogomez.vista;

import biblioteca.sergiogomez.DAO.ClaseDAO;
import biblioteca.sergiogomez.DAO.Modelo.Biblioteca;
import biblioteca.sergiogomez.DAO.Modelo.Usuario;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;

/**
 *
 * @author Sergio
 */
public class Principal extends javax.swing.JFrame implements ActionListener {
    private static JDesktopPane desktop;
    private static ClaseDAO conexion;
    private static Usuario sesion;
    private static Biblioteca biblioteca;

    public static Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public static void setBiblioteca(Biblioteca biblioteca) {
        Principal.biblioteca = biblioteca;
    }

    public static Usuario getSesion() {
        return sesion;
    }

    public static void setSesion(Usuario sesion) {
        Principal.sesion = sesion;
    }
    
    public static JDesktopPane getDesktop() {
        return desktop;
    }

    public static void setDesktop(JDesktopPane desktop) {
        Principal.desktop = desktop;
    } 

    public static ClaseDAO getConexion() {
        return conexion;
    }

    public static void setConexion(ClaseDAO conexion) {
        Principal.conexion = conexion;
    }
    
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        setConexion(new ClaseDAO());
        biblioteca=new Biblioteca();
        biblioteca.setUsuarios(conexion.cargarUsuarios());
        initComponents();
        dimensionarPantalla();
        iniciarDesktop();
        anadirListeners();
        mostrarLogin();
        menuExit.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuLogin = new javax.swing.JMenuItem();
        menuCambiarContrasena = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        adminUsuarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Inicio");

        menuLogin.setText("Login");
        menuLogin.setToolTipText("");
        jMenu1.add(menuLogin);

        menuCambiarContrasena.setText("Cambiar Contraseña");
        jMenu1.add(menuCambiarContrasena);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setText("Exit");
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Menu Administrador");

        adminUsuarios.setText("Admin Usuarios");
        jMenu2.add(adminUsuarios);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem adminUsuarios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCambiarContrasena;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuLogin;
    // End of variables declaration//GEN-END:variables

    private void iniciarDesktop() {
        desktop=new JDesktopPane();
        setContentPane(desktop);
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE); 
    }
    
    private void mostrarLogin(){
        Login frame = new Login();
        frame.setLocation((getWidth()-frame.getWidth())/2,(getHeight()-frame.getHeight())/2);
        frame.setVisible(true);
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }

    private void dimensionarPantalla() {
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        int alto=(int)dimension.getHeight()-50;
        int ancho=(int) dimension.getWidth();
        setSize(ancho, alto);
    }

    private void anadirListeners() {
        menuExit.addActionListener(this);
        menuLogin.addActionListener(this);
        menuCambiarContrasena.addActionListener(this);
        adminUsuarios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Exit":
                System.exit(0);               
                break;
            case "Login":
                mostrarLogin();
                break;
            case "Cambiar Contraseña":
                mostrarcambiarContrasena();
                break;
            case "Admin Usuarios":
                mostrarAdminUsuarios();
                break;
        }
    }

    private void mostrarcambiarContrasena() {
        CambiarContrasena frame=new CambiarContrasena();
        frame.setLocation((desktop.getWidth()-frame.getWidth())/2,(desktop.getHeight()-frame.getHeight())/2);
        frame.setVisible(true);
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }

    private void mostrarAdminUsuarios() {
        GestionUsuarios frame=new GestionUsuarios();
        frame.setLocation((desktop.getWidth()-frame.getWidth())/2,(desktop.getHeight()-frame.getHeight())/2);
        frame.setVisible(true);
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    
}