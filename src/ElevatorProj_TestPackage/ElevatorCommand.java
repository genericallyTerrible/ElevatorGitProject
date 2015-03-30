/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorProj_TestPackage;

/**
 *
 * @author Andrew Krause, Mitchell Babej, and John Merkel
 */
public class ElevatorCommand {
    
    //String constants for know an elevator's action after reaching it's desired floor

    /**
     *
     */
        public static final String MOVE_UP      = ElevatorTestFrame.MOVE_UP;

    /**
     *
     */
    public static final String MOVE_DOWN    = ElevatorTestFrame.MOVE_DOWN;

    /**
     *
     */
    public static final String NO_MOVE      = ElevatorTestFrame.NO_MOVE;
    //String constants to know if a command is for a specific elevator or either

    /**
     *
     */
        public static final String NoPreference = ElevatorTestFrame.NoPreference;

    /**
     *
     */
    public static final String PrefersOne   = ElevatorTestFrame.PrefersOne;

    /**
     *
     */
    public static final String PrefersTwo   = ElevatorTestFrame.PrefersTwo;
    
    private int floorOfCall;
    private String moveDirection;
    private String preference;
    private boolean isActive;
    
    /**
     *
     */
    public ElevatorCommand() {
        this.floorOfCall   = 0;
        this.moveDirection = NO_MOVE;
        this.preference    = NoPreference;
        this.isActive      = true;
    }
    
    /**
     *
     * @param floorOfCall
     * @param moveDirection
     */
    public ElevatorCommand(int floorOfCall, String moveDirection) {
        this.floorOfCall   = floorOfCall;
        this.moveDirection = moveDirection;
        this.preference    = NoPreference;
        this.isActive      = true;
    }
    
    /**
     *
     * @param floorOfCall
     * @param moveDirection
     * @param preference
     */
    public ElevatorCommand(int floorOfCall, String moveDirection, String preference) {
        this.floorOfCall   = floorOfCall;
        this.moveDirection = moveDirection;
        this.preference    = preference;
        this.isActive      = true;
    }
    
    /**
     *
     * @param floorOfCall
     * @param moveDirection
     * @param preference
     * @param isActive
     */
    public ElevatorCommand(int floorOfCall, String moveDirection, String preference, boolean isActive) {
        this.floorOfCall   = floorOfCall;
        this.moveDirection = moveDirection;
        this.preference    = preference;
        this.isActive      = isActive;
    }
    
    /**
     *
     * @return
     */
    public int getFloor() {
        return floorOfCall;
    }
    
    /**
     *
     * @return
     */
    public String getMove() {
        return moveDirection;
    }
    
    /**
     *
     * @return
     */
    public String getPreference() {
        return preference;
    }
    
    /**
     *
     * @param maybe
     */
    public void setActive(boolean maybe) {
        isActive = maybe;
    }
    
    /**
     *
     * @return
     */
    public boolean isActive() {
        return isActive;
    }
}
