/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package STEMproj_TestPackage;

/**
 *
 * @author a-krause
 */
public class ElevatorSystem{
    
    public Elevator elevator1;
    public Elevator elevator2;
    
    public ElevatorSystem(Elevator first, Elevator second){
        elevator1 = first;
        elevator2 = second;
    }
    
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