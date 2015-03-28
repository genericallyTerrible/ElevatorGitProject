/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ElevatorProj_TestPackage;

/**
 *
 * @authors Andrew Krause, Mitchell Babej, and John Merkel
 */
public class Elevator {
    private boolean doorOpen;
    private int floor;
    
    Elevator(int currentFloor) {
        floor = currentFloor;
        doorOpen = true;
    }
    
    public int getFloor() {
        return floor;
    }
    
    public boolean isDoorOpen() {
        return doorOpen;
    }
    
    public void openDoor() {
        doorOpen = true;
    }
    
    public void closeDoor() {
        doorOpen = false;
    }
    
    public void goUp() {
        floor++;
    }
    
    public void goDown() {
        if(!(floor < 1))
            floor--;
    }
}