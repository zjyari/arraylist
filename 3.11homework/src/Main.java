import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      
        ArrayList<Attendee> attendeesList = new ArrayList<>();
        attendeesList.add(new Attendee("Alice"));
        attendeesList.add(new Attendee("Bob"));
        attendeesList.add(new Attendee("Charlie"));

        Event event = new Event("E001", "Conference", "123 Main Street", "2023-04-25");

   
        event.getEventAttendees().addAll(attendeesList);

       
        event.organizeEvent();

        
    }
}