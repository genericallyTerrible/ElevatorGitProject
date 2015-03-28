/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ElevatorProj_TestPackage;

//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @authors Andrew Krause, Mitchell Babej, and John Merkel
 */
public class ElevatorTestFrame extends javax.swing.JFrame{

    /* Depricated
    ElevatorSystem elevatorSystem;
    */
    
    public static final String MOVE_UP      = "up";
    public static final String MOVE_DOWN    = "down";
    public static final String NO_MOVE      = "none";
    
    public static final String NoPreference = "no preference";
    public static final String PrefersOne   = "elvator 1";
    public static final String PrefersTwo   = "elevator 2";
    
    public static final int DOOR_TIME     = 1000;
    public static final int ELEVATOR_TIME = 2000;    
    private ElevatorShaft  shaft1;
    private ElevatorShaft  shaft2;
    private Timer      checkQueue;
    private QueueClass<ElevatorCommand> commandQueue;
    private boolean executionRunning = false;
    
    /**
     * Creates new form ElevatorTestFrame
     */
    public ElevatorTestFrame() {
        
        commandQueue = new QueueClass<>();
        
        checkQueue = new Timer(25, checkAction);
        checkQueue.setRepeats(false);
        
        initComponents();

        shaft1 = new ElevatorShaft("E1");
        shaft1Panel.add(shaft1);
        shaft2 = new ElevatorShaft("E2");
        shaft2Panel.add(shaft2);
    }
    
    private void addToQueue(String elevatorPreference, int floorOfCall){
        ElevatorCommand newCommand = new ElevatorCommand(floorOfCall, NO_MOVE, elevatorPreference);
        if(!commandQueue.contains(newCommand)) {
            commandQueue.add(newCommand);
            System.out.println("Added call for " + elevatorPreference + " to floor: " + floorOfCall);
            executeCommand();
        }
    }
    
    private void addToQueue(int floorOfCall, String moveDirection) {
        ElevatorCommand newCommand = new ElevatorCommand(floorOfCall, moveDirection);
        if(!commandQueue.contains(newCommand)) {
            commandQueue.add(newCommand);
            System.out.println("Added call for nearest elvator to floor: " + floorOfCall + ", moving " + moveDirection + " after call is complete");
            executeCommand();
        }
    }
    
    private void addToQueue(int floorOfCall, String moveDirection, String elevatorPreference) {
        commandQueue.add(new ElevatorCommand(floorOfCall, moveDirection, elevatorPreference));
        executeCommand();
    }
    
    private void executeCommand() {
        if(commandQueue.size() > 0 && !executionRunning) {
            ElevatorCommand newCommand = commandQueue.peek();
            if(newCommand != null) {
                boolean commandPassed = false;
                int goalFloor = newCommand.getFloor();
                String moveDirection = newCommand.getMove();
                String elevatorPreference = newCommand.getPreference();
                //Call prefered elevator or if there is no preference, the closest
                if (elevatorPreference.equals(PrefersOne)) {
                    //If not animated, do the thing
                    if(!shaft1.isAnimated()) {
                        shaft1.moveElevatorTo(goalFloor, moveDirection);
                        commandQueue.remove();
                        executionRunning = false;
                    } else {
                        //if animated, see if the other shaft can do the next action, etc.
                        executeNextCommand(1, 1);
                    }
                } else if (elevatorPreference.equals(PrefersTwo)) {
                    //If not animated, do the thing
                    if(!shaft2.isAnimated()) {
                        shaft2.moveElevatorTo(goalFloor, moveDirection);
                        commandQueue.remove();
                        executionRunning = false;
                    } else {
                        //if animated, see if the other shaft can do the next action, etc.
                        executeNextCommand(1, 2);
                    }
                } else {
                    //Call nearest elevator
                    ElevatorShaft closestShaft;
                    ElevatorShaft otherShaft;
                    if((Math.abs(shaft1.getCurrentFloor() - goalFloor)) <= (Math.abs(shaft2.getCurrentFloor() - goalFloor))) {
                        closestShaft = shaft1;
                        otherShaft   = shaft2;
                    } else {
                        closestShaft = shaft2;
                        otherShaft   = shaft1;
                    }

                    if(!closestShaft.isAnimated()) {
                        closestShaft.moveElevatorTo(goalFloor, moveDirection);
                        commandQueue.remove();
                        executionRunning = false;
                    }
                    else if (!otherShaft.isAnimated()) {
                        otherShaft.moveElevatorTo(goalFloor, moveDirection);
                        commandQueue.remove();
                        executionRunning = false;
                    }
                } 
            }
            checkQueue.start();
        }
    }
    
    private void executeNextCommand(int nextCommand, int previousShaft){
        if(commandQueue.size() >= nextCommand) {
            ElevatorCommand newCommand = commandQueue.peekAhead(nextCommand);
            if(newCommand != null) {
                int goalFloor = newCommand.getFloor();
                String moveDirection = newCommand.getMove();
                String elevatorPreference = newCommand.getPreference();
                //Call prefered elevator
                if (elevatorPreference.equals(PrefersOne)) {
                    if(!shaft1.isAnimated() && previousShaft != 1) {
                        shaft1.moveElevatorTo(goalFloor, moveDirection);
                        commandQueue.remove(nextCommand);
                    } else {
                        executeNextCommand(nextCommand + 1, 1);
                        return;
                    }
                } else if(elevatorPreference.equals(PrefersTwo)) {
                    if(!shaft2.isAnimated() && previousShaft != 2) {
                        shaft2.moveElevatorTo(goalFloor, moveDirection);
                        commandQueue.remove(nextCommand);
                    } else {
                        executeNextCommand(nextCommand + 1, 2);
                        return;
                    }
                } else {
                    //Call other elevator
                    if(previousShaft == 1 && !shaft2.isAnimated()){
                        shaft2.moveElevatorTo(goalFloor, moveDirection);
                        commandQueue.remove(nextCommand);
                    } else if(previousShaft == 2 && !shaft1.isAnimated()){
                        shaft1.moveElevatorTo(goalFloor, moveDirection);
                        commandQueue.remove(nextCommand);
                    }
                    executeNextCommand(nextCommand + 1, 2);
                    return;
                } 
            }
        }
        executionRunning = false;
        checkQueue.start();
    }
    
    
    /*
    * * * DEPRICATED * * *
    private void callNearestElevator(int floorOfCall, String moveDirection) {
        //Local variables
        ElevatorShaft closestShaft;
        ElevatorShaft   otherShaft;
        boolean wasQueued = false;
        boolean commandPassed = false;

        ElevatorCommand firstCommand = commandQueue.peek();
        if (firstCommand != null && firstCommand.getFloor() == floorOfCall && (firstCommand.getMove() == null ? moveDirection == null : firstCommand.getMove().equals(moveDirection))){
            wasQueued = true;
        }

        //Determine if any elevators already on this floor
        if(shaft1.getCurrentFloor() == floorOfCall && !shaft1.isAnimated()) {
            shaft1.moveElevatorTo(floorOfCall, moveDirection);
        } else if(shaft2.getCurrentFloor() == floorOfCall && !shaft2.isAnimated()) {
            shaft2.moveElevatorTo(floorOfCall, moveDirection);
        } else {
            if((Math.abs(shaft1.getCurrentFloor() - floorOfCall)) <= (Math.abs(shaft2.getCurrentFloor() - floorOfCall))) {
                closestShaft = shaft1;
                otherShaft   = shaft2;
            } else {
                closestShaft = shaft2;
                otherShaft   = shaft1;
        }

        if(!closestShaft.isAnimated()) {
            closestShaft.moveElevatorTo(floorOfCall, moveDirection);
            commandPassed = true;
        } else if(!otherShaft.isAnimated()) {
            otherShaft.moveElevatorTo(floorOfCall, moveDirection);
            commandPassed = true;
        } else {
            if(!wasQueued) {
                ElevatorCommand newCommand = new ElevatorCommand(floorOfCall, moveDirection);
                commandQueue.add(newCommand);
                System.out.println("Added call to floor: " + floorOfCall + ", with a final move of: " + moveDirection);
            }
            checkQueue.start();
            return;
            }
        }
        if (wasQueued && commandPassed) {
            System.out.println("Removed " + commandQueue.remove().toString());
            System.out.println("Commands left to exicute: " + commandQueue.size());
        }
        if(commandQueue.size() > 0)
        checkQueue.start();
    }
    */
    
    ActionListener checkAction = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            executeCommand();
        }};
    
    //@Override
    //currently a work in progress
    public void keyReleased(KeyEvent e) throws InterruptedException {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_1 : //user released non-numpad '1' key
                addToQueue(PrefersOne, 0);
                break;

            case KeyEvent.VK_2 : //user released non-numpad '2' key
                addToQueue(PrefersOne, 1);
                break;

            case KeyEvent.VK_3 : //user released non-numpad '3' key
                addToQueue(PrefersOne, 2);
                break;

            case KeyEvent.VK_NUMPAD1 : //user released numpad '1' key
                addToQueue(PrefersTwo, 0);
                break;

            case KeyEvent.VK_NUMPAD2 : //user released numpad '2' key
                addToQueue(PrefersTwo, 1);
                break;

            case KeyEvent.VK_NUMPAD3 : //user released numpad '3' key
                addToQueue(PrefersTwo, 2);
                break;

            case KeyEvent.VK_W : //user released keyboard 'w' key
                addToQueue(2, MOVE_DOWN);
                break;

            case KeyEvent.VK_A : //user released keyboard 'a' key
                addToQueue(1, MOVE_UP);
                break;

            case KeyEvent.VK_S : //user released keybaord 's' key
                addToQueue(1, MOVE_DOWN);
                break;

            case KeyEvent.VK_Z : //user released keyboard 'z' key
                addToQueue(0, MOVE_UP);
                break;


            default:
                System.err.println(e.getExtendedKeyCode() + " is an invalid Key Stroke");
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

        frameTitle = new javax.swing.JLabel();
        floor3InstructionsDown = new javax.swing.JLabel();
        floor2InstructionsUp = new javax.swing.JLabel();
        floor2InstructionsDown = new javax.swing.JLabel();
        floor1InstructionsUp = new javax.swing.JLabel();
        shaft1Panel = new javax.swing.JPanel();
        shaft2Panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        frameTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        frameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frameTitle.setText("Elevators");
        frameTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        floor3InstructionsDown.setText("Down: W");

        floor2InstructionsUp.setText("Up: A");

        floor2InstructionsDown.setText("Down: S");

        floor1InstructionsUp.setText("Up: Z");

        shaft1Panel.setMaximumSize(new java.awt.Dimension(103, 239));
        shaft1Panel.setMinimumSize(new java.awt.Dimension(103, 239));
        shaft1Panel.setPreferredSize(new java.awt.Dimension(103, 239));
        shaft1Panel.setLayout(new java.awt.GridBagLayout());

        shaft2Panel.setMaximumSize(new java.awt.Dimension(103, 239));
        shaft2Panel.setMinimumSize(new java.awt.Dimension(103, 239));
        shaft2Panel.setPreferredSize(new java.awt.Dimension(103, 239));
        shaft2Panel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(floor3InstructionsDown))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(floor2InstructionsUp)
                                .addComponent(floor2InstructionsDown)
                                .addComponent(floor1InstructionsUp)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(shaft1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shaft2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(frameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(floor3InstructionsDown)
                        .addGap(41, 41, 41)
                        .addComponent(floor2InstructionsUp)
                        .addGap(5, 5, 5)
                        .addComponent(floor2InstructionsDown)
                        .addGap(35, 35, 35)
                        .addComponent(floor1InstructionsUp))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shaft2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shaft1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        try {
            keyReleased(evt);
        } catch (InterruptedException ex) {
            Logger.getLogger(ElevatorTestFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formKeyReleased

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
    private javax.swing.JLabel floor1InstructionsUp;
    private javax.swing.JLabel floor2InstructionsDown;
    private javax.swing.JLabel floor2InstructionsUp;
    private javax.swing.JLabel floor3InstructionsDown;
    private javax.swing.JLabel frameTitle;
    private javax.swing.JPanel shaft1Panel;
    private javax.swing.JPanel shaft2Panel;
    // End of variables declaration//GEN-END:variables
}
