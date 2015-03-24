/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package STEMproj_TestPackage;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.Timer;

/**
 *
 * @author a-krause
 */
public class ElevatorTestFrame extends javax.swing.JFrame{

    ElevatorSystem elevatorSystem;
    
    /**
     * Creates new form ElevatorTestFrame
     */
    public ElevatorTestFrame() {
        initComponents();
        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(3);
        elevator2.closeDoor();
        elevatorSystem = new ElevatorSystem(elevator1, elevator2);
        updateDisplay();
    }
    
    public void updateDisplay()
    {
        resetAll();
        elevator1FloorLabel.setText("" + elevatorSystem.elevator1.getFloor());
        elevator2FloorLabel.setText("" + elevatorSystem.elevator2.getFloor());
        
        if(elevatorSystem.elevator1.getFloor() == 1)
            elevatorColorChange(elevatorSystem.elevator1, door3Panel, door3Label);
        else if(elevatorSystem.elevator1.getFloor() == 2)
            elevatorColorChange(elevatorSystem.elevator1, door2Panel, door2Label);
        else if(elevatorSystem.elevator1.getFloor() == 3)
            elevatorColorChange(elevatorSystem.elevator1, door1Panel, door1Label);
        
        if(elevatorSystem.elevator2.getFloor() == 1)
            elevatorColorChange(elevatorSystem.elevator2, door6Panel, door6Label);
        else if(elevatorSystem.elevator2.getFloor() == 2)
            elevatorColorChange(elevatorSystem.elevator2, door5Panel, door5Label);
        else if(elevatorSystem.elevator2.getFloor() == 3)
            elevatorColorChange(elevatorSystem.elevator2, door4Panel, door4Label);
    }
    
    private void elevatorColorChange(Elevator elevator, JPanel panel, JLabel label)
    {
        if(elevator.isDoorOpen())
        {
            panel.setBackground(Color.GREEN);
            label.setText("]    [");
        }
        else
        {
            panel.setBackground(Color.YELLOW);
            label.setText("=][=");
        }
    }
    
    private void resetAll()
    {
        reset(door1Panel, door1Label);
        reset(door2Panel, door2Label);
        reset(door3Panel, door3Label);
        reset(door4Panel, door4Label);
        reset(door5Panel, door5Label);
        reset(door6Panel, door6Label);
    }
    
    private void reset(JPanel panel, JLabel label)
    {
        panel.setBackground(Color.white);
        label.setText("=][=");
    }
    
    //@Override
    //currently a work in progress
    public void keyTyped(KeyEvent e) throws InterruptedException {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_1 :    //user released non-numpad '1' key
                System.out.println("Close door");
                Thread.sleep(2000);
                elevatorSystem.elevator1.closeDoor();
                updateDisplay();
                System.out.println("Move");
                Thread.sleep(elevatorSystem.moveElevator(1, 1));
                System.out.println("Move stop, open door");
                updateDisplay();
                Thread.sleep(2000);
                elevatorSystem.elevator1.openDoor();
                updateDisplay();
                break;
            case KeyEvent.VK_2 :    //user released non-numpad '2' key
                System.out.println("Close door");
                Thread.sleep(2000);
                elevatorSystem.elevator1.closeDoor();
                updateDisplay();
                System.out.println("Move");
                Thread.sleep(elevatorSystem.moveElevator(2, 1));
                System.out.println("Move stop, open door");
                updateDisplay();
                Thread.sleep(2000);
                elevatorSystem.elevator1.openDoor();
                updateDisplay();
                break;
            case KeyEvent.VK_3 :    //user released non-numpad '3' key
                Thread.sleep(elevatorSystem.moveElevator(3, 1));
                updateDisplay();
                break;
            case KeyEvent.VK_NUMPAD1 :  //user released numpad '1' key
                Thread.sleep(elevatorSystem.moveElevator(1, 2));
                updateDisplay();
                break;
            case KeyEvent.VK_NUMPAD2 :  //user released numpad '2' key
                Thread.sleep(elevatorSystem.moveElevator(2, 2));
                updateDisplay();
                break;
            case KeyEvent.VK_NUMPAD3 :  //user released numpad '3' key
                Thread.sleep(elevatorSystem.moveElevator(3, 2));
                updateDisplay();
                break;
            default: System.err.print("Invalid Key");
        }
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        elevator1FloorLabel = new javax.swing.JLabel();
        elevator2FloorLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        door1Panel = new javax.swing.JPanel();
        door1Label = new javax.swing.JLabel();
        door2Panel = new javax.swing.JPanel();
        door2Label = new javax.swing.JLabel();
        door3Panel = new javax.swing.JPanel();
        door3Label = new javax.swing.JLabel();
        door4Panel = new javax.swing.JPanel();
        door4Label = new javax.swing.JLabel();
        door5Panel = new javax.swing.JPanel();
        door5Label = new javax.swing.JLabel();
        door6Panel = new javax.swing.JPanel();
        door6Label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        elevator1FloorLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        elevator1FloorLabel.setText("1");

        elevator2FloorLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        elevator2FloorLabel.setText("3");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Elevators");

        door1Label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        door1Label.setText("=][=");

        javax.swing.GroupLayout door1PanelLayout = new javax.swing.GroupLayout(door1Panel);
        door1Panel.setLayout(door1PanelLayout);
        door1PanelLayout.setHorizontalGroup(
            door1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door1Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        door1PanelLayout.setVerticalGroup(
            door1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door1Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        door2Label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        door2Label.setText("=][=");

        javax.swing.GroupLayout door2PanelLayout = new javax.swing.GroupLayout(door2Panel);
        door2Panel.setLayout(door2PanelLayout);
        door2PanelLayout.setHorizontalGroup(
            door2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door2Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        door2PanelLayout.setVerticalGroup(
            door2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door2Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        door3Panel.setBackground(new java.awt.Color(102, 255, 102));

        door3Label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        door3Label.setText("]    [");

        javax.swing.GroupLayout door3PanelLayout = new javax.swing.GroupLayout(door3Panel);
        door3Panel.setLayout(door3PanelLayout);
        door3PanelLayout.setHorizontalGroup(
            door3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door3Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        door3PanelLayout.setVerticalGroup(
            door3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door3Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        door4Panel.setBackground(new java.awt.Color(255, 255, 0));

        door4Label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        door4Label.setText("=][=");

        javax.swing.GroupLayout door4PanelLayout = new javax.swing.GroupLayout(door4Panel);
        door4Panel.setLayout(door4PanelLayout);
        door4PanelLayout.setHorizontalGroup(
            door4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door4PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door4Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        door4PanelLayout.setVerticalGroup(
            door4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door4PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door4Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        door5Label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        door5Label.setText("=][=");

        javax.swing.GroupLayout door5PanelLayout = new javax.swing.GroupLayout(door5Panel);
        door5Panel.setLayout(door5PanelLayout);
        door5PanelLayout.setHorizontalGroup(
            door5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door5PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door5Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        door5PanelLayout.setVerticalGroup(
            door5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door5PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door5Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        door6Label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        door6Label.setText("=][=");

        javax.swing.GroupLayout door6PanelLayout = new javax.swing.GroupLayout(door6Panel);
        door6Panel.setLayout(door6PanelLayout);
        door6PanelLayout.setHorizontalGroup(
            door6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door6PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door6Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        door6PanelLayout.setVerticalGroup(
            door6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(door6PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(door6Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Down: W");

        jLabel2.setText("Up: A");

        jLabel4.setText("Up: Z");

        jLabel5.setText("Down: S");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(door2Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(door1Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(door3Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(door4Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(door5Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(door6Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(elevator1FloorLabel)
                        .addGap(74, 74, 74)
                        .addComponent(elevator2FloorLabel)))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elevator2FloorLabel)
                    .addComponent(elevator1FloorLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(door4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(door2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(door5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(door3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(door6Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(door1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        try {
            keyTyped(evt);
        } catch (InterruptedException ex) {
            Logger.getLogger(ElevatorTestFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(ElevatorTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElevatorTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElevatorTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElevatorTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElevatorTestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel door1Label;
    private javax.swing.JPanel door1Panel;
    private javax.swing.JLabel door2Label;
    private javax.swing.JPanel door2Panel;
    private javax.swing.JLabel door3Label;
    private javax.swing.JPanel door3Panel;
    private javax.swing.JLabel door4Label;
    private javax.swing.JPanel door4Panel;
    private javax.swing.JLabel door5Label;
    private javax.swing.JPanel door5Panel;
    private javax.swing.JLabel door6Label;
    private javax.swing.JPanel door6Panel;
    private javax.swing.JLabel elevator1FloorLabel;
    private javax.swing.JLabel elevator2FloorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
