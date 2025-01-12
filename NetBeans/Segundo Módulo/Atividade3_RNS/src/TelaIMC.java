
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author RaquelNunes
 */
public class TelaIMC extends javax.swing.JFrame {

    /**
     * Creates new form TelaIMC
     */
    public TelaIMC() {
        initComponents();

            txtResultado.setText("");
            txtInterpretacao.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelcalculoimc = new javax.swing.JLabel();
        jLabelaltura = new javax.swing.JLabel();
        jLabelpeso = new javax.swing.JLabel();
        jLabelresultado = new javax.swing.JLabel();
        jLabelinterpretacao = new javax.swing.JLabel();
        jButtoncalcularimc = new javax.swing.JButton();
        txtResultado = new javax.swing.JLabel();
        txtInterpretacao = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("IMC");

        jLabelcalculoimc.setFont(new java.awt.Font("Dialog", 0, 25)); // NOI18N
        jLabelcalculoimc.setText("Cálculo de IMC");

        jLabelaltura.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabelaltura.setText("Altura (m):");

        jLabelpeso.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabelpeso.setText("Peso (Kg):");

        jLabelresultado.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabelresultado.setText("Resultado:");

        jLabelinterpretacao.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabelinterpretacao.setText("Interpretação:");

        jButtoncalcularimc.setFont(new java.awt.Font("Dialog", 0, 25)); // NOI18N
        jButtoncalcularimc.setText("Calcular");
        jButtoncalcularimc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncalcularimcActionPerformed(evt);
            }
        });

        txtResultado.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtResultado.setText("jLabel1");

        txtInterpretacao.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtInterpretacao.setText("jLabel2");

        txtAltura.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N

        txtPeso.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabelcalculoimc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelinterpretacao)
                                .addGap(18, 18, 18)
                                .addComponent(txtInterpretacao))
                            .addComponent(jButtoncalcularimc)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelaltura)
                                    .addComponent(jLabelpeso)
                                    .addComponent(jLabelresultado))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(txtResultado))
                                    .addComponent(txtAltura, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addComponent(txtPeso))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelcalculoimc)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelaltura)
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpeso)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButtoncalcularimc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelresultado)
                    .addComponent(txtResultado))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelinterpretacao)
                    .addComponent(txtInterpretacao))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtoncalcularimcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncalcularimcActionPerformed
        // TODO add your handling code here:

        // ENTRADAS NA TELA DE IMC
        String altimc = txtAltura.getText() .replace(",", ".");
        String pesoimc = txtPeso.getText() .replace(",", ".");

         Double imc = 0.00; 
         String interpretacao = "";

        try {

            boolean validaAltura = altimc.matches("[0-9]{1}[.][0-9]{2}");
            boolean validaPeso = pesoimc.matches("[0-9]{2,3}[.][0-9]{2}");
            
            if (validaPeso == false && validaAltura == false) {
            JOptionPane.showMessageDialog(null, "Dados Inválidos");
            } else if (validaPeso == false) {
            JOptionPane.showMessageDialog(null, "Peso no Formato Inválido");
            } else if (validaAltura == false) {
            JOptionPane.showMessageDialog(null, "Altura no Formato Inválido");
            } else {
            } 
            
            // CONVERSAO PARA DOUBLE
            Double altura = Double.parseDouble(altimc);
            Double peso = Double.parseDouble(pesoimc);

            // PROCESSAMENTO
            imc = peso / (altura * altura);
            
            if (imc<18.5) {
                interpretacao = "Magreza";
            } else if (imc>18.5 && imc<=24.9) {
                interpretacao = "Normal";
            } else if (imc>=25 && imc<=29.9 ) {
                interpretacao = "Sobrepeso";
            } else if (imc>=30 && imc<=39.9) {
                interpretacao = "Obesidade";
            } else if (imc>=40) {
                interpretacao = "Obesidade Grave";
            }
                
            } catch (NumberFormatException ex) {
                System.out.print("Exception gerada" + ex.getMessage());
            }

            // SAIDA

            DecimalFormat valor = new DecimalFormat ("#.00");

            txtResultado.setText(valor.format(imc));
            txtInterpretacao.setText(interpretacao);

    }//GEN-LAST:event_jButtoncalcularimcActionPerformed

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
            java.util.logging.Logger.getLogger(TelaIMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaIMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaIMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaIMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaIMC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtoncalcularimc;
    private javax.swing.JLabel jLabelaltura;
    private javax.swing.JLabel jLabelcalculoimc;
    private javax.swing.JLabel jLabelinterpretacao;
    private javax.swing.JLabel jLabelpeso;
    private javax.swing.JLabel jLabelresultado;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JLabel txtInterpretacao;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JLabel txtResultado;
    // End of variables declaration//GEN-END:variables
}
