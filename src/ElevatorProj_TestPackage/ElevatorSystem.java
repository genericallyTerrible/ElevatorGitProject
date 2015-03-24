/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ElevatorProj_TestPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author a-krause
 */
public class ElevatorSystem{
    
    public Elevator elevator1;
    public Elevator elevator2;
    private Elevator currentElevator;
    public final int TIME_TO_CHANGE_ONE_FLOOR = 6000;
    public final int TIME_TO_OPEN_CLOSE_DOORS = 2000;
    
    Timer doorCloseTimer;
    
    public ElevatorSystem(Elevator first, Elevator second){
        elevator1 = first;
        elevator2 = second;
        doorCloseTimer = new Timer(TIME_TO_OPEN_CLOSE_DOORS, doorCloses);
    }
    
    public int moveElevator(int floorOfCall, int elevatorNumber){
        //Calculate time needed to move
             if(elevatorNumber == 1) currentElevator = elevator1;
        else if(elevatorNumber == 2) currentElevator = elevator2;
        else return -1;
        int totalTime = 0;
        totalTime += Math.abs(currentElevator.getFloor() - floorOfCall) * TIME_TO_CHANGE_ONE_FLOOR;
        totalTime += TIME_TO_OPEN_CLOSE_DOORS;
        
        //Move the elevator
        if(currentElevator.isDoorOpen()) {
            totalTime += TIME_TO_OPEN_CLOSE_DOORS;
            doorCloseTimer.start();
        } else {
            
        }
        
        
        
        return totalTime;
    }
    
     ActionListener doorCloses = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            currentElevator.closeDoor();
            //call elevator movement
        }
     };
    
    public void callNearestElevator(int floorOfCall){
        //Check who is closer
        if(Math.abs(elevator1.getFloor() - floorOfCall) <= Math.abs(elevator2.getFloor() - floorOfCall)){
            //elevator1 is closer
            
            if(elevator1.isDoorOpen()){
                elevator1.closeDoor();
            }
            
            //Executes while elevator1 is above
            while(elevator1.getFloor() > floorOfCall){
                elevator1.goDown();
            }
            //Executes while elevator1 is below
            while(elevator1.getFloor() < floorOfCall){
                elevator1.goUp();
            }
            
            elevator1.openDoor();
            
        } else {
            //elevator2 is closer
            
            if(elevator2.isDoorOpen()){
                elevator2.closeDoor();
            }
            
            //Executes while elevator2 is above
            while(elevator2.getFloor() > floorOfCall){
                elevator2.goDown();
            }
            //Executes while elevator2 is below
            while(elevator2.getFloor() < floorOfCall){
                elevator2.goUp();
            }
            
            elevator2.openDoor();
            
        }
    }
}