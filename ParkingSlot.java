/**
 * Parking Slot Class
 * @author         Sang Vo (104020390)
 * @version        JDK 18
 * @date           31 August 2022
 */

public class ParkingSlot {
    // Declaring Variables
    private String id; 
    private boolean type;
    private boolean occupied = false;
    private Car car; 
    
    /**
     * Constructor for objects of Parking Slot Class 
     * Intializes instance variables; id, type, staffMember and car
     *
     * @param   id Parking Slot identifier
     * @param   type Type of Parking Slot
     * @param   occupied If not occupied by a car
     * @param   car Car details consisting of registration number and owner's name
     */
    public ParkingSlot(String newId, boolean newType) {
        this.id = newId;
        this.type = newType;
    }

    /**
      * Using Get Method
      *
      * @return    Returns a String object that contains the selected variable 
      */
    public String getId() {
        return id;
    }

    public boolean getType() {
        return type;
    }

    // Get CAR 
    public Car getCar() {
        return car;
    }

    // Primitive boolean --> getter is
    public boolean isOccupied() {
        return occupied;
    }

    //check car is null;
    public String isParked(){
        return ("This car spot is occupied");
    }
    
    /**
      * Using Set Method
      *
      * @return    Returns a String object that contains the selected and changed variable 
      */
    public void setId(String id) {
        this.id = id;
    }
    
    public void setType(boolean type) {
        this.type = type;
    }

    // For Parking Slot Type
    public String displaySlotType() {
        if (type == true) {
            return "Staff";
        }
        else {
            return "Visitor";
        }
    }

    // Park Car
    public void parkCar(Car car) {
        this.car = car;
        this.occupied = true;
    }

    // Removing a Car
    public void removeCar() {
        this.car = null;
        this.occupied = false;
    }

    /**
     * Java internally calls toString() method
     * Overriding this method will return specified values
     *
     * @return    Returns a String object instead of hashcode values
     */ 
    public String toString() {
        return id+"\t"+displaySlotType()+"\t"+car;
    }
    
}