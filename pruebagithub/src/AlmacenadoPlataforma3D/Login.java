package AlmacenadoPlataforma3D;

import AlmacenadoPlataforma3D.ConeccionBD.ConectarUser;
import javax.swing.JOptionPane;
import AlmacenadoPlataforma3D.ConeccionBD.validarRut;

public class Login extends javax.swing.JFrame {
 validarRut val_rut = new validarRut();
  int continval=0;
  int cont_rut_incr=0;
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnok = new javax.swing.JButton();
        btntxt = new javax.swing.JTextField();
        btnpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Rut");

        jLabel2.setText("Password");

        btnok.setText("Ingresar");
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });
        btnok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnokKeyPressed(evt);
            }
        });

        btntxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntxtActionPerformed(evt);
            }
        });

        btnpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpassActionPerformed(evt);
            }
        });

        jLabel3.setText("Bienbenido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnpass, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btntxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnok)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btntxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btntxt.getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed


        
        
boolean validacion = false; 
validacion=val_rut.valr(btntxt.getText());  
ConectarUser ca = new ConectarUser();
        if(validacion==true){
                ca.acceso(btntxt.getText(), btnpass.getText());
                btnpass.setText(ca.respuestapass);
                cont_rut_incr=cont_rut_incr+ca.cntreñncr;
                if(cont_rut_incr==2){
                    JOptionPane.showMessageDialog(null,"ha ingresado la contraseña erronea 2 veces,tiene una oportunidad antes de un bloqueo");                  
                }
                if(cont_rut_incr==3){
                    JOptionPane.showMessageDialog(null,"ha ingresado la contraseña erronea 3 veces,contactese con el administrador");                  
                    btnpass.setEditable(false);
                }
                
            } else if (validacion!=true){
                JOptionPane.showMessageDialog(rootPane, "Rut Invalido");
            btnpass.setText("");
            btntxt.setText(ca.respuestapass);
               continval=continval+1;
               if(continval==2){
                    JOptionPane.showMessageDialog(null,"ha ingresado el rut erroneo 2 veces, tiene una ultima oportunidad antes de un bloqueo");                  
                }  
               if(3==continval){
                        JOptionPane.showMessageDialog(null,"ha ingresado el rut erroneo 3 veces, Contactese con el administrdor");
                     System.exit(0);
                        }
            } 
    }//GEN-LAST:event_btnokActionPerformed
public void limpiar_texto(){

    btnpass.setText(" ");
} 

    private void btntxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btntxtActionPerformed

    private void btnpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpassActionPerformed

    private void btnokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnokKeyPressed
        // TODO add your handling code here:
        //.showMessageDialog(this,"letra:"+evt.getKeyCode());
        if(evt.getKeyCode()==13 || evt.getKeyCode()==9 || evt.getKeyCode()==10){
            btnok.doClick();
        }
    }//GEN-LAST:event_btnokKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnok;
    private javax.swing.JPasswordField btnpass;
    private javax.swing.JTextField btntxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
