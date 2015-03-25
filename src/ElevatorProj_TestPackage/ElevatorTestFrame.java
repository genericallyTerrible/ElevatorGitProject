/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ElevatorProj_TestPackage;

//import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors Andrew Krause, Mitchell Babej, and John Merkel
 */
public class ElevatorTestFrame extends javax.swing.JFrame{

    /* Depricated
    ElevatorSystem elevatorSystem;
    */
    private ArrayList<ElevatorLabel> shaft1;
    private ArrayList<ElevatorLabel> shaft2;
    private int[] floorTracker = {0, 0};
    private boolean[] doorTracker = {true, true};
    /**
     * Creates new form ElevatorTestFrame
     */
    public ElevatorTestFrame() {
        
        shaft1 = new ArrayList<>();
        shaft2 = new ArrayList<>();
        ElevatorLabel newElevator;
        initComponents();
        /*Depricated
        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(3);
        elevator2.closeDoor();
        elevatorSystem = new ElevatorSystem(elevator1, elevator2);
        */
        
        newElevator = new ElevatorLabel("E1F1");
        elevator1Floor1.add(newElevator);
        shaft1.add(newElevator);
        
        newElevator = new ElevatorLabel("E1F2");
        elevator1Floor2.add(newElevator);
        shaft1.add(newElevator);
        
        newElevator = new ElevatorLabel("E1F3");
        elevator1Floor3.add(newElevator);
        shaft1.add(newElevator);
        
        newElevator = new ElevatorLabel("E2F1");
        elevator2Floor1.add(newElevator);
        shaft2.add(newElevator);
        
        newElevator = new ElevatorLabel("E2F2");
        elevator2Floor2.add(newElevator);
        shaft2.add(newElevator);
        
        newElevator = new ElevatorLabel("E2F3");
        elevator2Floor3.add(newElevator);
        shaft2.add(newElevator);
        
        shaft1.get(0).setBackground(ElevatorLabel.PRIMARY);
        shaft1.get(0).setText("]  [");
        shaft2.get(0).setBackground(ElevatorLabel.PRIMARY);
        shaft2.get(0).setText("]  [");
        elevator1Tracker.setText("" + floorTracker[0]);
        elevator2Tracker.setText("" + floorTracker[0]);
    }
    
    //Checks if the passed elevator 'shaft' is valid
    //If not, prints a system error and returns null
    //If it is, it returns the Arraylist for that 'shaft'
    private ArrayList<ElevatorLabel> checkShaft(int elevatorShaft) {
        ArrayList thisShaft;
        if (elevatorShaft == 1) thisShaft = shaft1;
        else if (elevatorShaft == 2) thisShaft = shaft2;
        else {
            System.err.println(elevatorShaft + " is not a valid elevator shaft");
            return null;
        }
        return thisShaft;
    }
    
    //Opens the doors on the elevator in the desired 'shaft'
    private void openDoors(int elevatorShaft) {
        ElevatorLabel thisElevator;
        ArrayList<ElevatorLabel> thisShaft = checkShaft(elevatorShaft);
        if(thisShaft != null) {
            thisElevator = thisShaft.get(floorTracker[elevatorShaft - 1]);
            thisElevator.openDoors();
            doorTracker[elevatorShaft - 1] = true;
        }
    }
    
    //Closes the doors on the elevator in the desired 'shaft'
    private void closeDoors(int elevatorShaft) {
        ElevatorLabel thisElevator;
        ArrayList<ElevatorLabel> thisShaft = checkShaft(elevatorShaft);
        if(thisShaft != null) {
            thisElevator = thisShaft.get(floorTracker[elevatorShaft - 1]);
            thisElevator.closeDoors();
            doorTracker[elevatorShaft - 1] = false;
        }
    }
    
    //@Override
    //currently a work in progress
    public void keyTyped(KeyEvent e) throws InterruptedException {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_1 :    //user released non-numpad '1' key
                openDoors(3);
                
                break;
                
            case KeyEvent.VK_2 :    //user released non-numpad '2' key
                
                
                break;
                
            case KeyEvent.VK_3 :    //user released non-numpad '3' key
                
                
                break;
                
            case KeyEvent.VK_NUMPAD1 :  //user released numpad '1' key
                
                
                break;
                
            case KeyEvent.VK_NUMPAD2 :  //user released numpad '2' key
                
                
                break;
                
            case KeyEvent.VK_NUMPAD3 :  //user released numpad '3' key
                
                
                break;
                
            case KeyEvent.VK_W : //user released keyboard 'w' key
            
                
                break;
                
            case KeyEvent.VK_A : //user released keyboard 'a' key

                
                break;
                
            case KeyEvent.VK_S : //user released keybaord 's' key
                
                
                break;
                
            case KeyEvent.VK_Z : //user released keyboard 'z' key
                
                
                break;
                
            default: 
                System.err.println("Invalid Key Stroke");
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

        elevator1Tracker = new javax.swing.JLabel();
        elevator2Tracker = new javax.swing.JLabel();
        frameTitle = new javax.swing.JLabel();
        floor3InstructionsDown = new javax.swing.JLabel();
        floor2InstructionsUp = new javax.swing.JLabel();
        floor2InstructionsDown = new javax.swing.JLabel();
        floor1InstructionsUp = new javax.swing.JLabel();
        elevator1Floor3 = new javax.swing.JPanel();
        elevator2Floor3 = new javax.swing.JPanel();
        elevator2Floor2 = new javax.swing.JPanel();
        elevator1Floor2 = new javax.swing.JPanel();
        elevator1Floor1 = new javax.swing.JPanel();
        elevator2Floor1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        elevator1Tracker.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        elevator1Tracker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevator1Tracker.setText("#");
        elevator1Tracker.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        elevator2Tracker.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        elevator2Tracker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elevator2Tracker.setText("#");
        elevator2Tracker.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        frameTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        frameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frameTitle.setText("Elevators");
        frameTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        floor3InstructionsDown.setText("Down: W");

        floor2InstructionsUp.setText("Up: A");

        floor2InstructionsDown.setText("Down: S");

        floor1InstructionsUp.setText("Up: Z");

        elevator1Floor3.setMaximumSize(new java.awt.Dimension(91, 40));
        elevator1Floor3.setMinimumSize(new java.awt.Dimension(91, 40));
        elevator1Floor3.setPreferredSize(new java.awt.Dimension(91, 40));
        elevator1Floor3.setLayout(new java.awt.GridBagLayout());

        elevator2Floor3.setMaximumSize(new java.awt.Dimension(91, 40));
        elevator2Floor3.setMinimumSize(new java.awt.Dimension(91, 40));
        elevator2Floor3.setPreferredSize(new java.awt.Dimension(91, 40));
        elevator2Floor3.setLayout(new java.awt.GridBagLayout());

        elevator2Floor2.setMaximumSize(new java.awt.Dimension(91, 40));
        elevator2Floor2.setMinimumSize(new java.awt.Dimension(91, 40));
        elevator2Floor2.setPreferredSize(new java.awt.Dimension(91, 40));
        elevator2Floor2.setLayout(new java.awt.GridBagLayout());

        elevator1Floor2.setMaximumSize(new java.awt.Dimension(91, 40));
        elevator1Floor2.setMinimumSize(new java.awt.Dimension(91, 40));
        elevator1Floor2.setPreferredSize(new java.awt.Dimension(91, 40));
        elevator1Floor2.setLayout(new java.awt.GridBagLayout());

        elevator1Floor1.setMaximumSize(new java.awt.Dimension(91, 40));
        elevator1Floor1.setMinimumSize(new java.awt.Dimension(91, 40));
        elevator1Floor1.setPreferredSize(new java.awt.Dimension(91, 40));
        elevator1Floor1.setLayout(new java.awt.GridBagLayout());

        elevator2Floor1.setMaximumSize(new java.awt.Dimension(91, 40));
        elevator2Floor1.setMinimumSize(new java.awt.Dimension(91, 40));
        elevator2Floor1.setPreferredSize(new java.awt.Dimension(91, 40));
        elevator2Floor1.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(elevator1Tracker)
                        .addGap(90, 90, 90)
                        .addComponent(elevator2Tracker))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(floor3InstructionsDown)
                        .addGap(18, 18, 18)
                        .addComponent(elevator1Floor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(elevator2Floor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(floor2InstructionsUp)
                            .addComponent(floor2InstructionsDown))
                        .addGap(23, 23, 23)
                        .addComponent(elevator1Floor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(elevator2Floor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(floor1InstructionsUp)
                        .addGap(37, 37, 37)
                        .addComponent(elevator1Floor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(elevator2Floor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(frameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {elevator1Floor1, elevator1Floor2, elevator1Floor3, elevator2Floor1, elevator2Floor2, elevator2Floor3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(elevator1Tracker)
                    .addComponent(elevator2Tracker))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(floor3InstructionsDown))
                    .addComponent(elevator2Floor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevator1Floor3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(floor2InstructionsUp)
                        .addGap(5, 5, 5)
                        .addComponent(floor2InstructionsDown))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(elevator1Floor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elevator2Floor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(floor1InstructionsUp))
                    .addComponent(elevator1Floor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elevator2Floor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {elevator1Floor1, elevator1Floor2, elevator1Floor3, elevator2Floor1, elevator2Floor2, elevator2Floor3});

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
    private javax.swing.JPanel elevator1Floor1;
    private javax.swing.JPanel elevator1Floor2;
    private javax.swing.JPanel elevator1Floor3;
    private javax.swing.JLabel elevator1Tracker;
    private javax.swing.JPanel elevator2Floor1;
    private javax.swing.JPanel elevator2Floor2;
    private javax.swing.JPanel elevator2Floor3;
    private javax.swing.JLabel elevator2Tracker;
    private javax.swing.JLabel floor1InstructionsUp;
    private javax.swing.JLabel floor2InstructionsDown;
    private javax.swing.JLabel floor2InstructionsUp;
    private javax.swing.JLabel floor3InstructionsDown;
    private javax.swing.JLabel frameTitle;
    // End of variables declaration//GEN-END:variables
}
