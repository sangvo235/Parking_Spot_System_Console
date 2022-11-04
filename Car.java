import java.time.LocalDateTime;

/**
 * Car Class
 * @author         Sang Vo (104020390)
 * @version        JDK 18
 * @date           31 August 2022
 */

public class Car {
    // Declaring Variables
    private String registrationNumber;
    private String owner;
    private boolean staffMember;
    private LocalDateTime localDateTime;

    /**
     * Constructor for objects of Car Class 
     * Intializes instance variables; registrationNumber and owner 
     *
     * @param   registrationNumber Car's Registration Number
     * @param   owner Name of Owner
     * @param   staffMember if owner is a staff member
     */
    public Car(String newregistrationNumber, String newOwner, boolean newStaffMember) {
        this.registrationNumber = newregistrationNumber;
        this.owner = newOwner;
        this.staffMember = newStaffMember;
    }

    /**
      * Using Get Method
      *
      * @return    Returns a String object that contains the selected variable 
      */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwner() {
        return owner;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    // Primitive boolean --> getter is
    public boolean isStaffMember() {
        return staffMember;
    } 

    // Return a relevant string instead of boolean 
    public String displayType() {
        if (staffMember == true) {
            return "Staff";
        }
        else {
            return "Visitor";
        }
    }
    
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    /**
     * Java internally calls toString() method
     * Overriding this method will return specified values
     *
     * @return    Returns a String object instead of hashcode values
     */ 
    public String toString() {
        return "Registration Number: "+registrationNumber+", Owner: "+owner+", Type: "+displayType();
    }
 }
