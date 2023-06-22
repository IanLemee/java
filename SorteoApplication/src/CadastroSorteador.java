import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CadastroSorteador extends javax.swing.JFrame {

    private GerenciadorSorteios gerenciadorSorteios;
    private Set<Integer> numerosSorteados;
    private int proximoId;

    public CadastroSorteador(GerenciadorSorteios gerenciadorSorteios) {
        initComponents();
        this.gerenciadorSorteios = gerenciadorSorteios;
        numerosSorteados = new HashSet<>();
        proximoId = 1;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InserirNome = new javax.swing.JTextField();
        GerarNumero = new javax.swing.JButton();
        Remover = new javax.swing.JButton();
        ShowNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InserirNome.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        InserirNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirNomeActionPerformed(evt);
            }
        });

        GerarNumero.setBackground(new java.awt.Color(51, 102, 255));
        GerarNumero.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        GerarNumero.setForeground(new java.awt.Color(255, 255, 255));
        GerarNumero.setText("Gerar Numero");
        GerarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarNumeroActionPerformed(evt);
            }
        });

        Remover.setText("Usuarios");
        Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverActionPerformed(evt);
            }
        });

        ShowNumber.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        ShowNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(InserirNome, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GerarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(Remover)))))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ShowNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(InserirNome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GerarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ShowNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Remover)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GerarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarNumeroActionPerformed
    String nome = InserirNome.getText();

        Random random = new Random();
        int numeroSorteado = gerarNumeroSorteado();

        SorteioIndividual sorteio = new SorteioIndividual(proximoId, nome, numeroSorteado);
        gerenciadorSorteios.registrarSorteio(sorteio);
        proximoId++;

        ShowNumber.setText(nome + " " + numeroSorteado);
    }//GEN-LAST:event_GerarNumeroActionPerformed

    private void InserirNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirNomeActionPerformed
    }//GEN-LAST:event_InserirNomeActionPerformed

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed
        RemoverUsuarioInterface removerUsuarioInterface = new RemoverUsuarioInterface();
        removerUsuarioInterface.setVisible(true);
    }//GEN-LAST:event_RemoverActionPerformed

       private int gerarNumeroSorteado() {
         Random random = new Random();
        int numeroSorteado = random.nextInt(6); // Gera um número aleatório entre 0 e 5

        while (numerosSorteados.contains(numeroSorteado)) {
            numeroSorteado = random.nextInt(6);
        }

        numerosSorteados.add(numeroSorteado);
        return numeroSorteado;
    }
     
    
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
            java.util.logging.Logger.getLogger(CadastroSorteador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroSorteador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroSorteador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroSorteador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        GerenciadorSorteios gerenciadorSorteios = new GerenciadorSorteios();
        CadastroSorteador cadastroSorteador = new CadastroSorteador(gerenciadorSorteios);
        cadastroSorteador.setVisible(true);

        SorteadorInterface sorteadorInterface = new SorteadorInterface(gerenciadorSorteios);
        sorteadorInterface.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GerarNumero;
    private javax.swing.JTextField InserirNome;
    private javax.swing.JButton Remover;
    private javax.swing.JLabel ShowNumber;
    // End of variables declaration//GEN-END:variables

    
}
