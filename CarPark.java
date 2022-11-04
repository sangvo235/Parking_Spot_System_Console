import java.util.Iterator;
import java.time.LocalDateTime;
import java.util.ArrayList;  
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Cark Park Class - maintains list of slots in the parking 
 * @author         Sang Vo (104020390)
 * @version        JDK 18
 * @date           01 September 2022
 */

public class CarPark {

    // Creating the parking slot array 
    ArrayList<ParkingSlot> slots = new ArrayList<ParkingSlot>();

    // Logic for searching if the parking slot exist 
    public boolean hasParkingSlot(String searching) {
        // Scan for eg. D01 in slots (Parking Slot Array)
        for (ParkingSlot slot : slots) {
            // If slot matches ID return true   
            if (slot.getId().equals(searching)) 
                return true;
        }
        return false;
    }

    // Logic for adding parking slot
    public void addParkingSlot(String newId, boolean newType) {
        // Create new Parking Slot
        ParkingSlot slotObj = new ParkingSlot(newId, newType);
        // Add to Array List
        slots.add(slotObj);
        // Print new Parking Slot Details
        System.out.println(slotObj.toString());
    }    

    // Logic for deleting parking slot
    public void deleteParkingSlot(String identifier) {
        // Creating interator 
        Iterator<ParkingSlot> here = slots.iterator();
        // While loop while 
        while(here.hasNext()) {
            ParkingSlot slot = here.next();
            String id = slot.getId();
            if(id.equals(identifier)) {
                if(slot.isOccupied() == true) {
                    System.out.println("Slot cannot be deleted because is occupied");
                }
                else {
                    // Removal of parking slot
                    here.remove();
                    System.out.println(slot+" is not currently occupied and has been successfully deleted!");
                }
            }
        }
    }

    // Logic for Function Finding Car via Registration Number
    public Car findACarByRegis(String registerNumber){
        for(ParkingSlot s : slots){
            if(s.getCar()!= null){
                if(s.getCar().getRegistrationNumber().equals(registerNumber)){
                    return s.getCar();
                }
            }
        }
        return null;
    }

    // Logic for Adding/Parking a car into a parking slot 
    public void addCar(Car car, String slotId) {
        // Creating interator 
        Iterator<ParkingSlot> here = slots.iterator();
        // While loop while 
        while(here.hasNext()) {
            ParkingSlot slot = here.next();
            String id = slot.getId();
            if(id.equals(slotId)) {

                Car c = findACarByRegis(car.getRegistrationNumber());

                if(slot.isOccupied() == true) {
                    System.out.println("You cannot add a car because slot is occupied");
                }
                else if (slot.getType() != car.isStaffMember()) {
                    System.out.println("You cannot park here, please ensure that you are parking in the correct type of slot!");
                }else if (c != null){
                    System.out.println("Invalid, car registration is already in use!");
                }
                else {
                    // add car to parking slot
                    slot.parkCar(car);

                    // list time of when car is parked
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String parkedTime = now.format(formatter);
                    car.setLocalDateTime(now);
                    System.out.println(car.toString()+" "+parkedTime);
                }
            }
        }
    }

    // Logic for displaying a list of all slots and their encapsulated variables 
    public void listSlots() {
        for(ParkingSlot s : slots){
            if(s.getCar() == null){
                System.out.println(s);
            }else{
                System.out.println(s);
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime recordTime = s.getCar().getLocalDateTime(); 
                long hour = ChronoUnit.HOURS.between(recordTime, now);
                long minute = ChronoUnit.MINUTES.between(recordTime, now) % 60;
                long second = ChronoUnit.SECONDS.between(recordTime, now) % 60;
                System.out.println("Elapse time since car has been parked ~ Hours: "+hour+", Minutes: "+minute+", Seconds: "+second);
            }
        }
    }

    // Logic for finding a car base on user provided car registration number 
    public void findCar(String regoNumber) {
        for(ParkingSlot s : slots){
            if(s.getCar() != null){
                String id = s.getCar().getRegistrationNumber();
                if(id.equals(regoNumber)) {
                    if(s.isOccupied() == true) {
                        System.out.println(s.getCar().toString()+ "Slot is Occupied");
    
                        LocalDateTime now = LocalDateTime.now();
                        LocalDateTime recordTime = s.getCar().getLocalDateTime(); 
                        long hour = ChronoUnit.HOURS.between(recordTime, now);
                        long minute = ChronoUnit.MINUTES.between(recordTime, now) % 60;
                        long second = ChronoUnit.SECONDS.between(recordTime, now) % 60;
                        System.out.println("Elapse time since car has been parked ~ Hours: "+hour+", Minutes: "+minute+", Seconds: "+second);
                    }
                    else {
                        System.out.println(s.getCar().toString()+" Slot is not Occupied");
                    }
                }
            }
        }
    }

    public void deleteCar(String regoNumber) {
        for(ParkingSlot s : slots){
            if(s.getCar() != null){
                String id = s.getCar().getRegistrationNumber();
                if(id.equals(regoNumber)) {
                    if(s.isOccupied() == true) {
                        s.removeCar();
                        System.out.println("Car has been successfully removed");
                    }
                    else {
                        System.out.println("Slot is not occupied, try again!");
                    }
                }
                else {
                    System.out.println("Invalid, car registration number is incorrect!");
                }
            }
        }
    }
}