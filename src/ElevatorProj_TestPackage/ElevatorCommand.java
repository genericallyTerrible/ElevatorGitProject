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
public class ElevatorCommand {
    
    public static final String NoPreference = ElevatorTestFrame.NoPreference;
    public static final String PrefersOne   = ElevatorTestFrame.PrefersOne;
    public static final String PrefersTwo   = ElevatorTestFrame.PrefersTwo;
    
    private int floorOfCall;
    private String moveDirection;
    private String preference;
    
    public ElevatorCommand(int floorOfCall, String moveDirection) {
        this.floorOfCall   = floorOfCall;
        this.moveDirection = moveDirection;
        this.preference    = NoPreference;
    }
    
    public ElevatorCommand(int floorOfCall, String moveDirection, String preference) {
        this.floorOfCall   = floorOfCall;
        this.moveDirection = moveDirection;
        this.preference    = preference;
    }
    
    public int getFloor() {
        return floorOfCall;
    }
    
    public String getMove() {
        return moveDirection;
    }
    
    public String getPreference() {
        return preference;
    }
}
