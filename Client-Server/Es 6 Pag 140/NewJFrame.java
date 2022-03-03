
package javaapplication4;

import java.awt.Color;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewJFrame extends javax.swing.JFrame {

    void Turnon()
    {
        if(jButton1.getText().equals(""))
        {
            jButton1.setEnabled(true);
        }
          if(jButton2.getText().equals(""))
        {
            jButton2.setEnabled(true);
        }
            if(jButton3.getText().equals(""))
        {
            jButton3.setEnabled(true);
        }
              if(jButton4.getText().equals(""))
        {
            jButton4.setEnabled(true);
        }
                if(jButton5.getText().equals(""))
        {
            jButton5.setEnabled(true);
        }
                  if(jButton6.getText().equals(""))
        {
            jButton6.setEnabled(true);
        }
                    if(jButton7.getText().equals(""))
        {
            jButton7.setEnabled(true);
        }
                      if(jButton8.getText().equals(""))
        {
            jButton8.setEnabled(true);
        }
                        if(jButton9.getText().equals(""))
        {
            jButton9.setEnabled(true);
        }
    }
    void Turnoff(){
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);  
}
    Client connection;
    public NewJFrame() {
        initComponents();
        try{
           connection=new Client("localhost",6789,0);
           jLabel1.setText("Connected");
           jLabel1.setForeground(Color.green);
           Waiting();
        }
        catch(IOException ex)
         {
             System.out.println("Errore");  
         }
    }
      void Waiting()
    {
        try{
        String where;
        where=connection.Listen();
        switch(where)
        {
            case"1-1":
                jButton1.setText("O");
                break;
              case"1-2":
                jButton2.setText("O");
                break;    
              case"1-3":
                jButton3.setText("O");
                break;
              case"2-1":
                jButton4.setText("O");
                break;    
              case"2-2":
                jButton5.setText("O");
                break;
              case"2-3":
                jButton6.setText("O");
                break;
              case"3-1":
                jButton7.setText("O");
                break;
              case"3-2":
                jButton8.setText("O");
                break;        
              case"3-3":
                jButton9.setText("O");
                break;        
        }
        if(CheckO())
        {
                    Turnon();
        }
        }
         catch(IOException ex)
         {
             System.out.println("Errore");  
         }
    }
      boolean CheckX() throws IOException
      {
          if(jButton1.getText().equals("X") && jButton2.getText().equals("X") && jButton3.getText().equals("X"))
          {            
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai vinto");
               return false;
          }
           if(jButton1.getText().equals("X") && jButton4.getText().equals("X") && jButton7.getText().equals("X"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai vinto");
               return false;
          }
          if(jButton1.getText().equals("X") && jButton5.getText().equals("X") && jButton9.getText().equals("X"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai vinto");
               return false;
          }
          if(jButton2.getText().equals("X") && jButton5.getText().equals("X") && jButton8.getText().equals("X"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai vinto");
               return false;
          }
          if(jButton3.getText().equals("X") && jButton6.getText().equals("X") && jButton9.getText().equals("X"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai vinto");
               return false;
          }
           if(jButton3.getText().equals("X") && jButton5.getText().equals("X") && jButton7.getText().equals("X"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai vinto");
               return false;
          }
            if(jButton4.getText().equals("X") && jButton5.getText().equals("X") && jButton6.getText().equals("X"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai vinto");
               return false;
          }
             if(jButton7.getText().equals("X") && jButton8.getText().equals("X") && jButton9.getText().equals("X"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai vinto");
               return false;
          }
             if(!jButton1.getText().equals("") && !jButton2.getText().equals("") && !jButton3.getText().equals("") && !jButton4.getText().equals("") && !jButton5.getText().equals("") && !jButton6.getText().equals("") && !jButton7.getText().equals("") && !jButton8.getText().equals("") && !jButton9.getText().equals("")){
                 connection.Adios();
                 Turnoff();
                 jLabel1.setText("pareggio");
                 jLabel1.setForeground(Color.yellow);
            }
             return true;
      }
      boolean CheckO() throws IOException
      {
          if(jButton1.getText().equals("O") && jButton2.getText().equals("O") && jButton3.getText().equals("O"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai perso");
               return false;
          }
           if(jButton1.getText().equals("O") && jButton4.getText().equals("O") && jButton7.getText().equals("O"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai perso");
               return false;
          }
          if(jButton1.getText().equals("O") && jButton5.getText().equals("O") && jButton9.getText().equals("O"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai perso");
          }
          if(jButton2.getText().equals("O") && jButton5.getText().equals("O") && jButton8.getText().equals("O"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai perso");
               return false;
          }
          if(jButton3.getText().equals("O") && jButton6.getText().equals("O") && jButton9.getText().equals("O"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai perso");
               return false;
          }
           if(jButton3.getText().equals("O") && jButton5.getText().equals("O") && jButton7.getText().equals("O"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai perso");
               return false;
          }
            if(jButton4.getText().equals("O") && jButton5.getText().equals("O") && jButton6.getText().equals("O"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai perso");
               return false;
          }
             if(jButton7.getText().equals("O") && jButton8.getText().equals("O") && jButton9.getText().equals("O"))
          {
              connection.Adios();
              Turnoff();
              jLabel1.setText("Hai perso");
               return false;
          }
              if(!jButton1.getText().equals("") && !jButton2.getText().equals("") && !jButton3.getText().equals("") && !jButton4.getText().equals("") && !jButton5.getText().equals("") && !jButton6.getText().equals("") && !jButton7.getText().equals("") && !jButton8.getText().equals("") && !jButton9.getText().equals("")){
                 connection.Adios();
                 Turnoff();
                 jLabel1.setText("pareggio");
                 jLabel1.setForeground(Color.yellow);
            }
             return true;
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Not connected");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            connection.Send("1-1");
            Turnoff();
            jButton1.setText("X");
            if(CheckX())
            {
                Waiting();
            }
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            connection.Send("1-2");
            Turnoff();
            jButton2.setText("X");
            if(CheckX())
            {
                Waiting();
            }
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            connection.Send("1-3");
            Turnoff();
            jButton3.setText("X");
            if(CheckX())
            {
                Waiting();
            }
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       try {
            connection.Send("2-1");
            Turnoff();
            jButton4.setText("X");
            if(CheckX())
            {
                Waiting();
            }
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            connection.Send("2-2");
            Turnoff();
            jButton5.setText("X");
            if(CheckX())
            {
                Waiting();
            }
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            connection.Send("2-3");
            Turnoff();
            jButton6.setText("X");
            if(CheckX())
            {
                Waiting();
            }
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            connection.Send("3-1");
            Turnoff();
            jButton7.setText("X");
            if(CheckX())
            {
                Waiting();
            }
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       try {
            connection.Send("3-2");
            Turnoff();
            jButton8.setText("X");
            if(CheckX())
            {
                Waiting();
            }
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            connection.Send("3-3");
            Turnoff();
            jButton9.setText("X");
            if(CheckX())
            {
                Waiting();
            }
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
