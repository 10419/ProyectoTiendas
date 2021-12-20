/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IGU;

import implementacion.ImplPersona;
import javax.swing.JOptionPane;
import valores.Persona;

/**
 *
 * @author INTEL
 */
public class LoginJFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginJFrame
     */
    public LoginJFrame() {
        initComponents();
        setLocationRelativeTo(null);
 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxf_usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jpsf_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        Jbt_Login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Usuario:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Ventas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 30, 299, 41));
        jPanel1.add(jtxf_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 82, 170, 35));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 131, -1, -1));

        jpsf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpsf_passwordActionPerformed(evt);
            }
        });
        jPanel1.add(jpsf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 128, 170, 34));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setText("Usuario:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        Jbt_Login.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        Jbt_Login.setForeground(new java.awt.Color(0, 51, 204));
        Jbt_Login.setText("Login");
        Jbt_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbt_LoginvalidacionLogueo(evt);
            }
        });
        jPanel1.add(Jbt_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 104, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Jbt_LoginvalidacionLogueo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbt_LoginvalidacionLogueo

        ImplPersona ip= new ImplPersona();
        Persona p= new Persona();

        //System.out.println("estoy ´probandoooo"+jtxf_usuario.getText()+"-"+jpsf_password.getText());

        p=ip.LoginReportePersonaUnico(jtxf_usuario.getText(), jpsf_password.getText());

        System.out.println("estoy ´probandoooo: "+p.getUsuario()+"-"+p.getPassword());

        if(p.isAcceso()){

            System.out.println("ingreso al sistema");

            MenuFrame cmf = new MenuFrame();
            cmf.show();

            LoginJFrame lf= new LoginJFrame();
            lf.show(false);
            dispose();
        }
        else{
           JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorecta");
        }
    }//GEN-LAST:event_Jbt_LoginvalidacionLogueo

    private void jpsf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpsf_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpsf_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbt_Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jpsf_password;
    private javax.swing.JTextField jtxf_usuario;
    // End of variables declaration//GEN-END:variables
}
