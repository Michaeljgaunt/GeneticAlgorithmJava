 
package Views;

import Controllers.Driver;
import javax.swing.ImageIcon;

public class MainMenu extends javax.swing.JFrame {
    
    //Constructor method. Initialises the interface and sets the program icon.
    public MainMenu() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Resources/dna_helix.png")).getImage());  
    }

    //Method to build the interface.
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SelectValType = new javax.swing.JPanel();
        valueMenu = new javax.swing.JComboBox();
        okBut = new javax.swing.JButton();
        valueTypeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Genetic Algorithm");

        valueMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Discrete Types", "Real-Valued Types" }));

        okBut.setText("OK");
        okBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButActionPerformed(evt);
            }
        });

        valueTypeLabel.setText("Select Value Types:");

        javax.swing.GroupLayout SelectValTypeLayout = new javax.swing.GroupLayout(SelectValType);
        SelectValType.setLayout(SelectValTypeLayout);
        SelectValTypeLayout.setHorizontalGroup(
            SelectValTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectValTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valueTypeLabel)
                .addGap(10, 10, 10)
                .addComponent(valueMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(okBut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SelectValTypeLayout.setVerticalGroup(
            SelectValTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectValTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SelectValTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueTypeLabel)
                    .addComponent(valueMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okBut))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SelectValType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SelectValType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Method to get the state of the menu.
    public int getMenuState() {
        return valueMenu.getSelectedIndex();
    }
    
    //Method that is called when the OK button is pressed.
    private void okButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButActionPerformed
        Driver.getMenuChoice();
    }//GEN-LAST:event_okButActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SelectValType;
    private javax.swing.JButton okBut;
    private static javax.swing.JComboBox valueMenu;
    private javax.swing.JLabel valueTypeLabel;
    // End of variables declaration//GEN-END:variables
}
