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
    
    public static final String MOVE_UP      = ElevatorTestFrame.MOVE_UP;
    public static final String MOVE_DOWN    = ElevatorTestFrame.MOVE_DOWN;
    public static final String NO_MOVE      = ElevatorTestFrame.NO_MOVE;
    
    private int floorOfCall;
    private String moveDirection;
    private String preference;
    private boolean isActive;
    
    public ElevatorCommand() {
        this.floorOfCall   = 0;
        this.moveDirection = NO_MOVE;
        this.preference    = NoPreference;
        this.isActive      = true;
    }
    
    public ElevatorCommand(int floorOfCall, String moveDirection) {
        this.floorOfCall   = floorOfCall;
        this.moveDirection = moveDirection;
        this.preference    = NoPreference;
        this.isActive      = true;
    }
    
    public ElevatorCommand(int floorOfCall, String moveDirection, String preference) {
        this.floorOfCall   = floorOfCall;
        this.moveDirection = moveDirection;
        this.preference    = preference;
        this.isActive      = true;
    }
    
    public ElevatorCommand(int floorOfCall, String moveDirection, String preference, boolean isActive) {
        this.floorOfCall   = floorOfCall;
        this.moveDirection = moveDirection;
        this.preference    = preference;
        this.isActive      = isActive;
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
    
    public void setActive(boolean maybe) {
        isActive = maybe;
    }
    
    public boolean isActive() {
        return isActive;
    }
}
