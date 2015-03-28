/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorProj_TestPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @authors Andrew Krause, Mitchell Babej, and John Merkels
 */
public class ElevatorShaft extends JPanel {
    
    
    private static final String MOVE_UP    = ElevatorTestFrame.MOVE_UP;
    private static final String MOVE_DOWN  = ElevatorTestFrame.MOVE_DOWN;
    private static final String NO_MOVE    = ElevatorTestFrame.NO_MOVE;
    private static final int DOOR_TIME     = ElevatorTestFrame.DOOR_TIME;
    private static final int ELEVATOR_TIME = ElevatorTestFrame.ELEVATOR_TIME;
    private static final int TOP_FLOOR    = 2;
    private static final int BOTTOM_FLOOR = 0;
    
    private String name = "";
    
    private ArrayList<DoorLabel> shaft;
    private int currentFloor = 0;
    private int goalFloor;
    private boolean isAnimated     = false;
    private boolean moveAfterClose = false;
    private String   moveAfterDone = NO_MOVE;
    private Timer openDoorsTimer;
    private Timer closeDoorsTimer;
    private Timer moveElevatorTimer;
    private String moveDirection;
    
    /**
     * Creates new form ElevatorShaft
     * @param InitialName Name for the particular instance of ElevatorShaft
     */
    public ElevatorShaft(String InitialName) {
        name = InitialName;
        
        shaft = new ArrayList<>();
        
        openDoorsTimer    = new Timer(DOOR_TIME, openDoors);
        closeDoorsTimer   = new Timer(DOOR_TIME, closeDoors);
        moveElevatorTimer = new Timer(ELEVATOR_TIME, moveElevator);
        openDoorsTimer   .setRepeats(false);
        closeDoorsTimer  .setRepeats(false);
        moveElevatorTimer.setRepeats(false);
        
        initComponents();
        
        DoorLabel newDoor;
        
        newDoor = new DoorLabel(name + "_F1");
        newDoor.openDoors();
        floor1.add(newDoor);
        shaft.add(newDoor);
        
        newDoor = new DoorLabel(name + "_F2");
        floor2.add(newDoor);
        shaft.add(newDoor);
        
        newDoor = new DoorLabel(name + "_F3");
        floor3.add(newDoor);
        shaft.add(newDoor);
        
        shaft.get(0).setBackground(DoorLabel.SECONDARY);
        shaft.get(0).setText("=][=");
        floorTracker.setText("" + (currentFloor + 1));
    }
    
    public String getShaftName() {
        return name;
    }
    
    public boolean isAnimated() {
        return isAnimated;
    }
    
    public int getCurrentFloor() {
        return currentFloor;
    }
    
    //Opens the doors on the elevator in the desired 'shaft'
    public void openDoors() {
        if(!isAnimated)
            isAnimated = true;
        openDoorsTimer.start();
    }
    
    ActionListener openDoors = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            shaft.get(currentFloor).openDoors();
            closeDoorsTimer.start();
        }};
    
    //Closes the doors on the elevator in the desired 'shaft'
    public void closeDoors() {
        if(!isAnimated)
           isAnimated = true;
        closeDoorsTimer.start();
    }
    
    ActionListener closeDoors = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            shaft.get(currentFloor).closeDoors();
            if(moveAfterClose){
                moveElevatorTimer.start();
            } else if(moveAfterDone.equals(MOVE_UP)) {
                moveElevatorTo(++goalFloor);
                moveAfterDone = NO_MOVE;
            } else if(moveAfterDone.equals(MOVE_DOWN)) {
                moveElevatorTo(--goalFloor);
                moveAfterDone = NO_MOVE;
            } else
                isAnimated = false;
        }};
    
    //Currently a work in progress
    public void moveElevatorTo(int destination) { 
        //Check if destination is a valid floor
        if (destination > TOP_FLOOR || destination < BOTTOM_FLOOR) {
            System.err.println("Invalid floor number");
            System.out.println("Please refer to floors by index value");
            return;
        }

        //Check if already on desired floor
        else if(currentFloor == destination) {
            openDoors();
            return;
        }
        isAnimated = true;
        //Determine to move up or down
        if(destination > currentFloor) moveDirection = MOVE_UP;
        else moveDirection = MOVE_DOWN;
        //Begin movement
        goalFloor = destination;
        moveElevatorTimer.start();    
    }
    
    public void moveElevatorTo(int destination, String moveAfterDone) {
        moveElevatorTo(destination);
        this.moveAfterDone = moveAfterDone;
    }
    
    ActionListener moveElevator = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            //Determine if move up or move down
            if(moveDirection.equals(MOVE_UP))
                shaft.get(currentFloor++).setEmpty();
            else if(moveDirection.equals(MOVE_DOWN))
                shaft.get(currentFloor--).setEmpty();
            else return;
            //Begin move
            moveDirection = NO_MOVE;
            //Set tracking label
            floorTracker.setText("" + (currentFloor + 1));
            //Set the proper floor label to have an elevator with closed doors
            shaft.get(currentFloor).closeDoors();
            //If on the goal floor, stop
            if(currentFloor == goalFloor){
                openDoors();
            }
            //Otherwise keep going
            else { 
                moveElevatorTo(goalFloor);
            }
        }};
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        floorTracker = new javax.swing.JLabel();
        floor3 = new javax.swing.JPanel();
        floor2 = new javax.swing.JPanel();
        floor1 = new javax.swing.JPanel();

        floorTracker.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        floorTracker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        floorTracker.setText("#");
        floorTracker.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        floor3.setMaximumSize(new java.awt.Dimension(91, 40));
        floor3.setMinimumSize(new java.awt.Dimension(91, 40));
        floor3.setPreferredSize(new java.awt.Dimension(91, 40));
        floor3.setLayout(new java.awt.GridBagLayout());

        floor2.setMaximumSize(new java.awt.Dimension(91, 40));
        floor2.setMinimumSize(new java.awt.Dimension(91, 40));
        floor2.setPreferredSize(new java.awt.Dimension(91, 40));
        floor2.setLayout(new java.awt.GridBagLayout());

        floor1.setMaximumSize(new java.awt.Dimension(91, 40));
        floor1.setMinimumSize(new java.awt.Dimension(91, 40));
        floor1.setPreferredSize(new java.awt.Dimension(91, 40));
        floor1.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(floorTracker))
                    .addComponent(floor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(floor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(floor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(floorTracker)
                .addGap(18, 18, 18)
                .addComponent(floor3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(floor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(floor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel floor1;
    private javax.swing.JPanel floor2;
    private javax.swing.JPanel floor3;
    private javax.swing.JLabel floorTracker;
    // End of variables declaration//GEN-END:variables
}
