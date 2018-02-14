/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.sergiogomez.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class CambiarContrasena extends javax.swing.JInternalFrame implements ActionListener {

    /**
     * Creates new form CambiarContrasena
     */
    public CambiarContrasena() {
        initComponents();
        iniciarListener();
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
        jLabel3 = new javax.swing.JLabel();
        contrasena = new javax.swing.JPasswordField();
        nuevaContrasena = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        aviso = new javax.swing.JLabel();

        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/sergiogomez/imagenes/login.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña: ");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nueva contraseña");
        jLabel3.setFocusTraversalPolicyProvider(true);

        jButton1.setText("Cambiar");

        aviso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        aviso.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(contrasena)
                                .addComponent(nuevaContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addComponent(aviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nuevaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aviso;
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField nuevaContrasena;
    // End of variables declaration//GEN-END:variables

    private void comprobarUsuarioContrasena(){
        if(contrasena.getText().isEmpty() || nuevaContrasena.getText().isEmpty()){
            aviso.setText("Rellena todos los campos.");
        }else{
            if(Principal.getConexion().comprobarUsuario(Principal.getSesion().getNombre(), contrasena.getText())){
                cambiarContraseña();
            }else{
                aviso.setText("Contraseña incorrecta.");
            }
        }
    }
    
    private void cambiarContraseña(){
        if(Principal.getConexion().cambiarContrasena(Principal.getSesion(), nuevaContrasena.getText().trim())){
            dispose();
            JOptionPane.showMessageDialog(null,"Contraseña cambiada","Sesion", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"No se pudo cambiar la contraseña","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        comprobarUsuarioContrasena();
    }

    private void iniciarListener() {
        jButton1.addActionListener(this);
    }
}
